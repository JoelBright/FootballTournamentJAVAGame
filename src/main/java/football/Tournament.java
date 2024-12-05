package football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tournament {
  String name;
  ArrayList<Team> teams;
  ArrayList<Match> matches;

  public Tournament(String name) {
    this.name = name;
    this.teams = new ArrayList<>();
    this.matches = new ArrayList<>();
  }

  int getValueOrDefault(@org.jetbrains.annotations.NotNull Map<String, Integer> map, String key) {
    return map.computeIfAbsent(key, k -> 0);
  }

  public String getName() {
    return name;
  }

  public ArrayList<Team> getTeams() {
    return teams;
  }

  public void setTeams(ArrayList<Team> teams) {
    this.teams = teams;
  }

  public ArrayList<Match> getMatches() {
    return matches;
  }

  public void setMatches(ArrayList<Match> matches) {
    this.matches = matches;
  }

  @Override
  public String toString() {
    StringBuilder outputString = new StringBuilder("Tournament Name: " + name + "\nTeams:\n");

    for ( Team team : teams ) outputString.append(team.toString()).append(",\n");
    outputString.append("\nMatches:");
    for ( Match match : matches ) outputString.append(match.toString()).append(",\n");

    return outputString.toString() + '}';
  }

  public String beginTournament() {
    System.out.println("\nThe " + name + " has begun!!\n");
    HashMap<String, Integer> matchWinners = new HashMap<>();

    for ( Match tournamentMatch : matches ) {
      String matchWinnerName = tournamentMatch.playMatch().getName();
      matchWinners.put(matchWinnerName, getValueOrDefault(matchWinners, matchWinnerName) + 1);
    }

    System.out.println("\nTournament points: ");
    StringBuilder tournamentResult = new StringBuilder("The " + name + " has resulted in Team ");
    ArrayList<String> highestScorers = new ArrayList<>();
    int higestScore = 0;
    for ( String teamName : matchWinners.keySet() ) {
      int pointsEarned = matchWinners.get(teamName);
      higestScore = Math.max(pointsEarned, higestScore);
      ArrayList<String> lowScorers = new ArrayList<>();
      for ( String scorer: highestScorers) {
        if( matchWinners.get(scorer) < higestScore ) lowScorers.add(scorer);
      }
      highestScorers.removeAll(lowScorers);
      lowScorers.clear();
      if ( pointsEarned == higestScore ) highestScorers.add(teamName);
      System.out.println("Team:" + teamName + " points: " + pointsEarned);
    }
    if ( highestScorers.size() == 1 ) {
      tournamentResult.append(highestScorers.get(0)).append(" emerging victorious!!!");
    } else tournamentResult.append("a grand tie!!!");

    return tournamentResult.toString();
  }
}
