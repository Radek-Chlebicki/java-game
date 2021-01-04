package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;

/**
 * Fills spacesuit with oxygen if player has oxygen tank item, reports space suit oxygen level
 *
 */
public class SpaceSuitFillWithOxygenAction extends Action {
    public SpaceSuitFillWithOxygenAction(){

    }

    @Override
    /**
     * <p>
     *    precondition(player needs to be carrying space suit)
     *    postcondition(if player has oxygenTankItem, calls fills spacesuit with amount of oxygen in tank and removes tank
     *                            and reports oxygen level in spacesuit
     *                      if player does not have oxygentank, instructs to get it and reports oxygen level in space suit
     *
     * </p>
     */
    public String execute(Actor actor, GameMap map) {
        String oxygenLevel = "";
        if (actor instanceof StunnablePlayer){
            StunnablePlayer stunnablePlayer = (StunnablePlayer) actor;
            if (!stunnablePlayer.checkIfHasAnItemOfType(SpaceSuitItem.class)){
                return "you need to pick it up first";
            }
            Item spaceSuitItemItem = stunnablePlayer.hasAnItemOfType(SpaceSuitItem.class);
            SpaceSuitItem spaceSuitItem = (SpaceSuitItem) spaceSuitItemItem;

            if (spaceSuitItem != null){
                Item oxygenTankItemItem = stunnablePlayer.hasAnItemOfType(OxygenTankItem.class);
                OxygenTankItem oxygenTankItem = (OxygenTankItem) oxygenTankItemItem;
                if (oxygenTankItem != null){
                    spaceSuitItem.addOxygen(oxygenTankItem.getOxygenAmount());
                    stunnablePlayer.getInventory().remove(oxygenTankItem);
                    return "Oxygen tank used to add Oxygen to space suit, space suit has: " + spaceSuitItem.getOxygenLevel() + " oxygen points" ;
                }

                else{
                    oxygenLevel = spaceSuitItem.getOxygenLevel();
                    return "you need an Oxygen tank to add oxygen to space suit, space suit currently has: " + oxygenLevel + " oxygen points";

                }
            }


        }
        return "you need an Oxygen tank to add oxygen to space suit, space suit currently has: " + oxygenLevel + " oxygen points";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Fill space suit with oxygen and check oxygen level";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
