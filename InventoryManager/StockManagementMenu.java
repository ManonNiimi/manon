/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author minam
 */

import javax.swing.JOptionPane;
import java.util.Map;

public class StockManagementMenu extends javax.swing.JFrame {

    /**
     * Creates new form StockManagementMenu
     */
    
    private DataManager dataManager = new DataManager();
    
    public StockManagementMenu() {
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

        exitstockmanagementbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        viewstocklevelbtn = new javax.swing.JButton();
        updatestocklevelbtn = new javax.swing.JButton();
        exporttxtfilebtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitstockmanagementbtn.setText("exit");
        exitstockmanagementbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitstockmanagementbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setText("-- Stock Management --");

        viewstocklevelbtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        viewstocklevelbtn.setText("1. View Stock Levels");
        viewstocklevelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewstocklevelbtnActionPerformed(evt);
            }
        });

        updatestocklevelbtn.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        updatestocklevelbtn.setText("2. Update Stock Levels");
        updatestocklevelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatestocklevelbtnActionPerformed(evt);
            }
        });

        exporttxtfilebtn.setText("export");
        exporttxtfilebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exporttxtfilebtnActionPerformed(evt);
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
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatestocklevelbtn)
                    .addComponent(viewstocklevelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(exitstockmanagementbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exporttxtfilebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(viewstocklevelbtn)
                .addGap(44, 44, 44)
                .addComponent(updatestocklevelbtn)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitstockmanagementbtn)
                    .addComponent(exporttxtfilebtn))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitstockmanagementbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitstockmanagementbtnActionPerformed
        // TODO add your handling code here:
         new InventoryMenu().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_exitstockmanagementbtnActionPerformed

    private void viewstocklevelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewstocklevelbtnActionPerformed
        // TODO add your handling code here:
        // 在庫レベル情報を取得（例: Map<String, Integer>の形式で取得するメソッドがある場合）
        Map<String, Integer> stockLevels = dataManager.getInstance().getAllItemsWithStockLevels();

        // メッセージ用の文字列を作成
        StringBuilder message = new StringBuilder("Current Stock Levels:\n");
        for (Map.Entry<String, Integer> entry : stockLevels.entrySet()) {
            String itemId = entry.getKey();
            String itemName = DataManager.getInstance().getItemName(itemId);  // アイテム名を取得
            int stockLevel = entry.getValue();
            
            
            message.append("Item ID: ").append(entry.getKey())
                   .append(", Name: ").append(itemName != null ? itemName : "Unknown")
                   .append(", Stock Level: ").append(stockLevel)
                   .append("\n");
        }
        
        // デバッグ出力
        System.out.println("Displaying stock levels:\n" + message.toString());

        // メッセージボックスで表示
        JOptionPane.showMessageDialog(this, message.toString(), "Stock Levels", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_viewstocklevelbtnActionPerformed

    private void updatestocklevelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatestocklevelbtnActionPerformed
        // TODO add your handling code here:
        new UpdateStockLevel().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_updatestocklevelbtnActionPerformed

    private void exporttxtfilebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exporttxtfilebtnActionPerformed
        // TODO add your handling code here:
        // データマネージャのインスタンスを取得
        DataManager dataManager = DataManager.getInstance();
    
        // ファイル出力用のオブジェクト
        java.io.FileWriter fileWriter = null;
        java.io.PrintWriter printWriter = null;

        try {
            // 出力先のファイルパスとファイル名を指定
            String filePath = "StockLevels.txt";

            // ファイルライターとプリントライターを作成
            fileWriter = new java.io.FileWriter(filePath);
            printWriter = new java.io.PrintWriter(fileWriter);

            // 在庫情報を取得
            Map<String, Integer> stockLevels = dataManager.getAllItemsWithStockLevels();

            // ファイルにヘッダーを書き込む
            printWriter.println("Item ID\tStock Level");

            // 在庫情報をファイルに書き込む
            for (Map.Entry<String, Integer> entry : stockLevels.entrySet()) {
                String itemId = entry.getKey();
                int stockLevel = entry.getValue();
                printWriter.println(itemId + "\t" + stockLevel);
            }

            // 成功メッセージを表示
            JOptionPane.showMessageDialog(this, "Stock levels have been successfully exported to " + filePath);

        } catch (Exception e) {
            // エラーメッセージを表示
            JOptionPane.showMessageDialog(this, "Error occurred while exporting stock levels: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) printWriter.close();
                if (fileWriter != null) fileWriter.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_exporttxtfilebtnActionPerformed

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
            java.util.logging.Logger.getLogger(StockManagementMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockManagementMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockManagementMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockManagementMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockManagementMenu().setVisible(true);
            }
        });
    }
    
    private void exportStockLevelBtnActionPerformed(java.awt.event.ActionEvent evt) {
        DataManager dataManager = DataManager.getInstance();
        String filePath = "stock_levels.txt"; // 保存するファイル名
        dataManager.exportStockLevelsToFile(filePath);
        JOptionPane.showMessageDialog(this, "Stock levels exported to " + filePath);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitstockmanagementbtn;
    private javax.swing.JButton exporttxtfilebtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton updatestocklevelbtn;
    private javax.swing.JButton viewstocklevelbtn;
    // End of variables declaration//GEN-END:variables
}
