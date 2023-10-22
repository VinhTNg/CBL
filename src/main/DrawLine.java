package main;

import java.awt.Graphics;
import javax.swing.JPanel;

/**Draw bridge for the game.
 * 
 */
public class DrawLine extends JPanel {
    //count to extend the length of the bridge
    int count = 0;

    /**Constructor of the class.
     * 
     */
    public DrawLine() {
        setBounds(50, 0, 100, 200);
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 0, 0, 100);
    }
}
