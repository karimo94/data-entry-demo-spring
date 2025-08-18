package com.karimo94.simpledataentry.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name", length = 255)
    @NotBlank(message = "Name field cannot be null or blank.")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "title", length = 255)
    @NotBlank(message = "Title field cannot be null or blank.")
    private String title;

    @Column(name = "hometown", length = 255)
    private String hometown;

    public Employee() {}
    public Employee(String name, int age, String title, String hometown) {
        super();
        this.age = age;
        this.name = name;
        this.title = title;
        this.hometown = hometown;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getHometown() {
        return hometown;
    }
    public void setHometown(String hometown) {
        this.hometown = hometown;
    }
}
