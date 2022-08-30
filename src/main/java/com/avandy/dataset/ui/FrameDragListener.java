package com.avandy.dataset.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// Making a java swing frame movable and setUndecorated
public class FrameDragListener extends MouseAdapter {
    private final JFrame frame;
    private Point mouseDownCompCoords = null;

    public FrameDragListener(JFrame frame) {
        this.frame = frame;
    }

    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;
    }

    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
    }
}