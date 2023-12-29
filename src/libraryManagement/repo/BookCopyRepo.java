package libraryManagement.repo;

import libraryManagement.model.Book;
import libraryManagement.model.BookCopy;

import java.util.ArrayList;
import java.util.List;

public class BookCopyRepo {

    public static BookCopyRepo instance = null;


    List<BookCopy> bookCopyList = new ArrayList<>();

    private BookCopyRepo() {}


    public static BookCopyRepo getInstance() {

        if (instance == null) {
            instance = new BookCopyRepo();
        }

        return instance;
    }

    public void addBookCopyList(BookCopy bookCopy) {
        bookCopyList.add(bookCopy);
    }

    public List<BookCopy> getBookForUser(String userId) {

        return bookCopyList.stream().filter(obj -> obj.getIssuedTo() != null).
                filter(obj -> obj.getIssuedTo().getUserId().equals(userId)).toList();

    }

}
