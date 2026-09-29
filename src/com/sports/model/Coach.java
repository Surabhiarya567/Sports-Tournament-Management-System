package com.sports.model;

public class Coach extends Person {

    private String coachId;
    private String specialization;

    // Default constructor
    public Coach() {
        super();
        this.coachId = "C000";
        this.specialization = "General";
    }

    // Parameterized constructor
    public Coach(String name, int age, String coachId, String specialization) {
        super(name, age);
        this.coachId = coachId;
        this.specialization = specialization;
    }

    // Getters
    public String getCoachId() {
        return coachId;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Setters
    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // Method overriding
    @Override
    public void displayRole() {
        System.out.println("Role: Coach");
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Coach ID: " + coachId
                + ", Specialization: " + specialization;
    }
}