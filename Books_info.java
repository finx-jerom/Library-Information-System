/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Files;

/**
 *
 * @author pc
 */
public class Books_info {

    private int id;
    private String Book;
    private String Author ;
    private String Publisher;

    public Books_info(){
    }

    public Books_info (int id, String Book, String Author, String Publisher) {
        this.id = id;
        this.Book = Book;
        this.Author = Author;
        this.Publisher = Publisher;
    }

    public Books_info (String Book, String Author, String Publisher) {
        this.Book = Book;
        this.Author = Author;
        this.Publisher = Publisher;
        
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getBook() {
        return Book;
    }

    public void setBook(String Book) {
        this.Book = Book;
    }    

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }    

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }
}
