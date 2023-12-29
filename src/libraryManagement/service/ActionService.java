package libraryManagement.service;

import libraryManagement.model.*;
import libraryManagement.repo.RackRepo;

public class ActionService {

    GetRackService getRackService = new GetRackService();
    UserService userService = new UserService();

    RackRepo rackRepo = RackRepo.getInstance();

    public void removeBook(String bookCopyId) {
        rackRepo.freeBookRack(bookCopyId);
    }


    public void reserveBook(String bookId, String userId, String dueDate) {

        User user = userService.getUserById(userId);

        if (user.getBooksIssued() == 5) {
            System.out.println("Cant issue more books");
            return;
        }
        Rack rack = getRackService.getBook(bookId);
        BookCopy bookCopy = rack.getBookCopy();
        bookCopy.setBookCopyStatus(BookCopyStatus.RESERVED);
        bookCopy.setIssuedTo(user);
        bookCopy.setDueDate(dueDate);

        rack.setRackStatus(RackStatus.AVAILABLE);
        rack.setBookCopy(null);
        user.setBooksIssued(user.getBooksIssued()+1);

    }




}
