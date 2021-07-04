import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String... args) throws IOException {
        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(9000), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null);
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = ReturnedValue.getValue();
            t.sendResponseHeaders(200, response.length());
            t.setAttribute("Access-Control-Allow-Origin", "*");
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes(StandardCharsets.US_ASCII));
            os.close();
        }
    }
}