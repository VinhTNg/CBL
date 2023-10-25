package main;

/**Main function to run game.
 * 
 */
public class Main {

    public static void main(String[] args) {
        Frame frame = new Frame();
        Game game = new Game();
        frame.add(game);
        frame.addKeyListener(game);
        frame.pack();
    }
}