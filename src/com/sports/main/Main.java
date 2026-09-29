package com.sports.main;

import java.util.Scanner;

import java.time.LocalDate;
import com.sports.model.Team;
import com.sports.model.Match;
import com.sports.model.Player;
import com.sports.model.SportType;
import com.sports.model.Tournament;
import com.sports.model.MatchUpdatable;
import java.time.format.DateTimeFormatter;
import com.sports.service.TournamentManager;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TournamentManager manager = new TournamentManager();

        Tournament tournament = new Tournament(
                "T001",
                "REVA Sports Tournament",
                "REVA University",
                SportType.FOOTBALL,
                0
        );

        boolean running = true;

        while (running) {

            System.out.println("\n========================================");
            System.out.println("     SPORTS TOURNAMENT MANAGEMENT");
            System.out.println("========================================");
            System.out.println("1. Register Team");
            System.out.println("2. Add Player");
            System.out.println("3. View Teams");
            System.out.println("4. View Players");
            System.out.println("5. Schedule Match");
            System.out.println("6. View Matches");
            System.out.println("7. Search Player");
            System.out.println("8. Update Match Result");
            System.out.println("9. Display Tournament Details");
            System.out.println("10. Exit");
            System.out.println("========================================");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

    System.out.println("\n===== REGISTER TEAM =====");

    System.out.print("Enter Team ID: ");
    String teamId = scanner.nextLine();

    System.out.print("Enter Team Name: ");
    String teamName = scanner.nextLine();

    System.out.println("Select Sport:");
    System.out.println("1. Football");
    System.out.println("2. Cricket");
    System.out.println("3. Basketball");
    System.out.println("4. Volleyball");

    System.out.print("Enter sport choice: ");
    int sportChoice = scanner.nextInt();
    scanner.nextLine();

    SportType sport;

    switch (sportChoice) {
        case 1:
            sport = SportType.FOOTBALL;
            break;

        case 2:
            sport = SportType.CRICKET;
            break;

        case 3:
            sport = SportType.BASKETBALL;
            break;

        case 4:
            sport = SportType.VOLLEYBALL;
            break;

        default:
            System.out.println("Invalid sport. Football selected.");
            sport = SportType.FOOTBALL;
    }

    System.out.print("Enter number of players: ");
    int playerCount = scanner.nextInt();
    scanner.nextLine();

    Team team = new Team(
            teamId,
            teamName,
            sport,
            playerCount
    );

    manager.addTeam(team);

    // Update tournament sport according to the registered team
    tournament.setSport(sport);
    
    tournament.addTeam();

    System.out.println("\nTeam registered successfully!");
    System.out.println(team);

    break;

                case 2:

    System.out.println("\n===== ADD PLAYER =====");

    System.out.print("Enter Player Name: ");
    String playerName = scanner.nextLine();

    System.out.print("Enter Age: ");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter Player ID: ");
    String playerId = scanner.nextLine();

    System.out.print("Enter Position: ");
    String position = scanner.nextLine();

    Player player = new Player(
            playerName,
            age,
            playerId,
            position
    );

    manager.addPlayer(player);

    System.out.println("\nPlayer added successfully!");
    System.out.println(player);

    break;

                case 3:
                    manager.displayTeams();
                    break;

                case 4:
                    manager.displayPlayers();
                    break;

                case 5:

    System.out.println("\n===== SCHEDULE MATCH =====");

    if (manager.getTeamCount() < 2) {
        System.out.println("At least 2 teams are required to schedule a match.");
        break;
    }

    System.out.print("Enter Match ID: ");
    String matchId = scanner.nextLine();

    if (manager.matchIdExists(matchId)) {
    System.out.println("Match ID already exists. Please use a different Match ID.");
    break;
    }


    System.out.print("Enter Team 1 ID: ");
    String team1Id = scanner.nextLine();

    System.out.print("Enter Team 2 ID: ");
    String team2Id = scanner.nextLine();

    Team team1 = manager.findTeam(team1Id);
    Team team2 = manager.findTeam(team2Id);

    if (team1 == null || team2 == null) {
        System.out.println("One or both teams were not found.");
        break;
    }

    if (team1.getSport() != team2.getSport()) {
        System.out.println("Error: Both teams must belong to the same sport.");
        System.out.println("Match cannot be scheduled.");
        break;
    }

    if (team1 == team2) {
        System.out.println("A team cannot play against itself.");
        break;
    }

    System.out.print("Enter Venue: ");
    String venue = scanner.nextLine();


    System.out.print("Enter Match Date (dd-MM-yyyy): ");
    String matchDate = scanner.nextLine();

System.out.print("Enter Result: ");
String result = scanner.nextLine().trim();

try {
    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    LocalDate enteredDate =
            LocalDate.parse(matchDate, formatter);

    if (enteredDate.isBefore(LocalDate.now())
            && result.equalsIgnoreCase("NOT PLAYED")) {

        System.out.println("Error: A past match must have a result.");
        System.out.println("Use WON, DRAW, or SUSPENDED.");
        break;
    }

    if (enteredDate.isAfter(LocalDate.now())
            && !result.equalsIgnoreCase("NOT PLAYED")) {

        System.out.println("Error: A future match must be NOT PLAYED.");
        break;
    }

} catch (DateTimeParseException e) {
    System.out.println("Invalid date format. Please use dd-MM-yyyy.");
    break;
}

Match match = new Match(
        matchId,
        team1,
        team2,
        venue,
        matchDate,
        result
);

manager.addMatch(match);

System.out.println("Match scheduled successfully!");
System.out.println(match);

break;

    

                case 6:
                    manager.displayMatches();
                    break;

                case 7:

    System.out.println("\n===== SEARCH PLAYER =====");

    System.out.print("Enter player name: ");
    String searchName = scanner.nextLine();

    manager.searchPlayer(searchName);

    break;

                case 8:

    System.out.println("\n===== UPDATE MATCH RESULT =====");

    System.out.print("Enter Match ID: ");
    String updateMatchId = scanner.nextLine();

    Match updateMatch = manager.findMatch(updateMatchId);

    if (updateMatch == null) {
        System.out.println("Match not found.");
        break;
    }

    System.out.print("Enter New Result: ");
    String newResult = scanner.nextLine();

    MatchUpdatable updater = updateMatch;
    updater.updateResult(newResult);

    System.out.println("\nMatch result updated successfully!");
    System.out.println(updateMatch);

    break;

                case 9:
                    System.out.println("\n===== TOURNAMENT DETAILS =====");
                    tournament.displayTournament();
                    break;

                case 10:
                    running = false;
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
    continue;
            }
        }

        scanner.close();
    }
}