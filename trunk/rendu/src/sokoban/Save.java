package sokoban;

import java.util.ArrayList;
import java.io.*;


/**
  * Classe permettant de sauvegarder un map avec le nom de la map d'origine
  * sur la première ligne.
  */
public class Save {

  private ArrayList<String> map = new ArrayList<>();
  private String path;
  private String name;

  /**
    * Constructeur de la classe.
    * Initialise le chemin de la sauvegarde selon le argument file.
    * @param mapToSave
		* La grille à sauvegarder.
    * @param name
		* Nom de la map d'origine.
    */
  public Save(ArrayList<String> mapToSave, String name) {
    this.map = mapToSave;
    this.path = "../ressources/save/save.xsb";
    this.name = name;
  }

  /**
    * Constructeur de la classe.
    * Initialise le chemin de la sauvegarde selon l'argument file.
    * @param mapToSave
		* La grille à sauvegarder.
    * @param file
		* Nom du joueur qui sauvegarde (playerName)
    * @param name
		* Nom de la map d'origine.
    */
  public Save(ArrayList<String> mapToSave, String file, String name) {
    this.map = mapToSave;
    this.path = "../ressources/save/" + file + ".xsb";
    this.name = name;
  }

  /**
    * Sauvegarde la map sur le chemin this.path avec this.name comme nom
    * de la map d'origine sur la première ligne.
    */
  public void saveMap() {
    try {
      File file = new File(this.path);

      if (file.exists()){
        file.delete();
      }
      FileWriter fw = new FileWriter(this.path,false);

      BufferedWriter output = new BufferedWriter(fw);
      String temp = "";
      temp += this.name + "\n";
      for (String line : this.map) {
        temp += line + "\n";
      }

      output.write(temp);

      output.flush();

      output.close();
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

}
