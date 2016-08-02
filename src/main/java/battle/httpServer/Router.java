package battle.httpServer;

import battle.httpServer.error.AbstractHttpServerError;
import battle.httpServer.error.RouteNotFound;
import battle.httpServer.controller.AbstractController;
import battle.httpServer.controller.DefaultController;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * @author Vehsamrak
 */
public class Router implements HttpHandler
{

    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        String route = exchange.getRequestURI().getPath();

        if (this.isRouteExists(route)) {
            AbstractController controller = this.getControllerByRoute(route);
            String html = controller.render();

            this.sendResponse(exchange, HttpCode.OK, html);
        } else {
            this.sendResponse(exchange, new RouteNotFound());
        }
    }

    private void setContentTypeHeader(HttpExchange exchange)
    {
        Headers headers = exchange.getResponseHeaders();
        headers.add("Content-Type", "application/json");
    }

    public void sendResponse(HttpExchange exchange, HttpCode httpCode, String html) throws IOException
    {
        byte[] bytes = html.getBytes();

        this.setContentTypeHeader(exchange);
        exchange.sendResponseHeaders(httpCode.getCode(), bytes.length);

        OutputStream output = exchange.getResponseBody();
        output.write(bytes);
        output.close();
    }
    public void sendResponse(HttpExchange exchange, AbstractHttpServerError error) throws IOException
    {
        this.sendResponse(exchange, error.getHttpCode(), error.getMessage());
    }

    private AbstractController getControllerByRoute(String route)
    {
        return this.getRoutes().get(route);
    }

    private boolean isRouteExists(String route)
    {
        return this.getRoutes().containsKey(route);
    }

    private HashMap<String, AbstractController> getRoutes()
    {
        HashMap<String, AbstractController> routes = new HashMap<String, AbstractController>();

        routes.put("/", new DefaultController());

        return routes;
    }
}
