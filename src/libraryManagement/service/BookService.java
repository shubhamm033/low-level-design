package libraryManagement.service;

import libraryManagement.model.*;
import libraryManagement.repo.BookCopyRepo;
import libraryManagement.repo.BookRepo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookService {

    BookRepo bookRepo = BookRepo.getInstance();
    BookCopyRepo bookCopyRepo = BookCopyRepo.getInstance();

    GetRackService getRackService =new GetRackService();

    RackService rackService = new RackService();

    public void addBooks(String bookId,
                         String bookTitle,
                         String authors,
                         String publishers,
                         String bookCopyIds) {

        String[] authorList = authors.split(",");
        List<String> authorListNew = Arrays.asList(authorList);

        String[] pubList = publishers.split(",");
        List<String> publishersList = Arrays.asList(pubList);

        String[] bookCopy = bookCopyIds.split(",");
        List<String> bookCopList = Arrays.asList(bookCopy);

        List<Integer> racks = new ArrayList<>();
        for (String bookCopyId: bookCopList) {
            BookCopy bookCopy1 = new BookCopy();
            bookCopy1.setBookCopyId(bookCopyId);
            bookCopy1.setBookCopyStatus(BookCopyStatus.AVAILABLE);

            Integer rackNo = getRackService.getRack();

            if (rackNo == null) {
                System.out.println("Rack Not Available");
                return;
            }
            racks.add(rackNo);
            rackService.bookRack(bookCopy1, rackNo);
            bookCopyRepo.addBookCopyList(bookCopy1);

        }

        System.out.println(String.format("Book %s added to rack %s", bookId, racks));
        Book book = new Book();
        book.setAuthor(authorListNew);
        book.setPublisher(publishersList);
        book.setId(Integer.parseInt(bookId));
        book.setTitle(bookTitle);


        bookRepo.addBook(book);
        System.out.println(String.format("book Added %s", book.getId()));

        for (String author: authorListNew) {
            bookRepo.updateCatalog(author, book);

        }

        for (String publisher: publishersList) {
            bookRepo.updateCatalog(publisher, book);
        }

        bookRepo.updateCatalog(bookTitle, book);
        bookRepo.updateCatalog(bookId, book);
    }


    public List<BookCopy> getBookCopyForUser(String userId) {
        return bookCopyRepo.getBookForUser(userId);

    }
}
