package org.example.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class JuegosControlador {
    @FXML
    private Button btnJuego1;

    @FXML
    private Button btnJuego2;

    @FXML
    public void jugarSieteSuerte() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JuegoSieteSuerte.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)btnJuego1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void jugarAdivinaNumero() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JuegoAdivinaNumero.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)btnJuego2.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
