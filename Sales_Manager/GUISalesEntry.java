package Sales_Manager;

import Sales_Manager.SalesEntry;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUISalesEntry extends JFrame {
    private JLabel txtItemID, txtQuantitySold, txtPrice, txtDate, txtSalesManager;
    private JTextField fieldItemID, fieldQuantitySold, fieldPrice, fieldDate, 
            fieldSalesManager;
    private JTable salesTable;
    private DefaultTableModel tableModel;
    private static final String itemsFile = "listofitems.txt";
    private static final String SalesEntryFile = "SalesEntry.txt";  
    private static final String stockFile = "StockLevels.txt";  
    
    public GUISalesEntry() {
        setTitle("Sales Manager System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);
        setLayout(new BorderLayout());
        
        
        
        JPanel inputPanel = new JPanel(new GridBagLayout()); 
        add(inputPanel, BorderLayout.NORTH);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST; 
        
        txtItemID = new JLabel("ItemID:");
        fieldItemID = new JTextField(15);
        txtQuantitySold = new JLabel("Quantity Sold:");
        fieldQuantitySold = new JTextField(15);
        txtPrice = new JLabel("Price:");
        fieldPrice = new JTextField(15);
        txtDate = new JLabel("Date:");
        fieldDate = new JTextField(15);
        txtSalesManager = new JLabel("SalesManager ID:");
        fieldSalesManager = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(txtItemID, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(fieldItemID, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(txtQuantitySold, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(fieldQuantitySold, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(txtPrice, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(fieldPrice, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(txtDate, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(fieldDate, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(txtSalesManager, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        inputPanel.add(fieldSalesManager, gbc);

        txtItemID.setPreferredSize(new Dimension(150, 30));  
        fieldItemID.setPreferredSize(new Dimension(150, 30));
        txtQuantitySold.setPreferredSize(new Dimension(150, 30));
        fieldQuantitySold.setPreferredSize(new Dimension(150, 30));
        txtPrice.setPreferredSize(new Dimension(150, 30)); 
        fieldPrice.setPreferredSize(new Dimension(150, 30));
        txtDate.setPreferredSize(new Dimension(150, 30)); 
        fieldDate.setPreferredSize(new Dimension(150, 30));
        txtSalesManager.setPreferredSize(new Dimension(150, 30)); 
        fieldSalesManager.setPreferredSize(new Dimension(150, 30));        
        
        JPanel buttonPanel = new JPanel(new GridBagLayout()); 

        JButton btnAdd = new JButton("Add");
        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");
        JButton btnReport = new JButton("Show SalesReport");
        JButton btnExit = new JButton("Exit");
        

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnReport);
        buttonPanel.add(btnExit);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        buttonPanel.add(btnAdd, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        buttonPanel.add(btnEdit, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        buttonPanel.add(btnDelete, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        buttonPanel.add(btnReport, gbc);
        gbc.gridx = 5;
        gbc.gridy = 0;
        buttonPanel.add(btnExit, gbc);

        add(buttonPanel, BorderLayout.SOUTH);
        
        String[] columnNames = {"SalesID", "ItemID", "Quantity", 
            "Price", "Total Price", "Date", "SalesManager ID"};
        tableModel = new DefaultTableModel(columnNames, 0);
        salesTable = new JTable(tableModel);
        add(new JScrollPane(salesTable), BorderLayout.CENTER);
        
        loadSalesEntriesFromFile();
        
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSalesEntry();
            }
        });
        
        salesTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            int selectedRow = salesTable.getSelectedRow();
                if (selectedRow != -1) {
                    fieldItemID.setText((String) tableModel.getValueAt(selectedRow, 1));   // ItemID
                    fieldQuantitySold.setText(String.valueOf(tableModel.getValueAt(selectedRow, 3))); // Quantity Sold
                    fieldPrice.setText(String.valueOf(tableModel.getValueAt(selectedRow, 4))); 
                    fieldDate.setText((String) tableModel.getValueAt(selectedRow, 7));  // Price
                    fieldSalesManager.setText((String) tableModel.getValueAt(selectedRow, 8));       // SalesManager ID

                }
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editSalesEntry();
                updateEntryFile();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSalesEntry();
                updateEntryFile();
            }
        });

        btnReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUISalesReport guiSalesReport = new GUISalesReport();
            };
        });
        
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GUIMain guimain = new GUIMain();
                guimain.setVisible(true);
            };
        });

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    
    private void addSalesEntry() {
        try {
            String itemID = fieldItemID.getText().trim();
            int quantitySold = Integer.parseInt(fieldQuantitySold.getText().trim());
            int price = Integer.parseInt(fieldPrice.getText().trim());
            int totalPrice = quantitySold * price;

            // Get the date from the input field
            String dateString = fieldDate.getText().trim();
            String salesManagerID = fieldSalesManager.getText().trim();

            // Validate the date format (e.g., dd/MM/yyyy)
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);  // Make the date validation strict
            Date date = null;
            try {
                date = sdf.parse(dateString);  // Attempt to parse the date
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Generate incremented salesID (e.g., SA001, SA002, etc.)
            String salesID = generateSalesID();

            // Check if the itemID exists in listofitems.txt
            if (!itemIDExists(itemID)) {
                JOptionPane.showMessageDialog(this, "ItemID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // If itemID exists, create a new SalesEntry object and add it to the table
            SalesEntry sales = new SalesEntry(salesID, itemID, price, quantitySold, 
                    totalPrice, sdf.format(date), salesManagerID);

            // Add new row to the table
            tableModel.addRow(new Object[]{salesID, itemID, quantitySold, price, totalPrice, sdf.format(date), salesManagerID});

            // Add the new sales entry to the file
            saveSalesEntryToFile();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Clear input fields
        fieldItemID.setText("");
        fieldQuantitySold.setText("");
        fieldPrice.setText("");
        fieldDate.setText("");
        fieldSalesManager.setText("");
    }

    private void editSalesEntry() {
        int selectedRow = salesTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "No row selected!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String itemID = fieldItemID.getText().trim();
            int quantitySold = Integer.parseInt(fieldQuantitySold.getText().trim());
            int price = Integer.parseInt(fieldPrice.getText().trim());
            String date = fieldDate.getText().trim();
            String salesManagerID = fieldSalesManager.getText().trim();

            if (itemID.isEmpty() || salesManagerID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int totalPrice = quantitySold * price;

            // Update table data
            tableModel.setValueAt(itemID, selectedRow, 1);
            tableModel.setValueAt(quantitySold, selectedRow, 2);
            tableModel.setValueAt(price, selectedRow, 3);
            tableModel.setValueAt(totalPrice, selectedRow, 4);
            tableModel.setValueAt(date, selectedRow, 5);
            tableModel.setValueAt(salesManagerID, selectedRow, 6);

            // Save updated entries to file
            saveSalesEntryToFile();

            JOptionPane.showMessageDialog(this, "Sales entry updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Clear input fields after editing
        fieldItemID.setText("");
        fieldQuantitySold.setText("");
        fieldPrice.setText("");
        fieldDate.setText("");
        fieldSalesManager.setText("");
    }

    private void deleteSalesEntry() {
        int selectedRow = salesTable.getSelectedRow();

        if (selectedRow != -1) {
            // Remove selected row from table
            tableModel.removeRow(selectedRow);

            // Save the updated data back to file
            saveSalesEntryToFile();
        } else {
            JOptionPane.showMessageDialog(this, "No row selected!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Clear input fields after deletion
        fieldItemID.setText("");
        fieldQuantitySold.setText("");
        fieldPrice.setText("");
        fieldDate.setText("");
        fieldSalesManager.setText("");
    }

    private void saveSalesEntryToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SalesEntryFile, false))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String salesID = (String) tableModel.getValueAt(i, 0);
                String itemID = (String) tableModel.getValueAt(i, 1);
                String quantitySold = String.valueOf(tableModel.getValueAt(i, 2));
                String price = String.valueOf(tableModel.getValueAt(i, 3));
                String totalPrice = String.valueOf(tableModel.getValueAt(i, 4));
                String date = (String) tableModel.getValueAt(i, 5);
                String salesManagerID = (String) tableModel.getValueAt(i, 6);

                writer.write(salesID + "," + itemID + "," + quantitySold + "," + price + "," + totalPrice + "," + date + "," + salesManagerID);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean itemIDExists(String itemID) {
        try (BufferedReader reader = new BufferedReader(new FileReader(itemsFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > 0 && parts[0].equals(itemID)) {
                    return true;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private String generateSalesID() {
        int newID = 1;  // Default start value
        Set<String> existingSalesIDs = new HashSet<>();  // To track existing salesIDs

        try (BufferedReader reader = new BufferedReader(new FileReader(SalesEntryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String salesID = parts[0];
                if (salesID.startsWith("SA")) {
                    existingSalesIDs.add(salesID);
                    try {
                        int currentID = Integer.parseInt(salesID.substring(2));
                        // Extract numeric part
                        newID = Math.max(newID, currentID + 1);  
                        // Increment to the next ID
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Ensure that the generated salesID is unique
        String generatedSalesID = String.format("SA%03d", newID);
        while (existingSalesIDs.contains(generatedSalesID)) {
            newID++;
            generatedSalesID = String.format("SA%03d", newID);
        }

        return generatedSalesID;
    }
    
    public void updateEntryFile() {
        File inputFile = new File(SalesEntryFile);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(inputFile, false))) {
            for (int i = 0; i < salesTable.getRowCount(); i++) {
                String[] parts = new String[7];
                parts[0] = String.valueOf(tableModel.getValueAt(i, 0));
                parts[1] = String.valueOf(tableModel.getValueAt(i, 1));
                parts[2] = String.valueOf(tableModel.getValueAt(i, 2));
                parts[3] = String.valueOf(tableModel.getValueAt(i, 3));
                parts[4] = String.valueOf(tableModel.getValueAt(i, 4));
                parts[5] = String.valueOf(tableModel.getValueAt(i, 5));
                parts[6] = String.valueOf(tableModel.getValueAt(i, 6));                 
                
                bw.write(parts[0]+ "," +parts[1]+ ","  +parts[2]+ "," +parts[3]+ "," +parts[4]+ "," +parts[5]+ "," +parts[6]);
                bw.newLine();
            }                               
        } 
        catch (IOException ex) {
            Logger.getLogger(GUISalesEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadSalesEntriesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SalesEntryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 7) {
                    String salesID = parts[0];
                    String itemID = parts[1];
                    String quantitySold = parts[2];
                    String price = parts[3];
                    String totalPrice = parts[4];
                    String date = parts[5];
                    String salesManagerID = parts[6];

                    // Add each entry to the table
                    tableModel.addRow(new Object[]{salesID, itemID, quantitySold, price, totalPrice, date, salesManagerID});
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new GUISalesEntry();
    }
}
