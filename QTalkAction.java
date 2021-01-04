//started by Radek finished By Mesbah

package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;


/**
 * Can be constructed with the string that will be returned when the Action is executed
 */
public class QTalkAction extends Action {
    private String theSpeech;

    /**
     *
     * @param theSpeech astring that is returned when the action is executed
     */
    public QTalkAction(String theSpeech){
        this.theSpeech = theSpeech;

    }

    /**
     * returns the string the action was constructed with
     * @param actor The actor performing the action.
     * @param gameMap
     * @return Returns the string it was constructed with
     */
    public String execute(Actor actor, GameMap gameMap){
        return this.theSpeech;
    }


    /**
     * menu description is talk to actor
     * @param actor The actor performing the action.
     * @return Returns a string
     */
    public String menuDescription(Actor actor) {
        return "Talk to QActor";
    }

    public String hotKey(){
        return "";
    }
}
