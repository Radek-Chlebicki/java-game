//started by Mesbah finished By Radek
//started by Radek finished By Mesbah


package game;

import edu.monash.fit2099.engine.WeaponItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * <p>
 * DisplayChar : {@value DisplayChars#EnemyGoonShoutsWeaponItemChar}
 * this is a weapon item with zero damage, which returns the verb "Insults by shouting " + anInsultString
 * </p>
 */

public class EnemyGoonShoutsWeaponItem extends WeaponItem {
    private ArrayList<String> insults = new ArrayList<>();

    /**
     * This item is displayed by an I, it has 0 damage, the verb: "Insults by shouting, " , and a list of String insults
     *
     */
    public EnemyGoonShoutsWeaponItem(){
        super("Insult",DisplayChars.EnemyGoonShoutsWeaponItemChar,0, "Insults by shouting, ");
        insults.add("stupid");
        insults.add("lame");
        insults.add("bitch");
        insults.add("frickin fracker");
        insults.add("son of a biscuit eater");
    }

    /**
     * returns the verb and a randomly chosen insult from the insults list
     * @return Returns verb and a random insult
     */

    public String verb() {
        Random random = new Random();
        return this.verb + insults.get(random.nextInt(insults.size())) ;
    }
}
