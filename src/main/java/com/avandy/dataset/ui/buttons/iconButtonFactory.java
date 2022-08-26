package com.avandy.dataset.ui.buttons;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class iconButtonFactory {
    protected ImageIcon icon;
    protected Color color;
    protected int x;
    protected int y;
    protected int width;
    protected int  height;

    public iconButtonFactory(ImageIcon icon, int x, int y, int width, int height) {
        this.icon = icon;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public abstract void buttonSetting(JButton button, String tooltipText);
}
