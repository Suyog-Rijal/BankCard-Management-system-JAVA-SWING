package GUI;

import Customs.CLabel;
import Customs.CTextField;
import Functions.BankCard;
import Functions.CreditCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Set_credit_limit {
    JPanel set_credit_limit = new JPanel();
    JLabel card_id = new CLabel("Card ID:");
    JTextField card_id_txtfield = new CTextField();
    JLabel credit_limit = new CLabel("Credit limit:");
    JTextField credit_limit_txtfield = new CTextField();
    JLabel grace_period = new CLabel("Grace period:");
    JButton set_credit_limit_btn = new JButton("Set Credit Limit");
    JButton clear_btn = new JButton("Clear");
    JButton display_btn = new JButton("Display");

    JTextField grace_period_txtfield = new CTextField();


    public Set_credit_limit(ArrayList<BankCard> bankCards) {
        set_credit_limit.setBackground(new java.awt.Color(238, 238, 238));
        set_credit_limit.setPreferredSize(new Dimension(700,692));
        set_credit_limit.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0,0,40,0);
        gbc.ipadx = 40;
        set_credit_limit.add(card_id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        set_credit_limit.add(card_id_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        set_credit_limit.add(credit_limit, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        set_credit_limit.add(credit_limit_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        set_credit_limit.add(grace_period, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        set_credit_limit.add(grace_period_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        clear_btn.setFont(new Font("Arial",0,15));
        clear_btn.setBackground(new java.awt.Color(187, 26, 26));
        clear_btn.setForeground(Color.WHITE);
        clear_btn.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        clear_btn.setPreferredSize(new Dimension(110, 37));
        set_credit_limit.add(clear_btn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        set_credit_limit_btn.setFont(new Font("Arial",0,15));
        set_credit_limit_btn.setBackground(new java.awt.Color(187, 26, 26));
        set_credit_limit_btn.setForeground(Color.WHITE);
        set_credit_limit_btn.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        set_credit_limit_btn.setPreferredSize(new Dimension(110, 37));
        set_credit_limit.add(set_credit_limit_btn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        display_btn.setFont(new Font("Arial",0,15));
        display_btn.setBackground(new java.awt.Color(187, 26, 26));
        display_btn.setForeground(Color.WHITE);
        display_btn.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        display_btn.setPreferredSize(new Dimension(110, 37));
        set_credit_limit.add(display_btn, gbc);

        clear_btn.addActionListener(e -> {
            clear();
        });

        display_btn.addActionListener(e -> {
            set_credit_limit.removeAll();
            set_credit_limit.add(new Display_credit(bankCards).getDisplay());
            set_credit_limit.revalidate();
            set_credit_limit.repaint();
        });

        set_credit_limit_btn.addActionListener(e -> {
            String cardId = card_id_txtfield.getText().toString();
            String creditLimit = credit_limit_txtfield.getText().toString();
            String gracePeriod = grace_period_txtfield.getText().toString();

            if (cardId.isEmpty() || creditLimit.isEmpty() || gracePeriod.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
            } else {
                try {
                    double creditlimit = Double.parseDouble(creditLimit);
                    boolean creditCardFound = false;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof CreditCard) {
                            if (bankCard.getCardId() == Integer.parseInt(cardId)) {
                                double balanceAmount = ((CreditCard) bankCard).getBalanceAmount();
                                if (creditlimit > balanceAmount) {
                                    JOptionPane.showMessageDialog(null, "Credit limit cannot exceed the balance amount.");
                                } else {
                                    ((CreditCard) bankCard).setTheCreditLimit(creditlimit, Integer.parseInt(gracePeriod));
                                    ((CreditCard) bankCard).setGracePeriod(Integer.parseInt(gracePeriod));
                                    JOptionPane.showMessageDialog(null, "Credit limit set successfully!");
                                    clear();
                                }
                                creditCardFound = true;
                                break;
                            }
                        }
                    }
                    if (!creditCardFound) {
                        JOptionPane.showMessageDialog(null, "No credit card found with the provided card ID.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
                }
            }
        });




    }
    public JPanel getSet_credit_limit() {
        return set_credit_limit;
    }

    public void clear() {
        card_id_txtfield.setText("");
        credit_limit_txtfield.setText("");
        grace_period_txtfield.setText("");
    }
}

