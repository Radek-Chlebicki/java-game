//radek and mesbah
package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * This behaviour causes the actor to move in random directions where possible
 */
public class BehaviourWander implements ActionFactory {

    public BehaviourWander(){

    }

    /**
     * returns MoveActorAction to a randomly chosen destination
     * @param actor Player that performs the action
     * @param gameMap The entire game map
     * @return it moves the actor to a possible destination
     */
    public Action getAction(Actor actor, GameMap gameMap){

        Location here = gameMap.locationOf(actor);
        //gets possible routes for actor
        // then check if the actor can enter
        // then choose one randomly
        //
        ArrayList<Exit> possible = new ArrayList<>();
        possible.add(null);
        for (Exit exit:here.getExits()){
            if (exit.getDestination().canActorEnter(actor)){
                possible.add(exit);
            }
        }
        Random r = new Random();
        Exit destination = possible.get(r.nextInt(possible.size()));


        return new MoveActorAction(destination.getDestination(), destination.getName());
    }

}
