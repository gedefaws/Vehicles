
package model;

import java.util.Map;

public class Truck extends AbstractVehicle {

    int theX;
    int theY;
    Direction theDir;

    public Truck(int theX, int theY, Direction theDir) {
        super(theX, theY, theDir);

    }

    @Override
    public boolean canPass(Terrain theTerrain, Light theLight) {
        // TODO Auto-generated method stub
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
            System.out.println(1);
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
                    System.out.println(5);

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
                    System.out.println(2);
                    System.out.println(newDir);
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
                    System.out.println(3);
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
                    System.out.println(4);
                    System.out.println(getDirection());
                    System.out.println(newDir);

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
            System.out.println(7);

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

            System.out.println(8);
            return getDirection().left();

        }

        // else {
        // System.out.println(6);
        // return getDirection().reverse();
        // }
        System.out.println(6);
        return getDirection().reverse();

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
        return "truck.gif";
    }

    // @Override
    // public Direction getDirection() {
    // // TODO Auto-generated method stub
    // System.out.println("the direction is" + theDir);
    // return theDir;
    // }

    // @Override
    // public int getX() {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    // @Override
    // public int getY() {
    // // TODO Auto-generated method stub
    // return 0;
    // }

    @Override
    public boolean isAlive() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void poke() {
        // TODO Auto-generated method stub

    }

    // @Override
    // public void reset() {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void setDirection(Direction theDir) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void setX(int theX) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void setY(int theY) {
    // // TODO Auto-generated method stub

    // }

}
