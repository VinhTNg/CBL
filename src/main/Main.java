package main;

/**Main function to run game.
 * 
 */
public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        Map map = new Map();
        frame.add(map);
        frame.pack();
    }
}