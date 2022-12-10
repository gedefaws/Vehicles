package model;

import java.util.Map;

public class Human extends AbstractVehicle {

    int theX;
    int theY;
    Direction theDir;
    int pokeCount = 0;
    Boolean dead = false;

    public Human(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir);

    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.GREEN) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
            System.out.println(1);
            return getDirection();
        }
        else if (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
            System.out.println(2);
            return getDirection().right();
        }
        else if (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
            System.out.println(3);
            return getDirection().left();
        }
        else if (theNeighbors.get(getDirection()) == Terrain.GRASS
                && theNeighbors.get(getDirection().left()) == Terrain.GRASS
                && theNeighbors.get(getDirection().right()) == Terrain.GRASS) {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection() || newDir == getDirection().right()
                    || newDir == getDirection().left()) {
                    bool = false;
                    System.out.println(4);
                    return newDir;
                }
            }
        }
        else if (theNeighbors.get(getDirection()) == Terrain.GRASS
                && (theNeighbors.get(getDirection().left()) != Terrain.GRASS
                && theNeighbors.get(getDirection().left()) != Terrain.CROSSWALK)
                && (theNeighbors.get(getDirection().right()) != Terrain.GRASS
                && theNeighbors.get(getDirection().right()) != Terrain.CROSSWALK)) {
            return getDirection();
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.GRASS
                 && theNeighbors.get(getDirection().left()) == Terrain.GRASS) 
                 && (theNeighbors.get(getDirection().right()) != Terrain.GRASS 
                 && theNeighbors.get(getDirection().right()) != Terrain.CROSSWALK)) {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection() || newDir == getDirection().left()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.GRASS
                && theNeighbors.get(getDirection().right()) == Terrain.GRASS)
                && (theNeighbors.get(getDirection().left()) != Terrain.GRASS
                && theNeighbors.get(getDirection().left()) != Terrain.CROSSWALK)) {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection() || newDir == getDirection().right()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if (theNeighbors.get(getDirection()) != Terrain.GRASS
                && theNeighbors.get(getDirection().right()) == Terrain.GRASS
                && theNeighbors.get(getDirection().left()) == Terrain.GRASS) {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection().left() || newDir == getDirection().right()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if (theNeighbors.get(getDirection()) != Terrain.GRASS
                && theNeighbors.get(getDirection().right()) != Terrain.GRASS
                && theNeighbors.get(getDirection().left()) == Terrain.GRASS) {
            return getDirection().left();
        }
        else if (theNeighbors.get(getDirection()) != Terrain.GRASS
                && theNeighbors.get(getDirection().right()) == Terrain.GRASS
                && theNeighbors.get(getDirection().left()) != Terrain.GRASS) {
            return getDirection().right();
        }
        else {
            System.out.println(7);
            return getDirection().reverse();
        }
        System.out.println(8);
        return getDirection().reverse();
    }

    @Override
    public void collide(Vehicle theOther) {
        if (theOther.isAlive() && theOther.getDeathTime() < getDeathTime()) {
            dead = true;
        }
    }

    @Override
    public int getDeathTime() {
        return 45;
    }

    @Override
    public String getImageFileName() {
        if (isAlive()){
            return "human.gif";
        }
        else {
            return "human_dead.gif";
        }
    }

    @Override
    public boolean isAlive() {
        if (dead == true && pokeCount < getDeathTime()) {
            return false;
        }
        else if (dead && pokeCount == 15) {
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