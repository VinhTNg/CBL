package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**create character and its position on the screen.
 * 
 */
public class Hero extends JLabel {

    int baseX = 20;
    int baseY = 400;
    int width = 50;
    int height = 100;

    int yVelocity = 3;
    int xVelocity = 3;
    
    /**Constructor for character.
     * 
     */
    public Hero() {
        ImageIcon hero = new ImageIcon("src\\newhero.png");
        this.setIcon(hero);
        this.setBounds(baseX, baseY, width, height);
    }

    /**Move the hero to the final coordinates of the rotated bridge.
     */
    public void move() {
        baseX += xVelocity;
        this.setBounds(baseX, baseY, width, height);
    }

    /**drop the hero if lose the game.
     */
    public void drop() {
        baseY += yVelocity;
        this.setBounds(baseX, baseY, width, height);
    }
}