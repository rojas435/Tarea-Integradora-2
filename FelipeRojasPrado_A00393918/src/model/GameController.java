package model;

public class GameController {
    //All the arrays with the positions available
    public static final int TOTAL_PLAYERS = 20;
    public static final int TOTAL_LEVELS = 10;
    public static final int TOTAL_TREASURES = 50;
    public static final int TOTAL_ENEMIES = 25;

    //Declare variables of the resolution
    private int resolutionX;
    private int resolutionY;

    //Declare all variables of the arrays
    private Level[] levels;
    private Player[] players;
    private Enemy[] enemies;
    private Treasure[] treasures;

    //Constructor of the class GameContoller
    public GameController() {
        resolutionX = 1280;
        resolutionY = 720;
        levels = new Level[TOTAL_LEVELS];
        players = new Player[TOTAL_PLAYERS];
        enemies = new Enemy[TOTAL_ENEMIES];
        treasures = new Treasure[TOTAL_TREASURES];
        //This will create instatly when the code is execute

        //Nombre del nivel, puntaje
        for(int i = 0; i < TOTAL_LEVELS; i++){
            levels[i] = new Level(i + 1, (i + 1)*20);
        }
    }

    /**
     * Name: playersAvailability
     * Description: this metod will check if theres a player in the game (Validation)
     * @return msj
     */
    public String playersAvailability(){
        String msj ="Posicion disponible";
        if(players[0] == null){
            msj = "No hay jugadores ";
        }else if(players[TOTAL_PLAYERS-1] != null){
            msj = "Limite de jugadores alcanzado";
        }
        return msj;
    }
    /**
     * Name: seachPlayer
     * Description: This method will look for an especific player, and will need the nickName that will be provided by the user
     * @param nickName
     * @return msj
     */ 
    public Player searchPlayer(String nickName){
        Player player = null;
        for(int i = 0; i < TOTAL_PLAYERS; i++){
            if(players[i] != null && players[i].getNickName().equalsIgnoreCase(nickName)){
               player = players[i];
            }            
        }
        return player;
    }
    /**
     * Name: addPlayer
     * Description: This method will add a player and will need a name and a nickName to add it
     * @param nickName = info provided by the user
     * @param name = info provided by the user
     * @return msj = The player is been created
     */
    public String addPlayer(String nickName, String name){
        String msj = "Se creo un jugador";
        boolean isEmpty = false;
        for(int i = 0; i < TOTAL_PLAYERS && !isEmpty; i++){
            if(players[i] == null){
                players[i] =  new Player(nickName, name, levels[0]);
                isEmpty = true;
            }
        }
        return msj;
    }
    /**
     * Name: enemyAvailability
     * Description: This metod will check if there is an enemy in the array
     * @return msj = Depends on the use of each option
     */
    public String enemyAvailability(){
        String msj ="Posicion disponible";
        if(enemies[0] == null){
            msj = "No hay Enemigos ";
        }else if(enemies[TOTAL_ENEMIES-1] != null){
            msj = "Limite de enmigos alcanzado";
        }
        return msj;
    }
    /**
     * Name: searchEnemy
     * Description: This method will allow to seach an enemy with the enemyName
     * @param nameEnemy
     * @return enemy = depends on in the use for other methods
     */
    public Enemy searchEnemy(String nameEnemy){
        Enemy enemy = null;
        for(int i = 0; i < TOTAL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getNameEnemy().equalsIgnoreCase(nameEnemy)){
               enemy = enemies[i];
            }            
        }
        return enemy;
    }
    /**
     * Name:addEnemy
     * Description: Will ask for all the parameters that conforms the enemy and save it 
     * @param nameEnemy
     * @param scorePlus
     * @param scoreLess
     * @param type
     * @param level
     * @return = msj the enemy is save
     */
    public String addEnemy(String nameEnemy, int scorePlus, int scoreLess, int type, int level){
        String msj = "Se creo un enemigo";
        boolean isEmpty = false;
        for(int i = 0; i < TOTAL_ENEMIES && !isEmpty; i++){
            if(enemies[i] == null){
                enemies[i] =  new Enemy(nameEnemy,type,scorePlus,scoreLess,levels[level-1],resolutionX,resolutionY);
                isEmpty = true;
            }
        }
        return msj;
    }
    /**
     * Name: treasureAvailability
     * Description: This method will check in the array if theres treasures are been created
     * and depends on the message in the main will appear on the necessity of the method or the condition
     * @return = msj
     */
    public String treasureAvailability(){
        String msj ="Posicion Disponible";
        if(treasures[0]==null){
            msj = "No hay tesoros";
        }else if(treasures[TOTAL_TREASURES-1] != null){
            msj = "Limite de tesoros alcanzado ";
        }
        return msj;
    }
    /**
     * Name: addTreasure
     * Description: This method will add a treasure with all the parameters needed to be created
     *
     * @param nameTreasure
     * @param UrlImage
     * @param scorePlusTreasure
     * @param level
     * @return msj = The treasure is created
     */
    public String addTreasure(String nameTreasure, String UrlImage, int  scorePlusTreasure, int level){
        String msj = "Se creo un tesoro";
        boolean isEmpty = false;
        for(int i = 0; i < TOTAL_TREASURES && !isEmpty; i++){
            // level - 1 >= 0 && level - 1 < SIZE
            if(treasures[i] == null){
                treasures[i] =  new Treasure(nameTreasure, UrlImage, scorePlusTreasure,levels[level-1],resolutionX,resolutionY);
                isEmpty = true;
            }
        }
        return msj;
    }
    /**
     * Name: changePoints
     * Description: This method will change the parameter points in the player and 
     * have conditions like the points has to be higher than what they have
     * @param inPoints
     * @param nickName
     * @return msj = Depends on the situation
     */
    public String changePoints(int inPoints, String nickName){
        String msj ="Se logro cambiar el puntaje del jugador";
        for(int i = 0; i<TOTAL_PLAYERS; i++){
            if(players[i] != null && players[i].getNickName().equalsIgnoreCase(nickName)){
                if(players[i].getScore()>= inPoints){
                    msj = "Error, solo se puede asignar puntajes mayores al actual";
                }else{
                    players[i].setScore(inPoints);
                }
            }
        }
        return msj;
    }
    /**
     * Name:increasePlayerLevel
     * Description: This method will allow to move the player to another level and has 
     * a validation that if the player doesnt have the points necessary to pass will pop out a msj with an error
     * @param nickName
     * @return msj = Depends on the situation
     */
    public String increasePlayerLevel(String nickName){
        String msj = "Se logro aumentar el puntaje";
        for(int i = 0; i < TOTAL_PLAYERS; i++){
            if(players[i] != null && players[i].getNickName().equalsIgnoreCase(nickName)){
                if(players[i].getScore()< players[i].getLevel().getScoreRequired()){
                    msj = "No se tiene el puntaje requerido para subir de nivel";
                }else if(players[i].getLevel().getId()== 10){ 
                    msj ="Error, has alcanzado el nivel maximo";
                }else{
                    players[i].setLevel(levels[players[i].getLevel().getId()]);
                    msj +="\nSubio de nivel: " +players[i].getLevel().getId() + "\n";
                }
            }
        }
        return msj;
    }
    /**
     * Name: listEnemies
     * Description: This will list all the enemies on the array but will need the level to consult the array
     * @param level
     * @return msj = enemies[i]
     */
    public String listEnemies(int level){
        String msj ="Enemigos: ";
        for(int i = 0; i < TOTAL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getLevel().getId()==level){
                msj += enemies[i].getNameEnemy() + ", ";
            }
        }
        return msj;
    }
    /**
     * Name:listTreasure
     * Description: This method will list all the treasures but will need the level and look for treasures
     * @param level
     * @return msj 
     */
    public String listTreasure(int level){
        String msj ="Tesoros: ";
        for(int i = 0; i < TOTAL_TREASURES; i++){
            if(treasures[i] != null && treasures[i].getLevel().getId()==level){
                msj += treasures[i].getNameTreasure() + ", ";
            }
        }
        return msj;
    }
    /**
     * Name:listTreasureInAllGame
     * Description: This method will list all the treasures in the hole game
     * @param nameTreasure
     * @return msj = Nametreasure
     */
    public String listTreasureInAllGame(String nameTreasure){
        String msj = "Tesoros encontrados: ";
        int counter = 0;
        for(int i = 0; i < TOTAL_TREASURES; i++){
            if(treasures[i] != null && treasures[i].getNameTreasure().equalsIgnoreCase(nameTreasure)){
                counter ++;
            }
        }
        if(counter == 0 ){
            msj ="No se encontraron tesoros con este nombre";
        }else{
            msj += counter;
        }
        return msj;
    }
    /**
     * Name: amountEnemiesType
     * Description: This method will count a type of enemy that this will be provided by the user, and count all this type in the game
     * @param type
     * @return msj
     */
    public String amountEnemiesType(int type){
        String msj ="Enemigos encontrados: ";
        int counter = 0;
        for(int i = 0; i < TOTAL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getType() == type){
                counter ++;
            }
        }
        if(counter == 0){
            msj="No existen enemigos";
        }else{
            msj += counter;
        }
        return msj;
    }
    /**
     * Name:countTreasuresName
     * Description: This method will count the treasure that is most repeated in all the game
     * @return msj
     */
    public String countTreasuresName(){
        String msj = "Tesoro encontrado: ";
        int counter = 0;
        int maxAmountTreasure = 0;
        String maxNameTreasure = null;
        for(int i = 0; i< TOTAL_TREASURES; i++){
            for(int j = 0; j < TOTAL_TREASURES; j++){
                if(treasures[i]!=null && treasures[j]!= null && treasures[i].getNameTreasure().equalsIgnoreCase(treasures[j].getNameTreasure())){
                    counter ++;
                }
            }
            if(counter > maxAmountTreasure ){
                maxAmountTreasure =counter;
                maxNameTreasure = treasures[i].getNameTreasure();
                counter = 0;
            }
        }
        msj += maxNameTreasure + "\nCantidad: " + maxAmountTreasure;
        return msj;
    }
    /**
     * Name: getBestEnemyLocation
     * Description: This method will look for the enemy that gives more points if is defeated by the player, giving the name and the level location
     * @return msj
     */
    public String getBestEnemyLocation(){
        String msj = "El enemigo con mayor puntaje: ";
        int saveScore = 0;
        String saveName = null;
        int saveLevel = 0;  
        for(int i = 0; i < TOTAL_ENEMIES; i++){
            if(enemies[i] != null && enemies[i].getScorePlus()>saveScore){
                saveScore = enemies[i].getScorePlus();
                saveName = enemies[i].getNameEnemy();
                saveLevel = enemies[i].getLevel().getId();
            }
        }
        msj += saveName + "\nEl enemigo esta en el nivel: " + saveLevel;
        return msj;
    }
    /**
     * Name: consonantsEnemy
     * Description: This method will look for all the enemies Name and look the consonants in the (consonants array)
     * @return msj = number of consonants in all the enemies
     */
    public String consonantsEnemy(){
        String msj = "Consonantes encontradas: ";
        int counter = 0;
        char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        for(int i = 0; i < TOTAL_ENEMIES; i++){
            if(enemies[i] != null){
                for(int j = 0; j < enemies[i].getNameEnemy().length(); j++){
                    for(int k = 0; k < consonants.length; k++){
                        if(enemies[i].getNameEnemy().toLowerCase().charAt(j) == consonants[k]){
                            counter ++;
                        }
                    }
                }
            }
        }
        if(counter == 0){
            msj = "No se han encontrado consonantes";
        }else{    
        msj += counter;
        }
        return msj;
    }
    /**
     * Name: topFive
     * Description: This method will give the top 5 players depending on the points that have to player
     * @return msj = Show all the top 5 players in (1,2,3,4,5) with the score
     */
    public String topFive(){
        String msj = "\n-Top 5 Jugadores-";
        int topPlayersScore[] = new int[TOTAL_PLAYERS];
        String topPlayersNickname[] = new String[TOTAL_PLAYERS];
        boolean done = false;
        int counter = 0;
        int amountPlayers = 0;
        int pos = 0;
        if (players[0] != null) {
            for (int i = 0; i < TOTAL_PLAYERS; i++) {
                if (players[i] != null) {
                    topPlayersScore[i] = players[i].getScore();
                    topPlayersNickname[i] = players[i].getNickName();
                    amountPlayers++;
                }
            }
            while(!done){
                if(topPlayersNickname[pos] != null && topPlayersScore[pos] < topPlayersScore[pos+1]){
                    int logScore = topPlayersScore[pos+1];
                    topPlayersScore[pos+1] = topPlayersScore[pos];
                    topPlayersScore[pos] = logScore;
                    String logNickname = topPlayersNickname[pos+1];
                    topPlayersNickname[pos+1] = topPlayersNickname[pos];
                    topPlayersNickname[pos] = logNickname;
                    pos = 0;
                    for (int j = 0; j < amountPlayers; j++) {
                        if (topPlayersNickname[j] != null && j != amountPlayers - 1 && topPlayersScore[j] >= topPlayersScore[j+1]){
                            counter++;
                        }
                        if(counter == amountPlayers - 1){
                            done = true;
                            counter = 0;
                        }
                    }
                    counter = 0;
                }else{
                    if(topPlayersScore[pos] == 0){
                        done = true;
                    }
                    pos++;
                }
            }
            for(int i = 0; i < 5; i++){
                if(topPlayersNickname[i] != null){
                    msj += "\n" + (i + 1) + ". " + topPlayersNickname[i] + " (" + topPlayersScore[i] + ")";
                }
            }
        }
        return msj;
    }
}
