package main;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstInterface extends JPanel implements ActionListener {
    JButton btn1, btn2, btn3;    

    FirstInterface() {
        this.setBackground(Color.gray);
        this.setLayout(null);
        this.setSize(450, 800);

        btn1 = new JButton("Play");
        btn1.addActionListener(this);
        btn1.setBounds(150, 100, 150, 30);
        btn1.setFocusable(false);
        btn1.setFont(new Font("MV Boli", Font.BOLD, 25));
        btn1.setForeground(Color.BLACK);
        btn1.setBackground(Color.lightGray);
        btn1.setBorder(BorderFactory.createEtchedBorder());

        btn2 = new JButton("Instructions");
        btn2.addActionListener(this);
        btn2.setBounds(150, 130, 150, 30);
        btn2.setFocusable(false);
        btn2.setFont(new Font("MV Boli", Font.BOLD, 25));
        btn2.setForeground(Color.BLACK);
        btn2.setBackground(Color.lightGray);
        btn2.setBorder(BorderFactory.createEtchedBorder());
        
        btn3 = new JButton("More");
        btn3.addActionListener(this);
        btn3.setBounds(150, 160, 150, 30);
        btn3.setFocusable(false);
        btn3.setFont(new Font("MV Boli", Font.BOLD, 25));
        btn3.setForeground(Color.BLACK);
        btn3.setBackground(Color.lightGray);
        btn3.setBorder(BorderFactory.createEtchedBorder());

        this.add(btn1);
        this.add(btn2);
        this.add(btn3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            Container parent = this.getParent();
            parent.remove(this);
            PlayWindow playWindow = new PlayWindow();
            parent.add(playWindow);
            parent.revalidate();
            parent.repaint();
        }
        if (e.getSource() == btn2) {
            Container parent = this.getParent();
            parent.remove(this);
            InstructionsWindow instructionsWindow = new InstructionsWindow();
            parent.add(instructionsWindow);
            parent.revalidate();
            parent.repaint();
        }
        if (e.getSource() == btn3) {
            Container parent = this.getParent();
            parent.remove(this);
            MoreWindow moreWindow = new MoreWindow();
            parent.add(moreWindow);
            parent.revalidate();
            parent.repaint();
        }
    }
}