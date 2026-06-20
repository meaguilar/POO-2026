package util;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Normaliza URLs para que javafx.scene.image.Image pueda cargarlas.
 * <p>
 * Acepta:
 * - http://, https://, file://
 * - Rutas absolutas Windows (C:\...\img.png) o Unix (/home/.../img.png)
 * - Rutas relativas (imagenes/img.png)
 * - URLs entre comillas: "https://..." o 'https://...'
 * <p>
 * NO funciona con paginas HTML (Google Images, Pinterest, Instagram);
 * hay que copiar la URL directa al archivo de imagen.
 */
public final class UrlImagenUtil {

    private UrlImagenUtil() {
    }

    public static String normalizar(String url) {
        if (url == null) return null;

        String trimmed = url.trim();
        if (trimmed.isEmpty()) return null;

        // Quita comillas envolventes si las hay.
        if ((trimmed.startsWith("\"") && trimmed.endsWith("\""))
                || (trimmed.startsWith("'") && trimmed.endsWith("'"))) {
            trimmed = trimmed.substring(1, trimmed.length() - 1).trim();
        }

        String lower = trimmed.toLowerCase();
        if (lower.startsWith("http://") || lower.startsWith("https://") || lower.startsWith("file:")) {
            return trimmed;
        }

        File archivo = new File(trimmed);
        if (archivo.isAbsolute()) return toFileUri(archivo);

        return trimmed;
    }

    /**
     * Convierte un File a un URI file:///.
     */
    private static String toFileUri(File archivo) {
        try {
            return archivo.toURI().toString();
        } catch (Exception e) {
            try {
                String path = archivo.getAbsolutePath().replace("\\", "/");
                if (path.length() > 2 && path.charAt(1) == ':') path = "/" + path;
                return new URI("file", null, path, null).toString();
            } catch (URISyntaxException ex) {
                return archivo.getAbsolutePath();
            }
        }
    }
}
