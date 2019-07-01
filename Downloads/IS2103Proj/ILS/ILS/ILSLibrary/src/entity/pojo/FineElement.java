package entity.pojo;
/**
 * @author pepe the frog
 */
import java.io.Serializable;

public class FineElement implements Serializable   {
    
    private Long fineID;
    private Integer daysOverdue;
    private Integer fineStatusCode; 
    private static final long serialVersionUID = 1234567L;

    public FineElement() {
    }

    public FineElement(Long fineID, Integer daysOverdue, Integer fineStatusCode) {
        this.fineID = fineID;
        this.daysOverdue = daysOverdue;
        this.fineStatusCode = fineStatusCode;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getDaysOverdue() {
        return daysOverdue;
    }

    public Long getFineID() {
        return fineID;
    }

    public Integer getFineStatusCode() {
        return fineStatusCode;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDaysOverdue(Integer daysOverdue) {
        this.daysOverdue = daysOverdue;
    }

    public void setFineID(Long fineID) {
        this.fineID = fineID;
    }

    public void setFineStatusCode(Integer fineStatusCode) {
        this.fineStatusCode = fineStatusCode;
    }

    @Override
    public String toString() {
        return  "<fineID,daysOverdue,fineStatusCode>"+fineID+"-"+daysOverdue+"-"+fineStatusCode;
    }
    
    
    
}
