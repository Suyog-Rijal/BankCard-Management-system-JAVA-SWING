package Customs;

import javax.swing.*;
import java.awt.*;

/**
 * Custom Label class that extends JLabel.
 * Provides customized appearance for labels.
 */
public class CLabel extends JLabel {

    /**
     * Constructor for CLabel.
     * @param text The text to be displayed on the label.
     */
    public CLabel(String text) {
        super(text);

        // Set label properties
        setFont(new Font("Arial", 0, 18));
        setForeground(Color.BLACK);
    }
}
