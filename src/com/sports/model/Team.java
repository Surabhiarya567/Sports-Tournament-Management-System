package com.sports.model;

public class Team { 

    private String teamId;
    private String teamName;
    private SportType sport;
    private int playerCount;

    // Static variable
    private static int totalTeams = 0;


    // Default constructor
    public Team() {
        this("T000", "Unknown Team", SportType.FOOTBALL, 0);
    }

    // Parameterized constructor
    public Team(String teamId, String teamName, SportType sport, int playerCount) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.sport = sport;
        this.playerCount = playerCount;
        totalTeams++;
    }

    // Getters
    public String getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public SportType getSport() {
        return sport;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    // Setters
    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setSport(SportType sport) {
        this.sport = sport;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    // Method overloading
    public void addPlayers(int count) {
        playerCount += count;
    }

    public void addPlayers(int count, boolean displayMessage) {
        playerCount += count;

        if (displayMessage) {
            System.out.println(count + " player(s) added.");
        }
    }

    // Static method
    public static int getTotalTeams() {
        return totalTeams;
    }



    @Override
    public String toString() {
        return String.format(
                "Team ID: %s | Team Name: %s | Sport: %s | Players: %d",
                teamId, teamName, sport, playerCount
        );
    }
    public int calculateTeamScore() {

    double score = playerCount * 10.0 + 5.0;

    // Explicit type casting: double converted to int
    int finalScore = (int) score;

    return finalScore;
}
}