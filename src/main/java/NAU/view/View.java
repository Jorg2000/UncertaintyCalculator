package NAU.view;

import NAU.controller.IController;
import NAU.view.swing.MainWindow;

/**
 * Created by root on 06.09.2015.
 */
public class View implements IView {
    MainWindow mainWindow;
    IController controller;

    public View(IController c) {
        controller = c;
    }

    public void startView() {
        mainWindow = new MainWindow(controller);
    }

}
