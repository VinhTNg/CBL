package main;

import javax.swing.*;

public class Frame extends JFrame {

    Frame() {
        ImageIcon logo = new ImageIcon("src\\Icon.jpg"); 
        this.setVisible(true);
        this.setTitle("VN Stick Hero");
        this.setIconImage(logo.getImage());

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(450, 800);
        this.setLocationRelativeTo(null);
    }
}
