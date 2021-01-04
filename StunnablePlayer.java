//started by Radek finished By Mesbah

package game;

import edu.monash.fit2099.engine.*;


/**
 * Extends the functionality of player to allow for stunning
 * DisplayChar : @
 */
public class StunnablePlayer extends Player {
    private int stuncount = 0;
    private GameMap moonGameMap = null;
    private GameMap earthGameMap = null;
    private BNWorld bnWorld = null;


    public StunnablePlayer(String name, char displayChar, int priority, int hitPoints, GameMap moonGameMap, GameMap earthGameMap, BNWorld bnWorld) {
        super(name, displayChar, priority, hitPoints);
        this.moonGameMap = moonGameMap;
        this.earthGameMap = earthGameMap;
        this.bnWorld = bnWorld;
    }

    /**
     * stun causes the stuncount to be = 2 which is then decremented each time the player playsturn()
     */
    public void stun(){
        if (stuncount > 0){
        }
        else{
            stuncount = 2;
        }
    }

    /**
     * player is considered to be stunned while stuncount != 0 thus returns a bool
     * @return True or false if the player is stunned
     */
    public boolean hasBeenStunned(){
        if (stuncount > 0){
            return true;
        }
        else{
            return false;
        }


    }

    /**
     * Decrements the players stuncount each turn otherwise default as player
     * @param actions the actions to display
     * @param map the map to display
     * @param display the object that performs the console I/O
     * @return return SkipTurnAction or the default behaviour
     */
    public Action playTurn(Actions actions, GameMap map, Display display) {
        String oxygenLevel = "";
        actions.add(new GameQuitAction());

        if (map == moonGameMap){
            Item spaceSuitItemItem = this.hasAnItemOfType(SpaceSuitItem.class);
            SpaceSuitItem spaceSuitItem = (SpaceSuitItem) spaceSuitItemItem;
            if (spaceSuitItem != null) {
                if (spaceSuitItem.noOxygenLeft()){
                    return new MoveActorAction(earthGameMap.at(22,10), "to earth - where there is oxygen" );
                }
                spaceSuitItem.useOxygen();
            }
            else{
                return new MoveActorAction(earthGameMap.at(22,10), "to earth - where you do not need a spacesuit" );
            }
        }

        if (stuncount > 0) {
            stuncount = stuncount - 1;
            while (showMenu(actions, display).getClass() != SkipTurnAction.class) {

            }
            return new SkipTurnAction();


        } else {
            return super.playTurn(actions, map, display);
        }
    }


    /**
     * <p>
     * precondition()
     * poscondition(will return the gameMap the stunnablePlayer is carrying)
     * </p>
     */
    public GameMap getGameMap(){
        return this.moonGameMap;
    }
    public BNWorld getWorld(){return this.bnWorld;}


    /**<p>
     * precondition(pass a class type)
     * postcondition( returns the first item of that type from the players inventory or return null)
     * </p>
     */
    public Item hasAnItemOfType(Class aClassType){
        for (Item item : this.getInventory()){
            if (item.getClass() == aClassType){
                return item;
            }
        }
        return null;
    }

    /**
     * <p>
     * precondition(pass a class type)
     * postcondition(returns bool representing whether players inventory contains an item of that type.
     * </p>
     *
     */

    public boolean checkIfHasAnItemOfType(Class aClassType){
        if ((hasAnItemOfType(aClassType)) == null) {
            return false;
        }
        return true;
    }
}
