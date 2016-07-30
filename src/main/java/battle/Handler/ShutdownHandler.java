package battle.Handler;

import com.sun.net.httpserver.HttpServer;

/**
 * Stops HttpServer
 * @author Vehsamrak
 */
public class ShutdownHandler implements Runnable
{

    private HttpServer server;

    public ShutdownHandler(HttpServer server)
    {
        this.server = server;
    }

    @Override
    public void run()
    {
        server.stop(1);
    }
}
