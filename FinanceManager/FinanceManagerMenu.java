package FinanceManager;

import Administrator.*;
import javax.swing.*;
import java.awt.*;

public class FinanceManagerMenu extends JFrame {

    public FinanceManagerMenu() {
        setTitle("Finance Manager Menu");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Header Label
        JLabel headerLabel = new JLabel("-- Finance Manager Menu --", SwingConstants.CENTER);
        headerLabel.setBounds(50, 20, 300, 30);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(headerLabel);

        // Buttons for Each Option
        JButton verifyPOButton = new JButton("Verify Purchase Orders");
        verifyPOButton.setBounds(100, 70, 200, 40);
        add(verifyPOButton);

        JButton checkStockButton = new JButton("Check Stock Status");
        checkStockButton.setBounds(100, 120, 200, 40);
        add(checkStockButton);

        JButton makePaymentButton = new JButton("Make Payment");
        makePaymentButton.setBounds(100, 170, 200, 40);
        add(makePaymentButton);

        JButton viewSupplierStatusButton = new JButton("View Supplier Payment Status");
        viewSupplierStatusButton.setBounds(100, 220, 200, 40);
        add(viewSupplierStatusButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 270, 200, 40);
        add(exitButton);

        // Action Listeners for Buttons
        verifyPOButton.addActionListener(e -> {
            new VerifyPurchaseOrders();
            dispose();
        });

        checkStockButton.addActionListener(e -> {
            new CheckStockStatus();
            dispose();
        });

        makePaymentButton.addActionListener(e -> {
            new MakePayment();
            dispose();
        });

        viewSupplierStatusButton.addActionListener(e -> {
            new ViewSupplierPaymentStatus();
            dispose();
            
        });

        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Exiting Program.");
            dispose();
            login_page login = new login_page();
            login.setVisible(true);
            
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FinanceManagerMenu();
    }
}
