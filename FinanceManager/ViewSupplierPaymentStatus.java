package FinanceManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewSupplierPaymentStatus extends JFrame {

    private JTable supplierTable;
    private DefaultTableModel tableModel;

    public ViewSupplierPaymentStatus() {
        setTitle("View Supplier Payment Status");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Label
        JLabel headerLabel = new JLabel("-- Supplier Payment Status --", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(headerLabel, BorderLayout.NORTH);

        // Table Setup
        String[] columns = {"Supplier Name", "Amount Paid", "Amount Pending", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        supplierTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(supplierTable);
        add(scrollPane, BorderLayout.CENTER);

        // Populate Table with Data
        loadSupplierData();

        // Back Button
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        add(backButton, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            new FinanceManagerMenu(); // Return to the main menu
            dispose();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadSupplierData() {
        // Simulated Data (replace this with dynamic data integration later)
        Object[][] supplierData = {
            {"Supplier A", "$1000", "$500", "Pending"},
            {"Supplier B", "$800", "$0", "Paid"},
            {"Supplier C", "$500", "$300", "Pending"},
            {"Supplier D", "$1500", "$0", "Paid"}
        };

        for (Object[] row : supplierData) {
            tableModel.addRow(row);
        }
    }

    public static void main(String[] args) {
        new ViewSupplierPaymentStatus();
    }
}
