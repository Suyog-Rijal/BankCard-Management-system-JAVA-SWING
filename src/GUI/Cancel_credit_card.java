package GUI;
import Customs.CLabel;
import Customs.CTextField;
import Functions.BankCard;
import Functions.CreditCard;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Cancel_credit_card {
    JPanel cancel_card = new JPanel();
    JLabel card_id = new CLabel("Card ID: ");
    JTextField card_id_txtfield = new CTextField();
    JButton submit = new JButton("Cancel Card");
    public Cancel_credit_card(ArrayList<BankCard> bankCards) {
        cancel_card.setBackground(new java.awt.Color(238, 238, 238));
        cancel_card.setPreferredSize(new Dimension(700,692));
        cancel_card.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,40,0);
        gbc.ipadx = 40;
        cancel_card.add(card_id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        cancel_card.add(card_id_txtfield, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        submit.setPreferredSize(new Dimension(110, 37));
        submit.setFont(new Font("Arial",0,15));
        submit.setBackground(new java.awt.Color(187, 26, 26));
        submit.setForeground(Color.WHITE);
        submit.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        cancel_card.add(submit, gbc);

        submit.addActionListener(e -> {
            String card_id = card_id_txtfield.getText();
            if (card_id.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a card ID");
                return;
            } else {
                try {
                    int card_id_int = Integer.parseInt(card_id);
                    boolean foundCard = false;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard.getCardId() == card_id_int) {
                            foundCard = true;
                            if (bankCard instanceof CreditCard) {
                                bankCards.remove(bankCard);
                                JOptionPane.showMessageDialog(null, "Credit card successfully cancelled");
                                return;
                            } else {
                                JOptionPane.showMessageDialog(null, "The card with the given ID is a debit card, not a credit card.");
                                return;
                            }
                        }
                    }
                    if (!foundCard) {
                        JOptionPane.showMessageDialog(null, "Card ID not found.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid card ID");
                }
            }
        });





    }
    public JPanel getCancel_card() {
        return cancel_card;
    }
}