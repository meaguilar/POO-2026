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
import org.example.util.Alerta;

import java.time.LocalDate;
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
    private MFXTextField txtHoras;

    @FXML
    private MFXButton btnRegistrar;


    private MFXComboBox<String> cbEstiloNatacion;


    @FXML
    public void initialize() {

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
           validarFechaFutura();
           Alerta.mostrarAlerta("Registro atleta","Prueba", root);
           limpiarFormulario();

       } catch (Exception e) {
           e.printStackTrace();
           Alerta.mostrarAlerta("Formato no valido","Ingresar el formato solicitado", root);
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
        txtNombre.requestFocus();
        txtNombre.clear();
        txtPeso.clear();
        txtAltura.clear();
        txtHoras.clear();
        dpFechaNacimiento.setValue(null);
        cbDeporte.setValue(null);
        cbEstiloNatacion.setValue(null);

    }

    private void validarFechaFutura(){
        LocalDate fecha = dpFechaNacimiento.getValue();

        if (fecha != null && fecha.isAfter(LocalDate.now())) {
            Alerta.mostrarAlerta("Error", "No se permiten fechas futuras", root);
        }
    }
}
