package http_tools_for_image;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpStatusChecker {
    public static final String URL = "https://http.cat/%d.jpg";
    public String getStatusImage(int code) throws InterruptedException, IOException {
        if (code >= 100 && code <= 600) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(String.format(URL, code)))
                    .timeout(Duration.ofSeconds(30))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return String.valueOf(response.request().uri());
        } else {
                throw new IOException("Non valid code");
            }
        }
}
