import com.twelvemonkeys.imageio.plugins.webp.WebPImageReaderSpi;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.spi.IIORegistry;
import javax.imageio.stream.ImageInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class TestWebP {
    public static void main(String[] args) throws Exception {
        IIORegistry.getDefaultInstance().registerServiceProvider(new WebPImageReaderSpi());

        System.out.println("Formatos: " + java.util.Arrays.toString(ImageIO.getReaderFormatNames()));

        String url = "https://static.wikia.nocookie.net/kirby/images/8/82/KEY_Captura_Kirby_Hablando.png/revision/latest/scale-to-width-down/1000?cb=20210531164948";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder(URI.create(url)).build();
        HttpResponse<InputStream> resp = client.send(req, HttpResponse.BodyHandlers.ofInputStream());
        System.out.println("Status: " + resp.statusCode());
        System.out.println("Content-Type: " + resp.headers().firstValue("content-type").orElse("?"));

        Path tmp = Files.createTempFile("test", ".bin");
        Files.copy(resp.body(), tmp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Bytes: " + Files.size(tmp));
        byte[] head = Files.readAllBytes(tmp);
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < Math.min(16, head.length); i++) {
            hex.append(String.format("%02x ", head[i]));
        }
        System.out.println("Magic: " + hex);

        try (ImageInputStream iis = ImageIO.createImageInputStream(tmp.toFile())) {
            Iterator<ImageReader> readers = ImageIO.getImageReaders(iis);
            while (readers.hasNext()) {
                ImageReader r = readers.next();
                System.out.println("Reader disponible: " + r.getClass().getName() + " (" + r.getFormatName() + ")");
            }
            iis.seek(0);
            Iterator<ImageReader> readers2 = ImageIO.getImageReadersByFormatName("webp");
            while (readers2.hasNext()) {
                ImageReader r = readers2.next();
                System.out.println("Reader WebP: " + r.getClass().getName());
                r.setInput(iis);
                System.out.println("Num images: " + r.getNumImages(true));
                System.out.println("Width x Height: " + r.getWidth(0) + " x " + r.getHeight(0));
            }
        }
    }
}
