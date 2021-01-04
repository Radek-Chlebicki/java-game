//started by Radek finished By Mesbah

package game;

import edu.monash.fit2099.engine.*;

import java.util.Random;

import static game.ManhattanDistance.distance;


/**
 * <p>
 *     DisplayChar : {@value DisplayChars#EnemyNinjaActorChar}
 *     Ninjas stay in one place unless they can see that the player is within 5 squares of them. then they move away.
 * </p>
 *
 */
public class EnemyNinjaActor extends Actor {
    private StunnablePlayer stunnablePlayer = null;
//    private World aworld = null;
//    private Application anapp = null;
    public EnemyNinjaActor(String name, StunnablePlayer aplayer){
        super(name, DisplayChars.EnemyNinjaActorChar, 100, 50 );
        this.stunnablePlayer = aplayer;
//        this.aworld = aworld;
//        this.anapp = anapp;
        DoorKeyItem aKey = new DoorKeyItem();
        aKey.getAllowableActions().clear();
        this.getInventory().add(aKey);

    }

    // Manhattan distance.
//    private int distance(Location a, Location b) {
//        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
//    }

    /**
     * There is a 50% chance the Ninja will try a stun action, if the stunnablePlayer is next to it otherwise it will skip its turn
     *
     * @param actions collection of possible Actions for this Actor
     * @param map the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return It returns either EnemyNinjaStunAction or SkipTurnAction
     */
    public Action playTurn(Actions actions, GameMap map, Display display) {
        Location ofNinja = map.locationOf(this);
        Location ofStunnablePlayer = map.locationOf(stunnablePlayer);
        int difference = distance(ofNinja, ofStunnablePlayer);
        if (difference <= 5){
            // to move away
            // wrap with random
            Random r = new Random();
            if (r.nextBoolean()) {
                return new EnemyNinjaStunAction(stunnablePlayer, this);
            }

        }
        // do not skip turn
        return new SkipTurnAction();
        }



    }

