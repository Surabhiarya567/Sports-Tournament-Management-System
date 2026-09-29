package com.sports.model;

public class Tournament {

    private String tournamentId;
    private String tournamentName;
    private String location;
    private SportType sport;
    private int numberOfTeams;

    // Default constructor
    public Tournament() {
        this("TOUR000", "Unnamed Tournament", "Not Assigned",
             SportType.FOOTBALL, 0);
    }

    // Parameterized constructor
    public Tournament(String tournamentId, String tournamentName,
                      String location, SportType sport,
                      int numberOfTeams) {

        this.tournamentId = tournamentId;
        this.tournamentName = tournamentName;
        this.location = location;
        this.sport = sport;
        this.numberOfTeams = numberOfTeams;
    }

    // Getters
    public String getTournamentId() {
        return tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public String getLocation() {
        return location;
    }

    public SportType getSport() {
        return sport;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    // Setters
    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSport(SportType sport) {
        this.sport = sport;
    }

    public void setNumberOfTeams(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
    }

    // Method to update number of teams
    public void addTeam() {
        numberOfTeams++;
    }

    // Method to display tournament details
    public void displayTournament() {
        System.out.println("Tournament ID: " + tournamentId);
        System.out.println("Tournament Name: " + tournamentName);
        System.out.println("Location: " + location);
        System.out.println("Sport: " + sport);
        System.out.println("Number of Teams: " + numberOfTeams);
    }

    @Override
    public String toString() {
        return String.format(
                "Tournament ID: %s | Name: %s | Location: %s | Sport: %s | Teams: %d",
                tournamentId,
                tournamentName,
                location,
                sport,
                numberOfTeams
        );
    }
}