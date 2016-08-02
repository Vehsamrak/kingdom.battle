package battle.httpServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Vehsamrak
 */
public class Router implements HttpHandler
{

    public static final int HTTP_OK = 200;

    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("test output");

        byte[] bytes = stringBuilder.toString().getBytes();

        exchange.sendResponseHeaders(HTTP_OK, bytes.length);

        OutputStream output = exchange.getResponseBody();
        output.write(bytes);
        output.close();
    }
}
