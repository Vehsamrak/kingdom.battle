package battle.httpServer.error;

import battle.httpServer.HttpCode;

/**
 * @author Vehsamrak
 */
public class RouteNotFound extends AbstractHttpServerError
{

    @Override
    public HttpCode getHttpCode()
    {
        return HttpCode.NOT_FOUND;
    }

    @Override
    public String getMessage()
    {
        return "Route was not found.";
    }
}
