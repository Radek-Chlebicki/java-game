package game;
//radek and mesbah

import edu.monash.fit2099.engine.*;


/**
 * provides fancy you quit text, always available to the player
 */
public class GameQuitAction extends Action {
    public GameQuitAction(){

    }

    @Override
    public String hotKey() {
        return "z";
    }

    @Override
    /**
     *<p>
     *     precondition(works with BNworld)
     *     postcondition(sets worlds end game message to youquit, removes player to end game )
     *</p>
     */
    public String execute(Actor actor, GameMap map) {
        if (actor instanceof StunnablePlayer) {
            StunnablePlayer stunnablePlayer = (StunnablePlayer)actor;
            stunnablePlayer.getWorld().setMessage("                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "YYYYYYY       YYYYYYY                                          QQQQQQQQQ                         iiii          tttt          \n" +
                    "Y:::::Y       Y:::::Y                                        QQ:::::::::QQ                      i::::i      ttt:::t          \n" +
                    "Y:::::Y       Y:::::Y                                      QQ:::::::::::::QQ                     iiii       t:::::t          \n" +
                    "Y::::::Y     Y::::::Y                                     Q:::::::QQQ:::::::Q                               t:::::t          \n" +
                    "YYY:::::Y   Y:::::YYYooooooooooo   uuuuuu    uuuuuu       Q::::::O   Q::::::Quuuuuu    uuuuuu  iiiiiiittttttt:::::ttttttt    \n" +
                    "   Y:::::Y Y:::::Y oo:::::::::::oo u::::u    u::::u       Q:::::O     Q:::::Qu::::u    u::::u  i:::::it:::::::::::::::::t    \n" +
                    "    Y:::::Y:::::Y o:::::::::::::::ou::::u    u::::u       Q:::::O     Q:::::Qu::::u    u::::u   i::::it:::::::::::::::::t    \n" +
                    "     Y:::::::::Y  o:::::ooooo:::::ou::::u    u::::u       Q:::::O     Q:::::Qu::::u    u::::u   i::::itttttt:::::::tttttt    \n" +
                    "      Y:::::::Y   o::::o     o::::ou::::u    u::::u       Q:::::O     Q:::::Qu::::u    u::::u   i::::i      t:::::t          \n" +
                    "       Y:::::Y    o::::o     o::::ou::::u    u::::u       Q:::::O     Q:::::Qu::::u    u::::u   i::::i      t:::::t          \n" +
                    "       Y:::::Y    o::::o     o::::ou::::u    u::::u       Q:::::O  QQQQ:::::Qu::::u    u::::u   i::::i      t:::::t          \n" +
                    "       Y:::::Y    o::::o     o::::ou:::::uuuu:::::u       Q::::::O Q::::::::Qu:::::uuuu:::::u   i::::i      t:::::t    tttttt\n" +
                    "       Y:::::Y    o:::::ooooo:::::ou:::::::::::::::uu     Q:::::::QQ::::::::Qu:::::::::::::::uui::::::i     t::::::tttt:::::t\n" +
                    "    YYYY:::::YYYY o:::::::::::::::o u:::::::::::::::u      QQ::::::::::::::Q  u:::::::::::::::ui::::::i     tt::::::::::::::t\n" +
                    "    Y:::::::::::Y  oo:::::::::::oo   uu::::::::uu:::u        QQ:::::::::::Q    uu::::::::uu:::ui::::::i       tt:::::::::::tt\n" +
                    "    YYYYYYYYYYYYY    ooooooooooo       uuuuuuuu  uuuu          QQQQQQQQ::::QQ    uuuuuuuu  uuuuiiiiiiii         ttttttttttt  \n" +
                    "                                                                       Q:::::Q                                               \n" +
                    "                                                                        QQQQQQ                                               \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             \n" +
                    "                                                                                                                             ");
            map.removeActor(actor);
        }
        return "you have quit the game";
    }

    @Override
    public String menuDescription(Actor actor) {
        return "quit game";
    }

}
