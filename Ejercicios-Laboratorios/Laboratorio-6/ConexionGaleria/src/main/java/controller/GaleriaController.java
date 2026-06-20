package controller;

import dao.ArteDAO;
import dao.ArteDAOImpl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import model.Arte;
import util.UrlImagenUtil;

import java.util.List;

/**
 * Controlador de galeria-view.fxml.
 * Carga Artes desde la BD, los dibuja como cards, y gestiona los
 * tres modales (Agregar, Eliminar, Actualizar) sobre un backdrop oscuro.
 */
public class GaleriaController {

    // ── Galería ──────────────────────────────────────────────────────────
    @FXML
    private TilePane tileContenedorObras;

    // ── Overlay ──────────────────────────────────────────────────────────
    @FXML
    private StackPane overlayBackdrop;

    // ── Modal Agregar ────────────────────────────────────────────────────
    @FXML
    private VBox panelAgregar;
    @FXML
    private TextField txtAgregarNombre;
    @FXML
    private TextField txtAgregarUrl;

    // ── Modal Eliminar ───────────────────────────────────────────────────
    @FXML
    private VBox panelEliminar;
    @FXML
    private TextField txtEliminarNombre;
    @FXML
    private VBox panelEliminarInfo;
    @FXML
    private Label lblEliminarId;
    @FXML
    private Label lblEliminarUrl;
    @FXML
    private ImageView imgEliminarPreview;
    @FXML
    private Button btnEliminarConfirmar;

    // ── Modal Actualizar ─────────────────────────────────────────────────
    @FXML
    private VBox panelActualizar;
    @FXML
    private TextField txtActualizarNombre;
    @FXML
    private TextField txtActualizarUrl;
    @FXML
    private Button btnActualizarConfirmar;

    // ── Estado interno ───────────────────────────────────────────────────
    private final ArteDAO arteDAO = new ArteDAOImpl();
    private static GaleriaController instancia;
    private Arte arteEliminar;
    private Arte arteActualizar;

    // ════════════════════════════════════════════════════════════════════
    // INICIALIZACIÓN
    // ════════════════════════════════════════════════════════════════════

    /**
     * Llamado por JavaFX al cargar el FXML. Cierra modales y carga Artes.
     */
    @FXML
    public void initialize() {
        instancia = this;
        cerrarTodosLosModales();
        cargarArtes();
    }

    /**
     * Metodo estatico: cualquier parte puede pedir refrescar la galeria.
     */
    public static void refrescarGaleria() {
        if (instancia != null) instancia.cargarArtes();
    }

    // ════════════════════════════════════════════════════════════════════
    // GALERÍA
    // ════════════════════════════════════════════════════════════════════

    /**
     * Limpia el TilePane y agrega una card por cada Arte de la BD.
     */
    public void cargarArtes() {
        tileContenedorObras.getChildren().clear();
        List<Arte> artes = arteDAO.listarTodos();
        for (Arte arte : artes) {
            tileContenedorObras.getChildren().add(crearCardArte(arte));
        }
    }

    /**
     * Arma la card de un Arte: un StackPane con placeholder + ImageView
     * (la imagen se descarga en background) y un Label con el nombre.
     */
    private VBox crearCardArte(Arte arte) {
        VBox card = new VBox(8);
        card.getStyleClass().add("gallery-card");
        card.setPadding(new Insets(10));
        card.setAlignment(Pos.TOP_CENTER);

        StackPane imageContainer = new StackPane();
        imageContainer.getStyleClass().add("card-image-container");

        Label placeholder = new Label("Cargando...");
        placeholder.getStyleClass().add("card-placeholder");
        placeholder.setAlignment(Pos.CENTER);
        StackPane.setAlignment(placeholder, Pos.CENTER);

        ImageView imageView = new ImageView();
        imageView.getStyleClass().add("card-image");
        imageView.setVisible(false);
        StackPane.setAlignment(imageView, Pos.CENTER);

        imageContainer.getChildren().addAll(placeholder, imageView);

        // Carga asincrona: backgroundLoading=true evita congelar el hilo de UI.
        String urlNorm = UrlImagenUtil.normalizar(arte.getUrlArte());
        if (urlNorm == null || urlNorm.isEmpty()) {
            placeholder.setText("Sin URL");
        } else {
            try {
                Image imagen = new Image(urlNorm, 160, 130, true, true, true);
                imageView.setImage(imagen);

                // Swap placeholder por imagen cuando termina de cargar.
                imagen.progressProperty().addListener((obs, oldVal, newVal) -> {
                    if (newVal.doubleValue() >= 1.0 && !imagen.isError()) {
                        Platform.runLater(() -> {
                            placeholder.setVisible(false);
                            imageView.setVisible(true);
                        });
                    }
                });
                if (imagen.getProgress() >= 1.0 && !imagen.isError()) {
                    placeholder.setVisible(false);
                    imageView.setVisible(true);
                }
                imagen.errorProperty().addListener((obs, oldVal, isError) -> {
                    if (Boolean.TRUE.equals(isError)) {
                        Platform.runLater(() -> {
                            imageView.setVisible(false);
                            placeholder.setText("Error al cargar");
                            placeholder.setVisible(true);
                        });
                    }
                });
            } catch (IllegalArgumentException ex) {
                placeholder.setText("URL invalida");
                System.err.println("URL invalida [" + arte.getNombreArte() + "]: " + urlNorm);
            }
        }

        Label lblNombre = new Label(arte.getNombreArte());
        lblNombre.getStyleClass().add("card-name");
        lblNombre.setWrapText(true);
        lblNombre.setMaxWidth(160);
        lblNombre.setAlignment(Pos.CENTER);

        card.getChildren().addAll(imageContainer, lblNombre);
        return card;
    }

