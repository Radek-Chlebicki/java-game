//radek and mesbah

package game;


import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.Item;


//by default items can be picked up

/**
 * <p>
 *     DisplayChar : {@value DisplayChars#DoorKeyItemChar}
 * When an actor has a DoorKeyItem in its inventory a DoorGround offers a DoorUnlockAction, A key is an item that is dropped by enemies when they have been knocked out
 * </p>
 */

public class DoorKeyItem extends Item {
    public DoorKeyItem() {
        super("DoorKeyItem", DisplayChars.DoorKeyItemChar);
    }

}
