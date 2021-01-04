package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;

import java.util.Random;

public class EnemyYugoMaxDissolveArmorAction extends Action {
    EnemyYugoMaxActor enemyYugoMaxActor = null;

    public EnemyYugoMaxDissolveArmorAction(EnemyYugoMaxActor enemyYugoMaxActor){
        this.enemyYugoMaxActor = enemyYugoMaxActor;
    }



    @Override
    public String execute(Actor actor, GameMap map) {
        Random r = new Random();
        StunnablePlayer stunnablePlayer = (StunnablePlayer) actor;
        Item waterPistolItemItem = stunnablePlayer.hasAnItemOfType(WaterPistolItem.class);
        WaterPistolItem waterPistolItem = (WaterPistolItem) waterPistolItemItem;

        waterPistolItem.empty();
        if (r.nextInt(10)<7){
            this.enemyYugoMaxActor.dissolveArmor();
            return "Yugo Max's armor has been dissolved";
        }
        else {
            return actor + " liquid misses" + enemyYugoMaxActor;
        }
    }

    @Override
    public String menuDescription(Actor actor) {
        return "dissolve armor using water pistol";
    }

    @Override
    public String hotKey() {
        return "";
    }
}
