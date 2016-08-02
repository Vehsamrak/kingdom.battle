package battle.httpServer.controller;

/**
 * @author Vehsamrak
 */
public class DefaultController extends AbstractController
{

    @Override
    public String render()
    {
        return "{\"test json\"}";
    }
}
