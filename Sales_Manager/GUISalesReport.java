package Sales_Manager;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUISalesReport {
    private static final String SalesEntryFile = "SalesEntry.txt";   

    private JFrame frame;
    private JTable salesTable;
    private DefaultTableModel tableModel;
    private JTextField dateField;

    public GUISalesReport() {
        frame = new JFrame("Sales Manager System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        String[] columnNames = {"Sales ID", "Item ID", "Total Price", "Date"};
        tableModel = new DefaultTableModel(columnNames, 0);
        salesTable = new JTable(tableModel);

        try {
            File file = new File(SalesEntryFile);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(frame, "SalesEntry.txt not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                String[] stringData = line.split(",");
                if (stringData.length >= 6) { 
                    String[] data = {stringData[0], stringData[1], stringData[4], stringData[5]};
                    tableModel.addRow(data);
                }
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(frame, "Error reading SalesEntry.txt: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        JScrollPane scrollPane = new JScrollPane(salesTable);

        JLabel dateLabel = new JLabel("Filter by Date (DD/MM/YYYY):");
        dateField = new JTextField(10);
        JButton filterButton = new JButton("Show Report");

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDate = dateField.getText();
                showSalesReport(selectedDate);
            }
        });

        JPanel filterPanel = new JPanel();
        filterPanel.add(dateLabel);
        filterPanel.add(dateField);
        filterPanel.add(filterButton);

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(filterPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void showSalesReport(String selectedDate) {
        JFrame reportFrame = new JFrame("Sales Report - " + selectedDate);
        reportFrame.setSize(500, 300);

        DefaultTableModel reportModel = new DefaultTableModel(new String[]{"Sales ID", "Item ID", "Total Price", "Date"}, 0);
        JTable reportTable = new JTable(reportModel);

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String date = tableModel.getValueAt(i, 3).toString();
            if (date.equals(selectedDate)) {
                reportModel.addRow(new Object[] {
                        tableModel.getValueAt(i, 0),
                        tableModel.getValueAt(i, 1),
                        tableModel.getValueAt(i, 2),
                        tableModel.getValueAt(i, 3)
                });
            }
        }

        // Add "Back" button functionality
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the report frame and return to the main frame
                reportFrame.dispose();
                frame.setVisible(true);
            }
        });

        // If no data for the selected date
        if (reportModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Does not have a Data.", "Error: ", JOptionPane.INFORMATION_MESSAGE);
        } else {
            reportFrame.add(new JScrollPane(reportTable), BorderLayout.CENTER);
            JPanel backPanel = new JPanel();
            backPanel.add(backButton);
            reportFrame.add(backPanel, BorderLayout.SOUTH);
            reportFrame.setVisible(true);
        }

        // Hide the main frame while the report frame is visible
        frame.setVisible(false);
    }

    public static void main(String[] args) {
        new GUISalesReport();
    }
}
