package GUI;
import Customs.CLabel;
import Customs.CTextField;
import Functions.BankCard;
import Functions.DebitCard;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
;

public class Add_debit_card {
    private JPanel add_debit = new JPanel();
    JLabel label = new CLabel("Add Debit Card");
    JLabel balance_amount = new CLabel("Balance Amount:");
    JTextField balance_amount_txtfield = new CTextField();
    JLabel card_id = new CLabel("Card ID:");
    JTextField card_id_txtfield = new CTextField();
    JLabel bank_account = new CLabel("Bank Account:");
    JTextField bank_account_txtfield = new CTextField();
    JLabel issuer_bank = new CLabel("Issuer Bank:");
    JTextField issuer_bank_txtfield = new CTextField();
    JLabel client_name = new CLabel("Client Name:");
    JTextField client_name_txtfield = new CTextField();
    JLabel pin_number = new CLabel("Pin Number:");
    JTextField pin_number_txtfield = new CTextField();
     JButton clear= new JButton("Clear");
    JButton add = new JButton("Add");
    JButton back = new JButton("Back");
    JButton display = new JButton("Display");

    public Add_debit_card(ArrayList<BankCard> bankCards) {
        add_debit.setBackground(new java.awt.Color(238, 238, 238));
        add_debit.setPreferredSize(new Dimension(700,692));
        add_debit.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        add_debit.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0,0,50,30);
        gbc.ipadx =15;
        add_debit.add(balance_amount, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add_debit.add(balance_amount_txtfield, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add_debit.add(card_id, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        add_debit.add(card_id_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add_debit.add(bank_account, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add_debit.add(bank_account_txtfield, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add_debit.add(issuer_bank, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        add_debit.add(issuer_bank_txtfield, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add_debit.add(client_name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add_debit.add(client_name_txtfield, gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        add_debit.add(pin_number, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        add_debit.add(pin_number_txtfield, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        clear.setPreferredSize(new Dimension(110, 37));
        clear.setFont(new Font("Arial",0,16));
        clear.setBackground(new java.awt.Color(187, 26, 26));
        clear.setForeground(Color.WHITE);
        clear.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        add_debit.add(clear, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        add.setPreferredSize(new Dimension(110, 37));
        add.setFont(new Font("Arial",0,15));
        add.setBackground(new java.awt.Color(187, 26, 26));
        add.setForeground(Color.WHITE);
        add.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        add_debit.add(add, gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;
        display.setPreferredSize(new Dimension(110, 37));
        display.setFont(new Font("Arial",0,15));
        display.setBackground(new java.awt.Color(187, 26, 26));
        display.setForeground(Color.WHITE);
        display.setBorder(BorderFactory.createLineBorder(Color.WHITE,2));
        add_debit.add(display, gbc);

        clear.addActionListener(e -> {
            clear();
        });

        display.addActionListener(e -> {
            add_debit.removeAll();
            add_debit.add(new Display_debit(bankCards).getDisplay());
            add_debit.revalidate();
            add_debit.repaint();
        });


        add.addActionListener(e -> {
            String balance_amount = balance_amount_txtfield.getText();
            String card_id = card_id_txtfield.getText();
            String bank_account = bank_account_txtfield.getText();
            String issuer_bank = issuer_bank_txtfield.getText();
            String client_name = client_name_txtfield.getText();
            String pin_number = pin_number_txtfield.getText();

            if(balance_amount.equals("") || card_id.equals("") || bank_account.equals("") || issuer_bank.equals("") || client_name.equals("") || pin_number.equals("")){
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            }
            else{
                try{
                    double balance_amount_int = Double.parseDouble(balance_amount);
                    int card_id_int = Integer.parseInt(card_id);
                    int pin_number_int = Integer.parseInt(pin_number);
                    DebitCard debitCard = new DebitCard(balance_amount_int, card_id_int, bank_account, issuer_bank, client_name, pin_number_int);
                    bankCards.add(debitCard);
                    JOptionPane.showMessageDialog(null, "Debit Card Added Successfully");
                    clear();
                }
                catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Please enter valid data or re-check the fields");
                }
            }
        });

    }

    public JPanel getAdd_debit() {
        return add_debit;

    }

    public void clear() {
        balance_amount_txtfield.setText("");
        card_id_txtfield.setText("");
        bank_account_txtfield.setText("");
        issuer_bank_txtfield.setText("");
        client_name_txtfield.setText("");
        pin_number_txtfield.setText("");
    }
}