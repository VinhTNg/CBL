package main;

/**Main function to run game.
 * 
 */
public class Main {

    public static void main(String[] args) {
        FrameInterface frame = new FrameInterface();
        Game game = new Game();
        frame.add(game);
        frame.addKeyListener(game);
        frame.pack();
    }
}