package main;

import java.awt.*;
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
        
        try {
            ImageIcon hero = new ImageIcon("hero.png");
            if (hero.getImageLoadStatus() == MediaTracker.ERRORED) {
                System.out.println("Error loading image: bla.jpeg");
            }
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }
}
