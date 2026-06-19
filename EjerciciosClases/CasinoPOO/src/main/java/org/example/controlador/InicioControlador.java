package org.example.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.example.util.Alerta;
import org.example.util.DialogoEntrada;

import java.io.IOException;
import java.util.Optional;

public class InicioControlador {

    @FXML
    private Button btnInicio;

    @FXML
    public void initialize() {

    }

    @FXML
    public void solicitarEdad() throws IOException{

        Optional<String> resultado = DialogoEntrada.solicitarDatos("Solicitar edad", "Ingresa tu edad: ", "Edad: ");

        if (resultado.isPresent()) {
            String texto = resultado.get().trim();

            try {
                int edad = Integer.parseInt(texto);

                if (edad < 0) {
                    Alerta.mostrarInformacion("Casino POO", "La edad no puede ser negativa");
                } else if (edad >= 18) {
                    ingresarCasino();
                }else {
                    Alerta.mostrarInformacion("Casino POO", "Edad no permitida");
                }

            } catch (NumberFormatException e) {
                    Alerta.mostrarError("Casino POO", "Debes ingresar un numero");
            }
        } else {
                Alerta.mostrarInformacion("Casino POO", "El usuario cancelo el ingreso");
        }
    }

    public void ingresarCasino() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Juegos.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) btnInicio.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
}
