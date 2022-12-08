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
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        
        if (theNeighbors.get(getDirection()) != Terrain.WALL && theNeighbors.get(getDirection().left()) == Terrain.WALL){
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection() || newDir == getDirection().right()) {
                    bool = false;
                    System.out.println("ATV " + 0);
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
                    System.out.println("ATV " + 1);
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
                    System.out.println("ATV " + 2);
                    return newDir;
                }
            }
        }
        else if (theNeighbors.get(getDirection()) == Terrain.WALL && theNeighbors.get(getDirection().right()) == Terrain.WALL){
            System.out.println("ATV " + 3);
            return getDirection().left();
        }
        else if (theNeighbors.get(getDirection()) == Terrain.WALL && theNeighbors.get(getDirection().left()) == Terrain.WALL){
            System.out.println("ATV " + 4);
            return getDirection().right();
        }
        else {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir != getDirection().reverse()){
                    bool = false;
                    System.out.println("ATV " + 5);
                    return newDir;
                }
            }
        }
        System.out.println("ATV " + 6);
        return getDirection();
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
        return 25;
    }

    @Override
    public String getImageFileName() {
        // TODO Auto-generated method stub
        if (isAlive()){
            return "atv.gif";
        }
        else { 
            return "atv_dead.gif";
        }
    }


    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        if (pokeCount < getDeathTime() && dead){
            System.out.println("now dead");
            return false;
        }
        else if (dead && pokeCount == getDeathTime()){
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
        
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        
    }
    public String toString(){
        return "(" + theX + "," + theY + ")";
    }
    
}
