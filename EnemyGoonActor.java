//started by Radek finished By Mesbah

package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * <p>
 * DisplayChar : {@value DisplayChars#EnemyGoonActorChar}
 * has a EnemyGoonShoutsWeaponItem, foolows the player and sometimes shouts insults
 * </p>
 *
 */
public class EnemyGoonActor extends Actor {

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    /**
     *Has a BehaviourFollow which causes it to follow the player
     * @param name the name of the Goon
     * @param player the player in the game
     */

    public EnemyGoonActor(String name, Actor player) {
        super(name, DisplayChars.EnemyGoonActorChar, 100, 50);
        addBehaviour(new BehaviourFollow(player));

        // here we give the shouts weapon but remove the ability to pick it up
        DoorKeyItem aKey = new DoorKeyItem();
        aKey.getAllowableActions().clear();
        this.getInventory().add(aKey);
        EnemyGoonShoutsWeaponItem aEnemyGoonShoutsWeaponItem = new EnemyGoonShoutsWeaponItem();
        //so that this weapon wont be dropped
        aEnemyGoonShoutsWeaponItem.getAllowableActions().clear();
        this.getInventory().add(aEnemyGoonShoutsWeaponItem);
    }

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }


    /**
     * If BehaviourFollow returns a MoveActorAction then it moves, if BehaviourFollow returns a null it is adjacent to Actor it is following and attacks
     * @param actions collection of possible Actions for this Actor
     * @param map the map containing the Actor
     * @param display the I/O object to which messages may be written
     * @return Returns whatever the super class returns
     */
    public Action playTurn(Actions actions, GameMap map, Display display) {


        for (ActionFactory factory : actionFactories) {
            Action action = factory.getAction(this, map);
            if (action != null)
                return action;
        }

        for (Action anAction : actions) {
            if (anAction.getClass() == AttackAction.class) {
                return anAction;
            }
        }
        // this is not needed
        return super.playTurn(actions, map, display);

    }

    /**
     * intrinsicWeapon verb is "Hard punches" and causes 10 damage
     * @return returns the IntrinsicWeapon
     */
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "Hard Punches");
    }

    /**
     *  10% chance of using EnemyGoonShoutsWeaponItem and 90% chance of using the intrinsic weapon
     * @return aWeapon
     */
    public Weapon getWeapon() {
        Random random = new Random();
        if (random.nextInt(10)==1){
            for (Item item : inventory) {
                if (item.asWeapon() != null)
                    return item.asWeapon();
            }
        }
        return getIntrinsicWeapon();

    }
}
