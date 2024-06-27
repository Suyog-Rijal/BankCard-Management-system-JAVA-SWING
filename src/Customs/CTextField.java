package Customs;

import javax.swing.*;
import java.awt.*;

/**
 * Custom TextField class that extends JTextField.
 * Provides customized appearance for text fields.
 */
public class CTextField extends JTextField {

    /**
     * Constructor for CTextField.
     * Sets the properties and appearance of the text field.
     */
    public CTextField() {
        setPreferredSize(new Dimension(130, 27));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setFont(new Font("Arial", 0, 16));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
}
