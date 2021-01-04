package game;
//radek and mesbah

import edu.monash.fit2099.engine.Location;

/**
 * offers the manhattan distance as a static method
 *
 */
public class ManhattanDistance {
    /**
     *
     * @param a location of one actor
     * @param b location of the other actor
     * @return the distance
     */
    static int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }

}
