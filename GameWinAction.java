package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;


/**
 * provides fancy you win text and ends the game
 */
public class GameWinAction extends Action {
    @Override
    /**
     * precondition(works with BNWorld)
     * postcondition(sets the end game message of the world to fancy you win, removes player to end the game)
     */
    public String execute(Actor actor, GameMap map) {
        if (actor instanceof StunnablePlayer){
            StunnablePlayer stunnablePlayer = (StunnablePlayer) actor;
            stunnablePlayer.getWorld().setMessage("\n" +
                    "\n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "YYYYYYY       YYYYYYY                                     WWWWWWWW                           WWWWWWWW iiii                   \n" +
                    "Y:::::Y       Y:::::Y                                     W::::::W                           W::::::Wi::::i                  \n" +
                    "Y:::::Y       Y:::::Y                                     W::::::W                           W::::::W iiii                   \n" +
                    "Y::::::Y     Y::::::Y                                     W::::::W                           W::::::W                        \n" +
                    "YYY:::::Y   Y:::::YYYooooooooooo   uuuuuu    uuuuuu        W:::::W           WWWWW           W:::::Wiiiiiiinnnn  nnnnnnnn    \n" +
                    "   Y:::::Y Y:::::Y oo:::::::::::oo u::::u    u::::u         W:::::W         W:::::W         W:::::W i:::::in:::nn::::::::nn  \n" +
                    "    Y:::::Y:::::Y o:::::::::::::::ou::::u    u::::u          W:::::W       W:::::::W       W:::::W   i::::in::::::::::::::nn \n" +
                    "     Y:::::::::Y  o:::::ooooo:::::ou::::u    u::::u           W:::::W     W:::::::::W     W:::::W    i::::inn:::::::::::::::n\n" +
                    "      Y:::::::Y   o::::o     o::::ou::::u    u::::u            W:::::W   W:::::W:::::W   W:::::W     i::::i  n:::::nnnn:::::n\n" +
                    "       Y:::::Y    o::::o     o::::ou::::u    u::::u             W:::::W W:::::W W:::::W W:::::W      i::::i  n::::n    n::::n\n" +
                    "       Y:::::Y    o::::o     o::::ou::::u    u::::u              W:::::W:::::W   W:::::W:::::W       i::::i  n::::n    n::::n\n" +
                    "       Y:::::Y    o::::o     o::::ou:::::uuuu:::::u               W:::::::::W     W:::::::::W        i::::i  n::::n    n::::n\n" +
                    "       Y:::::Y    o:::::ooooo:::::ou:::::::::::::::uu              W:::::::W       W:::::::W        i::::::i n::::n    n::::n\n" +
                    "    YYYY:::::YYYY o:::::::::::::::o u:::::::::::::::u               W:::::W         W:::::W         i::::::i n::::n    n::::n\n" +
                    "    Y:::::::::::Y  oo:::::::::::oo   uu::::::::uu:::u                W:::W           W:::W          i::::::i n::::n    n::::n\n" +
                    "    YYYYYYYYYYYYY    ooooooooooo       uuuuuuuu  uuuu                 WWW             WWW           iiiiiiii nnnnnn    nnnnnn\n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "\n");
            map.removeActor(actor);
        }
        return "you have won the game";
    }

    @Override
    public String hotKey() {
        return "w";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "Win the game";
    }
}


