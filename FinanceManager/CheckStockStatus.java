package FinanceManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class CheckStockStatus extends JFrame {
    private JTextArea textArea;
    private JButton backButton;

    public CheckStockStatus() {
        setTitle("Check Stock Status");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        // TextArea to display the stock status
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 20, 340, 180);
        add(scrollPane);

        // Back button to return to the main menu
        backButton = new JButton("Back");
        backButton.setBounds(150, 220, 100, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FinanceManagerMenu();
                dispose();
            }
        });

        loadStockStatus(); // Load stock status from the new StockLevels.txt file
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadStockStatus() {
        ArrayList<String> stockData = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("StockLevels.txt"))) {
            String line;

            // Skip the header
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+"); // Split by whitespace
                if (parts.length == 2) { // Ensure valid format
                    String itemID = parts[0];
                    String stockLevel = parts[1];
                    stockData.add("Item ID: " + itemID + ", Stock Level: " + stockLevel);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading stock file!", "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Display the stock data in the JTextArea
        if (!stockData.isEmpty()) {
            for (String stock : stockData) {
                textArea.append(stock + "\n");
            }
        } else {
            textArea.append("No stock data available.");
        }
    }

    public static void main(String[] args) {
        new CheckStockStatus();
    }
}
