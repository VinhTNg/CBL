package main;

import java.awt.Graphics;
import java.lang.Math;

/**create and manage bridge for the game.
 * 
 */
public class Bridge {
    int baseX = 50;
    int baseY = 500;
    int length = 0;
    int times = 0;

    //create velocity and keep track of angle while rotating the bridge
    double angularVelocity = Math.PI / 180;
    int xVelocity;
    int yVelocity;
    int xRotated = 0;
    int yRotated = length;
    

    /**draw the bridge when the spacebar is pressed. 
     * 
    */
    public void draw(Graphics g) {
        if (times == 0) {
            times++;
        } else {
            g.drawLine(baseX, baseY, baseX, baseY - length);
            length += 10;
        }
    }

    /**create the animation of the bridge rotating.
     * 
     */
    public void rotate(Graphics g) {
        xVelocity = (int) (length * Math.sin(angularVelocity));
        if (length <= 50) {
            xVelocity = 1;
        }
        // yVelocity = yRotated - (int) (length * Math.cos(angularVelocity));
        xRotated = xRotated + xVelocity;
        // yRotated = yRotated - yVelocity;
        yRotated = (int) Math.sqrt((Math.pow(length, 2) - Math.pow(xRotated, 2))) - 1;
        if (xRotated >= length || yRotated <= 0) {
            xRotated = length;
            yRotated = 0;
        }
        g.drawLine(baseX, baseY, baseX + xRotated, baseY - yRotated);
        
    }
}
