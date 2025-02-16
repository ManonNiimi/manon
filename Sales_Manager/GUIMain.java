package Sales_Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;
import Administrator.*;

public class GUIMain extends JFrame {
    private static final String itemsFile = "listofitems.txt";
    private static final String poFile = "purchaseorder.txt";
    
    public GUIMain() {
        setTitle("Main Menu-Sales Manager-");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10)); 

        JButton viewItemsButton = new JButton("View List of Item");
        JButton salesEntryButton = new JButton("Sales Entry");
        JButton viewPurchaseOrdersButton = new JButton("View List of Purchase Order");
        JButton requisitionButton = new JButton("Requisition");
        JButton logoutButton = new JButton("Logout");

        buttonPanel.add(viewItemsButton);
        buttonPanel.add(salesEntryButton);
        buttonPanel.add(viewPurchaseOrdersButton);
        buttonPanel.add(requisitionButton);
        buttonPanel.add(logoutButton);

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        add(buttonPanel, BorderLayout.CENTER);

        viewItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showItemsTable();
            }
        });

        salesEntryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sales Entry clicked!");
                GUISalesEntry guisalesentry = new GUISalesEntry();
            }
        });

        viewPurchaseOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "View List of Purchase Order clicked!");
                viewPurchaseOrders();
            }
        });
        
        requisitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Requisition clicked!");
                new GUIRequisition();
            }
        });

        logoutButton.addActionListener(new ActionListener() { // Add action for logout button
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to logout?",
                        "Logout",
                        JOptionPane.YES_NO_OPTION
                       
                );
                if (confirm == JOptionPane.YES_OPTION) {
                    dispose();
                    login_page loginpage = new login_page();
                    loginpage.setVisible(true);
                }
            }
        });

        setLocationRelativeTo(null);
    }

    private void showItemsTable() {
        try {
            File file = new File(itemsFile);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "Not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] columnNames = {"Item ID", "Item Name", "Price", "Supplier ID"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                tableModel.addRow(data);
            }
            
            br.close();

            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(500, 300));

            JOptionPane.showMessageDialog(this, scrollPane, "List of Items", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void viewPurchaseOrders(){
        try {
            File file = new File(poFile);
            if (!file.exists()) {
                JOptionPane.showMessageDialog(this, "Not found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            String[] columnNames = {"Purchase Order ID", "Purchase Requisition ID", "Purchase Manager ID", "Status"};
            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                tableModel.addRow(data);
            }
            
            br.close();

            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(500, 300));

            JOptionPane.showMessageDialog(this, scrollPane, "List of Items", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
     
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIMain().setVisible(true);
            }
        });
    }
}