package GUI;
import Functions.BankCard;
import Functions.DebitCard;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class Display {
    JPanel display = new JPanel();
    JTable table;

    public Display(ArrayList<BankCard> bankCards) {
        display.setBackground(Color.GREEN);
        display.setPreferredSize(new Dimension(700, 692));
        display.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        String[] columnNames = {"Card Id", "Bank Account", "Balance", "Client Name", "Card Type"};
        String[][] data = new String[bankCards.size()][5];
        for (int i = 0; i < bankCards.size(); i++) {
            data[i][0] = String.valueOf(bankCards.get(i).getCardId());
            data[i][1] = String.valueOf(bankCards.get(i).getBankAccount());
            data[i][2] = String.valueOf(bankCards.get(i).getBalanceAmount());
            data[i][3] = String.valueOf(bankCards.get(i).getClientName());
            data[i][4] = bankCards.get(i) instanceof DebitCard ? "Debit Card" : "Credit Card";
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
