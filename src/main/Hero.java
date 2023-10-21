package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**create character and its position on the screen.
 * 
 */
public class Hero extends JLabel {
    
    /**Constructor for character.
     * 
     */
    public Hero() {
        ImageIcon hero = new ImageIcon("hero.jpg");
        this.setText("|");
        this.setIcon(hero);
        this.setBounds(50, 430, 50, 100);
    }
}