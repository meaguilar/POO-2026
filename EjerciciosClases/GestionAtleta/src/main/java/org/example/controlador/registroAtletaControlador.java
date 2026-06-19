package org.example.controlador;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.example.catalogo.Deporte;
import org.example.catalogo.EstilosNatacion;
import org.example.dao.AtletaDAOImpl;
import org.example.modelo.Atleta;
import org.example.modelo.Nadador;
import org.example.util.Alerta;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;

public class registroAtletaControlador {

    @FXML
    private BorderPane root;

    @FXML
    private GridPane gridForm;

    @FXML
    private MFXTextField txtNombre;

    @FXML
    private MFXTextField txtPeso;

    @FXML
    private MFXTextField txtAltura;

    @FXML
    private MFXDatePicker dpFechaNacimiento;

    @FXML
    private MFXComboBox<Deporte> cbDeporte;

    @FXML
    private MFXTextField txtHoraLunes;

    @FXML
    private MFXTextField txtHoraMartes;

    @FXML
    private MFXTextField txtHoraMiercoles;

    @FXML
    private MFXTextField txtHoraJueves;

    @FXML
    private MFXTextField txtHoraViernes;

    @FXML
    private MFXTextField txtHoraSabado;

    @FXML
    private MFXTextField txtHoraDomingo;


    @FXML
    private MFXButton btnRegistrar;


    private MFXComboBox<String> cbEstiloNatacion;

    // Atributo de relacion con el DAO
    private AtletaDAOImpl atletaDAO;


    @FXML
    public void initialize() {

        atletaDAO = new AtletaDAOImpl();

        cbDeporte.getItems().addAll(Deporte.values());

        cbDeporte.setOnAction(event -> {
            Deporte seleccionado = cbDeporte.getValue();

            if (seleccionado == Deporte.NATACION) {
                mostrarComboNatacion();
            } else {
                removerComboNatacion();
            }
        });


    }

    @FXML
    public void registrar() {

       try {
           validarFormulario();
           validarFechaFutura();

           int edadCalculada = calcularEdad();

           // Validar la edad calculada
           if (edadCalculada < 0 || edadCalculada > 100) {
               throw new IllegalArgumentException("La edad no es válida.");
           }

           // Capturar el valor ingresado por el usuario en el formulario
           String nombre = txtNombre.getText().trim();
           double peso = Double.parseDouble(txtPeso.getText().trim());
           double altura = Double.parseDouble(txtAltura.getText().trim());
           Deporte deporteSeleccionado = cbDeporte.getValue();

           // Crear la instancia concreta del Atleta
           Atleta nuevoAtleta;

           // Evaluar el deporte para instanciar el objeto hijo correcto
           switch (deporteSeleccionado) {
               case NATACION -> {
                   Nadador nadador = new Nadador();
                   // Capturamos el estilo específico del nadador
                   if (cbEstiloNatacion != null && cbEstiloNatacion.getValue() != null) {
                       nadador.setEstilo(cbEstiloNatacion.getValue());
                   } else {
                       throw new IllegalArgumentException("Debe seleccionar un estilo de natación.");
                   }
                   nuevoAtleta = nadador;
               }
               case FUTBOL -> {
                   // nuevoAtleta = new Futbolista();

                   throw new IllegalArgumentException("El registro de futbolistas estará disponible pronto.");
               }
               default -> {
                   // Podrías tener una clase llamada AtletaGeneral, para aquellos que no tienen atributos propios
                   throw new IllegalArgumentException("Deporte no soportado en este formulario de momento.");
               }
           }

           // Establecer los datos ingresados por el usuario en la clase Atleta
           nuevoAtleta.setNombre(nombre);
           nuevoAtleta.setEdad(edadCalculada);
           nuevoAtleta.setPeso(peso);
           nuevoAtleta.setAltura(altura);
           nuevoAtleta.setHorasEntrenamientodiarias(procesarHorasEntrenamiento());
           nuevoAtleta.setDeporte(deporteSeleccionado);

           // Calcular datos antes de guardar en la BD
           double imc = nuevoAtleta.calcularIMC();
           nuevoAtleta.setImc(imc);
           nuevoAtleta.setClasificacionIMC(nuevoAtleta.clasificarIMC());
           nuevoAtleta.setPromHorasEntrenamiento(nuevoAtleta.calcularPromedioSemanalEntrenamiento());

           // capturar el id del entrenador
           int idEntrenadorSesion = 2;

           boolean guardadoExitoso = atletaDAO.guardar(nuevoAtleta, idEntrenadorSesion);

           if (guardadoExitoso) {
               Alerta.mostrarAlerta("Registro exitoso", "El atleta se ha guardado en la base de datos.", root);
               limpiarFormulario();
           } else {
               Alerta.mostrarAlerta("Error BD", "No se pudo guardar el atleta en la base de datos.", root);
           }

       } catch (IllegalArgumentException e) {
           Alerta.mostrarAlerta("Error de validación", e.getMessage(), root);
       } catch (NullPointerException e) {
           e.printStackTrace();
           Alerta.mostrarAlerta("Error", "Asegúrese de seleccionar todos los campos obligatorios.", root);
       } catch (Exception e) {
           e.printStackTrace();
           Alerta.mostrarAlerta("Formato no válido", "Por favor, revise que los campos numéricos y de horas sean correctos.", root);
       }
    }

