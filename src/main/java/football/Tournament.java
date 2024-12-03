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

    public static int getValueOrDefault(@org.jetbrains.annotations.NotNull Map<String, Integer> map, String key) {
        return map.computeIfAbsent(key, k -> 0);
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public void setMatches(ArrayList<Match> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder("Tournament Name: " + name + "\nTeams:");

        for (Team team : teams) outputString.append(team.toString()).append(", ");
        outputString.append("\nMatches:");
        for (Match match : matches) outputString.append(match.toString()).append(", ");

        return outputString.toString() + '}';
    }

    public String beginTournament() {
        System.out.println("\nThe " + name + " has begun!!\n");
        boolean tie = true;
        HashMap<String, Integer> matchWinners = new HashMap<>();

        for (Match tournamentMatch : matches) {
            String matchWinnerName = tournamentMatch.playMatch().getName();
            matchWinners.put(matchWinnerName, getValueOrDefault(matchWinners, matchWinnerName) + 1);
        }

        System.out.println("\nTournament points: ");
        StringBuilder tournamentResult = new StringBuilder("The " + name + " has resulted in Team ");
        for (String teamName : matchWinners.keySet()) {
            int pointsEarned = matchWinners.get(teamName);
            System.out.println("Team:" + teamName + " points: " + pointsEarned);
            if (pointsEarned > 1) {
                tournamentResult.append(teamName).append(" emerging victorious!!!");
                tie = false;
            }
        }
        if (tie) tournamentResult.append("a three-way tie!!!");

        return tournamentResult.toString();
    }
}
