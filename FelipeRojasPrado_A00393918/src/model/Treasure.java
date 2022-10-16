package model;
import java.util.Random;

public class Treasure {
    private String nameTreasure;
    private int scorePlusTreasure;
    private String UrlImage;
    private Level level;
    private int posX;
    private int posY;

    /**
     * 
     * @param nameTreasure
     * @param UrlImage
     * @param scorePlusTreasure
     * @param level
     * @param resX
     * @param resY
     */
    public Treasure(String nameTreasure, String UrlImage, int scorePlusTreasure, Level level,int resX,int resY){
        this.nameTreasure = nameTreasure;
        this.scorePlusTreasure = scorePlusTreasure;
        this.UrlImage = UrlImage;
        this.level = level;
        Random random = new Random();
        posX = random.nextInt(resX); 
        posY = random.nextInt(resY);
    }
    public String getNameTreasure() {
        return nameTreasure;
    }
    public Level getLevel(){
        return level;
    }
    

}
