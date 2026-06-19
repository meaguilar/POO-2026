package org.example.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.modelo.Juego;
import org.example.patrones.estrategia.EstrategiaJuego;
import org.example.patrones.estrategia.SieteSuerte;
import org.example.util.Alerta;


public class JuegoSieteSuerteControlador {

    @FXML
    private Button btnJugar;
    @FXML
    private Label lblResultado;

    private Juego juego;
    private EstrategiaJuego estrategia;

    @FXML
    public void initialize() {
        juego = new Juego();
        juego.setNombre("Siete de la suerte");
        estrategia = new SieteSuerte();
        lblResultado.setVisible(false);
    }

    @FXML
    public void jugar() throws Exception {
        juego.setEstrategia(estrategia);
        //lblResultado.setVisible(true);
        //lblResultado.setText(juego.iniciarJuego());
        String resultado = juego.iniciarJuego();

        Alerta.mostrarInformacion(juego.getNombre(), resultado);
        if (resultado.equals("¡Ganastes!") || resultado.equals("¡Has perdido!")) {
            seleccionarJuegos();
        }
    }

    public void seleccionarJuegos() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Juegos.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) btnJugar.getScene().getWindow();
        stage.setScene(scene);
    }
}
