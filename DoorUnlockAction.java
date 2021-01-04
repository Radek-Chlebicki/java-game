//started by Mesbah finished By Radek

package game;

import edu.monash.fit2099.engine.*;


// this is the allowable action of the door class of type ground

/**
 * <p>
 *
 * This has 2 effects
 * 1) the DoorKeyItem is removed from the Actors inventory
 * 2) The DoorGround is replaced with a FloorGround
 * </p>
 */
public class DoorUnlockAction extends Action {
    private String direction;
    private Location doorLocation;



    public DoorUnlockAction(String direction, Location doorLocation){
        this.direction = direction;
        this.doorLocation = doorLocation;
    }

    /**
     * Removes DoorKeyItem from Actors inventory and replaces DoorGround with FloorGround
     * @param actor The actor performing the action.
     * @param gameMap
     * @return "DoorGroundOpened"
     */
    public String execute(Actor actor, GameMap gameMap){
        Item itemToRemove = null;
        for (Item item: actor.getInventory()){
            if (item.getClass() == DoorKeyItem.class){
                itemToRemove = item;
            }
        }
        actor.getInventory().remove(itemToRemove);

        gameMap.add(new FloorGround(), this.doorLocation);
        return "DoorGround opened";
    }

    /**
     * the description of what this action does
     * @param actor The actor performing the action.
     * @return nameofactor + "opens door to the " + direction
     */
    public String menuDescription(Actor actor) {
        return actor + " opens door to the " + direction;
    }


    public String hotKey() {
        return "";
    }


}
