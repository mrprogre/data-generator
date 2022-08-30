package com.avandy.dataset;

import com.avandy.dataset.ui.FrameDragListener;
import com.avandy.dataset.ui.Gui;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        UIManager.put("Component.arc", 10);
        UIManager.put("ProgressBar.arc", 6);
        UIManager.put("Button.arc", 8);
        UIManager.put("Table.alternateRowColor", new Color(230, 230, 230));
        UIManager.put("TextField.background", Color.GRAY);
        UIManager.put("TextField.foreground", Color.BLACK);
        FlatLightLaf.setup();

        Gui gui = new Gui();
        Runnable runnable = () -> {
            FrameDragListener frameDragListener = new FrameDragListener(gui);
            gui.addMouseListener(frameDragListener);
            gui.addMouseMotionListener(frameDragListener);
        };
        SwingUtilities.invokeLater(runnable);
    }
}