    // ════════════════════════════════════════════════════════════════════
    // MODALES
    // ════════════════════════════════════════════════════════════════════

    /**
     * Oculta el backdrop y los tres paneles.
     */
    private void cerrarTodosLosModales() {
        overlayBackdrop.setVisible(false);
        overlayBackdrop.setManaged(false);
        setPanel(panelAgregar, false);
        setPanel(panelEliminar, false);
        setPanel(panelActualizar, false);
    }

    /**
     * Cambia visible y managed a la vez (necesario para hijos de StackPane).
     */
    private void setPanel(VBox panel, boolean visible) {
        panel.setVisible(visible);
        panel.setManaged(visible);
    }

    /**
     * Muestra el backdrop a pantalla completa y el modal indicado.
     * maxSize=MAX_VALUE fuerza al backdrop a expandirse a 1000x700.
     */
    private void abrirModal(VBox panel) {
        cerrarTodosLosModales();
        overlayBackdrop.setVisible(true);
        overlayBackdrop.setManaged(true);
        overlayBackdrop.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        overlayBackdrop.setPrefSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
        setPanel(panel, true);
    }

    @FXML
    private void manejarAbrirAgregar(ActionEvent e) {
        txtAgregarNombre.clear();
        txtAgregarUrl.clear();
        abrirModal(panelAgregar);
    }

    @FXML
    private void manejarAbrirEliminar(ActionEvent e) {
        txtEliminarNombre.clear();
        setPanel(panelEliminarInfo, false);
        imgEliminarPreview.setImage(null);
        btnEliminarConfirmar.setDisable(true);
        arteEliminar = null;
        abrirModal(panelEliminar);
    }

    @FXML
    private void manejarAbrirActualizar(ActionEvent e) {
        txtActualizarNombre.clear();
        txtActualizarUrl.clear();
        txtActualizarUrl.setDisable(true);
        btnActualizarConfirmar.setDisable(true);
        arteActualizar = null;
        abrirModal(panelActualizar);
    }

    @FXML
    private void manejarCerrarModal(ActionEvent e) {
        cerrarTodosLosModales();
    }

    /**
     * consume() evita que los clics dentro del modal lleguen al backdrop
     * y lo cierren por accidente.
     */
    @FXML
    private void consumirClick(MouseEvent e) {
        e.consume();
    }

    @FXML
    private void manejarCerrarSesion(ActionEvent e) {
        Platform.exit();
    }

    // ════════════════════════════════════════════════════════════════════
    // CRUD
    // ════════════════════════════════════════════════════════════════════

    @FXML
    private void manejarGuardar(ActionEvent e) {
        String nombre = txtAgregarNombre.getText().trim();
        String url = txtAgregarUrl.getText().trim();
        if (nombre.isEmpty() || url.isEmpty()) return;

        Arte arte = new Arte();
        arte.setNombreArte(nombre);
        arte.setUrlArte(url);

        if (arteDAO.guardar(arte)) {
            cargarArtes();
            cerrarTodosLosModales();
        }
    }

    @FXML
    private void manejarBuscarEliminar(ActionEvent e) {
        String nombre = txtEliminarNombre.getText().trim();
        if (nombre.isEmpty()) return;

        Arte arte = arteDAO.buscarPorNombre(nombre);
        if (arte == null) {
            setPanel(panelEliminarInfo, false);
            btnEliminarConfirmar.setDisable(true);
            arteEliminar = null;
            return;
        }

        arteEliminar = arte;
        lblEliminarId.setText("ID: " + arte.getIdArte());
        lblEliminarUrl.setText("URL: " + arte.getUrlArte());

        // Preview de la imagen en el modal.
        String urlNorm = UrlImagenUtil.normalizar(arte.getUrlArte());
        if (urlNorm != null) {
            try {
                imgEliminarPreview.setImage(new Image(urlNorm, 140, 100, true, true, true));
            } catch (Exception ex) {
                imgEliminarPreview.setImage(null);
            }
        } else {
            imgEliminarPreview.setImage(null);
        }

        setPanel(panelEliminarInfo, true);
        btnEliminarConfirmar.setDisable(false);
    }

    @FXML
    private void manejarEliminarConfirmar(ActionEvent e) {
        if (arteEliminar == null) return;
        if (arteDAO.eliminar(arteEliminar.getIdArte())) {
            cargarArtes();
            cerrarTodosLosModales();
        }
    }

    @FXML
    private void manejarBuscarActualizar(ActionEvent e) {
        String nombre = txtActualizarNombre.getText().trim();
        if (nombre.isEmpty()) return;

        Arte arte = arteDAO.buscarPorNombre(nombre);
        if (arte == null) {
            txtActualizarUrl.clear();
            txtActualizarUrl.setDisable(true);
            btnActualizarConfirmar.setDisable(true);
            arteActualizar = null;
            return;
        }

        arteActualizar = arte;
        txtActualizarUrl.setText(arte.getUrlArte());
        txtActualizarUrl.setDisable(false);
        btnActualizarConfirmar.setDisable(false);
    }

    @FXML
    private void manejarActualizarConfirmar(ActionEvent e) {
        if (arteActualizar == null) return;
        String url = txtActualizarUrl.getText().trim();
        if (url.isEmpty()) return;

        arteActualizar.setUrlArte(url);
        if (arteDAO.actualizar(arteActualizar)) {
            cargarArtes();
            cerrarTodosLosModales();
        }
    }
}
