package controller;

public class AppController {
    private MenuController menuController;
    public AppController() {
        this.menuController = new MenuController();
    }

    public void runApp() {
        menuController.startMenu();
    }
}
