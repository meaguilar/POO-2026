package org.example;

import io.github.palexdev.materialfx.theming.JavaFXThemes;
import io.github.palexdev.materialfx.theming.MaterialFXStylesheets;
import io.github.palexdev.materialfx.theming.UserAgentBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.util.ConexionPrueba;


public class MainFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        // ACTIVAR MATERIALFX THEME SYSTEM
        UserAgentBuilder.builder()
                .themes(JavaFXThemes.CASPIAN)
                .themes(MaterialFXStylesheets.forAssemble(true))
                .setDeploy(true)
                .setResolveAssets(true)
                .build()
                .setGlobal();

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/FormularioAtleta.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        scene.getStylesheets().add(
                getClass().getResource("/css/estilos.css").toExternalForm()
        );
        primaryStage.setTitle("Gestion Atleta");
        primaryStage.setScene(scene);
        primaryStage.show();

        //ConexionPrueba.probarConexion();
    }
}
