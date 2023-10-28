package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    JButton back;
    int heroLocation;

    //create score board and highest record
    JLabel score = new JLabel();
    int point = 0;
    JLabel record = new JLabel();
    int tempScore;
    int highestScore = 0;

    //use JPanel to create 2 lands
    JPanel firstLand = new JPanel();
    JPanel secLand = new JPanel();
    int red;
    int green;
    int blue;

    //generate random space for 2 lands
    Random randomX = new Random();
    Random randomLimX = new Random();
    Random random = new Random();

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

        //set up return button
        back = new JButton("Return");
        back.addActionListener(this);
        back.setBounds(340, 0, 100, 30);
        back.setFocusable(false);
        back.setFont(new Font("MV Boli", Font.BOLD, 25));
        back.setForeground(Color.BLACK);
        back.setBackground(Color.lightGray);
        back.setBorder(BorderFactory.createEtchedBorder());
        back.setVisible(true);

        //set up score board and record
        score.setText("Score: " + Integer.toString(point));
        score.setBounds(100, 100, 250, 100);
        score.setFont(new Font("MV Boli", Font.PLAIN, 40));
        record.setText("Record: " + Integer.toString(highestScore));
        record.setBounds(100, 0, 250, 100);
        record.setFont(new Font("MV Boli", Font.PLAIN, 40));

        //set up the ground
        red = (int) (random.nextFloat() * 255);
        green = (int) (random.nextFloat() * 255);
        blue = (int) (random.nextFloat() * 255);

        firstLand.setBounds(0, 500, newLimLand1, 300);
        secLand.setBounds(newX2, 500, newLimLand2, 300);
        firstLand.setBackground(new Color(red, green, blue));
        secLand.setBackground(new Color(red, green, blue));

        //set up Panel
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.setLayout(null);
        this.add(back);
        this.add(score);
        this.add(record);
        this.add(firstLand);
        this.add(secLand);
        this.add(hero);
        this.addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon backgroundImage = new ImageIcon("src\\background.png");
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
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
                hero.baseX = 17;
                hero.baseY = 400;
                hero.move();
                timerStop = false;

                // recreate Land 1 and Land 2
                red = (int) (random.nextFloat() * 255);
                green = (int) (random.nextFloat() * 255);
                blue = (int) (random.nextFloat() * 255);
                firstLand.setBackground(new Color(red, green, blue));
                secLand.setBackground(new Color(red, green, blue));
                newLimLand1 = (int) (randomLimX.nextFloat() * (maxLim1 - minLim1 + 1) + minLim1);
                newSpace = (int) (randomX.nextFloat() * (maxSpace - minSpace + 1) + minSpace);
                newX2 = newLimLand1 + newSpace;
                maxLim2 = width - newX2 - 20;
                minLim2 = width - newX2 - 30;
                newLimLand2 = (int) (randomLimX.nextFloat() * (maxLim2 - minLim2 + 1) + minLim2);
                firstLand.setBounds(0, 500, newLimLand1, 300);
                secLand.setBounds(newX2, 500, newLimLand2, 300);
                bridge.length = 0;
                bridge.times = 0;
                this.repaint();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (playing) {
                if (bridge.length < width - hero.baseX) {
                    this.repaint();
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
                heroLocation = bridge.length + bridge.baseX;
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
        if (e.getSource() == back) {
            timer.stop();
            Container parent = this.getParent();
            parent.removeAll();
            PlayWindow playWindow = new PlayWindow();
            parent.add(playWindow);
            parent.revalidate();
            parent.repaint();
        }
        if (timer.isRunning()) {
            if (bridge.xRotated >= bridge.length || bridge.yRotated <= 0) {
                if (hero.baseX < bridge.baseX + bridge.length - 25) {
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
