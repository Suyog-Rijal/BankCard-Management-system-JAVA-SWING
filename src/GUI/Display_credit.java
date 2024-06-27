package GUI;

import Functions.BankCard;
import Functions.CreditCard;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class Display_credit {
    JPanel display = new JPanel();
    public Display_credit(ArrayList<BankCard> bankCards) {
        display.setBackground(Color.WHITE);
        display.setPreferredSize(new Dimension(700, 692));
        display.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String[] columnNames = {"Card Id", "Balance Amount", "Bank Account", "Issuer Bank", "Client Name",
                "Card Type", "Interest Rate", "Expiry Date", "Is Granted", "Credit Limit", "Grace Period"};
        String[][] data = new String[bankCards.size()][11];
        for (int i = 0; i < bankCards.size(); i++) {
            if (bankCards.get(i) instanceof CreditCard) {
                CreditCard creditCard = (CreditCard) bankCards.get(i);
                data[i][0] = String.valueOf(creditCard.getCardId());
                data[i][1] = String.valueOf(creditCard.getBalanceAmount());
                data[i][2] = String.valueOf(creditCard.getBankAccount());
                data[i][3] = creditCard.getIssuerBank();
                data[i][4] = creditCard.getClientName();
                data[i][5] = "Credit Card";
                data[i][6] = String.valueOf(creditCard.getInterestRate());
                data[i][7] = String.valueOf(creditCard.getExpirationDate());
                data[i][8] = String.valueOf(creditCard.getIsGranted());
                data[i][9] = String.valueOf(creditCard.getCreditLimit());
                data[i][10] = String.valueOf(creditCard.getGracePeriod());
            }
        }

        JTable table = new JTable(data, columnNames);


        table = new JTable(data, columnNames);
        int width = 700;
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        table.setPreferredScrollableViewportSize(new Dimension(width, table.getPreferredSize().height));
        JScrollPane scrollPane = new JScrollPane(table);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        display.add(scrollPane, gbc);
    }


    public JPanel getDisplay() {
        return display;
    }
}