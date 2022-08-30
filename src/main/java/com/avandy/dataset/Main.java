package com.avandy.dataset;

import com.avandy.dataset.ui.FrameDragListener;
import com.avandy.dataset.ui.Gui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Gui gui = new Gui();
        Runnable runnable = () -> {
            FrameDragListener frameDragListener = new FrameDragListener(gui);
            gui.addMouseListener(frameDragListener);
            gui.addMouseMotionListener(frameDragListener);
        };
        SwingUtilities.invokeLater(runnable);
    }

}