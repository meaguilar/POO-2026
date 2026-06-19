package org.example.util;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class DialogoEntrada {

    public static Optional solicitarDatos(String titulo, String mensaje, String descripcion) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titulo);
        dialog.setHeaderText(mensaje);
        dialog.setContentText(descripcion);

        return dialog.showAndWait();
    }

}
