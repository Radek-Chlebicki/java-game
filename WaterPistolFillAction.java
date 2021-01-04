package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;


/**
 * Fills the WaterPistolItem
 *
 */
public class WaterPistolFillAction extends Action {
    public WaterPistolFillAction(){

    }

    @Override
    /**
     * precondition(Actor is instance of stunnablePlayer and has a WaterPistolItem)
     * postcondition(waterPistolItem held by actor is filled)
     */
    public String execute(Actor actor, GameMap map) {
        StunnablePlayer stunnablePlayer = (StunnablePlayer) actor;
        Item waterPistolItemItem = stunnablePlayer.hasAnItemOfType(WaterPistolItem.class);
        WaterPistolItem waterPistolItem = (WaterPistolItem) waterPistolItemItem;
        waterPistolItem.fill();
        return "Water Pistol(s) filled";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "Fills Water Pistol" ;
    }

    @Override
    public String hotKey() {
        return "";
    }
}
