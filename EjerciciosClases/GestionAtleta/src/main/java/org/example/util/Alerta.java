package org.example.util;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.dialogs.MFXGenericDialog;
import io.github.palexdev.materialfx.dialogs.MFXStageDialog;
import javafx.scene.layout.BorderPane;

public class Alerta {

    public static void mostrarAlerta(String titulo, String mensaje, BorderPane pane) {

        MFXGenericDialog dialog = new MFXGenericDialog();
        dialog.setHeaderText(titulo);
        dialog.setContentText(mensaje);

        MFXStageDialog stageDialog = new MFXStageDialog();
        stageDialog.setOwnerNode(pane);
        stageDialog.setContent(dialog);

        MFXButton btnAceptar = new MFXButton("Aceptar");
        btnAceptar.setOnAction(e -> stageDialog.close());
        dialog.addActions(btnAceptar);

        stageDialog.showAndWait();
    }
}