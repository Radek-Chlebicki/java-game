package game;
//radek and mesbah

import edu.monash.fit2099.engine.WeaponItem;


/**
 * <p>
 *     equivalent to thors axe
 *     DisplayChar : {@value DisplayChars#StickWeaponItemChar}
 *
 * </p>
 */


public class StickWeaponItem extends WeaponItem {
    public StickWeaponItem() {
        super("Stick", DisplayChars.StickWeaponItemChar, 100,"hit");
    }
}
