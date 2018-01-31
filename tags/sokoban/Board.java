package sokoban;

import java.util.ArrayList;

public class Board {

  protected Block[][] grid;
  protected ArrayList<Block> listCrate;
  protected ArrayList<Block> listObjective;
  protected Block player;

  public Board() {
		this.listCrate = new ArrayList<>();
		this.listObjective = new ArrayList<>();
  }

  public String toString() {
    String result = "";
    for (int i=0; i < this.grid.length; i++) {
      for (int j=0; j < this.grid.length; j++) {
        if (this.grid[i][j] != null) {
          result += this.grid[i][j].toString();
        }
      }
      result += "\n";
    }
    return result;
  }

  public void deadLocker() {
    for (int j = 0; j<this.grid.length; j++) {
      for (int i = 0; i<this.grid[0].length; i++) {
        if (this.grid[i][j] instanceof Crate) {
          if ((this.grid[i-1][j] instanceof Wall || this.grid[i+1][j] instanceof Wall) &&
          (this.grid[i][j-1] instanceof Wall || this.grid[i][j+1] instanceof Wall)) {
            ((Crate)this.grid[i][j]).setDeadlock(true);
          }
        }
      }
    }
  }

  public boolean isFinished() {
    for (int j = 0; j<this.grid.length; j++) {
      for (int i = 0; i<this.grid[0].length; i++) {
        if (this.grid[i][j] instanceof Crate) {
          if (!((Crate)this.grid[i][j]).isPlaced()) {
            return false;
          } else if (((Crate)this.grid[i][j]).isBlocked()) {
            return true;
          }
        }
      }
    }
    return true;
  }

  public void createGrid(ArrayList<ArrayList<String>> mapToString){
    this.grid = new Block[10][10];
    for (int i=0;i<mapToString.size();i++) {
      for (int j=0;j<mapToString.get(i).size();j++) {
        if (mapToString.get(i).get(j).equals(" ")){
					Block t = new FreeTile(i,j);
          this.grid[i][j] = t;
        }else if (mapToString.get(i).get(j).equals("#")) {
          Block t = new Wall(i,j);
          this.grid[i][j] = t;
        }else if (mapToString.get(i).get(j).equals("$")) {
          Block t = new Crate(i,j,false);
					this.listCrate.add(t);
          this.grid[i][j] = t;
        }else if (mapToString.get(i).get(j).equals(".")) {
          Block t = new Objective(i,j);
					this.listObjective.add(t);
          this.grid[i][j] = t;
        }else if (mapToString.get(i).get(j).equals("*")) {
          Block t = new Crate(i,j,true);
					this.listCrate.add(t);
          this.grid[i][j] = t;
        }else if (mapToString.get(i).get(j).equals("@")) {
          Block t = new Player(i,j,false);
					this.player=t;
          this.grid[i][j] = t;
        }else if (mapToString.get(i).get(j).equals("+")) {
          Block t = new Player(i,j,true);
					this.player=t;
          this.grid[i][j] = t;
        }
      }
    }

  }
}
