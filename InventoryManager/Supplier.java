/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package InventoryManager;

/**
 *
 * @author minam
 */
public class Supplier {
    private String id;
    private String name;
    private String contact;

    // Constructor
    public Supplier(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
