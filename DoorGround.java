//radek and mesbah
package game;

import edu.monash.fit2099.engine.*;


/**
 * <p>
 *     DisplayChar : {@value DisplayChars#DoorGroundChar}
 *      A door can’t be passed through until it has been opened with a key, A DoorGround offers a DoorUnlockAction to an Actor who has a DoorKeyItem in his inventory
 * </p>
 */
public class DoorGround extends Ground {

    /**
     * When drawing a DoorGround onto the map use the char 'D'
     */
    public DoorGround() {
        super(DisplayChars.DoorGroundChar);
    }

    /**
     * Regardless of the Actor this will always False as actors cannot pass through
     * @param actor the actor that is adjacent to this DoorGround
     * @return It returns false because the actor cannot enter
     */
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    /**
     * This returns a DoorUnlockAction to an  actor that is an instance of Player and that has a DoorKeyItem in its inventory
     * otherwise it has the default behaviour
     * @param actor the Actor acting
     * @param location the current Location of the ground
     * @param direction the direction of the Ground from the Actor
     * @return the action that the actor will have an option to execute
     */
    public Actions allowableActions(Actor actor, Location location, String direction){
        //check if actor is player
        if (actor instanceof Player) {
            for (Item item : actor.getInventory()) {
                if (item.getClass() == DoorKeyItem.class) {
                    return new Actions(new DoorUnlockAction(direction, location));
                }

            }
        }

        return new Actions();
    }


    /**
     * always returns True as objects cannot be thrown through it
     * @return returns True when because an object is blocked
     */
    public boolean blocksThrownObjects() {
        return true;
    }
}
