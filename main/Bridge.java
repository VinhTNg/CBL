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
    double angularVelocity;
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

    /**Create animation the bridge falling down.
     */
    public void rotateDown(Graphics g) {
        angularVelocity = Math.PI / 180;
        yVelocity = (int) (length * Math.sin(angularVelocity));
        if (length <= 50) {
            yVelocity = 1;
        }
        yRotated = yRotated + yVelocity;
        xRotated = (int) Math.sqrt((Math.pow(length, 2) - Math.pow(yRotated, 2))) - 10;
        if (xRotated < 0 || yRotated > length) {
            xRotated = 0;
            yRotated = length;
        }
        g.drawLine(baseX, baseY, baseX + xRotated, baseY + yRotated);
    }

    /**create the animation of the bridge rotating.
     * 
     */
    public void rotate(Graphics g) {
        angularVelocity = Math.PI / 180;
        xVelocity = (int) (length * Math.sin(angularVelocity));
        if (length <= 50) {
            xVelocity = 1;
        }
        // yVelocity = yRotated - (int) (length * Math.cos(angularVelocity));
        // yRotated = yRotated - yVelocity;
        xRotated = xRotated + xVelocity;
        yRotated = (int) Math.sqrt((Math.pow(length, 2) - Math.pow(xRotated, 2))) - 10;
        if (xRotated >= length || yRotated <= 0) {
            xRotated = length;
            yRotated = 0;
        }
        g.drawLine(baseX, baseY, baseX + xRotated, baseY - yRotated);
        
    }
}
