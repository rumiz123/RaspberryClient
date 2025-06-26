package com.raspberryclient.launcher;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.File;

/**
 * Simple launcher that wraps the built jar and starts it with Java.
 */
public class RaspberryLauncher {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Raspberry Client Launcher");
        JButton play = new JButton("Play");
        play.addActionListener(e -> {
            try {
                File jar = new File("RaspberryClient-1.0.0.jar");
                ProcessBuilder pb = new ProcessBuilder("java", "-jar", jar.getAbsolutePath());
                pb.inheritIO();
                pb.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        frame.add(play);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
