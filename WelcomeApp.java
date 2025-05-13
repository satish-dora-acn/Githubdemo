import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;

public class WelcomeApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", new WelcomeHandler());
        server.setExecutor(null); // Default executor
        server.start();
        System.out.println("Server started at http://localhost:8080");

        // Show response first via curl
        Thread.sleep(2000);
        System.out.println("Ready for curl request...");

        // Server stays alive a bit longer
        Thread.sleep(5000);
        server.stop(0);
        System.out.println("Server stopped.");
    }

    static class WelcomeHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "Welcome to my Java app!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();
        }
    }
}
