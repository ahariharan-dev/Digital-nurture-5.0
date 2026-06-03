import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientAPIExample {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.github.com/users/octocat"))
                .header("Accept", "application/vnd.github+json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Response body:");
            System.out.println(response.body());
        } catch (IOException e) {
            System.out.println("Request failed: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Request was interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
