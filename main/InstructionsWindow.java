package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InstructionsWindow extends JPanel implements ActionListener {
    
    JLabel label = new JLabel();
    JButton backBtn;
    
    public InstructionsWindow() {
        
        label.setText("<html>" + "Hold the space bar to increase the length of the bridge. <br> The length of the bridge cannot be shorter than the distance of two stops. <br> The length of the bridge cannot exceed the second stop. <br> Tap enter to continue playing." + "</html>");


        backBtn = new JButton("Return");
        backBtn.addActionListener(this);
        backBtn.setLayout(null);
        backBtn.setBounds(150, 720, 150, 30);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("MV Boli", Font.BOLD, 25));
        backBtn.setForeground(Color.BLACK);
        backBtn.setBackground(Color.lightGray);
        backBtn.setBorder(BorderFactory.createEtchedBorder());

        ImageIcon background = new ImageIcon("src\\background.png");
        label.setIcon(background);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.BOLD, 16));
        label.setForeground(Color.BLACK);
        label.setLayout(null);
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
