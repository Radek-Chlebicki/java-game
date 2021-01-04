
//started by Radek finished By Mesbah

package game;

import edu.monash.fit2099.engine.*;


/**
 * <p>
 *     DisplayChar : {@value DisplayChars#EnemyDoctorMaybeChar}
 * Has half the hit points of a Grunt, and does not move at all. He should be placed inside a locked room. When defeated, Doctor Maybe must drop a rocket engine.
 * </p>
 */
public class EnemyDoctorMaybeActor extends Actor {
    /**
     * This actor is called "Doctor Maybe", is represented by the char '~'
     */
    public EnemyDoctorMaybeActor(){
        super("Doctor Maybe", DisplayChars.EnemyDoctorMaybeChar,100,25);
        RocketEngineItem aRocketEngineItem = new RocketEngineItem();
        aRocketEngineItem.getAllowableActions().clear();;
        this.getInventory().add(aRocketEngineItem);
        DoorKeyItem aKey = new DoorKeyItem();
        aKey.getAllowableActions().clear();
        this.getInventory().add(aKey);

    }

    @Override

    // list of actions is generated in the world turn to turn it is then given to the actor
    // if doctorMaybe can attack he will
    // otherwise he does nothing
    // doctor maybe will know to attack as player offers the attack action
    /**
     * this actor always attacks adjacent actors otherwise he skips his turn
     */
    public Action playTurn(Actions actions, GameMap map, Display display) {
        for (Action anAction : actions){
            if (anAction.getClass() == AttackAction.class){
                return anAction;
            }
        }
        return new SkipTurnAction();
    }

    @Override
    /**
     * intrinsic weapon is called "soft punches" with damage 3
     *
     */
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(3, "Soft Punches");
    }


    @Override

    // the attackAction will drop all the items once the doctormaybe is knocked out
    //
    /**
     * Other actors can do the default things to this actor as specified in the Actor class
     */
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        return super.getAllowableActions(otherActor, direction, map);
    }
}
