package model;

import java.util.Map;

public class Taxi extends AbstractVehicle {

    int theX;
    int theY;
    Direction theDir;
    int pokeCount = 0;
    Boolean dead = false;
    int redLightTimeCount = 0;

    public Taxi(int theX, int theY, Direction theDir){
        super(theX, theY, theDir);

    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        // TODO Auto-generated method stub
        
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
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
        if(theOther.isAlive() && theOther.getDeathTime() < getDeathTime()){
            dead = true;
        }
        
    }

    @Override
    public int getDeathTime() {
        // TODO Auto-generated method stub
        return 15;
    }

    @Override
    public String getImageFileName() {
        // TODO Auto-generated method stub
        if (isAlive()){
            return "taxi.gif";
        }
        else {
            return "taxi_dead.gif";
        }
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        if (pokeCount < 15 && dead){
            System.out.println("now dead");
            return false;
        }
        else if (dead && pokeCount == 15){
            dead = false;
            pokeCount = 0;
            System.out.println("now awake");
            setDirection(Direction.random());
            return true;
        } 
        else {
            return true;
        }              
    }

    @Override
    public void poke() {
        // TODO Auto-generated method stub
        pokeCount++;
        System.out.println("count is " + pokeCount);

    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        
    }
    
    public String toString(){
        return "(" + theX + "," + theY + ")";
    }
    
}
