package FinanceManager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static final String FILE_PATH = "purchaseorder.txt";
    public static List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    static {
        loadPurchaseOrders();
    }

    public static class PurchaseOrder {
        String poID; // Primary Key
        String prID; // Foreign Key from Purchase Requisition
        String generatedBy; // User ID of the creator
        String status; // Approved, Rejected, or Paid

        public PurchaseOrder(String poID, String prID, String generatedBy, String status) {
            this.poID = poID;
            this.prID = prID;
            this.generatedBy = generatedBy;
            this.status = status;
        }

        @Override
        public String toString() {
            return String.format("%s, %s, %s, %s", poID, prID, generatedBy, status);
        }
    }

    public static void loadPurchaseOrders() {
        purchaseOrders.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    purchaseOrders.add(new PurchaseOrder(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePOStatus(String poID, String newStatus) {
        purchaseOrders.stream()
            .filter(po -> po.poID.equals(poID))
            .findFirst()
            .ifPresent(po -> po.status = newStatus);
        savePurchaseOrders();
    }

    public static void savePurchaseOrders() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (PurchaseOrder po : purchaseOrders) {
                bw.write(String.format("%s,%s,%s,%s", po.poID, po.prID, po.generatedBy, po.status));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PurchaseOrder> getApprovedPurchaseOrders() {
        List<PurchaseOrder> approved = new ArrayList<>();
        for (PurchaseOrder po : purchaseOrders) {
            if ("Approved".equalsIgnoreCase(po.status)) {
                approved.add(po);
            }
        }
        return approved;
    }
}
