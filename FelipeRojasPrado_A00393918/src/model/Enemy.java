package model;
import java.util.Random;

public class Enemy {
    //Declaration of Variables
    private String nameEnemy;
    private TypeEnemy typeEnemy;
    private int scorePlus;
    private int scoreLess;
    private Level level;
    private int posX;
    private int posY;


    /**
     * 
     * @param nameEnemy
     * @param typeEnemy
     * @param scorePlus
     * @param scoreLess
     * @param level
     * @param resX
     * @param resY
     */
    public Enemy(String nameEnemy, int typeEnemy, int scorePlus, int scoreLess,Level level,int resX, int resY) {
        this.nameEnemy = nameEnemy;
        this.scorePlus = scorePlus;
        this.scoreLess = scoreLess;
        this.level = level;
        Random random = new Random();
        posX = random.nextInt(resX); 
        posY = random.nextInt(resY);
        
        switch(typeEnemy){
            case 1:
                this.typeEnemy = TypeEnemy.OGRE;
                break;

            case 2:
                this.typeEnemy = TypeEnemy.ABSTRACT;
                break;

            case 3:
                this.typeEnemy = TypeEnemy.BOSS;
                break;

            case 4:
                this.typeEnemy = TypeEnemy.MAGIC;
                break;         
        }
    }

    public String getNameEnemy() {
        return nameEnemy;
    }
    public Level getLevel(){
        return level;
    }
    public int getScorePlus(){
        return scorePlus;
    }
    public int getType(){
        switch(typeEnemy){
            case OGRE:
                return 1;

            case ABSTRACT:
                return 2;
            
            case BOSS:
                return 3;
            
            case MAGIC:
                return 4;
        
            default:
                return 0;
        }
    }

}
