import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SimpleHttpClient {

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public enum Method {
        GET, POST, PUT
    }

    public static String request(String url, Method method, String body) {
        try {
            HttpRequest.Builder builder = HttpRequest.newBuilder()
                    .uri(URI.create(url));

            switch (method) {
                case GET -> builder.GET();
                case POST -> builder.header("Content-Type", "application/json")
                                    .POST(HttpRequest.BodyPublishers.ofString(body));
                case PUT -> builder.header("Content-Type", "application/json")
                                   .PUT(HttpRequest.BodyPublishers.ofString(body));
            }

            HttpRequest request = builder.build();

            HttpResponse<String> response =
                    CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("HTTP request failed: " + e.getMessage(), e);
        }
    }

    public static String get(String url) {
        return request(url, Method.GET, null);
    }

    public static String postJson(String url, String json) {
        return request(url, Method.POST, json);
    }

    public static String putJson(String url, String json) {
        return request(url, Method.PUT, json);
    }
}
