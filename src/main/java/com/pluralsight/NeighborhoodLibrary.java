package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static void main(String[] args) {

        // Declaring an array (object of type Book)
        Book[] inventory = new Book[5];

        inventory[0] = new Book(1, "789-092-45-76", "Pride and Prejudice");
        inventory[1] = new Book(2, "789-4r4-f3-00", "Anna Karenina");
        inventory[2] = new Book(3, "789-oo9-10-09", "To Kill a Mockingbird");
        inventory[3] = new Book(4, "789-i91-13-12", "War and Peace");
        inventory[4] = new Book(5, "789-06u-09-89", "Republic");

        // The Store Home Screen
        Scanner myScanner = new Scanner(System.in);

        // Run a loop until the user quits the program.
        while (true) {
            // Display the options menu to the user.
            System.out.println("What do you want to do?");
            System.out.println("  1 - Show available books");
            System.out.println("  2 - Show checked out books");
            System.out.println("  3 - Exit");
            System.out.println("Enter your command:");

            // Read the user's input command.
            int command = myScanner.nextInt();
            myScanner.nextLine();  // Consume newline character after the number input

            // Use switch to handle user's choices
            switch (command) {
                case 1:
                    findAllBooks(inventory, myScanner); // Show available books
                    break;
                case 2:
                    findCheckedOutBooks(inventory, myScanner); // Show checked out books
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;  // Exit the program
                default:
                    // Display an error message if the user inputs an invalid command.
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    // Method to find and display all available books
    public static void findAllBooks(Book[] inventory, Scanner myScanner) { //takes an array of Book objects + scanner for input
        System.out.println("All available books:");
        boolean found = false; //initializing to false - meaning no books found and if so goes to the end
        for (Book book : inventory) { // for each loop , Book object and inventory array
            if (!book.isCheckedOut()) { // checks if book is not checked out
                System.out.println("ID " + book.getId() + " - " + book.getTitle() + " isbn - (" + book.getIsbn() + ")");
                found = true; //if at least one book is found it sets to true
            }
        }
        if (!found) { // if books are not found then- means false confirmed
            System.out.println("No books are available.");
            return; //exits if no books are available
        }
        System.out.println("Please enter the book ID to check out, or type 0 to go back to the menu:");

        int bookId = myScanner.nextInt(); //reading user input of Id (which is integer)
        myScanner.nextLine();

        if (bookId == 0) {
            return; //goes back to the home screen
        }

        for (Book book : inventory) {
            if (book.getId() == bookId && !book.isCheckedOut()){
                System.out.println("Enter your name to check out the book: ");
                String userName = myScanner.nextLine();//reads user's name
                book.checkOut(userName); // this checkOut method is used to update the book status
//                System.out.println(book.getTitle() + " has been checked out by " + userName);
                return; // book is checked out
            }
        }
        System.out.println("The book is already checked out.");


    }

    // Method to find and display all checked out books
    public static void findCheckedOutBooks(Book[] inventory, Scanner myScanner) {
        System.out.println("Checked Out Books:");
        boolean found = false; // found the result of the search if not found goes to the end, meaning have not found anything yet.
        for (Book book : inventory) {
            if (book.isCheckedOut()) { // display if the book is checked out
                System.out.println( "ID " + book.getId() + "-" + book.getTitle() + " isbn - (" + book.getIsbn() + ") - Checked out by " + book.getCheckedOutTo());
                found = true; // it is true if found at least one book that has been checked out
            }
        }
        if (!found) {
            System.out.println("No books are currently checked out.");
        }

        //implementing conditions for user to check in a book or to return to main menu
        System.out.println(" Please enter 'C' if you would like to check in the book or 'X' to return to the main menu ");
        String choice = myScanner.nextLine().toUpperCase();

        if (choice.equals("X")){
            return;
        }else if (choice.equals("C")) {
            System.out.println("Please enter the book ID to check in: ");
            int bookId = myScanner.nextInt();
            myScanner.nextLine();

            for (Book book : inventory) {
                if (book.getId() == bookId && book.isCheckedOut()) {
                    book.checkIn();
                    return;
                }
            }
        }else {
            // If the user entered an invalid option
            System.out.println("Invalid option. Returning to the home screen.");
        }

    }

}

