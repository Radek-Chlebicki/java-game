package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;


/**
 * <p>
 * The water pistol has only enough water for one shot
 * DisplayChar is {@value DisplayChars#WaterPistolWeaponItemChar}
 * name is water pistol
 * </p>
 */
public class WaterPistolItem extends Item {
    private boolean filled = false; // do i need constructor

    public WaterPistolItem(){
        super("Water Pistol", DisplayChars.WaterPistolWeaponItemChar);
    }

    /**
     * <p>
     * Checks whether loaded
     * precondition(none)
     * postcondition(returns loaded bool where true means loaded)
     * </p>
     */
    public boolean isEmpty(){
        return !this.filled;

    }

    /**
     * <p>
     * Perform a shot
     * precondition (ensure that WaterPistolIsLoaded)
     * postcondition (Water pistol is not loaded)
     * </p>
     */
    public void empty(){
        this.filled = false;
    }


    /**
     * <p>
     * Fills with water
     * precondition (none)
     * postcondition (water pistol is loaded)
     * </p>
     */
    public void fill(){
        if (this.filled == false){
            this.filled = true;
        }
    }


}
