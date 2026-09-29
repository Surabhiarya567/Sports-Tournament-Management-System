package com.sports.model;

public class Player extends Person {

    private String playerId;
    private String position;

    // Default constructor
    public Player() {
        super();
        this.playerId = "P000";
        this.position = "Not Assigned";
    }

    // Parameterized constructor
    public Player(String name, int age, String playerId, String position) {
        super(name, age);
        this.playerId = playerId;
        this.position = position;
    }

    // Getters
    public String getPlayerId() {
        return playerId;
    }

    public String getPosition() {
        return position;
    }

    // Setters
    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Method overriding
    @Override
    public void displayRole() {
        System.out.println("Role: Player");
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Player ID: " + playerId
                + ", Position: " + position;
    }
}