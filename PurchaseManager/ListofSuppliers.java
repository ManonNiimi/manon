package PurchaseManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListofSuppliers {
   
    public void loadDataIntoTable(JTable listofsupplierstable, String filename){
        DefaultTableModel model = (DefaultTableModel) listofsupplierstable.getModel();
        model.setRowCount(0);

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null){
                String[] values = line.split(";");
                if(values.length >=4){
                    model.addRow(new Object[]{
                        values[0].trim(),
                        values[1].trim(),
                        values[2].trim(),
                        values[3].trim(),
                    }); 
                }
            }


        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error loading data: "+ e.getMessage()); 
        }
    }
    
    public void loadTableDataforGui(GUI_Suppliers gui, String filename){
        JTable table = gui.getListOfSuppliersTable();
        loadDataIntoTable(table, filename);
    }
      
}
