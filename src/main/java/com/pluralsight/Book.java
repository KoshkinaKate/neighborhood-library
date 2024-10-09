package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean  isCheckedOut;
    private String checkedOutTo;

//constructor that takes in the required properties as parameters and sets them when a new instance of Book is created
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false; //because book can not be checked out at the beginning
        this.checkedOutTo = null; //same as above
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

// Check out method
    public void checkOut(String userName) {
        if (!isCheckedOut) { //checks if the book is not already checked out (return false- means available)
            this.isCheckedOut = true; // changes from false to true and means the book is checked out
            this.checkedOutTo = userName; //set the user who is checking out the book
            System.out.println(title + " has been checked out by " + userName);
        } else {
            System.out.println(title + " is already checked out.");
        }
    }

// Check in method
    public void checkIn() {
        if (isCheckedOut) { //checking if it is true
            this.isCheckedOut = false; //book has been returned
            this.checkedOutTo = null; //clear the name of the person who checked it out
            System.out.println(title + " has been checked in");
        } else {
            System.out.println(title + " is not currently checked out.");
        }
    }


}
