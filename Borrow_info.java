/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Files;

/**
 *
 * @author pc
 */
public class Borrow_info {

    private int id;
    private String Student_id;
    private String Name ;
    private String Book;

    public Borrow_info(){
    }

    public Borrow_info (int id, String Student_id, String Name, String Book) {
        this.id = id;
        this.Student_id = Student_id;
        this.Name = Name;
        this.Book = Book;
    }

    public Borrow_info (String Student_id, String Name, String Book) {
        this.Student_id = Student_id;
        this.Name = Name;
        this.Book = Book;
        
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getStudent_id() {
        return Student_id;
    }

    public void getStudent_id(String Student_id) {
        this.Student_id = Student_id;
    }    

    public String getName() {
        return Name;
    }

    public void getName(String Author) {
        this.Name = Name;
    }    

    public String getBook() {
        return Book;
    }

    public void getBook(String Book) {
        this.Book = Book;
    }
}

