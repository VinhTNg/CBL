package main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class Main {
    
    public static void main(String[] args) {
        Frame frame = new Frame();
        FirstInterface firstInterface = new FirstInterface();
        frame.add(firstInterface);
    }
}
