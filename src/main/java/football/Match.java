package football;

public class Match {
    Team team1;
    Team team2;
    int score1;
    int score2;
    Team winner;

    public Match(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = 0;
        this.score2 = 0;
        winner = null;
    }

    @Override
    public String toString() {
        String outputString = "{Match details: " + "Home team=" + team1.getName() + ", Guest team=" + team2.getName() + ", score1=" + score1 + ", score2=" + score2 + ", winner=";

        outputString += (winner == null) ? "Not yet decided" : winner.getName();

        return outputString + '}';
    }

    public Team playMatch() {
        score1 = 0;
        score2 = 0;

        for (Player playerOfTeam1 : team1.getPlayers()) {
            int activity;
            switch (playerOfTeam1.getPosition()) {
                case "Striker" -> {
                    activity = (int) (Math.random() * (20 - 10 + 1) + 10);
                    score1 += activity;
                }
                case "Defender" -> {
                    activity = (int) (Math.random() * (10 + 1) + 0);
                    score2 -= activity;
                }
                case "Goalie" -> {
                    activity = (int) (Math.random() * (5 + 1) + 0);
                    score2 -= activity;
                }
                default -> throw new IllegalStateException("Unexpected value: " + playerOfTeam1.getPosition());
            }
            System.out.println(playerOfTeam1.getPosition() + " of Home team:" + team1.getName() + " " + playerOfTeam1.getName() + " achieved an activity of: " + activity);
        }

        for (Player playerOfTeam2 : team2.getPlayers()) {
            int activity;
            switch (playerOfTeam2.getPosition()) {
                case "Striker" -> {
                    activity = (int) (Math.random() * (20 - 10 + 1) + 10);
                    score2 += activity;
                }
                case "Defender" -> {
                    activity = (int) (Math.random() * (10 + 1) + 0);
                    score1 -= activity;
                }
                case "Goalie" -> {
                    activity = (int) (Math.random() * (5 + 1) + 0);
                    score1 -= activity;
                }
                default -> throw new IllegalStateException("Unexpected value: " + playerOfTeam2.getPosition());
            }
            System.out.println(playerOfTeam2.getPosition() + " of Guest team:" + team2.getName() + " " + playerOfTeam2.getName() + " achieved an activity of: " + activity);
        }

        score1 = Math.abs(score1);
        score2 = Math.abs(score2);

        System.out.println("Final score: " + score1 + "-" + score2 + " Home Team:" + team1.getName() + " scored:" + score1 + " while Guest Team:" + team2.getName() + " scored:" + score2);

        Team matchWinner;

        if (score1 == score2) {
            System.out.println("\nRematch scheduled and triggered:");
            matchWinner = playMatch();
        } else {
            matchWinner = (score1 > score2) ? team1 : team2;
            System.out.println("The match " + team1.getName() + " v.s " + team2.getName() + " was won by: " + matchWinner.getName() + "!!!\n");
        }
        return matchWinner;
    }
}
