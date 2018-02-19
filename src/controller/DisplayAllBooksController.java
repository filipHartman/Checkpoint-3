package controller;

import dao.DaoBook;
import model.Book;
import view.DisplayAllBooksView;

import java.util.ArrayList;

public class DisplayAllBooksController {
    private DaoBook daoBook;
    private DisplayAllBooksView dabView;

    public DisplayAllBooksController() {
        this.daoBook = new DaoBook();
        this.dabView = new DisplayAllBooksView();
    }

    public ArrayList<Book> getAllBooksFromDB() {
        return daoBook.importAllBooks();
    }

    public void showBooksInfo(ArrayList<Book> books) {
        int numberOfBook = 1;
        for (Book book: books) {
            dabView.displayText(String.format("%d.\n", numberOfBook++));
            dabView.displayObjectInfo(book.toString());
        }
    }
}
