package GUI;
import Customs.CLabel;
import Customs.CTextField;
import Functions.BankCard;
import Functions.CreditCard;
import Functions.DebitCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Add_credit_card {
    JPanel add_credit = new JPanel();
    JLabel card_id = new CLabel("Card ID: ");
    JTextField card_id_txtfield = new CTextField();
    JLabel client_name = new CLabel("Client Name: ");
    JTextField client_name_txtfield = new CTextField();
    JLabel issuer_bank = new CLabel("Issuer Bank: ");
    JTextField issuer_bank_txtfield = new CTextField();
    JLabel bank_account = new CLabel("Bank Account: ");
    JTextField bank_account_txtfield = new CTextField();
    JLabel balance_amount = new CLabel("Balance Amount: ");
    JTextField balance_amount_txtfield = new CTextField();
    JLabel cvc_number = new CLabel("CVC Number: ");
    JTextField cvc_number_txtfield = new CTextField();
    JLabel interest_rate = new CLabel("Interest Rate: ");
    JTextField interest_rate_txtfield = new CTextField();
    JLabel expiry_date = new CLabel("Expiry Date: ");
    JButton clear = new JButton("Clear");
    JButton add = new JButton("Add");
    JButton display = new JButton("Display");
    JComboBox expiry_date_month = new JComboBox(new String[]{"Monthe",
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10","11","12"});
    JComboBox expiry_date_year = new JComboBox(new String[]{
            "Year", "2016", "2017", "2018", "2019",
            "2020", "2021", "2022", "2023", "2024", "2025"});
    JComboBox expiry_date_day = new JComboBox(new String[]{"Day",
            "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
            "11","12","13", "14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30","31"});

    public Add_credit_card(ArrayList<BankCard> bankCards) {
        add_credit.setBackground(new java.awt.Color(238, 238, 238));
        add_credit.setPreferredSize(new Dimension(700,692));
        add_credit.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,50,20);
        gbc.ipadx =10;
        add_credit.add(card_id, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add_credit.add(card_id_txtfield, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add_credit.add(client_name, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        add_credit.add(client_name_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add_credit.add(issuer_bank, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add_credit.add(issuer_bank_txtfield, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add_credit.add(bank_account, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        add_credit.add(bank_account_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add_credit.add(balance_amount, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add_credit.add(balance_amount_txtfield, gbc);


        gbc.gridx = 2;
        gbc.gridy = 3;
        add_credit.add(interest_rate, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        add_credit.add(interest_rate_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add_credit.add(expiry_date, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        expiry_date_year.setPreferredSize(new Dimension(100, 30));
        expiry_date_year.setBackground(Color.WHITE);
        expiry_date_year.setForeground(Color.BLACK);
        add_credit.add(expiry_date_year, gbc);

        gbc.gridx = 2;
        gbc.gridy = 5;
        expiry_date_month.setPreferredSize(new Dimension(100, 30));
        expiry_date_month.setBackground(Color.WHITE);
        expiry_date_month.setForeground(Color.BLACK);
        add_credit.add(expiry_date_month, gbc);

        gbc.gridx = 3;
        gbc.gridy = 5;
        expiry_date_day.setPreferredSize(new Dimension(100, 30));
        expiry_date_day.setBackground(Color.WHITE);
        expiry_date_day.setForeground(Color.BLACK);
        add_credit.add(expiry_date_day, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add_credit.add(cvc_number, gbc);

        gbc.gridx= 1;
        gbc.gridy = 4;
        add_credit.add(cvc_number_txtfield, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        clear.setPreferredSize(new Dimension(110, 37));
        clear.setFont(new Font("Arial",0,15));
        clear.setBackground(new java.awt.Color(187, 26, 26));
        clear.setForeground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        add_credit.add(clear, gbc);

        gbc.gridx = 2;
        gbc.gridy = 6;
        add.setPreferredSize(new Dimension(110, 37));
        add.setFont(new Font("Arial",0,15));
        add.setBackground(new java.awt.Color(187, 26, 26));
        add.setForeground(Color.WHITE);
        add.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        add_credit.add(add, gbc);

        gbc.gridx = 3;
        gbc.gridy = 6;
        display.setPreferredSize(new Dimension(110, 37));
        display.setFont(new Font("Arial",0,15));
        display.setBackground(new java.awt.Color(187, 26, 26));
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        add_credit.add(display, gbc);

        clear.addActionListener(e -> clear());

        display.addActionListener(e -> {
            add_credit.removeAll();
            add_credit.add(new Display_credit(bankCards).getDisplay());
            add_credit.revalidate();
            add_credit.repaint();
        });

        add.addActionListener(e -> {
                String card_id = card_id_txtfield.getText();
                String client_name = client_name_txtfield.getText();
                String issuer_bank = issuer_bank_txtfield.getText();
                String bank_account = bank_account_txtfield.getText();
                String balance_amount = balance_amount_txtfield.getText();
                String interest_rate = interest_rate_txtfield.getText();
                String cvc_number = cvc_number_txtfield.getText();

                if (card_id.equals("") || client_name.equals("") || issuer_bank.equals("") || bank_account.equals("") || balance_amount.equals("") || interest_rate.equals("") || expiry_date_year.getSelectedItem().equals("Year") || expiry_date_month.getSelectedItem().equals("Monthe") || expiry_date_day.getSelectedItem().equals("Day") || cvc_number.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields");
                } else {
                    try {
                        int card = Integer.parseInt(card_id);
                        double balance = Double.parseDouble(balance_amount);
                        int cvc = Integer.parseInt(cvc_number);
                        double interest = Double.parseDouble(interest_rate);
                        String expirationDate = expiry_date_year.getSelectedItem() + "-" + expiry_date_month.getSelectedItem() + "-"
                                + expiry_date_day.getSelectedItem();
                        CreditCard creditCard = new CreditCard(card, client_name, issuer_bank, bank_account, balance, cvc, interest,
                                expirationDate);
                        bankCards.add(creditCard);
                        JOptionPane.showMessageDialog(null, "credit Card added successfully");
                        clear();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid data or re-check the fields");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "An error occurred while adding the credit card. Please try again later.");
                    }
                }
        });

    }
    public JPanel getAdd_credit() {
        return add_credit;
    }

    public void clear() {
        card_id_txtfield.setText("");
        client_name_txtfield.setText("");
        issuer_bank_txtfield.setText("");
        bank_account_txtfield.setText("");
        balance_amount_txtfield.setText("");
        interest_rate_txtfield.setText("");
        expiry_date_month.setSelectedIndex(0);
        expiry_date_year.setSelectedIndex(0);
        cvc_number_txtfield.setText("");
        expiry_date_day.setSelectedIndex(0);
    }
}
