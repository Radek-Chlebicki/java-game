package game;

import edu.monash.fit2099.engine.*;

/**
 * <p>
 * Actor cannot enter
 * Ground represented by {@value DisplayChars#WaterGroundChar}
 * </p>
 *
 */
public class WaterGround extends Ground {
    public WaterGround(){
        super(DisplayChars.WaterGroundChar);
    }

    @Override
    /**
     * Actor cannot enter
     */
    public boolean canActorEnter(Actor actor) {
        return false;
    }

    @Override
    /**
     * <p>
     * precondition()
     * postcondition(if actor is an instance of Stunnable Player, and has a Water Pistol Item will return a WaterPistolFillAction
     *                  otherwise same as superclass)
     * </p>
     */
    public Actions allowableActions(Actor actor, Location location, String direction) {
        if (actor instanceof StunnablePlayer){
            StunnablePlayer stunnablePlayer = (StunnablePlayer) actor;
            WaterPistolItem waterPistolItem = (WaterPistolItem) stunnablePlayer.hasAnItemOfType(WaterPistolItem.class);
            if (waterPistolItem != null){
                if (waterPistolItem.isEmpty()){
                    return new Actions(new WaterPistolFillAction());

                }
            }
        }
        return super.allowableActions(actor,location,direction);
    }
}
