//started by Mesbah finished By Radek

package game;

import edu.monash.fit2099.engine.*;


// actor drops the engine and the body here
// actor steps of this ground
// actor now has the option to build the rocket

// actor must be player


/**
 * <p>
 *     Ground is displayed with char DisplayChar : {@value DisplayChars#RocketBuildGroundChar}
 *     You must also add a special location to the map: the rocket pad.
 *      To build the rocket, the player needs to place both the rocket body and the rocket engine on the rocket
 *       pad.
 * </p>
 *
 */
public class RocketBuildGround extends Ground {
    private GameMap moonGameMap = null;

    public RocketBuildGround(){
        super(DisplayChars.RocketBuildGroundChar);
    }

    public RocketBuildGround(GameMap moonGameMap){
        super(DisplayChars.RocketBuildGroundChar);
        //this.displayChar = DisplayChars.RocketBuildGroundChar;
        this.moonGameMap = moonGameMap;
    }

    /**
     * <p>checks if adjacent actor is player and if the grounds location contains items of type RocketBodyItem and RocketEngine Item</p>
     * @param actor the Actor acting
     * @param location the current Location of the ground
     * @param direction the direction of the Ground from the Actor
     * @return default or RocketBuildAction
     *
     */
    public Actions allowableActions(Actor actor, Location location, String direction){

        if (actor instanceof StunnablePlayer) {
            StunnablePlayer stunnablePlayer =  (StunnablePlayer) actor;
            boolean hasRocketBodyItem = false;
            boolean hasRocketEngineItem = false;
//        System.out.println(location.getItems());

            // check if is player
            for (Item item : location.getItems()) {
                if (item.getClass() == RocketBodyItem.class) {
                    hasRocketBodyItem = true;
                }
                if (item.getClass() == RocketEngineItem.class) {
                    hasRocketEngineItem = true;
                }
            }


            if (hasRocketBodyItem && hasRocketEngineItem) {
                return new Actions(new RocketBuildAction(location, stunnablePlayer.getGameMap()));
            } else {
                return new Actions();
            }
        }

        else {
            return new Actions();
        }

    }
}
