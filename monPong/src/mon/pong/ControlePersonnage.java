/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mon.pong;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author PC
 */
public class ControlePersonnage implements KeyListener{
    /**
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        
        int y = Action.panel.getJoueury();

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (y > 6) {
                y -=90;
                Action.panel.setJoueury(y);
                Action.panel.repaint();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (y < Action.panel.getHeight() - 100) {
                y += 90;
                Action.panel.setJoueury(y);
                Action.panel.repaint();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
