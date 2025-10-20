package praktikum_4;

public class Book {
    private String title;
    private String author;
    private boolean isAvailable;
    //Konstruktor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    //getter : Akses Data
    public String getTitle() { 
    	return title; 
    }
    public String getAuthor() { 
    	return author; 
    }
    public boolean isAvailable() { 
    	return isAvailable; 
    }
    //setter : Modif data
    public void borrowBook() {
    	this.isAvailable = false; 
    }
    public void returnBook() {
    	this.isAvailable = true; 
    }
}

