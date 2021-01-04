//started by Radek finished By Mesbah

package game;

import edu.monash.fit2099.engine.*;


/**
 * <p> Removes the RocketBodyItem and RocketEngineItem from the RocketBuildGround
 *      Places RocketCompleteItem in ActorsInventory
 *  </p>
 */
public class RocketBuildAction extends Action {
    private Location thisLocation = null;
    private GameMap moonGameMap = null;
    public RocketBuildAction(Location thisLocation, GameMap moonGameMap){
        this.moonGameMap = moonGameMap;
        this.thisLocation = thisLocation;

    }

    /**
     * Removes the RocketBodyItem and RocketEngineItem from the RocketBuildGround places RocketCompleteItem in Actors Inventory
     *
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return "New Rocket has been manufactured and placed in " + actor + " inventory"
     */
    public String execute(Actor actor, GameMap map) {
        Item removeRocketBody = null;
        Item removeRocketEngine = null;
        for (Item item : this.thisLocation.getItems()){
            if (item.getClass() == RocketBodyItem.class){
                removeRocketBody = item;
            }

            if (item.getClass() == RocketEngineItem.class){
                removeRocketEngine = item;
            }
        }

//        if (removeRocketBody != null){
        this.thisLocation.removeItem(removeRocketBody);
//        }
//        if (removeRocketEngine !=null){
        this.thisLocation.removeItem(removeRocketEngine);

        Item rocketCompleteItem = Item.newFurniture("The complete Rocket", DisplayChars.RocketCompleteItemChar);
        rocketCompleteItem.getAllowableActions().add(new MoveActorAction(moonGameMap.at(1, 1), "to moon that has no oxygen"));
        this.thisLocation.addItem(rocketCompleteItem);

        return "New Rocket has been manufactured and is in " + thisLocation;
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor  +  " Build the rocket using the rocket body and the Rocket Engine";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
