package sokoban;


/**
  * Classe permettant de gérer la lecture/l'écriture sur des fichiers.
  */
public class FileManagement {

  /**
    * Constructeur de la classe.
    */
  public FileManagement() {

  }

  /**
    * Créer un nouvel objet Save avec le nom du joueur et sa progression puis fait appel
    * à la fonction saveMap de la classe Save.
    * @param b le Board courrant
    * @param playerName le nom du joueur
    * @param playerLevel la progression du joueur
    */
  public void setSave(Board b, String playerName, PlayerReader playerLevel) {
    Save save = new Save (b.createArrayList(),playerName,("map"+playerLevel.getLevel()));
    save.saveMap();
  }

  /**
    * Fait appel aux fonctions setFile puis readingMap de la classe MapReader pour charger une sauvegarde.
    * @param playerName le nom du joueur
    * @param map une instance de MapReader
    * @return l'instance de MapReader modifiée.
    */
  public MapReader loadMap(String playerName, MapReader map) {
    map.setFile("../ressources/save/"+playerName+".xsb");
    map.readingMap();
    return map;
  }

  /**
    * Fait appel aux fonctions setFileCancel et readingCancel de la classe MapReader pour annuler un coup.
    * @param playerName le nom du joueur
    * @param map une instance de MapReader
    * @return l'instance de MapReader modifiée.
    */
  public MapReader loadCancel(String playerName, MapReader map) {
    map.setFileCancel("../ressources/save/cancel_"+playerName+".xsb");
    map.readingCancel();
    return map;
  }

  /**
    * Créer un nouvel objet Save avec le nom du joueur et sa progression puis fait appel
    * à la fonction saveMap de la classe Save.
    * @param b le Board courrant
    * @param playerName le nom du joueur
    * @param playerLevel la progression du joueur
    */
  public void setCancel(Board b, String playerName, PlayerReader playerLevel) {
    Save cancel = new Save (b.createArrayList(),("cancel_"+playerName),("map"+playerLevel.getLevel()));
    cancel.saveMap();
  }

}
