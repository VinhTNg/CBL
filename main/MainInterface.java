package main;

public class MainInterface {
    
    public static void main(String[] args) {
        FrameInterface frame = new FrameInterface();
        FirstInterface firstInterface = new FirstInterface();
        frame.add(firstInterface);
    }
}
