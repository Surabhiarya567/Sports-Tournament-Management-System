# SPORTS TOURNAMENT MANAGEMENT SYSTEM

## 1. Project Overview

The **Sports Tournament Management System** is a console-based Java application for managing teams, players, matches, tournament details, player searches, and match results.

The project demonstrates Java Object-Oriented Programming concepts from Unit I and Unit II using classes, inheritance, abstraction, interfaces, arrays, constructors, methods, control statements, and custom packages.

---

## 2. Technologies & Package Structure

**Technologies:** Java, Scanner, `javac`, `java`, arrays, OOP and custom packages.

```text
src/
└── com/sports/
    ├── model/
    │   ├── Person.java
    │   ├── Player.java
    │   ├── Coach.java
    │   ├── Team.java
    │   ├── Match.java
    │   ├── Tournament.java
    │   ├── SportType.java
    │   └── MatchUpdatable.java
    ├── service/
    │   └── TournamentManager.java
    └── main/
        └── Main.java
```

---

## 3. Main Features

1. Register Team
2. Add Player
3. View Teams
4. View Players
5. Schedule Match
6. View Matches
7. Search Player
8. Update Match Result
9. Display Tournament Details
10. Exit

### Match Validation

* Duplicate Match IDs are rejected.
* Both teams must exist.
* A team cannot play against itself.
* Both teams must belong to the same sport.
* Past/today's matches cannot remain `NOT PLAYED`.
* Future matches must initially be `NOT PLAYED`.
* Invalid date formats are rejected.

---

## 4. Java Concept Traceability

| Java Requirement          | Implementation                                                        |
| ------------------------- | --------------------------------------------------------------------- |
| Encapsulation             | Private fields with getters/setters                                   |
| Data types & scope        | `String`, `int`, `double`, `boolean`, instance/local/static variables |
| Operators & precedence    | `playerCount * 10.0 + 5.0` in `Team`                                  |
| Type casting              | `(int) score` in `Team`                                               |
| Enum                      | `SportType`                                                           |
| if-else                   | Validation and search                                                 |
| switch                    | Main menu and sport selection                                         |
| Loops                     | `while` and `for` loops                                               |
| break / continue / return | Used throughout menu, validation and methods                          |
| Arrays of objects         | `Team[]`, `Player[]`, `Match[]`                                       |
| Console I/O               | `Scanner`, `println()`, `printf()`                                    |
| Formatted output          | `printf()` and `String.format()`                                      |
| Constructor overloading   | Default and parameterized constructors                                |
| Constructor chaining      | `this()`                                                              |
| Method overloading        | `addPlayers(int)` and `addPlayers(int, boolean)`                      |
| Static                    | `Team.totalTeams`, `getTotalTeams()`                                  |
| `this`                    | Constructors and setters                                              |
| String methods            | `trim()`, `equalsIgnoreCase()`, `toLowerCase()`, `contains()`         |
| Inheritance               | `Person → Player`, `Person → Coach`                                   |
| `super`                   | Used in subclass constructors and `toString()`                        |
| Overriding                | `displayRole()` and `toString()`                                      |
| Dynamic binding           | `Person` reference referring to `Player`                              |
| Abstract class/method     | `Person` and `displayRole()`                                          |
| Interface                 | `MatchUpdatable` implemented by `Match`                               |
| Interface reference       | `MatchUpdatable updater = updateMatch`                                |
| `toString()`              | Overridden in model classes                                           |
| Final method              | `Person.displayBasicInfo()`                                           |
| Custom packages           | `model`, `service`, `main`                                            |

---

## 5. Data Management

`TournamentManager` manages arrays of teams, players, and matches.

The system supports:

* Team and player registration
* Match scheduling and viewing
* Player searching using partial names
* Team and match lookup
* Duplicate Match ID checking
* Match result updates
* Array capacity checking
* Invalid input/menu handling

---

## 6. Match Result Update

The organizer can update an existing match using its Match ID.

Example:

```text
===== UPDATE MATCH RESULT =====
Enter Match ID: M01
Enter New Result: RCB WON

Match result updated successfully!
```

The `MatchUpdatable` interface is implemented by `Match` and accessed through an interface reference.

---

## 7. Compilation and Execution

### Compile

```text
javac -d out src\com\sports\model\*.java src\com\sports\service\*.java src\com\sports\main\*.java
```

### Run

```text
java -cp out com.sports.main.Main
```

---

## 8. DFD and UML

The project documentation includes:

* **DFD Level 0:** Overall interaction between the user and the tournament system.
* **DFD Level 1:** Team management, player management, match scheduling, player search, result updating, and tournament details.
* **UML Class Diagram:** Shows the main classes, inheritance hierarchy, and interface relationship.

Inheritance:

```text
        Person
        /    \
    Player   Coach
```

Interface:

```text
MatchUpdatable
      ↑
    Match
```

---

## 9. Testing

| Test Case                   | Expected Result           |
| --------------------------- | ------------------------- |
| Register Team               | Team added                |
| Add Player                  | Player added              |
| View Teams/Players          | Records displayed         |
| Schedule valid match        | Match scheduled           |
| Different sports            | Match rejected            |
| Duplicate Match ID          | Match rejected            |
| Same team vs itself         | Match rejected            |
| Past match + result         | Accepted                  |
| Past match + `NOT PLAYED`   | Rejected                  |
| Future match + `NOT PLAYED` | Accepted                  |
| Search Player               | Matching player displayed |
| Update Match Result         | Result updated            |
| Invalid Match ID            | Error displayed           |
| Exit                        | Program terminates        |

---

## 10. Conclusion

The **Sports Tournament Management System** provides a practical console-based implementation of Java Unit I and Unit II concepts. It demonstrates OOP principles including encapsulation, inheritance, abstraction, polymorphism, interfaces, constructors, static/final members, arrays, control flow, strings, console I/O, and custom packages while providing a functional tournament management application.
