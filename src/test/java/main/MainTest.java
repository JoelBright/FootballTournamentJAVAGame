package main;

import football.Tournament;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  @Test
  void testMain() {
    // Simulate user input for 'N' to stop the tournament after the first run
    String input = "N\n";
    InputStream in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    // Capture the console output
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outContent));

    // Call the main method
    Main.main(new String[]{});

    // Verify the output contains the expected strings
    String output = outContent.toString();
    assertTrue(output.contains("Football game:"));
    assertTrue(output.contains("Replay the tournament? (Y/N)"));
  }

  @Test
  void testSetupTournament() {
    Main mainApp = new Main();
    Tournament tour = mainApp.setupTournament();
    assertNotNull(tour);
    assertEquals("UK tour", tour.getName());
    assertEquals(3, tour.getTeams().size());
    assertEquals(3, tour.getMatches().size());
  }

  @Test
  void testGetUserInputYes() {
    Main mainApp = new Main();
    InputStream in = new ByteArrayInputStream("Y".getBytes());
    Scanner scanner = new Scanner(in);
    assertTrue(mainApp.getUserInput(scanner));
  }

  @Test
  void testGetUserInputNo() {
    Main mainApp = new Main();
    InputStream in = new ByteArrayInputStream("N".getBytes());
    Scanner scanner = new Scanner(in);
    assertFalse(mainApp.getUserInput(scanner));
  }

  @Test
  void testGetUserInputEmpty() {
    Main mainApp = new Main();
    InputStream in = new ByteArrayInputStream("".getBytes());
    Scanner scanner = new Scanner(in);
    assertFalse(mainApp.getUserInput(scanner));
  }

  @Test
  void testRunTournament() {
    // Simulate the user input for 'Yes' then NO
    InputStream in = new ByteArrayInputStream("Y\nN".getBytes());
    Scanner scanner = new Scanner(in);
    Main mainApp = new Main();
    mainApp.runTournament(scanner);
    // No specific assertion here as runTournament's main job is to run and print
  }
}