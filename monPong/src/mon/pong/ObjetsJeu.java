
package mon.pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ObjetsJeu extends JPanel {

    private int joueurx;
    private int joueury;

    private int ennemiX;
    private int ennemiY;

    private int balleX;
    private int balleY;
    
    public ObjetsJeu() {

        joueurx = 10;
        joueury = 235;

        ennemiX = 744;
        ennemiY = 235;
        
        balleX=382;
        balleY=270;
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new ControlePersonnage());

    }

    public int getJoueurx() {
        return joueurx;
    }

    public int getJoueury() {
        return joueury;
    }

    public void setJoueurx(int joueurx) {
        this.joueurx = joueurx;
    }

    public void setJoueury(int joueury) {
        this.joueury = joueury;
    }

    public int getEnnemiX() {
        return ennemiX;
    }

    public int getEnnemiY() {
        return ennemiY;
    }

    public int getBalleX() {
        return balleX;
    }

    public int getBalleY() {
        return balleY;
    }

    public void setEnnemiX(int ennemiX) {
        this.ennemiX = ennemiX;
    }

    public void setEnnemiY(int ennemiY) {
        this.ennemiY = ennemiY;
    }

    public void setBalleX(int balleX) {
        this.balleX = balleX;
    }

    public void setBalleY(int balleY) {
        this.balleY = balleY;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.setColor(Color.YELLOW);
        g.fillRect(joueurx , joueury, 40, 100);

        g.setColor(Color.CYAN);
        g.fillRect(ennemiX, ennemiY, 40, 100);
        
        g.setColor(Color.WHITE );
        g.fillOval(balleX, balleY, 30, 30);
        
        g.setColor(Color.PINK);
        g.fillRect(50, 0, 3, this.getHeight());
        
        g.setColor(Color.WHITE );
        g.fillRect(this.getWidth()/2, 0, 2, this.getHeight());
        
        g.setColor(Color.PINK);
        g.fillRect(this.getWidth()-50, 0, 3, this.getHeight());

        Font niveau = new  Font("courier",Font.ROMAN_BASELINE, 20);
        g.setFont(niveau);
        g.setColor(Color.RED);
        g.drawString("Niveau : " + Action.niveau, 6, 20);
        
        Font vies = new  Font("courier",Font.ROMAN_BASELINE, 20);
        g.setFont(vies);
        g.setColor(Color.RED);
        g.drawString("Vies : " + Action.vies, 6, 40);
    }

}
