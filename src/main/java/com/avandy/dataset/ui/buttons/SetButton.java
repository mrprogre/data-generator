package com.avandy.dataset.ui.buttons;

import javax.swing.*;
import java.awt.*;

public class SetButton extends iconButtonFactory {

    public SetButton(ImageIcon icon, Color color, int x, int y, int width, int height) {
        super(icon, x, y, width, height);
        this.color = color;
    }

    @Override
    public void buttonSetting(JButton button, String tooltipText) {
        button.setToolTipText(tooltipText);
        button.setIcon(icon);
        button.setBackground(color);
        button.setBounds(x, y, width, height);
    }
}
