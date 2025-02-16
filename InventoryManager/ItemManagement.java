/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author minam
 */

public class ItemManagement extends javax.swing.JFrame {

    /**
     * Creates new form ItemManagement
     */
    public ItemManagement() {
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

        jLabel1 = new javax.swing.JLabel();
        additembtn = new javax.swing.JButton();
        edititembtn = new javax.swing.JButton();
        deleteitembtn = new javax.swing.JButton();
        exititemmanagementbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setText("-- Item Management --");

        additembtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        additembtn.setText("1. Add Item");
        additembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additembtnActionPerformed(evt);
            }
        });

        edititembtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        edititembtn.setText("2. Edit Item");
        edititembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edititembtnActionPerformed(evt);
            }
        });

        deleteitembtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        deleteitembtn.setText("3. Delete Item");
        deleteitembtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteitembtnActionPerformed(evt);
            }
        });

        exititemmanagementbtn.setText("exit");
        exititemmanagementbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exititemmanagementbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(deleteitembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edititembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(additembtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(exititemmanagementbtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(additembtn)
                .addGap(30, 30, 30)
                .addComponent(edititembtn)
                .addGap(32, 32, 32)
                .addComponent(deleteitembtn)
                .addGap(30, 30, 30)
                .addComponent(exititemmanagementbtn)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void additembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additembtnActionPerformed
        // TODO add your handling code here:
        // Add item form を表示
        new AddItem().setVisible(true);  // ItemManagement クラスのインスタンスを生成して表示
        this.dispose();  // 現在の InventoryMenu フレームを閉じる
    }//GEN-LAST:event_additembtnActionPerformed

    private void edititembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edititembtnActionPerformed
        // TODO add your handling code here:
        // Edit item form を表示
        new EditItem().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_edititembtnActionPerformed

    private void deleteitembtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteitembtnActionPerformed
        // TODO add your handling code here:
        // Delete item form　を表示
        new DeleteItem().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_deleteitembtnActionPerformed

    private void exititemmanagementbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exititemmanagementbtnActionPerformed
        // TODO add your handling code here:
        new InventoryMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_exititemmanagementbtnActionPerformed

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
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton additembtn;
    private javax.swing.JButton deleteitembtn;
    private javax.swing.JButton edititembtn;
    private javax.swing.JButton exititemmanagementbtn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
