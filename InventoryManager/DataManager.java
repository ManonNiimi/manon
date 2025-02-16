/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author minam
 */

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataManager {
    // Map to store items with item ID as key
    private static DataManager instance;
    private Map<String, String> items;
    private Map<String, Integer> stockLevels;
    private Map<String, Supplier> suppliers;

    // Constructor
    public DataManager() {
        items = new HashMap<>();
        stockLevels = new HashMap<>();
        suppliers = new HashMap<>();
    }
    
    
    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        System.out.println("Returning DataManager instance: " + instance);
        return instance;
    }
    
    public boolean addSupplier(String supplierID, String supplierName, String supplierContact) {
        if (suppliers.containsKey(supplierID)) {
            return false;
        }
        suppliers.put(supplierID, new Supplier(supplierID, supplierName, supplierContact));
        System.out.println("Supplier added successfully");
        return true;
    }
    
    public Map<String, Supplier> getAllSuppliers() {
        return new HashMap<>(suppliers);
    }
    
    public boolean doesSupplierExist(String supplierID) {
        return suppliers.containsKey(supplierID);
    }
    
    public Supplier getSupplier(String supplierID) {
        return suppliers.get(supplierID);
    }
    
    
    public boolean editSupplier(String supplierID, String newName, String newContact) {
        Supplier supplier = suppliers.get(supplierID);
        if (supplier != null) {
            supplier.setName(newName);
            supplier.setContact(newContact);
            return true;
        }
        return false;
    }   
    
    public boolean deleteSupplier(String supplierID) {
        if (suppliers.containsKey(supplierID)) {
            suppliers.remove(supplierID);
            System.out.println("Supplier deleted: ID = " + supplierID);
            return true;
        }
        System.out.println("Supplier deletion failed: ID = " + supplierID + " not found.");
        return false;
    }


    // Method to add an item
    public boolean addItem(String itemId, String itemName) {
        if (items.containsKey(itemId)) {
            return false; // Item already exists
        }
        items.put(itemId, itemName);
        stockLevels.put(itemId, 0);
        System.out.println("Item added: ID = " + itemId + ", Name = " + itemName + ", Stock Level = 0");
        System.out.println("Current items map: " + items); // itemsマップの内容を表示
        return true;
    }
    
    // Method to get the stock level of an item
    public Integer getStockLevel(String itemId) {
        return stockLevels.getOrDefault(itemId, 0);
    }
    
    // アイテムを取得するメソッド
    public String getItem(String itemId) {
        if (items.containsKey(itemId)) {
            return items.get(itemId); // ItemクラスにgetItemNameが必要
        } else {
            return null; // アイテムが存在しない場合
        }
    }
    
    public String getItemName(String itemId) {
        System.out.println("Fetching item name for ID: " + itemId); // デバッグ出力
        String itemName = items.get(itemId);
        System.out.println("Found item name: " + (itemName != null ? itemName : "Unknown"));
        return itemName != null ? itemName : "Unknown";
}
    
    // Method to check if an item exists by its ID
    public boolean doesItemExist(String itemId) {
        return items.containsKey(itemId);
    }
    

    // Method to edit an item
    public boolean editItem(String itemId, String newItemName) {
        if (items.containsKey(itemId)) {
            items.put(itemId, newItemName);
            System.out.println("Item edited: ID = " + itemId + ", New Name = " + newItemName);
            return true;
        }
        return false; // Item not found
    }

    // Method to delete an item
    public boolean deleteItem(String itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
            stockLevels.remove(itemId);
            System.out.println("Item deleted: ID = " + itemId);
            return true;
        }
        return false; // Item not found
    }

    // Method to get all items (for displaying)
    public Map<String, Integer> getAllItemsWithStockLevels() {
        System.out.println("Returning stock levels: " + stockLevels); // デバッグ出力
        return new HashMap<>(stockLevels); // 在庫レベルのコピーを返す
    }
    
    public boolean updateStockLevel(String itemId, int newStockLevel) {
        if (stockLevels.containsKey(itemId)) {
            stockLevels.put(itemId, newStockLevel);
            return true;
        }
        return false;
    }
    
        // 新たにStock Levelをファイルに出力するメソッド
    public void exportStockLevelsToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Item ID\tStock Level\n");
            for (Map.Entry<String, Integer> entry : stockLevels.entrySet()) {
                writer.write(entry.getKey() + "\t" + entry.getValue() + "\n");
            }
            System.out.println("Stock levels exported successfully to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error exporting stock levels: " + e.getMessage());
        }
    }

    // テスト用: Stockレベル追加機能
    public void addStock(String itemId, int quantity) {
        stockLevels.put(itemId, quantity);
    }
}
