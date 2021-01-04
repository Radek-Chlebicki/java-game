package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;


/**
 * DisplayChar : {@value DisplayChars#EnemyGruntActorChar}
 */
public class EnemyGruntActor extends Actor {


	private List<ActionFactory> actionFactories = new ArrayList<ActionFactory>();

	private void addBehaviour(ActionFactory behaviour) {
		actionFactories.add(behaviour);
	}
	// Grunts have 50 hitpoints and are always represented with a g
	public EnemyGruntActor(String name, Actor player) {
		super(name, DisplayChars.EnemyGruntActorChar, 5, 50);
		addBehaviour(new BehaviourFollow(player));
		DoorKeyItem aKey = new DoorKeyItem();
		aKey.getAllowableActions().clear();
		this.getInventory().add(aKey);

	}

	@Override
	public Action playTurn(Actions actions, GameMap map, Display display) {
		for (ActionFactory factory : actionFactories) {
			Action action = factory.getAction(this, map);
			if(action != null)
				return action;
		}
		
		return super.playTurn(actions,  map,  display);
	}
}
