package libraryManagement;

import libraryManagement.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Driver {

    static Manager manager = new Manager();

    public static void main(String[] args) throws FileNotFoundException {

        File initialFile = new File("src/libraryManagement/input.txt");

        final InputStream targetStream = new FileInputStream(initialFile);

        Scanner scanner = new Scanner(targetStream);

        while (true) {
            String command = scanner.nextLine();
//            System.out.println(command);
            String[] commands = command.split(" ");
            String commandType = commands[0];


            switch (commandType) {

                case "create_library":
                    manager.createLibrary(commands[1]);
                    break;


                case "add_book":
                    manager.addBooks(commands);
                    break;


                case "search":
                    manager.searchBook(commands[2]);
                    break;


                case "remove_book_copy":
                    manager.removeBookCopy(commands[1]);
                    break;

//
                case "print_borrowed":
                    manager.printborrowedBooks(commands[1]);
                    break;
//
//
                case "borrow_book":
                    manager.borrowBook(commands);

                    break;
//
//                case "return_book_copy":
//                    break;
//
//
//                case "borrow_book_copy":
//                    break;

                default:
                    System.out.println("exit");
            }

        }}}
