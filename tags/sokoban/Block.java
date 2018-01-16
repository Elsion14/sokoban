package sokoban;

public abstract class Block {

  private int x;
  private int y;

  public Block(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public abstract String toString();

}
