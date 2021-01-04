package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;


/**
 * <p>
 *     DisplayChar : {@value DisplayChars#EnemyYugoMaxActor}
 *     This is the enemy actor
 *     Has an armor that can be dissolved
 *     while armor is activated hurt() function causes no daamage
 *
 * </p>
 */
public class EnemyYugoMaxActor extends Actor {
    private boolean armored = true;
    public EnemyYugoMaxActor(){
        super("Armored Yugo Max", DisplayChars.EnemyYugoMaxActor,10, 5);
    }

    /**
     * <p>
     *      precondition(none)
     *      postcondition(armor deactivated)
     *
     * </p>
     */
    public void dissolveArmor() {
        this.name = "Vulnerable Yugo Max";
        this.armored = false;
    }

    @Override
    /**
     * <p>
     *     precondition()
     *     postcondition(if actor is a stunnablePlayer and has waterPistolItem
     *                      offers EnemyYugoMaxDissolveArmorAction
     *                   otherwise offers whatever super class offers
     *                   )
     * </p>
     */
    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions allActions = super.getAllowableActions(otherActor, direction, map);
        if (this.armored){
            if (otherActor instanceof StunnablePlayer){
                StunnablePlayer stunnablePlayer = (StunnablePlayer) otherActor;
                WaterPistolItem waterPistolItem = (WaterPistolItem) stunnablePlayer.hasAnItemOfType(WaterPistolItem.class);
                if (waterPistolItem == null){
                    return allActions;
                } else {
                    if (waterPistolItem.isEmpty()) {
                        return allActions;
                    } else {
                        allActions.add(new EnemyYugoMaxDissolveArmorAction(this));
                        return allActions;
                    }
                }
            }
        }

        return allActions;
    }

    @Override
    /**
     * intrinsicWeapon verb is "Hard punches" and causes 10 damage
     * @return returns the IntrinsicWeapon
     */

    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "Hard Punches");
    }

    @Override
    /**
     * <p>
     * precondition(none)
     * postcondition(no damage will be incurred if still armored
     *                      if not armored then damgage will be incured)
     * </p>
     *
     */
    public void hurt(int points) {
        if (!this.armored) {
            super.hurt(points);
        }
    }
}
