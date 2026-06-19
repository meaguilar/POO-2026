package org.example.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.modelo.Juego;
import org.example.patrones.estrategia.AdivinaNumero;
import org.example.util.Alerta;

public class JuegoAdivinaNumeroControlador {
    @FXML
    private Button btnJugar;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtNumero;

    private Juego juego;
    private AdivinaNumero estrategia;

    @FXML
    public void initialize() {
        juego = new Juego();
        juego.setNombre("Adivina Numero");
        estrategia = new AdivinaNumero();
        lblResultado.setVisible(false);
    }

    @FXML
    public void jugar() {
        try {
            juego.setEstrategia(estrategia);
            int numero = Integer.parseInt(txtNumero.getText().toString().trim());
            estrategia.setNumeroUsuario(numero);
            String resultado = juego.iniciarJuego();

            Alerta.mostrarInformacion(juego.getNombre(), resultado);
            txtNumero.requestFocus();
            if (resultado.equals("¡Adivinastes!")){
                txtNumero.clear();
                seleccionarJuegos();
            }else {
                txtNumero.requestFocus();
            }

        } catch (Exception e) {
            Alerta.mostrarError("Error", "Debe ingresar un número entero válido.");
            e.printStackTrace();
        }

    }

    public void seleccionarJuegos() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Juegos.fxml"));
       // Parent root = fxmlLoader.load();
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) txtNumero.getScene().getWindow();
        stage.setScene(scene);
    }

}
