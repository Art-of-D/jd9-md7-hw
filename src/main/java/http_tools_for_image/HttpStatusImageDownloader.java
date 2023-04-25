package http_tools_for_image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    String string;
    public void HttpStatusImageDownloader(int code) throws Exception {
        string = new HttpStatusChecker().getStatusImage(code);
        Image image = ImageIO.read(new URL(string));
        if (image == null){
            throw new Exception("NO IMAGE");
        } else {
            try(InputStream in = new URL(string).openStream()){
                Files.copy(in, Paths.get("client-server"));
            }
        }
    }
}
