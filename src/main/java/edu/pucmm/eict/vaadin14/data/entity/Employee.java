package edu.pucmm.eict.vaadin14.data.entity;



public class Employee {
    String name;
    String title;
    String image;

    public Employee() {
    }

    public Employee(String name, String title, String image) {
        this.name = name;
        this.title = title;
        this.image = image;
    }

    public Employee(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
