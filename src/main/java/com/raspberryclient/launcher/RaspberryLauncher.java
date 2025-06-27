package com.raspberryclient.launcher;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.io.File;
import java.net.URISyntaxException;

import com.raspberryclient.mod.RaspberryClient;

/**
 * Simple launcher that wraps the built jar and starts it with Java.
 */
public class RaspberryLauncher {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Raspberry Client Launcher");
        JButton play = new JButton("Play");
        play.addActionListener(e -> {
            try {
                // Determine the directory this launcher is running from so the
                // client jar can be located next to the EXE or jar.
                File base;
                try {
                    base = new File(RaspberryLauncher.class.getProtectionDomain()
                            .getCodeSource().getLocation().toURI()).getParentFile();
                } catch (URISyntaxException ex) {
                    base = new File(".");
                }

                String jarName = String.format("%s-%s.jar", "RaspberryClient", RaspberryClient.VERSION);
                File jar = new File(base, jarName);

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
