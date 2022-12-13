package model;

import java.util.Map;

public class Taxi extends AbstractVehicle {

    private int theX;
    private int theY;
    private Direction theDir;
    private int pokeCount = 0;
    private Boolean dead = false;
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
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(getDirection()) == Terrain.STREET
            || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection()) == Terrain.LIGHT){
                return getDirection();
        }
        else if (theNeighbors.get(getDirection()) == Terrain.GRASS
             || theNeighbors.get(getDirection()) == Terrain.TRAIL
             || theNeighbors.get(getDirection()) == Terrain.WALL){
            
            if (theNeighbors.get(getDirection().left()) == Terrain.STREET
            || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection().left()) == Terrain.LIGHT) {
                return getDirection().left();
            }
            else if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
            || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection().right()) == Terrain.LIGHT){
                return getDirection().right();
            }
            else {
                return getDirection().reverse();
            }
        }
        else {
            return getDirection().reverse();
        }
    }

    @Override
    public void collide(Vehicle theOther) {
        if(theOther.isAlive() && theOther.getDeathTime() < getDeathTime()){
            dead = true;
        }       
    }

    @Override
    public int getDeathTime() {
        return 15;
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
    public boolean isAlive() {
        if (pokeCount < getDeathTime() && dead){
            return false;
        }
        else if (dead && pokeCount == getDeathTime()){
            dead = false;
            pokeCount = 0;
            setDirection(Direction.random());
            return true;
        } 
        else {
            return true;
        }              
    }

    @Override
    public void poke() {
        pokeCount++;
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
