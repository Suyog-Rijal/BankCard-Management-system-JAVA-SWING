package GUI;
import Customs.CLabel;
import Customs.CTextField;
import Functions.BankCard;
import Functions.DebitCard;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Withdraw {
    JPanel withdraw = new JPanel();
    JLabel card_id = new CLabel("Card ID:");
    JTextField card_id_txtfield = new CTextField();
    JLabel withdrawl_amount = new CLabel("Withdrawl Amount:");
    JTextField withdrawl_amount_txtfield = new CTextField();
    JLabel data_of_withdrawl = new CLabel("Date of Withdrawl:");
    JTextField date_of_withdrawl_txtfield = new CTextField();
    JLabel pin_number = new CLabel("Pin Number:");
    JTextField pin_number_txtfield = new CTextField();
    JButton withdraw_btn = new JButton("Withdraw");
    JButton clear_btn = new JButton("Clear");
    JButton display_btn = new JButton("Display");
    public Withdraw(ArrayList<BankCard> bankCards) {
        withdraw.setBackground(new java.awt.Color(238, 238, 238));
        withdraw.setPreferredSize(new Dimension(700, 692));
        withdraw.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0);
        gbc.ipadx = 40;
        withdraw.add(card_id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        withdraw.add(card_id_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        withdraw.add(withdrawl_amount, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        withdraw.add(withdrawl_amount_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        withdraw.add(data_of_withdrawl, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        withdraw.add(date_of_withdrawl_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        withdraw.add(pin_number, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        withdraw.add(pin_number_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        clear_btn.setPreferredSize(new Dimension(110, 37));
        clear_btn.setFont(new Font("Arial", 0, 15));
        clear_btn.setBackground(new java.awt.Color(187, 26, 26));
        clear_btn.setForeground(Color.WHITE);
        clear_btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        withdraw.add(clear_btn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        withdraw_btn.setPreferredSize(new Dimension(110, 37));
        withdraw_btn.setFont(new Font("Arial", 0, 15));
        withdraw_btn.setBackground(new java.awt.Color(187, 26, 26));
        withdraw_btn.setForeground(Color.WHITE);
        withdraw_btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        withdraw.add(withdraw_btn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        display_btn.setFont(new Font("Arial",0,15));
        display_btn.setBackground(new java.awt.Color(187, 26, 26));
        display_btn.setForeground(Color.WHITE);
        display_btn.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        display_btn.setPreferredSize(new Dimension(110, 37));
        withdraw.add(display_btn, gbc);

        display_btn.addActionListener(e ->{
            withdraw.removeAll();
            withdraw.add(new Display_debit(bankCards).getDisplay());
            withdraw.revalidate();
            withdraw.repaint();
        });

        clear_btn.addActionListener(e -> {
            clear();
        });

        withdraw_btn.addActionListener(e -> {
            try {
                String card_id = card_id_txtfield.getText();
                String withdrawl_amount = withdrawl_amount_txtfield.getText();
                String date_of_withdrawl = date_of_withdrawl_txtfield.getText();
                String pin_number = pin_number_txtfield.getText();
                if (card_id.equals("") || withdrawl_amount.equals("") || date_of_withdrawl.equals("") || pin_number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields.");
                } else {
                    int card_id_int = Integer.parseInt(card_id);
                    int withdrawl_amount_int = Integer.parseInt(withdrawl_amount);
                    int pin_number_int = Integer.parseInt(pin_number);
                    boolean found = false;
                    for (BankCard bankCard : bankCards) {
                        if (bankCard instanceof DebitCard) {
                            if (bankCard.getCardId() == card_id_int) {
                                found = true;
                                DebitCard debitCard = (DebitCard) bankCard;
                                if (((DebitCard) bankCard).getPinNumber() == pin_number_int) { // check the pin number
                                    double balance = debitCard.getBalanceAmount();
                                    if (withdrawl_amount_int > balance) {
                                        JOptionPane.showMessageDialog(null, "Withdrawal amount exceeds balance.");
                                    } else {
                                        debitCard.withdraw(withdrawl_amount_int, date_of_withdrawl, pin_number_int);
                                        JOptionPane.showMessageDialog(null, "Withdrawal successful.");
                                        clear();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid pin number.");
                                }
                            }
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Card ID not found.");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter numbers only.");
            }
        });


    }




    public void clear() {
        card_id_txtfield.setText("");
        withdrawl_amount_txtfield.setText("");
        date_of_withdrawl_txtfield.setText("");
        pin_number_txtfield.setText("");
    }
    public JPanel getWithdraw() {
        return withdraw;
    }
}
