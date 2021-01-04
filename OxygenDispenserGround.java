package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;


/**
 * <p>
 *     Offers a dispense oxygen action to a stunnable player
 *     DisplayChar : {@value DisplayChars#OxygenDispenserGround}
 * </p>
 */
public class OxygenDispenserGround extends Ground {

    public OxygenDispenserGround(){
        super(DisplayChars.OxygenDispenserGround);
    }

    @Override
    /**
     * <p>
     *     precondition(actor is a stunnable player)
     *     postcondition(an OxygenDispenseAction is returned)
     * </p>
     */
    public Actions allowableActions(Actor actor, Location location, String direction) {
        boolean isTankThere = false;
        if (actor instanceof StunnablePlayer){
            for (Item item: location.getItems()){
                if (item.getClass() == OxygenTankItem.class){
                    isTankThere = true;
                }
            }
            if (isTankThere){
                return  super.allowableActions(actor, location, direction);
            }
            else{
                OxygenDispenseAction oxygenDispenseAction = new OxygenDispenseAction(location);
                return new Actions(oxygenDispenseAction);

            }

        }
        return super.allowableActions(actor, location, direction);
    }
}
