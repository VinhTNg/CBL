package main;

import java.awt.Color;
import java.awt.Dimension;
// import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JPanel;


/**Create map and functions for the game.
 * 
 */
public class Game extends JPanel implements KeyListener {
    int width = 450;
    int height = 800;
    Hero hero = new Hero();
    DrawLine drawLine = new DrawLine();

    JPanel firstLand = new JPanel();
    JPanel secLand = new JPanel();
    Random randomX = new Random();
    Random randomLimX = new Random();
    //space between first land and second land
    int maxSpace = 300;
    int minSpace = 50;
    //space for first land
    int maxLim1 = 100;
    int minLim1 = 70;
    //create first land and space between first and second land
    int newLimLand1 = (int) (randomLimX.nextFloat() * (maxLim1 - minLim1 + 1) + minLim1);
    int newSpace = (int) (randomX.nextFloat() * (maxSpace - minSpace + 1) + minSpace);
    int newX2 = newLimLand1 + newSpace;
    //space for second land
    int maxLim2 = width - newX2;
    int minLim2 = newX2 + 20;
    int newLimLand2 = (int) (randomLimX.nextFloat() * (maxLim2 - minLim2 + 1) + minLim2);

    /**Constructor for map.
     * 
     */
    public Game() {

        //set limit for the ground
        firstLand.setBounds(0, 500, newLimLand1, 300);
        secLand.setBounds(newX2, 500, newLimLand2, 300);
        firstLand.setBackground(Color.black);
        secLand.setBackground(Color.black);

        //set up Panel
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);
        this.add(firstLand);
        this.add(secLand);
        this.add(hero);
        this.setFocusable(true);
    }

    // @Override
    // public void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     g.drawLine(50, 300, 50, 500);
    // }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.add(drawLine);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            // create new Land 1 and land 2
            newLimLand1 = (int) (randomLimX.nextFloat() * (maxLim1 - minLim1 + 1) + minLim1);
            newSpace = (int) (randomX.nextFloat() * (maxSpace - minSpace + 1) + minSpace);
            newX2 = newLimLand1 + newSpace;
            maxLim2 = width - newX2 + 20;
            minLim2 = width - newX2 - 50;
            newLimLand2 = (int) (randomLimX.nextFloat() * (maxLim2 - minLim2 + 1) + minLim2);
            firstLand.setBounds(0, 500, newLimLand1, 300);
            secLand.setBounds(newX2, 500, newLimLand2, 300);
        }
    }
}
