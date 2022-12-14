
package model;

import java.util.Map;

public class Truck extends AbstractVehicle {

    public Truck(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir);

    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        if (theTerrain == Terrain.CROSSWALK && theLight == Light.RED) {
            return false;
        }
        return true;
    }

    @Override
    public Direction chooseDirection(Map<Direction, Terrain> theNeighbors) {
        if ((theNeighbors.get(getDirection()) == Terrain.STREET
             || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
             || theNeighbors.get(getDirection()) == Terrain.LIGHT)
            && (theNeighbors.get(getDirection().right()) == Terrain.GRASS
                || theNeighbors.get(getDirection().right()) == Terrain.TRAIL
                || theNeighbors.get(getDirection().right()) == Terrain.WALL)
            && (theNeighbors.get(getDirection().left()) == Terrain.GRASS
                || theNeighbors.get(getDirection().left()) == Terrain.TRAIL
                || theNeighbors.get(getDirection().left()) == Terrain.WALL)) {
            return getDirection();
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.STREET
                  || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                  || theNeighbors.get(getDirection()) == Terrain.LIGHT)
                 && (theNeighbors.get(getDirection().right()) == Terrain.STREET
                     || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().right()) == Terrain.LIGHT)
                 && (theNeighbors.get(getDirection().left()) == Terrain.STREET
                     || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection() || newDir == getDirection().right()
                    || newDir == getDirection().left()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.STREET
                  || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                  || theNeighbors.get(getDirection()) == Terrain.LIGHT)
                 && (theNeighbors.get(getDirection().right()) == Terrain.STREET
                     || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().right()) == Terrain.LIGHT)
                 && (theNeighbors.get(getDirection().left()) == Terrain.GRASS
                     || theNeighbors.get(getDirection().left()) == Terrain.TRAIL
                     || theNeighbors.get(getDirection().left()) == Terrain.WALL)) {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection() || newDir == getDirection().right()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.STREET
                  || theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                  || theNeighbors.get(getDirection()) == Terrain.LIGHT)
                 && (theNeighbors.get(getDirection().right()) == Terrain.GRASS
                     || theNeighbors.get(getDirection().right()) == Terrain.TRAIL
                     || theNeighbors.get(getDirection().right()) == Terrain.WALL)
                 && (theNeighbors.get(getDirection().left()) == Terrain.STREET
                     || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {
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
                  || theNeighbors.get(getDirection()) == Terrain.TRAIL
                  || theNeighbors.get(getDirection()) == Terrain.WALL)
                 && (theNeighbors.get(getDirection().right()) == Terrain.STREET
                     || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().right()) == Terrain.LIGHT)
                 && (theNeighbors.get(getDirection().left()) == Terrain.STREET
                     || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {
            Boolean bool = true;
            while (bool == true) {
                Direction newDir = Direction.random();
                if (newDir == getDirection().right() || newDir == getDirection().left()) {
                    bool = false;
                    return newDir;
                }
            }
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.GRASS
                  || theNeighbors.get(getDirection()) == Terrain.TRAIL
                  || theNeighbors.get(getDirection()) == Terrain.WALL)
                 && (theNeighbors.get(getDirection().right()) == Terrain.STREET
                     || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().right()) == Terrain.LIGHT)
                 && (theNeighbors.get(getDirection().left()) == Terrain.GRASS
                     || theNeighbors.get(getDirection().left()) == Terrain.TRAIL
                     || theNeighbors.get(getDirection().left()) == Terrain.WALL)) {

            return getDirection().right();
        }
        else if ((theNeighbors.get(getDirection()) == Terrain.GRASS
                  || theNeighbors.get(getDirection()) == Terrain.TRAIL
                  || theNeighbors.get(getDirection()) == Terrain.WALL)
                 && (theNeighbors.get(getDirection().right()) == Terrain.GRASS
                     || theNeighbors.get(getDirection().right()) == Terrain.TRAIL
                     || theNeighbors.get(getDirection().right()) == Terrain.WALL)
                 && (theNeighbors.get(getDirection().left()) == Terrain.STREET
                     || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                     || theNeighbors.get(getDirection().left()) == Terrain.LIGHT)) {

            return getDirection().left();

        }
        return getDirection().reverse();

    }

    @Override
    public int getDeathTime() {
        return 0;
    }

    @Override
    public String getImageFileName() {
        return "truck.gif";
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public void reset() {
        // TODO Auto-generated method stub

    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

    @Override
    public void collide(Vehicle theOther) {
        // Not necessary for truck since truck never dies
        
    }

    @Override
    public void poke() {
        // Not necessary for truck since truck never dies
        
    }

}
