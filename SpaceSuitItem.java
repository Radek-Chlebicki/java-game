package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;


/**
 * <p>
 *     Needed for player to breathe on the moon
 *     Display char: {@value DisplayChars#SpaceSuitItemChar}
 * </p>
 */
public class SpaceSuitItem extends Item {
    private int oxygenPointLevel = 0;


    public SpaceSuitItem(){
        super("space suit", DisplayChars.SpaceSuitItemChar);
        this.getAllowableActions().add(new SpaceSuitFillWithOxygenAction());
    }

    /**
     * <p>
     * precondition(an int amount of oxygen to add)
     * postcondition( the amount of oxygen in the space suit will increase by that amount)
     *
     * </p>
     * @param oxygenAmountToAdd
     */
    public void addOxygen(int oxygenAmountToAdd){
        oxygenPointLevel += oxygenAmountToAdd;
    }


    /**
     * <p>
     *     precondition(client must call noOxygenLeft(), if true then send back to earth)
     *     postcondition(oxygen amount in spacesuit decreased by one point)
     * </p>
     */
    public void useOxygen(){
        oxygenPointLevel -= 1;
    }

    /**
     * <p>
     * precondition(none)
     * postcondition(Int value of the oxygen level in the suit)
     * </p>
     */

    public String getOxygenLevel(){
        return String.valueOf(this.oxygenPointLevel);
    }

    /**
     * <p>
     * precondition(none)
     * postcondition(returns bool true if there is no oxygen in the space suit)
     * </p>
     */
    public boolean noOxygenLeft(){
        if (oxygenPointLevel <= 0) {
            oxygenPointLevel = 0;
            return true;
        }
        else{
            return false;
        }
    }
//    @Override
//    public Actions getAllowableActions() {
//        Actions canDo =  super.getAllowableActions();
//        canDo.add(new SpaceSuitFillWithOxygenAction());
//        return  canDo;
//    }

}
