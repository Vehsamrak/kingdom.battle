package battle;

import battle.handler.ShutdownHandler;
import battle.httpServer.Router;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

/**
 * @author Vehsamrak
 */
public class Launcher
{

    public void run() throws Exception
    {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(8000), 0);

        Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHandler(server), "shutdown-thread"));

        server.createContext("/", new Router());
        server.start();
    }
}
