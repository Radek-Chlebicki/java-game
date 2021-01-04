//started by Mesbah finished By Radek

package game;

import edu.monash.fit2099.engine.*;

/**
 * Removes the plans from the players inventory, places rocketbodyitem in players inventory, and removes the qactor from map
 */
public class QGivePlanAction extends Action {
    // does not need direction
    private Actor qActor;

    /**
     *
     * @param qActor the actor
     */
    public QGivePlanAction(Actor qActor){
        this.qActor = qActor;
    }


    /**
     * <p>
     *     Removes the plans from the players inventory, places rocketbodyitem in players inventory, and removes the qactor from map
     * </p>
     *
     * @param actor the actor is the player
     * @param gameMap
     * @return "Plans given to QActor, Rocket body recieved"
     */
    public String execute(Actor actor, GameMap gameMap){
        // remove the plans from the inventory

        Item itemToRemove = null;

        // find the specific object
        for (Item item : actor.getInventory() ){
            if (item.getClass() == QPlansItem.class){
                itemToRemove = item;
            }
        }

        actor.getInventory().remove(itemToRemove);



        // put the rocket body in the inventory
        Item aRocketBody = new RocketBodyItem();
        aRocketBody.getAllowableActions().clear();
        aRocketBody.getAllowableActions().add(new DropItemAction(aRocketBody));
        actor.getInventory().add(aRocketBody);

        gameMap.removeActor(qActor);

        return "Plans given to QActor, Rocket body recieved";
    }


    /**
     * the menu description
     *
     * @return actor + " Give plans to " + "QActor"
     */
    public String menuDescription(Actor actor){
        return actor + " Give plans to " + "QActor";
    }

    public String hotKey(){
        return  "" ;
    }
}
