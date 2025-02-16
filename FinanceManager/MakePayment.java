package FinanceManager;

import javax.swing.*;
import java.awt.*;

public class MakePayment extends JFrame {
    private DefaultListModel<String> poListModel;
    private JList<String> poList;

    public MakePayment() {
        setTitle("Make Payment");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        poListModel = new DefaultListModel<>();
        updateListModel();

        poList = new JList<>(poListModel);
        add(new JScrollPane(poList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton markPaidButton = new JButton("Mark as Paid");
        JButton backButton = new JButton("Back");
        buttonPanel.add(markPaidButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        markPaidButton.addActionListener(e -> markAsPaid());
        backButton.addActionListener(e -> returnToMenu());

        setVisible(true);
    }

    private void markAsPaid() {
        int index = poList.getSelectedIndex();
        if (index != -1) {
            DataManager.PurchaseOrder selectedPO = DataManager.getApprovedPurchaseOrders().get(index);
            DataManager.updatePOStatus(selectedPO.poID, "Paid");
            JOptionPane.showMessageDialog(this, "Order " + selectedPO.poID + " marked as Paid!", "Payment Status", JOptionPane.INFORMATION_MESSAGE);
            updateListModel();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an order to mark as Paid.", "Selection Needed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateListModel() {
        poListModel.clear();
        for (DataManager.PurchaseOrder po : DataManager.getApprovedPurchaseOrders()) {
            poListModel.addElement(po.toString());
        }
    }

    private void returnToMenu() {
        this.setVisible(false);  // Hide or close the current window
        new FinanceManagerMenu().setVisible(true);  // Redirect to the main menu
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MakePayment().setVisible(true));
    }
}
