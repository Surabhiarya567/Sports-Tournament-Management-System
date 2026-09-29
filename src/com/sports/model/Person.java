package com.sports.model;

public abstract class Person {

    private String name;
    private int age;

    // Default constructor
    public Person() {
        this.name = "Unknown";
        this.age = 0;
    }

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Abstract method
    public abstract void displayRole();
    // Final method because basic person information should not be changed by subclasses
public final void displayBasicInfo() {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
}

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}