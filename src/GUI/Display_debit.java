package GUI;

import Functions.BankCard;
import Functions.DebitCard;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class Display_debit {
    JLabel label = new JLabel("Display Debit Card");
    JPanel display = new JPanel();
    JTable table;

    public Display_debit(ArrayList<BankCard> bankCards) {
        display.setBackground(Color.GREEN);
        display.setPreferredSize(new Dimension(700, 692));
        display.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type", "Pin", "Has Withdrawn"};
        ArrayList<DebitCard> debitCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard instanceof DebitCard) {
                debitCards.add((DebitCard) bankCard);
            }
        }
        String[][] data = new String[debitCards.size()][7];
        for (int i = 0; i < debitCards.size(); i++) {
            data[i][0] = String.valueOf(debitCards.get(i).getCardId());
            data[i][1] = String.valueOf(debitCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(debitCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(debitCards.get(i).getClientName());
            data[i][4] =  "Debit Card";
            data[i][5] = String.valueOf(debitCards.get(i).getPinNumber());
            data[i][6] = String.valueOf(debitCards.get(i).getHasWithdrawn());
        }

        table = new JTable(data, columnNames);
        int width = 700;
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        table.setPreferredScrollableViewportSize(new Dimension(width, table.getPreferredSize().height));
        JScrollPane scrollPane = new JScrollPane(table);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        display.add(scrollPane, gbc);
    }

    public JPanel getDisplay() {
        return display;
    }
}
