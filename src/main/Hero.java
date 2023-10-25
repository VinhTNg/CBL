package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**create character and its position on the screen.
 * 
 */
public class Hero extends JLabel {

    int baseX = 50;
    int baseY = 430;
    int width = 50;
    int height = 100;

    int xVelocity = 2;
    
    /**Constructor for character.
     * 
     */
    public Hero() {
        ImageIcon hero = new ImageIcon("hero.jpg");
        this.setText("HERO");
        this.setIcon(hero);
        this.setBounds(baseX, baseY, width, height);
    }

    /**Move the hero to the final coordinates of the rotated bridge.
     */
    public void move() {
        baseX += xVelocity;
        this.setBounds(baseX, baseY, width, height);
    }
}