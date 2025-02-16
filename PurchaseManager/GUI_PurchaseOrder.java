
package PurchaseManager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class GUI_PurchaseOrder extends javax.swing.JPanel {
    private ArrayList<PM_PurchaseOrder> purchaseOrders; // List to hold purchase orders
    private int poCount = 1;
    
    
    




        /**
         * Creates new form GUI_PurchaseOrder
         */
        public GUI_PurchaseOrder() {
            purchaseOrders = new ArrayList<>();
            initComponents();
            loadRequisitionsFromFile();
            loadPurchaseOrdersFromFile();
        }

        private void loadRequisitionsFromFile() {
            try (Scanner scanner = new Scanner(new File("Requisition.txt"))) {
                //Pls check filepath if requisiton table doesnt load//
                DefaultTableModel model = (DefaultTableModel) reqtable.getModel();


                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] parts = line.split(",");

                    // Ensure there are exactly 5 columns in each line before adding to the table
                    if (parts.length == 5) {
                        model.addRow(parts);
                    }
                }

                
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "File not found: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void loadPurchaseOrdersFromFile() {
            try (BufferedReader reader = new BufferedReader(new FileReader("purchaseorder.txt"))) {
                String line;
                DefaultTableModel model = (DefaultTableModel) potable.getModel();
                int maxPoNumber = 0;
                
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) { // Ensure we have all columns
                        model.addRow(parts);
                        purchaseOrders.add(new PM_PurchaseOrder(parts[0], parts[1], parts[2], parts[3]));
                    
                        String poID = parts[0];
                        int poNumber = Integer.parseInt(poID.substring(2));
                        maxPoNumber = Math.max(maxPoNumber, poNumber);
                    
                    
                    }
                }
                
                poCount = maxPoNumber + 1;
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void addPurchaseOrder() throws IOException{
            int row = reqtable.getSelectedRow();
            if(row != -1){
                String requisitionID = (String) reqtable.getValueAt(row,0);

                String poID = "PO" + String.format("%03d", poCount++);

                String generatedBy = generatedtxt.getText();
                String status = (String) statuscmb.getSelectedItem();

                PM_PurchaseOrder po = new PM_PurchaseOrder(poID, requisitionID, generatedBy, status);

                purchaseOrders.add(po);
                DefaultTableModel model = (DefaultTableModel) potable.getModel();
                model.addRow(new Object[]{po.getpoID(), po.getRequisitionID(), po.getGeneratedBy(), po.getStatus()});

                appendPurchaseOrder(po);



            }else{
                JOptionPane.showMessageDialog(this, "Please select a row from the Requisition Table to add a PO.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void appendPurchaseOrder(PM_PurchaseOrder po) throws IOException{
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("purchaseorder.txt",true))){
                writer.write(po.getpoID() + "," + po.getRequisitionID() + "," + po.getGeneratedBy() + "," + po.getStatus());
                writer.newLine();
            }catch (IOException e){
                e.printStackTrace();

            }
        }
        
        private void deleteRow() {
            int selectedRow = potable.getSelectedRow(); // Get the selected row index

            if (selectedRow != -1) { // Check if a row is selected
                DefaultTableModel model = (DefaultTableModel) potable.getModel();
                String poIDToDelete = (String) model.getValueAt(selectedRow, 0); // Get the PO ID of the selected row

                // Remove the row from the table
                model.removeRow(selectedRow);

                // Remove the corresponding PO from the list
                purchaseOrders.removeIf(po -> po.getpoID().equals(poIDToDelete));

                // Update the file
                try {
                    updateFileAfterDeletion();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row from the PO Table to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        private void updateFileAfterDeletion() throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("purchaseorder.txt"))) {
                DefaultTableModel model = (DefaultTableModel) potable.getModel();

                // Write each row back into the file
                for (int i = 0; i < model.getRowCount(); i++) {
                    String poID = (String) model.getValueAt(i, 0);
                    String requisitionID = (String) model.getValueAt(i, 1);
                    String generatedBy = (String) model.getValueAt(i, 2);
                    String status = (String) model.getValueAt(i, 3);

                    // Write this row's data to the file
                    writer.write(poID + "," + requisitionID + "," + generatedBy + "," + status);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

        private void updatePurchaseOrderInFile(int rowIndex, String updatedStatus) {
            DefaultTableModel model = (DefaultTableModel) potable.getModel();
            try {
                File inputFile = new File("purchaseorder.txt");
                File tempFile = new File("temp_purchaseorder.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String line;
                int currentRow = 0;

                while ((line = reader.readLine()) != null) {
                    if (currentRow == rowIndex) {
                        // Replace the line for the updated row
                        String poID = (String) model.getValueAt(rowIndex, 0);
                        String requisitionID = (String) model.getValueAt(rowIndex, 1);
                        String description = (String) model.getValueAt(rowIndex, 2);
                        writer.write(poID + "," + requisitionID + "," + description + "," + updatedStatus);
                    } else {
                        writer.write(line); // Write the unchanged line
                    }
                    writer.newLine();
                    currentRow++;
                }

                reader.close();
                writer.close();

                // Replace the old file with the updated one
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        reqtable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        potable = new javax.swing.JTable();
        statuscmb = new javax.swing.JComboBox<>();
        generatedtxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        addbtn1 = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Purchase Order");
        add(jLabel1);
        jLabel1.setBounds(160, 60, 190, 32);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(6, 9, 72, 23);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Purchase Order Table");
        add(jLabel2);
        jLabel2.setBounds(660, 170, 230, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Purchase Requistion Table");
        add(jLabel3);
        jLabel3.setBounds(150, 170, 280, 25);

        reqtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Requisition ID", "Item ID", "Quantity", "Date", "Sales Manager"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(reqtable);

        add(jScrollPane3);
        jScrollPane3.setBounds(50, 210, 474, 402);

        potable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Order ID", "Requisition ID", "Generated by", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(potable);

        add(jScrollPane1);
        jScrollPane1.setBounds(560, 210, 452, 402);

        statuscmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Approved", "Rejected","Pending" }));
        statuscmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statuscmbActionPerformed(evt);
            }
        });
        add(statuscmb);
        statuscmb.setBounds(830, 80, 183, 22);

        generatedtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatedtxtActionPerformed(evt);
            }
        });
        add(generatedtxt);
        generatedtxt.setBounds(830, 40, 183, 22);

        jLabel4.setText("Status : ");
        add(jLabel4);
        jLabel4.setBounds(740, 80, 80, 16);

        jLabel5.setText("Generated by : ");
        add(jLabel5);
        jLabel5.setBounds(720, 40, 100, 16);

        addbtn1.setText("Add");
        addbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtn1ActionPerformed(evt);
            }
        });
        add(addbtn1);
        addbtn1.setBounds(940, 110, 72, 23);

        deletebtn.setText("Delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        add(deletebtn);
        deletebtn.setBounds(940, 140, 72, 23);
        add(jLabel6);
        jLabel6.setBounds(-10, 530, 1120, 190);

        jLabel8.setText(" e.g. : PM001");
        add(jLabel8);
        jLabel8.setBounds(830, 60, 70, 16);
        add(jLabel9);
        jLabel9.setBounds(700, 60, 0, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        javax.swing.SwingUtilities.getWindowAncestor(this).dispose();
        PMmenu PMmenupage = new PMmenu();
        PMmenupage.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void generatedtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatedtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generatedtxtActionPerformed

    private void addbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtn1ActionPerformed
        try {
            addPurchaseOrder();
        } catch (IOException ex) {
            Logger.getLogger(GUI_PurchaseOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addbtn1ActionPerformed

    private void statuscmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statuscmbActionPerformed
        int row = potable.getSelectedRow();
        if (row != -1) {
            String updatedStatus = (String) statuscmb.getSelectedItem();
            potable.setValueAt(updatedStatus, row, 3); // Update status column

            // Update the file by rewriting only the changed row
            updatePurchaseOrderInFile(row, updatedStatus);
        }
    }//GEN-LAST:event_statuscmbActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
        deleteRow();
        
    }//GEN-LAST:event_deletebtnActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    javax.swing.JFrame frame = new javax.swing.JFrame("Purchase Order Management");
                    frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

                    // Debugging: Ensure GUI_PurchaseOrder is instantiated without issues
                    GUI_PurchaseOrder purchaseOrderPanel = new GUI_PurchaseOrder();
                    frame.setContentPane(purchaseOrderPanel); // Attach the GUI to the frame

                    frame.setSize(1000, 800);  // Set desired size
                    frame.setLocation(0, 0);  // Set top-left corner position
                    frame.setVisible(true);   // Show frame
                } catch (Exception e) {
                    e.printStackTrace(); // Print any errors during runtime
                }
            }
        });
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn1;
    private javax.swing.JButton deletebtn;
    private javax.swing.JTextField generatedtxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable potable;
    private javax.swing.JTable reqtable;
    private javax.swing.JComboBox<String> statuscmb;
    // End of variables declaration//GEN-END:variables
}
