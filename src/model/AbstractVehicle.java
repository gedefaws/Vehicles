package model;

import java.util.Map;

import view.RoadRageGUI;
import view.RoadRageMain;

public abstract class AbstractVehicle implements Vehicle {
    int theX;
    int theY;
    Direction theDir;
    public AbstractVehicle(int theX, int theY, Direction theDir){
        this.theX = theX;
        this.theY = theY;
        this.theDir = theDir;
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
        return 0;
    }

    @Override
    public String getImageFileName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Direction getDirection() {
        // TODO Auto-generated method stub
        if(theDir.dx() < 0){
            return Direction.WEST;
        }
        else if(theDir.dx() > 0){
            return Direction.EAST;
        }
        else if(theDir.dy() < 0){
            return Direction.NORTH;
        }
        else {
            return Direction.SOUTH;
        }
    }

    @Override
    public int getX() {
        // TODO Auto-generated method stub
        return theX;
    }

    @Override
    public int getY() {
        // TODO Auto-generated method stub
        return theY;
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
        this.theDir = theDir;
    }

    @Override
    public void setX(int theX) {
        // TODO Auto-generated method stub
        this.theX = theX;
        
    }

    @Override
    public void setY(int theY) {
        // TODO Auto-generated method stub
        this.theY = theY;
        
    }

}
