import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Punto de entrada. Carga galeria-view.fxml, lo envuelve en una Scene
 * de 1000x700 y muestra la ventana principal.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/galeria-view.fxml"));
            primaryStage.setTitle("Galeria de Arte");
            primaryStage.setScene(new Scene(root, 1000, 700));
            primaryStage.show();
        } catch (Exception e) {
            System.err.println("Error al iniciar la aplicacion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
