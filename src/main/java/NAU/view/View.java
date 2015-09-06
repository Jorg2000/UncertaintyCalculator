package NAU.view;

import NAU.controller.IController;
import NAU.view.swing.MainWindow;


public class View implements IView {
    private MainWindow mainWindow;
    private IController controller;

    public View(IController c) {
        controller = c;
    }

    public void startView() {
        mainWindow = new MainWindow(controller);
    }

}
