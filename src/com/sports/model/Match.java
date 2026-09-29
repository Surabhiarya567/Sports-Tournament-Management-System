package com.sports.model;

public class Match implements MatchUpdatable {

    private String matchId;
    private Team team1;
    private Team team2;
    private String venue;
    private String matchDate;
    private String result;

    // Default constructor
    public Match() {
        this(
            "M000",
            new Team(),
            new Team(),
            "Not Assigned",
            "Not Scheduled",
            "Not Played"
        );
    }

    // Parameterized constructor
    public Match(String matchId, Team team1, Team team2,
                 String venue, String matchDate, String result) {

        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.venue = venue;
        this.matchDate = matchDate;
        this.result = result;
    }

    // Getters
    public String getMatchId() {
        return matchId;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public String getVenue() {
        return venue;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public String getResult() {
        return result;
    }

    // Setters
    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public void setResult(String result) {
        this.result = result;
    }

    // Method to display match details
    public void displayMatch() {
        System.out.println("Match ID: " + matchId);
        System.out.println("Team 1: " + team1.getTeamName());
        System.out.println("Team 2: " + team2.getTeamName());
        System.out.println("Venue: " + venue);
        System.out.println("Date: " + matchDate);
        System.out.println("Result: " + result);
    }

    @Override
public void updateResult(String result) {
    this.result = result;
}

    @Override
    public String toString() {
        return "Match ID: " + matchId
                + " | " + team1.getTeamName()
                + " vs " + team2.getTeamName()
                + " | Venue: " + venue
                + " | Date: " + matchDate
                + " | Result: " + result;
    }
}