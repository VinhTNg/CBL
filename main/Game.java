package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


/**Create map and functions for the game.
 * 
 */
public class Game extends JPanel implements KeyListener, ActionListener {

    int width = 450;
    int height = 800;
    Hero hero = new Hero();
    Bridge bridge = new Bridge();
    int heroLocation = hero.baseX + bridge.length;

    //create score board and highest record
    JLabel score = new JLabel();
    int point = 0;
    JLabel record = new JLabel();
    int tempScore;
    int highestScore = 0;

    //use JPanel to create 2 lands
    JPanel firstLand = new JPanel();
    JPanel secLand = new JPanel();

    //generate random space for 2 lands
    Random randomX = new Random();
    Random randomLimX = new Random();

    //space between first land and second land
    int maxSpace = 300;
    int minSpace = 50;

    //space for first land
    int maxLim1 = 100;
    int minLim1 = 70;

    //create first land and space between first and second land
    int newLimLand1 = (int) (randomLimX.nextFloat() * (maxLim1 - minLim1 + 1) + minLim1);
    int newSpace = (int) (randomX.nextFloat() * (maxSpace - minSpace + 1) + minSpace);
    int newX2 = newLimLand1 + newSpace;

    //space for second land
    int maxLim2 = width - newX2 - 20;
    int minLim2 = newX2 - 50;
    int newLimLand2 = (int) (randomLimX.nextFloat() * (maxLim2 - minLim2 + 1) + minLim2);

    //for animation
    Timer timer;
    boolean startAnimation = false;
    boolean timerStop = false;
    boolean playing = true;
    boolean drop = false;

    /**Constructor for map.
     * 
     */
    public Game() {

        //create timer for animation
        timer = new Timer(10, this);

        //set up score board and record
        score.setText("Score: " + Integer.toString(point));
        score.setBounds(100, 100, 250, 100);
        score.setFont(new Font("Serif", Font.PLAIN, 40));
        record.setText("Record: " + Integer.toString(highestScore));
        record.setBounds(100, 0, 250, 100);
        record.setFont(new Font("Serif", Font.PLAIN, 40));

        //set limit for the ground
        firstLand.setBounds(0, 500, newLimLand1, 300);
        secLand.setBounds(newX2, 500, newLimLand2, 300);
        firstLand.setBackground(Color.black);
        secLand.setBackground(Color.black);

        //set up Panel
        this.setPreferredSize(new Dimension(width, height));
        this.setLayout(null);
        this.add(score);
        this.add(record);
        this.add(firstLand);
        this.add(secLand);
        this.add(hero);
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drop) {
            bridge.rotateDown(g);
        } else if (timerStop) {
            bridge.rotate(g);
        } else if (!startAnimation) {
            bridge.draw(g);
        } else if (startAnimation) {
            bridge.rotate(g);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        //get to next level
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!playing) {
                playing = true;

                //in case user presses start before the animation is complete
                timer.stop();
                startAnimation = false;
                timerStop = true;
                drop = false;
                bridge.length = 0;
                bridge.xRotated = 0;
                bridge.baseY = 500;

                //set Hero back to starting position
                hero.baseX = 48;
                hero.baseY = 430;
                hero.move();
                timerStop = false;

                // create new Land 1 and Land 2
                newLimLand1 = (int) (randomLimX.nextFloat() * (maxLim1 - minLim1 + 1) + minLim1);
                newSpace = (int) (randomX.nextFloat() * (maxSpace - minSpace + 1) + minSpace);
                newX2 = newLimLand1 + newSpace;
                maxLim2 = width - newX2 - 20;
                minLim2 = width - newX2 - 50;
                newLimLand2 = (int) (randomLimX.nextFloat() * (maxLim2 - minLim2 + 1) + minLim2);
                firstLand.setBounds(0, 500, newLimLand1, 300);
                secLand.setBounds(newX2, 500, newLimLand2, 300);
                bridge.length = 0;
                bridge.times = 0;
                this.repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            System.out.println("1");
            if (playing) {
                if (bridge.length < width - hero.baseX) {
                    repaint();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (playing) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                playing = false;
                startAnimation = true;
                bridge.xRotated = 0;
                bridge.yRotated = bridge.length;
                heroLocation = bridge.length + hero.baseX;
                timer.start();
                if (heroLocation >= newX2 && heroLocation <= newX2 + newLimLand2) {
                    tempScore++;
                    point++;
                    score.setText("Score: " + Integer.toString(point));
                } else {
                    if (tempScore >= highestScore) {
                        highestScore = tempScore;
                    }
                    tempScore = 0;
                    point = 0;
                    score.setText("Score: " + Integer.toString(point));
                    record.setText("Record: " + Integer.toString(highestScore));
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (timer.isRunning()) {
            if (bridge.xRotated >= bridge.length || bridge.yRotated <= 0) {
                if (hero.baseX < bridge.baseX + bridge.length) {
                    hero.move();
                } else if (heroLocation < newX2 || heroLocation > newX2 + newLimLand2) {
                    drop = true;
                    if (hero.baseY < height) {
                        drop = true;
                        hero.drop();
                        this.repaint();
                    } else {
                        timer.stop();
                        drop = false;
                        timerStop = true;
                        startAnimation = false;
                        bridge.length = 0;
                        bridge.baseY = 500;
                    }
                } else {
                    timer.stop();
                    timerStop = true;
                    startAnimation = false;
                }
            } else {
                if (drop) {
                    hero.drop();
                }
                this.repaint();
            }
        }
    }
}
