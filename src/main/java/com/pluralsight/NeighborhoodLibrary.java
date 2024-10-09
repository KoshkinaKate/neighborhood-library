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
                    findAllBooks(inventory); // Show available books
                    break;
                case 2:
                    findCheckedOutBooks(inventory); // Show checked out books
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
    public static void findAllBooks(Book[] inventory) { //takes an array of Book objects
        System.out.println("All available books:");
        boolean found = false; //initializing to false - meaning no books found and it so goes to the end
        for (Book book : inventory) { // for each loop , Book object and inventory array
            if (!book.isCheckedOut()) { // checks if book is not checked out
                System.out.println(book.getId() + " - " + book.getTitle());
                found = true; //if at least one book is found it sets to true
            }
        }
        if (!found) { // if books are not found then-
            System.out.println("No books are available.");
        }
    }

    // Method to find and display all checked out books
    public static void findCheckedOutBooks(Book[] inventory) {
        System.out.println("Checked Out Books:");
        boolean found = false;
        for (Book book : inventory) {
            if (book.isCheckedOut()) { // display if the book is checked out
                System.out.println( book.getId() + "-" + book.getTitle());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books are currently checked out.");
        }
    }
}

