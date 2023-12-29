package libraryManagement.service;

import libraryManagement.model.Book;
import libraryManagement.model.User;
import libraryManagement.repo.BookRepo;

import java.util.List;

public class SearchService {

    BookRepo bookRepo = BookRepo.getInstance();
    public void serachByKey(String key) {

        List<Book> bookList =  bookRepo.getBookBykey(key);

        for (Book book: bookList) {
            System.out.println(book);
        }

    }





}
