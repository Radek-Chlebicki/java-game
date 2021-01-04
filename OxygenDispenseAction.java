package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;

/**
 * <p>
 *     Causes oxygen tank item to be placed in the OxygenDispenserGround
 *
 * </p>
 */

public class OxygenDispenseAction extends Action {
    private Location thisLocation = null;
    public OxygenDispenseAction(Location thisLocation){
        this.thisLocation = thisLocation;
    }

    /**
     *
     *
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        OxygenTankItem oxygenTankItem = new OxygenTankItem();
        thisLocation.addItem(oxygenTankItem);
        return "Oxygen tank with 10 oxygen points generated";
    }

    @Override
    public String menuDescription(Actor actor) {
        return actor + "Push button to Dispense Oxygen";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
