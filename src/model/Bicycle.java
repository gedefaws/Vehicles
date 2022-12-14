package model;

import java.util.Map;

public class Bicycle extends AbstractVehicle {

    private int pokeCount;
    private boolean dead;

    public Bicycle(int theX, int theY, Direction theDir){
        super(theX, theY, theDir);
        pokeCount = 0;
        dead = false;
    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        if((theTerrain == Terrain.LIGHT && theLight != Light.GREEN)
        || (theTerrain == Terrain.CROSSWALK && theLight != Light.GREEN)){
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        if(theNeighbors.get(getDirection()) == Terrain.TRAIL){
            return getDirection();
        }
        else if(theNeighbors.get(getDirection().left()) == Terrain.TRAIL){
            return getDirection().left();
        }
        else if(theNeighbors.get(getDirection().right()) == Terrain.TRAIL){
            return getDirection().right();
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.STREET
            || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
            || theNeighbors.get(getDirection()) == Terrain.LIGHT)
            && (theNeighbors.get(getDirection().left()) != Terrain.TRAIL 
            || (theNeighbors.get(getDirection().right()) != Terrain.TRAIL))){
                return getDirection();
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.GRASS
            || theNeighbors.get(getDirection()) == Terrain.WALL)
            && (theNeighbors.get(getDirection().left()) != Terrain.TRAIL 
            || (theNeighbors.get(getDirection().right()) != Terrain.TRAIL))){
        
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
        if (theOther.isAlive() && theOther.getDeathTime() < getDeathTime()){
            dead = true;
        }       
    }

    @Override
    public int getDeathTime() {
        return 35;
    }

    @Override
    public String getImageFileName() {
        if (isAlive()){
            return "bicycle.gif";
        }
        else {
            return "bicycle_dead.gif";
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
        return "(" + getX() + "," + getY()+ ")";
    }
}
