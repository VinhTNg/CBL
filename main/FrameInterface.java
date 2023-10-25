package main;

import javax.swing.*;


public class FrameInterface extends JFrame {

    Game game = new Game();

    FrameInterface() {
        ImageIcon logo = new ImageIcon("src\\Icon.jpg"); 
        this.setVisible(true);
        this.setTitle("VN Stick Hero");
        this.setIconImage(logo.getImage());
        this.addKeyListener(game);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450, 800);
        this.setLocationRelativeTo(null);
    }
}
