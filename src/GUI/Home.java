package GUI;
import Customs.CButton;
import Functions.BankCard;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Home {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel balance_amount = new JLabel();
    JLabel balance_amount_value = new JLabel();
    JLabel usernameLabel = new JLabel();
    JLabel bank_name = new JLabel();
    JPanel panel1 = new JPanel();
    JButton add_debit_card = new CButton("Add Debit Card");
    JButton add_credit_card = new CButton("Add Credit Card");
    JButton withdraw = new CButton("Withdraw");
    JButton cancel_creditcard = new CButton("Cancel Credit Card");
    JButton display = new CButton("Display");
    JButton set_credit_limit = new CButton("Set Credit Limit");
    JPanel panel2 = new JPanel();
    ArrayList<BankCard> bankCards = new ArrayList<>();


    public Home() {

        frame.setTitle("Account");
        frame.setSize(1100, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);

        panel.setSize(frame.getWidth(), 55);
        panel.setLayout(null);
        panel.setBackground(Color.black);
        frame.add(panel);

        balance_amount.setText("Balance Amount: ");
        balance_amount.setFont(new Font("Serif", Font.BOLD, 17));
        balance_amount.setForeground(Color.white);
        balance_amount.setBounds(20,0, frame.getWidth(),55);
        panel.add(balance_amount);

        balance_amount_value.setText("0.0");
        balance_amount_value.setFont(new Font("Serif", Font.BOLD, 17));
        balance_amount_value.setForeground(Color.white);
        balance_amount_value.setBounds(156,0, frame.getWidth(),55);
        panel.add(balance_amount_value);

        usernameLabel.setText("User");
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 17));
        usernameLabel.setForeground(Color.white);
        usernameLabel.setBounds(980,0, frame.getWidth(),55);
        panel.add(usernameLabel);

        bank_name.setText("BANK");
        bank_name.setFont(new Font("Serif", Font.BOLD, 22));
        bank_name.setForeground(Color.white);
        bank_name.setBounds(470,0, frame.getWidth(),55);
        panel.add(bank_name);

        panel1.setBounds(0,58,400,692);
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 40;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 20, 0);
        panel1.add(add_debit_card, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(add_credit_card, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel1.add(withdraw, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(cancel_creditcard, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel1.add(display, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel1.add(set_credit_limit, gbc);

        panel2.setBackground(new java.awt.Color(238, 238, 238));
        panel2.setBounds(400,58,700,692);

        // For debit card
        add_debit_card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.add(new Add_debit_card(bankCards).getAdd_debit());
                panel2.revalidate();
                panel2.repaint();
            }
        });

        // For credit card
        add_credit_card.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.add(new Add_credit_card(bankCards).getAdd_credit());
                panel2.revalidate();
                panel2.repaint();
            }
        });

        // For cancel credit card
        cancel_creditcard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.add(new Cancel_credit_card(bankCards).getCancel_card());
                panel2.revalidate();
                panel2.repaint();
            }
        });

        // For Display
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.add(new Display(bankCards).getDisplay());
                panel2.revalidate();
                panel2.repaint();
            }
        });

        // For withdraw
        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.add(new Withdraw(bankCards).getWithdraw());
                panel2.revalidate();
                panel2.repaint();
            }
        });

        // For set_credit_limit
        set_credit_limit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.removeAll();
                panel2.add(new Set_credit_limit(bankCards).getSet_credit_limit());
                panel2.revalidate();
                panel2.repaint();
            }
        });

        frame.add(panel2);
        frame.add(panel1);
        frame.add(panel);
        frame.setVisible(true);
    }

}
