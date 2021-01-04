//started by Radek finished By Mesbah

package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


/**
 *  <p>
 *      DisplayChar : {@value DisplayChars#QActorChar}
 *      If the player is holding rocket plans, they should be able to give them to Q. This will cause the plans to be removed and replaced by the rocket body
 *      Q will then dissapear.
 *
 *      Talking to Q without rocket plans in the player’s inventory resultS in Q saying “I can
 *      give you something that will help, but I’m going to need the plans.” If the player does have the
 *      rocket plans in their inventory, Q says “Hand them over, I don’t have all day!”
 *
 *  </p>
 */
public class QActor extends Actor {

    private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

    private void addBehaviour(ActionFactory behaviour) {
        actionFactories.add(behaviour);
    }


    /**
     * Qactor is called "Qactor" has 100 hitPoints, represented by char 'Q'
     */
    public QActor(){
        super("QActor", DisplayChars.QActorChar, 10, 100);
        addBehaviour(new BehaviourWander());
    }

    /**
     * Wanders according to BehaviourWander, if there is no where to go then it returns skip turn action
     * @param actions
     * @param gameMap
     * @param display
     * @return
     */
    public Action playTurn(Action actions, GameMap gameMap, Display display){
        // this will come from the wander behaviour
        for (ActionFactory anActionFactory: actionFactories){
            Action returnaction = anActionFactory.getAction(this, gameMap);
            if (returnaction != null){
                return returnaction;
            }
        }
        // if the wander behaviour does nothing then this will happen
        return new SkipTurnAction();
    }


    /**
     *  <p>
     *          If player inventory has plans return GivePlanAction, or TalkAction constructed with ("I dont have time")
     *         If player inventory does not have plans return TalkAction constructed with ("I have something but i need the plans ")
     *      </p>
     * @param otherActor the Actor that might be performing attack
     * @param direction String representing the direction of the other Actor
     * @param map i GameMap
     * @return Returns givePlanAction or SkipTurnAction or TalkAction
     */

    public Actions getAllowableActions(Actor otherActor, String direction, GameMap map) {
        Actions list = new Actions();
        // since QActor is a friendly npc it cannot be attacked
        if (otherActor instanceof Player){
            boolean hasPlans = false;
            for (Item item : otherActor.getInventory()){
                if (item.getClass() == QPlansItem.class){
                    hasPlans = true;
                }
            }
            if (hasPlans){
                list.add(new QTalkAction("Hand the plans over, quickly"));
                list.add(new QGivePlanAction(this));
                return list;
            }
            else{
                list.add(new QTalkAction("I can give you something but i need the plans"));
            }
            return list;
        }

        // enemies can attack QActor, but cannot exchange plans with QActor
        else {
            list.add(new AttackAction(otherActor, this));
            return list;
        }
    }

//    @Override
//    protected IntrinsicWeapon getIntrinsicWeapon() {
//        return new IntrinsicWeapon()
//    }
}
