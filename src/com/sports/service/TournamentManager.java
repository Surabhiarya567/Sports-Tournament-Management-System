package com.sports.service;

import com.sports.model.Match;
import com.sports.model.Player;
import com.sports.model.Team;
import com.sports.model.Person;

public class TournamentManager {

    private Team[] teams;
    private Player[] players;
    private Match[] matches;

    private int teamCount;
    private int playerCount;
    private int matchCount;

    // Constructor
    public TournamentManager() {
        teams = new Team[10];
        players = new Player[30];
        matches = new Match[20];

        teamCount = 0;
        playerCount = 0;
        matchCount = 0;
    }

    // Add a team
    public void addTeam(Team team) {
        if (teamCount < teams.length) {
            teams[teamCount] = team;
            teamCount++;
            System.out.println("Team added successfully.");
        } else {
            System.out.println("Team limit reached.");
        }
    }

    // Add a player
    public void addPlayer(Player player) {
        if (playerCount < players.length) {
            players[playerCount] = player;
            playerCount++;
            System.out.println("Player added successfully.");
        } else {
            System.out.println("Player limit reached.");
        }
    }

    // Add a match
    public void addMatch(Match match) {
        if (matchCount < matches.length) {
            matches[matchCount] = match;
            matchCount++;
            System.out.println("Match scheduled successfully.");
        } else {
            System.out.println("Match limit reached.");
        }
    }

    // Display all teams
    public void displayTeams() {

        System.out.println("\n===== REGISTERED TEAMS =====");

        if (teamCount == 0) {
            System.out.println("No teams registered.");
            return;
        }

        for (int i = 0; i < teamCount; i++) {
            System.out.println(teams[i]);
        }
    }

    public void displayPlayers() {

    System.out.println("\n===== REGISTERED PLAYERS =====");

    if (playerCount == 0) {
        System.out.println("No players registered.");
        return;
    }

    for (int i = 0; i < playerCount; i++) {

        // Person reference referring to a Player object
        Person person = players[i];

        // Dynamic binding: Player's overridden method is called
        person.displayRole();

        // Final method inherited from Person
        person.displayBasicInfo();

        System.out.println("Player ID: " + players[i].getPlayerId());
        System.out.println("Position: " + players[i].getPosition());
        System.out.println("--------------------------------");
    }
}
    // Display all matches
    public void displayMatches() {

        System.out.println("\n===== SCHEDULED MATCHES =====");

        if (matchCount == 0) {
            System.out.println("No matches scheduled.");
            return;
        }

        for (int i = 0; i < matchCount; i++) {
            System.out.println(matches[i]);
        }
    }

    // Search player by name
    public void searchPlayer(String name) {

        boolean found = false;

        for (int i = 0; i < playerCount; i++) {

            if (players[i].getName().toLowerCase().contains(name.trim().toLowerCase())) {
                System.out.println("\nPlayer Found:");
                System.out.println(players[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Player not found.");
        }
    }
    // Get number of registered teams
public int getTeamCount() {
    return teamCount;
}

// Find team using Team ID
public Team findTeam(String teamId) {

    for (int i = 0; i < teamCount; i++) {

        if (teams[i] != null) {

            String storedId = teams[i].getTeamId();

            if (storedId.equalsIgnoreCase(teamId.trim())) {
                return teams[i];
            }
        }
    }

    return null;
}
// Check whether a Match ID already exists
public boolean matchIdExists(String matchId) {

    for (int i = 0; i < matchCount; i++) {

        if (matches[i] != null
                && matches[i].getMatchId().equalsIgnoreCase(matchId.trim())) {
            return true;
        }
    }

    return false;
}
// Find match using Match ID
public Match findMatch(String matchId) {

    for (int i = 0; i < matchCount; i++) {

        if (matches[i] != null &&
            matches[i].getMatchId().equalsIgnoreCase(matchId.trim())) {

            return matches[i];
        }
    }

    return null;
}
}