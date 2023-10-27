package main;

import javax.swing.*;

/**Create window for the game.
 */
public class Frame extends JFrame {

    /**Constructor for frame.
     */
    public Frame() {
        ImageIcon logo = new ImageIcon("src\\newlogo.png"); 
        this.setVisible(true);
        this.setTitle("VN Stick Hero");
        this.setIconImage(logo.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450, 800);
        this.setLocationRelativeTo(null);
    }
}
