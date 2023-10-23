package main;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class MoreWindow extends JPanel implements ActionListener{
    
    JLabel label = new JLabel();
    JButton backBtn;

    MoreWindow() {
        
        backBtn = new JButton("Return");
        backBtn.addActionListener(this);
        backBtn.setLayout(null);
        backBtn.setBounds(150, 720, 150, 30);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("MV Boli", Font.BOLD, 25));
        backBtn.setForeground(Color.BLACK);
        backBtn.setBackground(Color.lightGray);
        backBtn.setBorder(BorderFactory.createEtchedBorder());

        label.setText("<html>"+"This game is made by Vinh and Nam"+"</html>");

        ImageIcon background = new ImageIcon("src\\background.png");
        label.setIcon(background);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.BOLD, 16));
        label.setForeground(Color.BLACK);
        // label.setLayout(null);
        label.setPreferredSize(new Dimension(450, 800));
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
