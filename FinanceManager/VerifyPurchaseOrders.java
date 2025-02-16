package FinanceManager;

import javax.swing.*;
import java.awt.*;

public class VerifyPurchaseOrders extends JFrame {
    private DefaultListModel<String> poListModel;
    private JList<String> poList;

    public VerifyPurchaseOrders() {
        setTitle("Verify Purchase Orders");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        poListModel = new DefaultListModel<>();
        updateListModel();

        poList = new JList<>(poListModel);
        add(new JScrollPane(poList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton approveButton = new JButton("Approve");
        JButton rejectButton = new JButton("Reject");
        JButton backButton = new JButton("Back");
        buttonPanel.add(approveButton);
        buttonPanel.add(rejectButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        approveButton.addActionListener(e -> updateStatus("Approved"));
        rejectButton.addActionListener(e -> updateStatus("Rejected"));
        backButton.addActionListener(e -> returnToMenu());

        setVisible(true);
    }

    private void updateStatus(String status) {
        int index = poList.getSelectedIndex();
        if (index != -1) {
            DataManager.PurchaseOrder selectedPO = DataManager.purchaseOrders.get(index);
            DataManager.updatePOStatus(selectedPO.poID, status);
            JOptionPane.showMessageDialog(this, "Purchase Order " + selectedPO.poID + " has been " + status, "Status Update", JOptionPane.INFORMATION_MESSAGE);
            updateListModel();
        } else {
            JOptionPane.showMessageDialog(this, "Please select a Purchase Order to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateListModel() {
        poListModel.clear();
        for (DataManager.PurchaseOrder po : DataManager.purchaseOrders) {
            if (!"Paid".equalsIgnoreCase(po.status)) {
                poListModel.addElement(po.toString());
            }
        }
    }

    private void returnToMenu() {
        this.setVisible(false);  // Hide or dispose this window
        new FinanceManagerMenu().setVisible(true);  // Assume FinanceManagerMenu is another JFrame that should be shown
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VerifyPurchaseOrders().setVisible(true));
    }
}
