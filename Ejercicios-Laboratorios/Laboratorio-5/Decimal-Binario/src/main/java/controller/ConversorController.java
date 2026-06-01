package controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import model.BinarioADecimal;
import model.Conversor;
import model.DecimalABinario;

public class ConversorController {
    @FXML
    private TextField txtCantidad;

    @FXML
    private ComboBox<String> cbxDe;

    @FXML
    private ComboBox<String> cbxA;

    @FXML
    private Label lblResultado;

    private Conversor conversor;

    @FXML
    public void initialize() {
        conversor = new Conversor();

        cbxDe.getItems().addAll("Decimal", "Binario");
        cbxA.getItems().addAll("Binario", "Decimal");

        cbxDe.setValue("Decimal");
        cbxA.setValue("Binario");
    }

    @FXML
    void convertir(ActionEvent event) {
        try {
            String cantidad = txtCantidad.getText().trim();
            String de = cbxDe.getValue();
            String a = cbxA.getValue();

            if (cantidad.isEmpty()) {
                throw new IllegalArgumentException("Ingresa una cantidad.");
            }

            if (de == null || a == null) {
                throw new IllegalArgumentException("Selecciona ambas opciones.");
            }

            if (de.equals(a)) {
                throw new IllegalArgumentException("Debes seleccionar conversiones diferentes.");
            }

            conversor.setValor(cantidad);

            if (de.equals("Decimal") && a.equals("Binario")) {
                conversor.setEstrategia(new DecimalABinario());
            } else if (de.equals("Binario") && a.equals("Decimal")) {
                conversor.setEstrategia(new BinarioADecimal());
            } else {
                throw new IllegalArgumentException("Conversión no válida.");
            }

            String resultado = conversor.ejecutarConversion();
            lblResultado.setText(resultado);
            mostrarAlertaInformacion("Conversión exitosa", "La conversión se realizó correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlertaError("Dato inválido", "Ingresa un número decimal entero válido.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            mostrarAlertaError("Error de validación", e.getMessage());
        }
    }

    @FXML
    void limpiar(ActionEvent event) {
        txtCantidad.clear();
        cbxDe.setValue("Decimal");
        cbxA.setValue("Binario");
        lblResultado.setText("---");
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR, mensaje, ButtonType.OK);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void mostrarAlertaInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, mensaje, ButtonType.OK);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
