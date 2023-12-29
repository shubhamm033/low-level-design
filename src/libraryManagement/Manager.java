package libraryManagement;

import libraryManagement.model.Book;
import libraryManagement.model.BookCopy;
import libraryManagement.model.User;
import libraryManagement.repo.BookCopyRepo;
import libraryManagement.repo.BookRepo;
import libraryManagement.repo.RackRepo;
import libraryManagement.service.ActionService;
import libraryManagement.service.BookService;
import libraryManagement.service.RackService;
import libraryManagement.service.SearchService;

import java.util.List;

public class Manager {


    RackService rackService = new RackService();
    SearchService searchService = new SearchService();

    BookService bookService = new BookService();

    ActionService actionService = new ActionService();

    public void createLibrary(String number) {
        rackService.createRacks(Integer.parseInt(number));


    }

    public void searchBook(String key) {
        searchService.serachByKey(key);

    }

    public void addBooks(String[] commands) {
        String bookId = commands[1];
        String bookTitle = commands[2];
        String authors = commands[3];
        String publishers = commands[4];
        String bookCopyIds = commands[5];
        bookService.addBooks(bookId, bookTitle, authors, publishers, bookCopyIds);

    }

    public void removeBookCopy(String bookCopyId) {
        actionService.removeBook(bookCopyId);
    }


    public void borrowBook(String[] commands) {
        String bookId = commands[1];
        String userId = commands[2];
        String dueDate = commands[3];
        actionService.reserveBook(bookId, userId, dueDate);

    }



    public void printborrowedBooks(String userId) {
            List<BookCopy> bookRepoList = bookService.getBookCopyForUser(userId);

            for(BookCopy bookCopy : bookRepoList) {
                System.out.println(bookCopy);
            }

    }




}
