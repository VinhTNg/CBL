package main;

import javax.swing.JFrame;

/**Create frame for game.
 * 
 */
public class Frame extends JFrame {

    /**constructor for frame.
     * 
     */
    public Frame() {
        this.setVisible(true);
        this.setSize(450, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
