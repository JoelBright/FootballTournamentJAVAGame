package football;

public class Match {
  Team team1;
  Team team2;
  int score1;
  int score2;
  int positiveScoreActivity;
  int negativeScoreActivity;
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
    String homeTeam = team1.getName();
    String guestTeam = team2.getName();
    StringBuilder outputString = new StringBuilder(
        "{Match " + homeTeam + " v.s " + guestTeam + " details: { Home team:" + homeTeam + ", Guest team:" + guestTeam + ", current scores " + score1 + "-" + score2);

    if ( (winner == null) ) {
      outputString.append(", Game not yet decided}");
    }
    else {
      outputString.append(", winner:").append(winner.getName()).append('}');
    }

    return outputString.toString() + '}';
  }

  private int getActivity(Position position, boolean overtime) {
    int activity;
    positiveScoreActivity = 0;
    negativeScoreActivity = 0;
    int max = 7;
    int min = 1;
    if ( overtime ) {
      max /= 2;
      min /= 2;
    }
    switch ( position ) {
      case STRIKER -> {
        activity = (int) (Math.random() * (max * 2 - min * 2 + 1) + min * 2);
        positiveScoreActivity += activity;
      }
      case MIDFIELDER_WM -> {
        activity = (int) (Math.random() * (max - min + 1) + min);
        positiveScoreActivity += activity;
      }
      case MIDFIELDER_CM -> {
        activity = (int) (Math.random() * (max / 2 + 1) + min);
        positiveScoreActivity += activity;
      }
      case DEFENDER_CB -> {
        activity = (int) (Math.random() * (max * 2 + 1) + min);
        negativeScoreActivity -= activity;
      }
      case DEFENDER_FB -> {
        activity = (int) (Math.random() * (max - min + 1) + min);
        negativeScoreActivity -= activity;
      }
      case GOALKEEPER -> {
        activity = (int) (Math.random() * (max / 2 + 1) + min);
        negativeScoreActivity -= activity;
      }
      default -> activity = 0;
    }
    return activity;
  }

  private void gameplayOccurs(boolean overtime) {
    for ( Player playerOfTeam1 : team1.getPlayers() ) {
      System.out.println(
          playerOfTeam1.getPosition() + " of Home team:" + team1.getName() + " " + playerOfTeam1.getName() + " achieved an activity of: " + getActivity(
              playerOfTeam1.getPosition(), overtime));
    }
    score1 += Math.abs(positiveScoreActivity);
    score2 += Math.abs(negativeScoreActivity);
    for ( Player playerOfTeam2 : team2.getPlayers() ) {
      System.out.println(
          playerOfTeam2.getPosition() + " of Guest team:" + team2.getName() + " " + playerOfTeam2.getName() + " achieved an activity of: " + getActivity(
              playerOfTeam2.getPosition(), overtime));
    }
    score1 += Math.abs(negativeScoreActivity);
    score2 += Math.abs(positiveScoreActivity);
  }

  public Team playMatch() {
    score1 = 0;
    score2 = 0;
    System.out.println(
        "Initial score: " + score1 + "-" + score2 + " Home Team:" + team1.getName() + " scored:" + score1 + " while " + "Guest Team:" + team2.getName() + " scored:" + score2);
    gameplayOccurs(false);

    System.out.println(
        "\nHalftime break initiated!!\n" + "Current score: " + score1 + "-" + score2 + " Home Team:" + team1.getName() + " scored:" + score1 + " while " + "Guest Team:" + team2.getName() + " scored:" + score2);
    gameplayOccurs(false);

    System.out.println(
        "\n2nd half concluded!!\n" + "Final score: " + score1 + "-" + score2 + " Home Team:" + team1.getName() + " scored:" + score1 + " while Guest Team:" + team2.getName() + " scored:" + score2);

    while ( score1 == score2 ) {
      System.out.println("\nOvertime triggered:");
      gameplayOccurs(true);
      System.out.println("Overtime concluded!!");
    }

    winner = (score1 > score2) ? team1 : team2;
    System.out.println(
        "The match " + team1.getName() + " v.s " + team2.getName() + " was won by: " + winner.getName() + "!!!\n");

    return winner;
  }
}