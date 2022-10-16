package model;

public class Level {
    //Declaration of variables
    private int id;
    private int scoreRequired;
    private DifficultyLevel difficulty;

    /**
     * 
     * @param id
     * @param scoreRequired
     */
    public Level(int id, int scoreRequired){
        this.id =id;
        this.scoreRequired = scoreRequired;
        this.difficulty = null;
    }
    public int getScoreRequired(){
        return scoreRequired;
    }
    public int getId(){
        return id;
    }
}
