package controller;

import dao.DaoBook;
import model.Book;
import view.MenuView;

import java.util.ArrayList;

public class MenuController {
    private MenuView menuView;
    private DisplayAllBooksController displayAllBooksController;

    public MenuController() {
        this.menuView = new MenuView();
    }
    public void startMenu() {
        boolean programActive = true;
        while(programActive) {
            menuView.displayMenu();
            String option = menuView.getInputFromUser("Choose option: ");
            switch (option) {
                case "1":
                    displayAllBooksController = new DisplayAllBooksController();
                    ArrayList<Book> books = new DaoBook().importAllBooks();
                    displayAllBooksController.showBooksInfo(books);
                    break;
                case "0":
                    programActive = false;
                    break;
                default:
                    menuView.displayText("Wrong option\n");
                    break;
            }
        }
    }
}