    private void mostrarComboNatacion() {

        if (cbEstiloNatacion == null) {

            cbEstiloNatacion = new MFXComboBox<>();

            cbEstiloNatacion.getItems().addAll(
                    Arrays.stream(EstilosNatacion.values())
                    .map(Enum::name)
                    .toList());

            cbEstiloNatacion.setFloatingText("Estilo de natación");
            gridForm.add(cbEstiloNatacion, 0, 7, 2, 1);
            cbEstiloNatacion.setMaxWidth(Double.MAX_VALUE);
        }
    }

    private void removerComboNatacion() {

        if (cbEstiloNatacion != null) {
            gridForm.getChildren().remove(cbEstiloNatacion);
            cbEstiloNatacion = null;
        }
    }

    private void limpiarFormulario() {
        txtNombre.clear();
        txtPeso.clear();
        txtAltura.clear();
        dpFechaNacimiento.setValue(null);
        cbDeporte.setValue(null);

        txtHoraLunes.clear();
        txtHoraMartes.clear();
        txtHoraMiercoles.clear();
        txtHoraJueves.clear();
        txtHoraViernes.clear();
        txtHoraSabado.clear();
        txtHoraDomingo.clear();

        // limpiar solo si existe el componente en memoria
        if (cbEstiloNatacion != null) {
            cbEstiloNatacion.setValue(null);
        }
        txtNombre.requestFocus();
    }

    private void validarFechaFutura(){
        LocalDate fecha = dpFechaNacimiento.getValue();

        if (fecha != null && fecha.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("No se permiten fechas de nacimiento futuras.");
        }
    }

    private void validarFormulario() {
        // Validar campos vacíos esenciales
        if (txtNombre.getText().trim().isEmpty() || txtPeso.getText().trim().isEmpty() ||
                txtAltura.getText().trim().isEmpty() || cbDeporte.getValue() == null) {
            throw new IllegalArgumentException("Todos los campos obligatorios deben estar completos.");
        }
        // Si es natación, obligar a seleccionar estilo
        if (cbDeporte.getValue() == Deporte.NATACION &&
                (cbEstiloNatacion == null || cbEstiloNatacion.getValue() == null)) {
            throw new IllegalArgumentException("Por favor, seleccione un estilo de natación.");
        }
    }

    private int calcularEdad() {
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();

        if (fechaNacimiento == null) {
            throw new IllegalArgumentException("Debe seleccionar una fecha de nacimiento primero.");
        }

        // Calcula el período de tiempo entre la fecha de nacimiento y el día de hoy
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    private double[] procesarHorasEntrenamiento() {
        double[] horasArreglo = new double[7];
        try {
            horasArreglo[0] = txtHoraLunes.getText().trim().isEmpty() ? 0.0 : Double.parseDouble(txtHoraLunes.getText().trim());
            horasArreglo[1] = txtHoraMartes.getText().trim().isEmpty() ? 0.0 : Double.parseDouble(txtHoraMartes.getText().trim());
            horasArreglo[2] = txtHoraMiercoles.getText().trim().isEmpty() ? 0.0 : Double.parseDouble(txtHoraMiercoles.getText().trim());
            horasArreglo[3] = txtHoraJueves.getText().trim().isEmpty() ? 0.0 : Double.parseDouble(txtHoraJueves.getText().trim());
            horasArreglo[4] = txtHoraViernes.getText().trim().isEmpty() ? 0.0 : Double.parseDouble(txtHoraViernes.getText().trim());
            horasArreglo[5] = txtHoraSabado.getText().trim().isEmpty() ? 0.0 : Double.parseDouble(txtHoraSabado.getText().trim());
            horasArreglo[6] = txtHoraDomingo.getText().trim().isEmpty() ? 0.0 : Double.parseDouble(txtHoraDomingo.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Las horas semanales deben ser exclusivamente números (ej. 2.5).");
        }
        return horasArreglo;
    }
}
