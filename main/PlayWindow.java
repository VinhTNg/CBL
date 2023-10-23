package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

import java.awt.*;

public class PlayWindow extends JPanel implements ActionListener{
    
    JLabel label, labelPlay;
    JButton playButton, backBtn;

    PlayWindow() {
        
        backBtn = new JButton("Return");
        backBtn.addActionListener(this);
        backBtn.setLayout(null);
        backBtn.setBounds(150, 720, 150, 30);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("MV Boli", Font.BOLD, 25));
        backBtn.setForeground(Color.BLACK);
        backBtn.setBackground(Color.lightGray);
        backBtn.setBorder(BorderFactory.createEtchedBorder());

        labelPlay = new JLabel();
        labelPlay.setText("PLAY");    
        labelPlay.setHorizontalTextPosition(JLabel.CENTER);
        labelPlay.setVerticalTextPosition(JLabel.CENTER);
        labelPlay.setFont(new Font("MV Boli", Font.BOLD, 25));
        labelPlay.setBounds(190, 450, 100, 50);
        labelPlay.setForeground(Color.BLACK); 

        ImageIcon playBtnIcon = new ImageIcon("src\\playbutton.png");
        
        playButton = new JButton(playBtnIcon);
        playButton.setLayout(null);
        playButton.setBounds(175, 500, 100, 100);
        playButton.setFocusable(false);

        label = new JLabel();
        ImageIcon background = new ImageIcon("src\\background.png");
        label.setIcon(background);
        label.setLayout(null);
        label.setPreferredSize(new Dimension(440, 800));
        label.add(labelPlay);
        label.add(playButton);
        label.add(backBtn);
        
        this.setPreferredSize(new Dimension(450, 800));
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backBtn) {
            Container parent = this.getParent();
            parent.remove(this);
            FirstInterface firstInterface = new FirstInterface();
            parent.add(firstInterface);
            parent.revalidate();
            parent.repaint();
        }
    }
}