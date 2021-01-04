package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;

/**
 * <p>
 * This item serves as an oxygen tank
 * DisplayChar: {@value DisplayChars#OxygenTankItemChar}
 * </p>
 *
 */

public class OxygenTankItem extends Item {
    public OxygenTankItem(){
        super("Oxygen Tank", DisplayChars.OxygenTankItemChar);
    }

    /**
     * <p>
     *     precondition(none)
     *     postcondition(returns int amount of oxygen contained)
     * </p>
     *
     */

    public int getOxygenAmount(){
        return 100;
    }
}
