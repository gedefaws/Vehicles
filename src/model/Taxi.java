package model;

import java.util.Map;

public class Taxi extends Car {

    private int theX;
    private int theY;
    private Direction theDir;
    private int redLightTimeCount = 0;

    public Taxi(int theX, int theY, Direction theDir){
        super(theX, theY, theDir);

    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {        
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.RED && redLightTimeCount < 3){
            redLightTimeCount++;
            return false;
        }
        else if (theTerrain == Terrain.LIGHT && theLight == Light.RED){
            redLightTimeCount = 0;
            return false;
        }
        else {
            redLightTimeCount = 0;
            return true;
        }
    }

    @Override
    public String getImageFileName() {
        if (isAlive()){
            return "taxi.gif";
        }
        else {
            return "taxi_dead.gif";
        }
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String toString(){
        return "(" + theX + "," + theY + ")";
    }

}
