/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sales_Manager;

public class Items {
    private String itemID;
    private String name;
    private int price;
    private int stocklevel;
    private int reorderlevel;
    
    public Items(String itemID,String name,int price,int stocklevel,int reorderlevel){
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.stocklevel = stocklevel;
        this.reorderlevel = reorderlevel;
    }
    
    public String getItemID(){return itemID;}
    
    public String getName(){return name;}
    
    public int getPrice() {return price;}
    
    public int getStocklevel() {return stocklevel;}
    
    public int getReorder() {return reorderlevel;}
    
    public void setStocklevel(int stocklevel){
        this.stocklevel = stocklevel;
    }
    
    public boolean Reorderlevel() {
        return stocklevel < reorderlevel;
    }
    
    @Override
    public String toString(){
        return "Item:{" + "ID:" +itemID+ "ItemName:" +name+ "Price:" +price+ 
                "Stock:" +stocklevel+  "ReorderLevel:" +reorderlevel+ "}";
    }
}
