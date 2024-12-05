package football;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

  @Test
  void testToStringNoWinner() {
    Team t1 = new Team("Chelsea FC");
    Team t2 = new Team("Arsenal FC");

    Match matchClass = new Match(t1, t2);

    String outputString = matchClass.toString();
    String expectedString =
        "{Match Chelsea FC v.s Arsenal FC details: { Home team:Chelsea FC, Guest team:Arsenal FC, current scores 0-0, Game not yet decided}}";
    assertNotNull(matchClass);
    assertEquals(expectedString, outputString);
  }

  @Test
  void testToStringWithWinner() {
    Team t1 = new Team("Chelsea FC");
    Team t2 = new Team("Arsenal FC");

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

    ArrayList<Player> playerList2 = new ArrayList<>();
    playerList2.add(p4);
    playerList2.add(p5);
    playerList2.add(p6);
    t2.setPlayers(playerList2);

    Match matchClass = new Match(t1, t2);
    Team winner = matchClass.playMatch();

    String outputString = matchClass.toString();
    String expectedStringContents1 =
        "{Match Chelsea FC v.s Arsenal FC details: { Home team:Chelsea FC, Guest team:Arsenal FC, current scores ";
    String expectedStringContents2 = ", winner:" + winner.getName() + "}}";
    assertNotNull(matchClass);
    assertTrue(outputString.contains(expectedStringContents1));
    assertTrue(outputString.contains(expectedStringContents2));
  }

  @Test
  void playMatch() {

    Team t1 = new Team("Real Madrid");
    Team t2 = new Team("Chelsea FC");

    Player p1 = new Player("Endrick", 18, Position.STRIKER, t1);
    Player p2 = new Player("David Alaba", 32, Position.DEFENDER_CB, t1);
    Player p3 = new Player("Thibaut Courtois", 32, Position.GOALKEEPER, t1);

    Player p4 = new Player("Nicolas Jackson", 23, Position.STRIKER, t2);
    Player p5 = new Player("Tosin Adarabioyo", 27, Position.DEFENDER_CB, t2);
    Player p6 = new Player("Robert Sánchez", 27, Position.GOALKEEPER, t2);
    Player p7 = new Player("John Smith", 27, Position.RESERVE, t2);

    ArrayList<Player> playerList1 = new ArrayList<>();
    playerList1.add(p1);
    playerList1.add(p2);
    playerList1.add(p3);
    t1.setPlayers(playerList1);

    ArrayList<Player> playerList2 = new ArrayList<>();
    playerList2.add(p4);
    playerList2.add(p5);
    playerList2.add(p6);
    playerList2.add(p7);
    t2.setPlayers(playerList2);

    Match matchClass = new Match(t1, t2);

    // Capture the console output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    Team winner = matchClass.playMatch();

    // Verify the output contains the expected strings
    String output = outContent.toString();
    assertTrue(output.contains("Initial score:"));
    assertTrue(output.contains("Halftime break initiated!!"));
    assertTrue(output.contains("2nd half concluded!!"));
    assertTrue(output.contains("The match Real Madrid v.s Chelsea FC was won by:"));

    String winnerName = winner.getName();
    if ( "Real Madrid".equals(winnerName) ) assertEquals("Real Madrid", winnerName);
    else assertEquals("Chelsea FC", winnerName);
  }
}