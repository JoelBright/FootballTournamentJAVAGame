package football;

public class Player {

  String name;
  int age;
  Position position;
  Team team;
  public Player(String name, int age, Position position, Team team) {
    this.name = name;
    this.age = age;
    this.position = position;
    this.team = team;
  }

  public String getName() {
    return name;
  }

  public Position getPosition() {
    return position;
  }

  @Override
  public String toString() {
    return "{" + "Player name:'" + name + '\'' + ", age:" + age + ", position:'" + position + '\'' + ", team:'" + team.getName() + '\'' + '}';
  }
}

