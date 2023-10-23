package main;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


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
