package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;

/**
 * Display Char: {@value DisplayChars#WallGroundChar}
 */
public class WallGround extends Ground {

	public WallGround() {
		super(DisplayChars.WallGroundChar);
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
