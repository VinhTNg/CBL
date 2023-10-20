package main;

/**Main function to run game.
 * 
 */
public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        // Hero hero = new Hero();
        Map map = new Map();
        frame.add(map);
        frame.pack();
        // frame.add(hero);
    }
}