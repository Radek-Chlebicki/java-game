package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;

/**
 * <p>
 *     coming here with the sleeping yugo max causes a GameWinAction() to be returned
 *     DisplayChar : {@value DisplayChars#JailGroundChar}
 *
 * </p>
 */
public class JailGround extends Ground {
    public JailGround(){
        super(DisplayChars.JailGroundChar);
    }

    @Override
    /**
     *
     * <p>
     *     precondition(actor is a stunnable player, actor is carrying sleeping yugo max )
     *     postcondition(GameWinAction is returned)
     * </p>
     */
    public Actions allowableActions(Actor actor, Location location, String direction) {
        Item yugoMax = null;

        if (actor instanceof StunnablePlayer){
            StunnablePlayer stunnablePlayer = (StunnablePlayer) actor;
            for (Item item: stunnablePlayer.getInventory()){
                if (item.getDisplayChar() == '%'){
                    yugoMax = item;
                }
            }
            if (yugoMax != null) {
                if (yugoMax.toString().equals( "Sleeping Vulnerable Yugo Max")) {
                    return new Actions(new GameWinAction());
                }
            }
        }
        return super.allowableActions(actor, location, direction);
    }
}
