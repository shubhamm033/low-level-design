package libraryManagement.repo;

import libraryManagement.model.Book;
import libraryManagement.model.BookCopy;
import libraryManagement.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepo {
    public static BookRepo instance = null;


    List<Book> bookList = new ArrayList<>();

    Map<String, List<Book>> mapBook = new HashMap<String, List<Book>>();

    private BookRepo() {}


    public static BookRepo getInstance() {

        if (instance == null) {
            instance = new BookRepo();
        }

        return instance;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }


    public void updateCatalog(String key, Book book) {
        if (mapBook.containsKey(key)) {
            List<Book> books = mapBook.get(key);
            books.add(book);
            mapBook.put(key, books);
        }

        else{
            List<Book> books = new ArrayList<>();
            books.add(book);
            mapBook.put(key, books);
        }


    }

    public List<Book> getBookBykey(String key) {
        return mapBook.get(key);
    }





}
