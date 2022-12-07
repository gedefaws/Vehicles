
package model;

import java.util.Map;

public class Car extends AbstractVehicle {

    int theX;
    int theY;
    Direction theDir;
    int count = 0;
    boolean dead = false;

    public Car(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir);

    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        // TODO Auto-generated method stub
        if(theTerrain == Terrain.LIGHT && theLight == Light.RED){
            return false;
        }
        else if (theTerrain == Terrain.CROSSWALK && (theLight == Light.YELLOW || theLight == Light.RED)){
            return false;
        }
        return true;
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
        }else {
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
        if (isAlive()) {
            return "car.gif";
        }
        else {
            return "car_dead.gif";
        }
        
    }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        if (count < 15 && dead){
            System.out.println("now dead");
            return false;
        }
        else if (dead && count == 15){
            dead = false;
            count = 0;
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
        count++;
        System.out.println("count is " + count);

    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub
        Vehicle v = new Car(theX, theY, theDir);
    }

    public String toString(){
        return "(" + theX + "," + theY + ")";
    }
}
