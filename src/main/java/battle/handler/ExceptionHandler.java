package battle.handler;

/**
 * @author Vehsamrak
 */
public class ExceptionHandler
{
    public static boolean handle(Exception exception) {
        exception.printStackTrace();

        return true;
    }
}
