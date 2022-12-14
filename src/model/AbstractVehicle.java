package model;

import java.util.Map;

import view.RoadRageGUI;
import view.RoadRageMain;

public abstract class AbstractVehicle implements Vehicle {
    private int theX;
    private int theY;
    private Direction theDir;

    public AbstractVehicle(int theX, int theY, Direction theDir){
        this.theX = theX;
        this.theY = theY;
        this.theDir = theDir;
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
        return theX;
    }

    @Override
    public int getY() {
        return theY;
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
    }

    @Override
    public void setDirection(Direction theDir) {
        this.theDir = theDir;
    }

    @Override
    public void setX(int theX) {
        this.theX = theX;
        
    }

    @Override
    public void setY(int theY) {
        this.theY = theY;
        
    }

}
