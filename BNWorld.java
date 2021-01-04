package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * <p>
 *     has default fancy you lose message
 *     oofers to change the message that is shown when the game is ended
 * </p>
 */
public class BNWorld{
    private Display display;
    private List<GameMap> maps = new ArrayList<GameMap>();
    private ActorLocations actorLocations = new ActorLocations();
    private Actor player; // We only draw the particular map this actor is on.


    /**
     *
     * @param display
     */
    public BNWorld(Display display) {
        Objects.requireNonNull(display);
        this.display = display;
    }

    /**
     * Add a map to the world.
     *
     * @param map the GameMap to add
     */
    public void addMap(GameMap map) {
        maps.add(map);
        map.setActorLocations(actorLocations);
    }

    /**
     * Add the player to a map.
     *
     * The player is special: we only display the map that the player is on.
     *
     * @param player the player to add
     * @param map the map where the player is to be added
     * @param y y coordinate of the player
     * @param x x coordinate of the player
     */
    public void addPlayer(Actor player, GameMap map, int y, int x) {
        this.player = player;
        map.addActor(player, x, y);
    }

    /**
     * Run the game.
     *
     * On each iteration the gameloop does the following:
     *  - displays the player's map
     *  - processes the actions of every Actor in the game, regardless of map
     *
     * We could either only process the actors on the current map, which would make
     * time stop on the other maps, or we could process all the actors.  We chose to
     * process all the actors.
     *
     * @throws IllegalStateException if the player doesn't exist
     */
    public void run() {
        if(player == null)
            throw new IllegalStateException();

        while (stillRunning()) {
            display.println(String.valueOf(stillRunning()));
            GameMap playersMap = actorLocations.locationOf(player).map();
            playersMap.draw(display);
            for (Actor actor : actorLocations) {
                if (stillRunning()) {
                    processActorTurn(actor);
                }
                else{
                    break;
                }
            }
        }
        display.println(endGameMessage());
    }

    /**
     * Gives an Actor its turn.
     *
     * The Actions an Actor can take include:
     * <ul>
     *  <li> those conferred by items it is carrying </li>
     *  <li> movement actions for the current location and terrain </li>
     *  <li> actions that can be done to Actors in adjacent squares </li>
     *  <li> actions that can be done using items in the current location </li>
     *  <li> skipping a turn</li>
     * </ul>
     *
     * @param actor the Actor whose turn it is.
     */
    protected void processActorTurn(Actor actor) {
        Location here = actorLocations.locationOf(actor);
        GameMap map = here.map();
        // builds a list of actions from the inventory of items held by the
        Actions actions = new Actions();
        for (Item item : actor.getInventory()) {
            actions.add(item.getAllowableActions());
        }

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            // builds allowable actions from an actor
            if (actorLocations.isAnActorAt(destination)) {
                Actor adjacentActor = actorLocations.actorAt(destination);
                actions.add(adjacentActor.getAllowableActions(actor, exit.getName(), map));
            } else {
                // here is where the actor and location is passed to allowableActions of a ground
                Ground adjacentGround = map.groundAt(destination);
                // the location is that of theground
                actions.add(adjacentGround.allowableActions(actor, destination, exit.getName()));
                actions.add(adjacentGround.getMoveAction(actor, destination, exit.getName(), exit.getHotKey()));
            }
        }

        //builds actions based on the item that is available here
        for (Item item : here.getItems()) {
            actions.add(item.getAllowableActions());
        }
        actions.add(new SkipTurnAction());


        // here is where the action is performed
        Action action = actor.playTurn(actions, map, display);
        String result = action.execute(actor, map);
        display.println(result);
    }

    /**
     * Returns true if the game is still running.
     *
     * The game is considered to still be running if the player is still around.
     *
     * @return true if the player is still on the map.
     */
    protected boolean stillRunning() {
        return actorLocations.contains(player);
    }

    /**
     * Return a string that can be displayed when the game ends.
     *
     * @return the string "Game Over"
     */

    private String anEndGameMessage = "                                                                                                                                        \n" +
            "                                                                                                                                        \n" +
            "YYYYYYY       YYYYYYY                                     LLLLLLLLLLL                                                                   \n" +
            "Y:::::Y       Y:::::Y                                     L:::::::::L                                                                   \n" +
            "Y:::::Y       Y:::::Y                                     L:::::::::L                                                                   \n" +
            "Y::::::Y     Y::::::Y                                     LL:::::::LL                                                                   \n" +
            "YYY:::::Y   Y:::::YYYooooooooooo   uuuuuu    uuuuuu         L:::::L                  ooooooooooo       ssssssssss       eeeeeeeeeeee    \n" +
            "   Y:::::Y Y:::::Y oo:::::::::::oo u::::u    u::::u         L:::::L                oo:::::::::::oo   ss::::::::::s    ee::::::::::::ee  \n" +
            "    Y:::::Y:::::Y o:::::::::::::::ou::::u    u::::u         L:::::L               o:::::::::::::::oss:::::::::::::s  e::::::eeeee:::::ee\n" +
            "     Y:::::::::Y  o:::::ooooo:::::ou::::u    u::::u         L:::::L               o:::::ooooo:::::os::::::ssss:::::se::::::e     e:::::e\n" +
            "      Y:::::::Y   o::::o     o::::ou::::u    u::::u         L:::::L               o::::o     o::::o s:::::s  ssssss e:::::::eeeee::::::e\n" +
            "       Y:::::Y    o::::o     o::::ou::::u    u::::u         L:::::L               o::::o     o::::o   s::::::s      e:::::::::::::::::e \n" +
            "       Y:::::Y    o::::o     o::::ou::::u    u::::u         L:::::L               o::::o     o::::o      s::::::s   e::::::eeeeeeeeeee  \n" +
            "       Y:::::Y    o::::o     o::::ou:::::uuuu:::::u         L:::::L         LLLLLLo::::o     o::::ossssss   s:::::s e:::::::e           \n" +
            "       Y:::::Y    o:::::ooooo:::::ou:::::::::::::::uu     LL:::::::LLLLLLLLL:::::Lo:::::ooooo:::::os:::::ssss::::::se::::::::e          \n" +
            "    YYYY:::::YYYY o:::::::::::::::o u:::::::::::::::u     L::::::::::::::::::::::Lo:::::::::::::::os::::::::::::::s  e::::::::eeeeeeee  \n" +
            "    Y:::::::::::Y  oo:::::::::::oo   uu::::::::uu:::u     L::::::::::::::::::::::L oo:::::::::::oo  s:::::::::::ss    ee:::::::::::::e  \n" +
            "    YYYYYYYYYYYYY    ooooooooooo       uuuuuuuu  uuuu     LLLLLLLLLLLLLLLLLLLLLLLL   ooooooooooo     sssssssssss        eeeeeeeeeeeeee  \n" +
            "                                                                                                                                        \n" +
            "                                                                                                                                        \n" +
            "                                                                                                                                        \n" +
            "                                                                                                                                        \n" +
            "                                                                                                                                        \n" +
            "                                                                                                                                        \n" +
            "                                                                                                                                        ";


    /**
     * <p>
     * precondition(provide a string to show the message which will be shown when  the game will be over)
     * postcondition( the default message is changed )
     * </p>
     *
     *
     */

    public void setMessage(String aString){
        this.anEndGameMessage = aString;
    }

    protected String endGameMessage() {
        return anEndGameMessage;
    }
}

