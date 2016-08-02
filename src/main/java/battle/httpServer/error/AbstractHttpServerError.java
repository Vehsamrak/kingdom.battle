package battle.httpServer.error;

import battle.httpServer.HttpCode;

/**
 * @author Vehsamrak
 */
abstract public class AbstractHttpServerError
{
    abstract public HttpCode getHttpCode();
    abstract public String getMessage();
}
