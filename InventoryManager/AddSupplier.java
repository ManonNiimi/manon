/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InventoryManager;

import javax.swing.JOptionPane;

/**
 *
 * @author minam
 */
public class AddSupplier extends javax.swing.JFrame {

    /**
     * Creates new form AddSupplier
     */
    public AddSupplier() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entersupplierIDtxt = new javax.swing.JTextField();
        entersuppliernametxt = new javax.swing.JTextField();
        supplieraddsavebtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        entersuppliercontacttxt = new javax.swing.JTextField();
        exiteditbtn1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        entersupplierIDtxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        entersupplierIDtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entersupplierIDtxtActionPerformed(evt);
            }
        });

        entersuppliernametxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        entersuppliernametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entersuppliernametxtActionPerformed(evt);
            }
        });

        supplieraddsavebtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        supplieraddsavebtn.setText("save");
        supplieraddsavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplieraddsavebtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel2.setText("Enter Supplier ID (SP001)");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel3.setText("Enter Supplier Name");

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel4.setText("Enter Supplier Contact");

        entersuppliercontacttxt.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        entersuppliercontacttxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entersuppliercontacttxtActionPerformed(evt);
            }
        });

        exiteditbtn1.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        exiteditbtn1.setText("exit");
        exiteditbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exiteditbtn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(entersuppliernametxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entersupplierIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(entersuppliercontacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exiteditbtn1)
                        .addGap(153, 153, 153)
                        .addComponent(supplieraddsavebtn)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(entersupplierIDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(entersuppliernametxt)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(entersuppliercontacttxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exiteditbtn1)
                    .addComponent(supplieraddsavebtn))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entersupplierIDtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entersupplierIDtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entersupplierIDtxtActionPerformed

    private void entersuppliernametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entersuppliernametxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entersuppliernametxtActionPerformed

    private void supplieraddsavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplieraddsavebtnActionPerformed
        // TODO add your handling code here:
        DataManager dataManager = DataManager.getInstance();
        // Get item ID and name from text fields
        String supplierID = entersupplierIDtxt.getText().trim();
        String supplierName = entersuppliernametxt.getText().trim();
        String supplierContact = entersuppliercontacttxt.getText().trim();
        
        // Validate input
        if (!supplierID.isEmpty() && !supplierName.isEmpty()) {
            // Attempt to add item to DataManager
            if (dataManager.addSupplier(supplierID, supplierName, supplierContact)) {
                JOptionPane.showMessageDialog(this, "Supplier added successfully: ID = " + supplierID + ", Name = " + supplierName + "Contact: " + supplierContact);
                // Clear text fields
                entersupplierIDtxt.setText("");
                entersuppliernametxt.setText("");
                entersuppliercontacttxt.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Supplier ID already exists.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "All fields (ID, Name, Contact) must be filled.", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
                                        


    }//GEN-LAST:event_supplieraddsavebtnActionPerformed

    private void entersuppliercontacttxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entersuppliercontacttxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entersuppliercontacttxtActionPerformed

    private void exiteditbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exiteditbtn1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new SupplierEntryMenu().setVisible(true);
    }//GEN-LAST:event_exiteditbtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField entersupplierIDtxt;
    private javax.swing.JTextField entersuppliercontacttxt;
    private javax.swing.JTextField entersuppliernametxt;
    private javax.swing.JButton exiteditbtn1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton supplieraddsavebtn;
    // End of variables declaration//GEN-END:variables
}
