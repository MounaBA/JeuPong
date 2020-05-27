/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mon.pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.KeyStroke;

/**
 *
 * @author hassrmd
 */
public class Action extends JFrame implements ActionListener {

    public static JOptionPane jop1;
    public static int niveau = 5;
    public static int vies = 5;

    public static ObjetsJeu panel = new ObjetsJeu();

    /**
     *
     */
    public JFrame fenetre;
    JMenuBar barreMenu;
    JMenu fichier;
    JMenu options;
    JMenuItem nouvellePartie;
    JMenuItem quitter;
    JMenuItem continuer;
    JMenuItem niveauJeu;
    JRadioButton niv1;
    JRadioButton niv2;
    JMenuItem autres;

    public void init() {

        fenetre = new JFrame();
        barreMenu = new JMenuBar();
        fichier = new JMenu();
        options = new JMenu();
        nouvellePartie = new JMenuItem();
        quitter = new JMenuItem();
        continuer = new JMenuItem();
        niveauJeu = new JMenu();
        niv1 = new JRadioButton();
        niv2 = new JRadioButton();
        autres = new JMenu();
        fenetre.setJMenuBar(barreMenu);
        fichier.setText("Fichier");
        fichier.setMnemonic('F');
        barreMenu.add(fichier);
        options.setText("Options");
        options.setMnemonic('O');
        barreMenu.add(options);
        nouvellePartie.setText("Nouvelle Partie");
        quitter.setText("Quitter");
        continuer.setText("Continuer");
        nouvellePartie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_MASK));

        fichier.add(continuer);
        fichier.add(nouvellePartie);
        fichier.add(quitter);
        niveauJeu.setText("Niveau de jeu");
        autres.setText("Autres options");
        options.add(niveauJeu);
        options.add(autres);
        niv1.setText("Niveau Debutant");
        niv2.setText("Niveau professsionel");
        niveauJeu.add(niv1);
        niveauJeu.add(niv2);
        nouvellePartie.addActionListener(this);
        quitter.addActionListener(this);

        fenetre.setTitle("jeu Pong");
        fenetre.setSize(800, 600);
        fenetre.setResizable(false);
        //fenetre.setLocationRelativeTo(null);
        fenetre.setContentPane(panel);

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

        nouvellePartie.addActionListener(this);
        continuer.addActionListener(this);
        quitter.addActionListener(this);
        niv1.addActionListener(this);
        niv2.addActionListener(this);
    }

    public static void parametresballe(int n, int v) {
        int x = panel.getBalleX(), y = panel.getBalleY();
        vies = v;
        niveau = n;
        boolean backX = false;
        boolean backY = false;

        while (true) {
            if (x < 50) {
                vies--;
                backX = false;
            }
            if (x > panel.getWidth() - 81) {
                backX = true;
            }
            if (y < 1) {
                backY = false;
            }
            if (y > panel.getHeight() - 30) {
                backY = true;
            }

            if (x < panel.getJoueurx() + 42 && y > panel.getJoueury() - 6 && y < panel.getJoueury() + 106) {
                if (niveau > 1) {
                    niveau--;
                }
                backX = false;
            }
            if (!backX) {
                panel.setBalleX(++x);
            } else {
                panel.setBalleX(--x);
            }
            if (!backY) {
                panel.setBalleY(++y);
            } else {
                panel.setBalleY(--y);
            }
            panel.repaint();
            panel.setEnnemiY(y);

            try {
                if (niveau > 1) {
                    Thread.sleep(niveau);

                } else {
                    Thread.sleep(2);
                }

            } catch (InterruptedException e) {
            }

            if (vies == 0) {
                jop1 = new JOptionPane();
                jop1.showMessageDialog(null, " Tu as perdu, fin de la partie!", "Fin de la partie! ", JOptionPane.ERROR_MESSAGE);
                break;
            }
        }
    }

    public static void parametresBalle() {
        int x = panel.getBalleX(), y = panel.getBalleY();

        boolean backX = false;
        boolean backY = false;

        while (true) {
            if (x < 50) {
                vies--;
                backX = false;
            }
            if (x > panel.getWidth() - 81) {
                backX = true;
            }
            if (y < 1) {
                backY = false;
            }
            if (y > panel.getHeight() - 30) {
                backY = true;
            }

            if (x < panel.getJoueurx() + 42 && y > panel.getJoueury() - 6 && y < panel.getJoueury() + 106) {
                if (niveau > 1) {
                    niveau--;
                }
                backX = false;
            }
            if (!backX) {
                panel.setBalleX(++x);
            } else {
                panel.setBalleX(--x);
            }
            if (!backY) {
                panel.setBalleY(++y);
            } else {
                panel.setBalleY(--y);
            }
            panel.repaint();
            panel.setEnnemiY(y);

            try {
                if (niveau > 1) {
                    Thread.sleep(niveau);

                } else {
                    Thread.sleep(1);
                }

            } catch (InterruptedException e) {
            }

            if (vies == 0) {
                jop1 = new JOptionPane();
                jop1.showMessageDialog(null, " Tu as perdu, fin de la partie!", "Fin de la partie! ", JOptionPane.ERROR_MESSAGE);
                break;

            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        FileText f = new FileText();
        String a;
        int b;
        if (ae.getSource() == continuer) {
            a = f.continuer();
            b = Integer.parseInt(a);
            niveau = (b / 10);
            vies = (b % 10);
            System.out.println("partie Precedente a demarre " + niveau + vies);
            parametresballe(niveau, vies);
        }

        if (ae.getSource() == nouvellePartie) {
            System.out.println("nouvelle Partie a demarre " + niveau + vies);
            parametresBalle();
        }

        if (ae.getSource() == quitter) {
            JOptionPane infoQuit = new JOptionPane();
            @SuppressWarnings("static-access")
            int choix = infoQuit.showConfirmDialog(null, "Voulez-vous vraiment quitter l'application ?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (choix == JOptionPane.YES_OPTION) {

                f.sauvegarder();
                System.exit(0);
            }
        }
        {
            if (ae.getSource() == niv2) {
                JOptionPane infoTerrain = new JOptionPane();
                @SuppressWarnings("static-access")
                int choix = infoTerrain.showConfirmDialog(null, "Le changement de table redémarrera une nouvelle partie voulez-vous vraiment changer le niveau ?", "Confirmation", JOptionPane.YES_NO_OPTION);

                if (choix == JOptionPane.YES_OPTION) {

                    fenetre.setBounds(0, 0, 1000, 600);
                    fenetre.setLocationRelativeTo(null);
                    panel.setBalleX((1000 - 35) / 2);
                    panel.setEnnemiX(1000 - 55);
                }
            } else if (ae.getSource() == niv1) {
                JOptionPane infoTerrain = new JOptionPane();
                @SuppressWarnings("static-access")
                int choix = infoTerrain.showConfirmDialog(null, "Le changement de table redémarrera une nouvelle partie voulez-vous vraiment changer le niveau ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choix == JOptionPane.YES_OPTION) {

                    fenetre.setBounds(0, 0, 800, 600);
                    //enetre.setLocationRelativeTo(null);
                    panel.setBalleX(382);
                    panel.setEnnemiX(744);
                }

                
            }
        }
    }
}
