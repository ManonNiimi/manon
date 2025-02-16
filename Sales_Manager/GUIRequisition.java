package Sales_Manager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class GUIRequisition extends JFrame {
    private JLabel txtItemID, txtQuantityRequired, txtDate, txtSalesManagerID;
    private JTextField fieldItemID, fieldQuantityRequired, fieldDate, fieldSalesManagerID;
    private JTable requisitionTable;
    private DefaultTableModel tableModel;
    private static final String requisitionFile = "Requisition.txt";
    private static int currentID = 1;

    public GUIRequisition() {
        setTitle("Requisition System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        add(inputPanel, BorderLayout.NORTH);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtItemID = new JLabel("ItemID:");
        fieldItemID = new JTextField(15);
        txtQuantityRequired = new JLabel("QuantityRequired:");
        fieldQuantityRequired = new JTextField(15);
        txtDate = new JLabel("Date:");
        fieldDate = new JTextField(15);
        txtSalesManagerID = new JLabel("SalesManager ID:");
        fieldSalesManagerID = new JTextField(15);

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(txtItemID, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        inputPanel.add(fieldItemID, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(txtQuantityRequired, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        inputPanel.add(fieldQuantityRequired, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(txtDate, gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        inputPanel.add(fieldDate, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(txtSalesManagerID, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        inputPanel.add(fieldSalesManagerID, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnDelete = new JButton("Delete");
        JButton btnExit = new JButton("Exit");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnExit);

        add(buttonPanel, BorderLayout.SOUTH);

        // Table
        String[] columnNames = {"RequisitionID", "ItemID", "Quantity", "Date", "SalesManagerID"};
        tableModel = new DefaultTableModel(columnNames, 0);
        requisitionTable = new JTable(tableModel);
        add(new JScrollPane(requisitionTable), BorderLayout.CENTER);

        // Load existing requisitions
        loadRequisitions();

        // Button Actions
        btnAdd.addActionListener(e -> addRequisition());
        btnDelete.addActionListener(e -> deleteRequisition());
        btnExit.addActionListener(e -> {
            dispose();
            GUIMain guimain = new GUIMain();
            guimain.setVisible(true);
        });

        requisitionTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = requisitionTable.getSelectedRow();
                if (selectedRow != -1) {
                    fieldItemID.setText((String) tableModel.getValueAt(selectedRow, 1));
                    fieldQuantityRequired.setText(String.valueOf(tableModel.getValueAt(selectedRow, 2)));
                    fieldDate.setText((String) tableModel.getValueAt(selectedRow, 3));
                    fieldSalesManagerID.setText((String) tableModel.getValueAt(selectedRow, 4));
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadRequisitions() {
        File file = new File(requisitionFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error creating file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) { // Updated to match the new structure
                    tableModel.addRow(data);
                    updateCurrentID(data[0]);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addRequisition() {
        String itemID = fieldItemID.getText();
        String quantityRequired = fieldQuantityRequired.getText();
        String date = fieldDate.getText();
        String salesManagerID = fieldSalesManagerID.getText();

        if (itemID.isEmpty() || quantityRequired.isEmpty() || date.isEmpty() || salesManagerID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String requisitionID = generateRequisitionID();
        tableModel.addRow(new Object[]{requisitionID, itemID, quantityRequired, date, salesManagerID});
        updateRequisitionFile();

        fieldItemID.setText("");
        fieldQuantityRequired.setText("");
        fieldDate.setText("");
        fieldSalesManagerID.setText("");
    }

    private String generateRequisitionID() {
        return "PR" + String.format("%03d", currentID++);
    }

    private void updateCurrentID(String requisitionID) {
        try {
            int idNumber = Integer.parseInt(requisitionID.substring(2));
            currentID = Math.max(currentID, idNumber + 1);
        } catch (NumberFormatException ex) {
            // Ignore invalid IDs
        }
    }

    private void deleteRequisition() {
        int selectedRow = requisitionTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
            updateRequisitionFile();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a requisition to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        fieldItemID.setText("");
        fieldQuantityRequired.setText("");
        fieldDate.setText("");
        fieldSalesManagerID.setText("");
    }

    private void updateRequisitionFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(requisitionFile, false))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    bw.write((String) tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error updating file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new GUIRequisition();
    }
}