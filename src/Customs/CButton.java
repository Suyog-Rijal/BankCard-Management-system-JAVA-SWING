package Customs;

import javax.swing.*;
import java.awt.*;

/**
 * Custom Button class that extends JButton.
 * Provides customized appearance and behavior for buttons.
 */
public class CButton extends JButton {

    /**
     * Constructor for CButton.
     * @param text The text to be displayed on the button.
     */
    public CButton(String text) {
        super(text);

        // Set button properties
        setFocusPainted(false);
        setContentAreaFilled(true);
        setMargin(new Insets(10, 10, 10, 10));
        setFont(new Font("Arial", 0, 18));
        setBackground(new java.awt.Color(187, 26, 26));
        setForeground(new java.awt.Color(255, 255, 255));
    }
}
