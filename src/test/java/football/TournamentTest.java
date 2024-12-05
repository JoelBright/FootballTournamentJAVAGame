package football;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TournamentTest {

  @Test
  void testGetName() {
    Tournament tour = new Tournament("UK tour");
    assertEquals("UK tour", tour.getName());
  }

  @Test
  void testSetAndGetTeams() {
    Tournament tour = new Tournament("UK tour");
    Team t1 = new Team("Real Madrid");
    ArrayList<Team> teamList = new ArrayList<>();
    teamList.add(t1);
    tour.setTeams(teamList);
    assertEquals(teamList, tour.getTeams());
  }

  @Test
  void testSetAndGetMatches() {
    Tournament tour = new Tournament("UK tour");
    Team t1 = new Team("Real Madrid");
    Team t2 = new Team("Chelsea FC");

    Match m1 = new Match(t1, t2);
    ArrayList<Match> matchList = new ArrayList<>();
    matchList.add(m1);
    tour.setMatches(matchList);
    assertEquals(matchList, tour.getMatches());
  }

  @Test
  void testGetValueOrDefault() {
    Tournament tour = new Tournament("UK tour");
    HashMap<String, Integer> testHash = new HashMap<>();

    assertEquals(0, tour.getValueOrDefault(testHash, "A"));
  }

  @Test
  void testToString() {
    Tournament tour = new Tournament("UK tour");
    assertEquals("Tournament Name: UK tour\nTeams:\nMatches:}", tour.toString());
  }

  @Test
  void testBeginTournament() {
    Tournament tour = new Tournament("UK tour");
    Team t1 = new Team("Real Madrid");
    Team t2 = new Team("Chelsea FC");
    Team t3 = new Team("Real Madrid B");
    Team t4 = new Team("Chelsea FCB");

    Player p1 = new Player("Endrick", 18, Position.STRIKER, t1);
    Player p2 = new Player("David Alaba", 32, Position.DEFENDER_CB, t1);
    Player p3 = new Player("Thibaut Courtois", 32, Position.GOALKEEPER, t1);

    Player p4 = new Player("Nicolas Jackson", 23, Position.STRIKER, t2);
    Player p5 = new Player("Tosin Adarabioyo", 27, Position.DEFENDER_CB, t2);
    Player p6 = new Player("Robert Sánchez", 27, Position.GOALKEEPER, t2);

    ArrayList<Player> playerList1 = new ArrayList<>();
    playerList1.add(p1);
    playerList1.add(p2);
    playerList1.add(p3);
    t1.setPlayers(playerList1);
    t3.setPlayers(playerList1);

    ArrayList<Player> playerList2 = new ArrayList<>();
    playerList2.add(p4);
    playerList2.add(p5);
    playerList2.add(p6);
    t2.setPlayers(playerList2);
    t4.setPlayers(playerList2);

    ArrayList<Team> teamList = new ArrayList<>();
    teamList.add(t1);
    teamList.add(t2);
    teamList.add(t3);
    teamList.add(t4);
    tour.setTeams(teamList);

    Match m1 = new Match(t1, t2);
    Match m2 = new Match(t2, t3);
    Match m3 = new Match(t3, t4);
    Match m4 = new Match(t4, t1);
    Match m5 = new Match(t3, t1);
    Match m6 = new Match(t4, t2);
    ArrayList<Match> matchList = new ArrayList<>();
    matchList.add(m1);
    matchList.add(m2);
    matchList.add(m3);
    matchList.add(m4);
    matchList.add(m5);
    matchList.add(m6);
    tour.setMatches(matchList);

    // Capture the console output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    String testOutput = tour.beginTournament();

    // Verify the output contains the expected strings
    String consoleOutput = outContent.toString();

    assertTrue(consoleOutput.contains("The UK tour has begun!!"));
    assertTrue(consoleOutput.contains("Tournament points:"));
    assertTrue(testOutput.contains("The UK tour has resulted in Team"));
    if (testOutput.contains("a grand tie!!!")) {
      assertTrue(testOutput.contains("a grand tie!!!"));
      while ( testOutput.contains("a grand tie!!!") ) {
        matchList.clear();
        matchList.add(m1);
        tour.setMatches(matchList);
        testOutput = tour.beginTournament();
      }
      assertTrue(testOutput.contains("emerging victorious!!!"));
    } else {
      assertTrue(testOutput.contains("emerging victorious!!!"));
      while ( testOutput.contains("emerging victorious!!!") ) {
        testOutput = tour.beginTournament();
      }
      assertTrue(testOutput.contains("a grand tie!!!"));
    }
  }
}