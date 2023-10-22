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
    int width = 450;
    int height = 800;
    JPanel firstLand = new JPanel();
    JPanel secLand = new JPanel();
    Hero hero = new Hero();
    JButton b1 = new JButton("ReGenerate");

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
    public Map() {
        b1.setBounds(125, 0, 200, 50);
        b1.addActionListener(this);
        b1.setFocusable(false);

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
        this.add(b1);
    }

    //reGenerate map
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            //create new Land 1 and land 2
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
