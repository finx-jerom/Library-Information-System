/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package System_Files;

/**
 *
 * @author pc
 */
public class Student {

    private int id;
    private String name;
    private String course;
    private int year;

    public Student() {
    }

    public Student(int id, String name, String course, int year) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public Student(String name, String course, int year) {
        this.name = name;
        this.course = course;
        this.year = year;
    }

    // Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
