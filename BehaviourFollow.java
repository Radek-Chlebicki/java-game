package game;

import edu.monash.fit2099.engine.*;

public class BehaviourFollow implements ActionFactory {

	private Actor target;

	public BehaviourFollow(Actor subject) {
		this.target = subject;
	}

	/**
	 *
	 * @param actor
	 * @param map
	 * @return
	 */

	public Action getAction(Actor actor, GameMap map) {
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int currentDistance = ManhattanDistance.distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = ManhattanDistance.distance(destination, there);
				if (newDistance < currentDistance) {
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}
		//returns null if cannot enter or cannot get closer
		return null;
	}

	// Manhattan distance.
//	private int distance(Location a, Location b) {
//		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
//	}
}