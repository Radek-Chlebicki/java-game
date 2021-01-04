//started by Mesbah finished By Radek

package game;

import edu.monash.fit2099.engine.*;

import static game.ManhattanDistance.distance;

/**
 * This action calls the isStunnable() on the stunnablePlayer, and if it is stunnable then it calls stun() on the StunnablePlayer. Also it tries to move the Ninja one step away from the player.
 *
 *
 */
public class EnemyNinjaStunAction extends Action {
    // this is not used
    private EnemyNinjaActor enemyNinjaActor;
    private StunnablePlayer stunnablePlayer;
//    private World aworld = null;
//    private Application anapp = null;

    /**
     *
     * @param aplayer the player that is being watched
     * @param aNinja the Ninja that will be moved
     */
    public EnemyNinjaStunAction(StunnablePlayer aplayer, EnemyNinjaActor aNinja){
        this.stunnablePlayer = aplayer;
        this.enemyNinjaActor = aNinja;
//        this.aworld = aworld;
//        this.anapp = anapp;

    }

    /**
     * Stuns the player if possible and moves the Ninja away if possible
     * @param asubject not used
     * @param gameMap used to move the Ninja
     * @return  " has been Stunned " when player can be stunned. And "Careful the Ninja is trying to stun you " if player is already stunned and cannot be stunned
     */
    public String execute(Actor asubject, GameMap gameMap){
        Location ofNinja = gameMap.locationOf(enemyNinjaActor);
        Location ofStunnablePlayer = gameMap.locationOf(stunnablePlayer);
        int difference = ManhattanDistance.distance(ofNinja, ofStunnablePlayer);


        for (Exit exit : ofNinja.getExits()) {
            Location destination = exit.getDestination();
            if (destination.canActorEnter(enemyNinjaActor)) {
                int newDistance = ManhattanDistance.distance(destination, ofStunnablePlayer);
                if (newDistance > difference) {
//                        map.removeActor(this);
//                        map.addActor(this, destination.x(),destination.y() );
                    gameMap.moveActor(enemyNinjaActor, destination);
//                        return new MoveActorAction(destination, exit.getName());
                }
            }
        }

        if (!stunnablePlayer.hasBeenStunned()){
            stunnablePlayer.stun();
            return this.stunnablePlayer + " has been Stunned ";

        }
        else{
            return this.stunnablePlayer + "Careful the Ninja is trying to stun you";
        }


    }

    @Override
    public String menuDescription(Actor actor) {
        return "Stun ";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
