package NAU.view;

import NAU.controller.IController;
import NAU.view.swing.MainWindow;

import javax.swing.*;


public class View implements IView {
    private MainWindow mainWindow;
    private IController controller;

    public View(IController c) {
        controller = c;
    }

    public void startView() {

        /*try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }*/

        mainWindow = new MainWindow(controller);
    }

}
