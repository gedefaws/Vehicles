package model;

import java.util.Map;

import io.FileLoader;

public class Atv extends AbstractVehicle{
    int theX;
    int theY;
    Direction theDir;
    

    public Atv(int theX, int theY, Direction theDir){
        super(theX, theY, theDir);
    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void collide(Vehicle theOther) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getDeathTime() {
        // TODO Auto-generated method stub
        return 25;
    }

    @Override
    public String getImageFileName() {
        // TODO Auto-generated method stub
        return "atv.gif";
    }

    @Override
    public Direction getDirection() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void poke() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDirection(Direction theDir) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setX(int theX) {
        this.theX = theX;
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setY(int theY) {
        // TODO Auto-generated method stub
        this.theY = theY;
        
    }
    
}
