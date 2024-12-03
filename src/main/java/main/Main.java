package main;

import football.Match;
import football.Player;
import football.Team;
import football.Tournament;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Football game:");

        Team t1 = new Team("Madrid");
        Team t2 = new Team("Chelsie");
        Team t3 = new Team("London");

        Player p1 = new Player("Messi", 29, "Striker", t1);
        Player p2 = new Player("Ronaldo", 28, "Striker", t2);
        Player p3 = new Player("Beckham", 30, "Striker", t3);
        Player p4 = new Player("Daniel", 28, "Defender", t1);
        Player p5 = new Player("Timothy", 30, "Defender", t2);
        Player p6 = new Player("Peter", 29, "Defender", t3);
        Player p7 = new Player("Anthony", 30, "Goalie", t1);
        Player p8 = new Player("Carl", 29, "Goalie", t2);
        Player p9 = new Player("Gregory", 28, "Goalie", t3);

        ArrayList<Player> playerList1 = new ArrayList<>();
        playerList1.add(p1);
        playerList1.add(p4);
        playerList1.add(p7);
        t1.setPlayers(playerList1);

        ArrayList<Player> playerList2 = new ArrayList<>();
        playerList2.add(p2);
        playerList2.add(p5);
        playerList2.add(p8);
        t2.setPlayers(playerList2);

        ArrayList<Player> playerList3 = new ArrayList<>();
        playerList3.add(p3);
        playerList3.add(p6);
        playerList3.add(p9);
        t3.setPlayers(playerList3);

        ArrayList<Team> teamList = new ArrayList<>();
        teamList.add(t1);
        teamList.add(t2);
        teamList.add(t3);

        Match m1 = new Match(t1, t2);
        Match m2 = new Match(t2, t3);
        Match m3 = new Match(t3, t1);

        ArrayList<Match> matchList = new ArrayList<>();
        matchList.add(m1);
        matchList.add(m2);
        matchList.add(m3);

        Tournament tour = new Tournament("UK tour");

        tour.setTeams(teamList);
        tour.setMatches(matchList);

        System.out.println(tour);
        boolean replay = false;
        do {
            System.out.println(tour.beginTournament());
            System.out.println("Replay the tournament? (Y/N)");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNext()) {
                String userInput = scanner.next();
                replay = userInput.equalsIgnoreCase("Y");
            }
        } while (replay);
    }

}