package NAU;
import NAU.controller.Controller;
import NAU.controller.IController;
import NAU.view.IView;
import NAU.view.View;

public class App
{
    public static void main( String[] args )
    {
        IController controller = new Controller();
        IView view = new View(controller);
        view.startView();
    }
}
