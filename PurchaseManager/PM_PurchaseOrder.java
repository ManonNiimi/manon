
package PurchaseManager;


public class PM_PurchaseOrder {
    private String poID;
    private String requisitionID;
    private String generatedBy;
    private String status;
    
    public PM_PurchaseOrder(String poID, String requisitionID, String generatedBy, String status){
        this.poID = poID;
        this.requisitionID = requisitionID;
        this.generatedBy = generatedBy;
        this.status = status;
        
        
    }
    
    public String getpoID(){
        return poID;
    }
    
    public void setpoID(String poID){
        this.poID = poID;
    }

    public String getRequisitionID() {
        return requisitionID;
    }

    public void setRequisitionID(String requisitionID) {
        this.requisitionID = requisitionID;
    }

    public String getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
