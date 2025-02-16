/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales_Manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalesEntry {
    private static String itemsFile = "listofitems.txt";
    private String SalesEntryFile = "SalesEntry.txt";       
    private String salesID;
    private String itemID;
    private int price;
    private int quantitysold;
    private int totalprice;
    private String salesdate;
    private String salesManagerID;
    
    public SalesEntry(String salesID,String itemID,int price,int quantitysold,int totalprice,String salesdate, String salesManagerID){
        this.salesID = salesID;
        this.itemID = itemID;
        this.price = price;
        this.quantitysold = quantitysold;
        this.totalprice = totalprice;
        this.salesdate = salesdate;
        this.salesManagerID = salesManagerID;       
    }
    
    public void addToFile(String[] salesList){   
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SalesEntryFile, false))){
            for (String sales: salesList) {
                bw.write(sales);
                bw.newLine();
            }
        } catch (IOException ex) {
            //Logger.getLogger(SalesEntry.class.getID()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public String fetchItemID() {
        try (Scanner scanner = new Scanner(new File(itemsFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(itemID)) {
                    return parts[1];
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(SalesEntry.class.getID()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     
    public static void updateStockLevel(String itemID, int newStockLevel) {
        File inputFile = new File(itemsFile);
        File tempFile = new File("Items_temp.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile, false))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(itemID)) {
                    parts[3] = String.valueOf(newStockLevel);
                    line = String.join(",", parts);
                }
                bw.write(line);
                bw.newLine();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        if (!inputFile.delete()) {
            System.out.println("Failed to delete original file.");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Failed to rename temp file.");
        }
    }
    
    public String getSalesID(){return salesID;}
    
    public String getItemID(){return itemID;}
    
    public int getPrice(){return price;}
    
    public int getQuantitysold(){return quantitysold;}
    
    public int getTotalPrice(){return totalprice;}
    
    public String getSalesDate(){return salesdate;}
    
    public String getSalesManagerID(){return salesManagerID;}
    
    @Override
    public String toString(){
        return "SalesEntry{" +"SalesID: " +salesID+ "ItemID: " +itemID+ "Price: " +price+ 
                "QuantitySold: " +quantitysold+ "TotalPrice: " +totalprice+ "Date: " +salesdate+ "SalesManagerID: " +salesManagerID+ "}";
    }
}
