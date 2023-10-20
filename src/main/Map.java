package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;


/**Create map for the game.
 * 
 */
public class Map extends JPanel implements ActionListener {
    JPanel firstLand = new JPanel();
    JPanel secLand = new JPanel();
    Hero hero = new Hero();
    JButton b1 = new JButton("ReGenerate");

    Random randomX = new Random();
    Random randomLimX = new Random();
    int maxSpace = 200;
    int minSpace = 50;
    int maxLim = 200;
    int minLim = 100;
    int newLimLand1 = (int) (randomLimX.nextFloat() * (maxLim - minLim + 1) + minLim);
    int newSpace = (int) (randomX.nextFloat() * (maxSpace - minSpace + 1) + minSpace);
    int newX = newLimLand1 + newSpace;

    /**Constructor for map.
     * 
     */
    public Map() {
        b1.setBounds(125, 0, 200, 50);
        b1.addActionListener(this);
        b1.setFocusable(false);

        //set limit for the ground
        firstLand.setBounds(0, 500, newLimLand1, 300);
        secLand.setBounds(newX, 500, 450 - newX, 300);
        firstLand.setBackground(Color.black);
        secLand.setBackground(Color.black);

        //set up Panel
        this.setPreferredSize(new Dimension(450, 800));
        this.setLayout(null);
        this.add(firstLand);
        this.add(secLand);
        this.add(hero);
        this.add(b1);
    }

    //reGenerate map
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            //create new Land
            newLimLand1 = (int) (randomLimX.nextFloat() * (maxLim - minLim + 1) + minLim);
            newSpace = (int) (randomX.nextFloat() * (maxSpace - minSpace + 1) + minSpace);
            newX = newLimLand1 + newSpace;
            firstLand.setBounds(0, 500, newLimLand1, 300);
            secLand.setBounds(newX, 500, 450 - newX, 300);
        }
    }
}
