package battle.httpServer;

/**
 * @author Vehsamrak
 */
public enum HttpCode
{
    OK {
        @Override
        public int getCode()
        {
            return 200;
        }
    },
    NOT_FOUND {
        @Override
        public int getCode()
        {
            return 404;
        }
    };

    public abstract int getCode();
}
