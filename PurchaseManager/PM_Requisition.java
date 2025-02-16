
package PurchaseManager;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PM_Requisition {
    private String requisitionID;
    private String itemID;
    private String quantityRequired;
    private String date;
    private String salesManagerID;
    private static String itemsFile = "listofitems.txt";
    private static String RequisitionFile = "Requisition.txt";       
    //Pls check filepath of txt files in case of loading error//
   
    public PM_Requisition(String requisitionID, String itemID, String quantityRequired, String date, String salesManagerID){
        this.requisitionID = requisitionID;
        this.itemID = itemID;
        this.quantityRequired = quantityRequired;
        this.date = date;
        this.salesManagerID = salesManagerID;
    }       
    
    public void addToFile(String[] requisitionList){   
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RequisitionFile, false))){
            for (String requisition: requisitionList) {
                bw.write(requisition);
                bw.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(PM_SalesEntry.class.getName()).log(Level.SEVERE, null, ex);
        }    
    } 
 
    public String fetchItemName() {
        try (Scanner scanner = new Scanner(new File(itemsFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(itemID)) {
                    return parts[1];
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PM_SalesEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public String getRequisitionID(){return requisitionID;}
    
    public String getItemID(){return itemID;}
    
    public String getQuantityRequired(){return quantityRequired;}
    
    public String getSalesDate(){return date;}
    
    public String getSalesManagerID(){return salesManagerID;}
    
    @Override
    public String toString(){
        return "Requisition{" + "RequisitionID: " +requisitionID+ "ItemID: " 
                +itemID+ "RequiredQuantity: " +quantityRequired+ "}";
    }
}
