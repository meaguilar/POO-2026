package util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public final class UrlImagenUtil {

    private UrlImagenUtil() {}

    /**
     * Normaliza la URL para que JavaFX Image pueda cargarla.
     * Acepta: http/https, file:///, rutas absolutas Windows/Unix.
     * Retorna null si la entrada está vacía.
     */
    public static String normalizar(String url) {
        if (url == null) return null;

        String trimmed = url.trim();
        if (trimmed.isEmpty()) return null;

        // Quitar comillas envolventes si el usuario pegó la URL entrecomillada
        if ((trimmed.startsWith("\"") && trimmed.endsWith("\""))
                || (trimmed.startsWith("'") && trimmed.endsWith("'"))) {
            trimmed = trimmed.substring(1, trimmed.length() - 1).trim();
        }

        String lower = trimmed.toLowerCase();

        // URLs web o file: ya están listas
        if (lower.startsWith("http://") || lower.startsWith("https://") || lower.startsWith("file:")) {
            return trimmed;
        }

        // Ruta absoluta del sistema → convertir a file:///
        File archivo = new File(trimmed);
        if (archivo.isAbsolute()) {
            return toFileUri(archivo);
        }

        // Ruta relativa: devolver tal cual
        return trimmed;
    }

    private static String toFileUri(File archivo) {
        try {
            return archivo.toURI().toString();
        } catch (Exception e) {
            try {
                String path = archivo.getAbsolutePath();
                String uriPath = path.replace("\\", "/");
                if (uriPath.length() > 2 && uriPath.charAt(1) == ':') {
                    uriPath = "/" + uriPath;
                }
                return new URI("file", null, uriPath, null).toString();
            } catch (URISyntaxException ex) {
                return archivo.getAbsolutePath();
            }
        }
    }
}