package sokoban;

public interface Movable {

  public abstract Board move(Board map, List<int> position);

}