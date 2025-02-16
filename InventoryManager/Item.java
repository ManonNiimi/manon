/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

public class Item {
    private String itemId;
    private String name;
    private int stockLevel;

    // Constructor
    public Item(String itemId, String name, int stockLevel) {
        this.itemId = itemId;
        this.name = name;
        this.stockLevel = stockLevel;
    }

    // Getter and Setter for itemId
    public String getItemId() {
        return itemId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for stockLevel
    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}
