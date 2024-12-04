package football;

import java.util.ArrayList;

public class Team {
  String name;
  ArrayList<Player> players;

  public Team(String name) {
    this.name = name;
    players = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Player> getPlayers() {
    return players;
  }

  public void setPlayers(ArrayList<Player> players) {
    this.players = players;
  }

  @Override
  public String toString() {
    StringBuilder outputString = new StringBuilder("{ Team name:" + name + ", players:\n");
    for ( Player player : players ) outputString.append(player.toString()).append(",\n");
    return outputString.toString() + '}';
  }
}
