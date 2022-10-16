package model;

public class Player {
    private String name;
    private String nickName;
    private int score;
    private Level level;

    /**
     * 
     * @param nickName
     * @param name
     * @param level
     */
    public Player(String nickName, String name, Level level) {
        this.name = name;
        this.nickName = nickName;
        score = 10;
        this.level = level;
    }
    public String getNickName(){
        return nickName;
    }
    public int getScore(){
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public Level getLevel(){
        return level;
    }
    public void setLevel(Level level){
        this.level = level;
    }
}
