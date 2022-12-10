package model;

import java.util.Map;

import io.FileLoader;

public class Atv extends AbstractVehicle{
    int theX;
    int theY;
    Direction theDir;
    Boolean dead = false;
    int pokeCount = 0;

    public Atv(int theX, int theY, Direction theDir){
        super(theX, theY, theDir);
    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        return true;
    }

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {        
        if (theNeighbors.get(getDirection()) != Terrain.WALL && theNeighbors.get(getDirection().left()) == Terrain.WALL){
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection() || newDir == getDirection().right()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if (theNeighbors.get(getDirection()) != Terrain.WALL && theNeighbors.get(getDirection().right()) == Terrain.WALL){
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection().left() || newDir == getDirection()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if (theNeighbors.get(getDirection()) == Terrain.WALL && theNeighbors.get(getDirection().left()) != Terrain.WALL 
            && theNeighbors.get(getDirection().right()) != Terrain.WALL){
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection().left() || newDir == getDirection().right()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if (theNeighbors.get(getDirection()) == Terrain.WALL && theNeighbors.get(getDirection().right()) == Terrain.WALL){
            return getDirection().left();
        }
        else if (theNeighbors.get(getDirection()) == Terrain.WALL && theNeighbors.get(getDirection().left()) == Terrain.WALL){
            return getDirection().right();
        }
        else {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir != getDirection().reverse()){
                    bool = false;
                    return newDir;
                }
            }
        }
        System.out.println("ATV " + 6);
        return getDirection();
    }

    @Override
    public void collide(Vehicle theOther) {
        if(theOther.isAlive() && theOther.getDeathTime() < getDeathTime()){
            dead = true;
        }
        
    }

    @Override
    public int getDeathTime() {
        return 25;
    }

    @Override
    public String getImageFileName() {
        if (isAlive()){
            return "atv.gif";
        }
        else { 
            return "atv_dead.gif";
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
