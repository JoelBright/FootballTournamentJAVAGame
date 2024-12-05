package main;

import football.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Main mainApp = new Main();
    mainApp.runTournament(new Scanner(System.in));
  }

  public void runTournament(Scanner scanner) {
    System.out.println("Football game:");

    Tournament tour = setupTournament();
    System.out.println(tour);

    boolean replay;
    do {
      System.out.println(tour.beginTournament());
      System.out.println("Replay the tournament? (Y/N)");
      replay = getUserInput(scanner);
    } while ( replay );
  }

  public boolean getUserInput(Scanner scanner) {
    if ( scanner.hasNext() ) {
      String userInput = scanner.next();
      return userInput.equalsIgnoreCase("Y");
    }
    return false;
  }

  public Tournament setupTournament() {
    Team t1 = new Team("Real Madrid");
    Team t2 = new Team("Chelsea FC");
    Team t3 = new Team("Arsenal FC");

    Player p1 = new Player("Endrick", 18, Position.STRIKER, t1);
    Player p4 = new Player("David Alaba", 32, Position.DEFENDER_CB, t1);
    Player p7 = new Player("Thibaut Courtois", 32, Position.GOALKEEPER, t1);
    Player p10 = new Player("Dani Ceballos", 28, Position.MIDFIELDER_CM, t1);
    Player p11 = new Player("Vinícius Júnior", 24, Position.MIDFIELDER_WM, t1);
    Player p12 = new Player("Rodrygo", 23, Position.MIDFIELDER_WM, t1);
    Player p13 = new Player("Ferland Mendy", 29, Position.DEFENDER_FB, t1);
    Player p14 = new Player("Daniel Carvajal", 32, Position.DEFENDER_FB, t1);
    Player p15 = new Player("Gonzalo García", 20, Position.STRIKER, t1);

    Player p2 = new Player("Nicolas Jackson", 23, Position.STRIKER, t2);
    Player p5 = new Player("Tosin Adarabioyo", 27, Position.DEFENDER_CB, t2);
    Player p8 = new Player("Robert Sánchez", 27, Position.GOALKEEPER, t2);
    Player p16 = new Player("Reece James", 24, Position.DEFENDER_FB, t2);
    Player p17 = new Player("Ben Chilwell", 28, Position.DEFENDER_FB, t2);
    Player p18 = new Player("Moisés Caicedo", 23, Position.MIDFIELDER_CM, t2);
    Player p19 = new Player("Pedro Neto", 24, Position.MIDFIELDER_WM, t2);
    Player p20 = new Player("Jadon Sancho", 24, Position.MIDFIELDER_WM, t2);
    Player p21 = new Player("Marc Guiu", 18, Position.STRIKER, t2);

    Player p3 = new Player("Kai Havertz", 30, Position.STRIKER, t3);
    Player p6 = new Player("Gabriel Magalhães", 26, Position.DEFENDER_CB, t3);
    Player p9 = new Player("David Raya", 29, Position.GOALKEEPER, t3);
    Player p22 = new Player("Riccardo Calafiori", 22, Position.DEFENDER_FB, t3);
    Player p23 = new Player("Ben White", 27, Position.DEFENDER_FB, t3);
    Player p24 = new Player("Mikel Merino", 28, Position.MIDFIELDER_CM, t3);
    Player p25 = new Player("Raheem Sterling", 30, Position.MIDFIELDER_WM, t3);
    Player p26 = new Player("Bukayo Saka", 23, Position.MIDFIELDER_WM, t3);
    Player p27 = new Player("Gabriel Jesus", 27, Position.STRIKER, t3);

    ArrayList<Player> playerList1 = new ArrayList<>();
    playerList1.add(p1);
    playerList1.add(p15);
    playerList1.add(p11);
    playerList1.add(p12);
    playerList1.add(p10);
    playerList1.add(p4);
    playerList1.add(p13);
    playerList1.add(p14);
    playerList1.add(p7);
    t1.setPlayers(playerList1);

    ArrayList<Player> playerList2 = new ArrayList<>();
    playerList2.add(p2);
    playerList2.add(p21);
    playerList2.add(p19);
    playerList2.add(p20);
    playerList2.add(p18);
    playerList2.add(p5);
    playerList2.add(p16);
    playerList2.add(p17);
    playerList2.add(p8);
    t2.setPlayers(playerList2);

    ArrayList<Player> playerList3 = new ArrayList<>();
    playerList3.add(p3);
    playerList3.add(p27);
    playerList3.add(p25);
    playerList3.add(p26);
    playerList3.add(p24);
    playerList3.add(p6);
    playerList3.add(p22);
    playerList3.add(p23);
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

    return tour;
  }
}