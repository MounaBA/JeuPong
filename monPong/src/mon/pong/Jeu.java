package mon.pong;

import static mon.pong.Action.niveau;
import static mon.pong.Action.vies;

/**
 *
 * @author PC
 */
public class Jeu {

    public static void main(String[] args) {
        /*FileText f = new FileText();
        String a;
        int b;
        a = f.continuer();
            b = Integer.parseInt(a);
            niveau = (b / 10);
            vies = (b % 10); */
        Action action = new Action();
        action.init();
        action.parametresBalle();
        //action.parametresballe(niveau, vies);
    }
}
