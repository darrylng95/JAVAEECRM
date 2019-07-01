package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
@Entity
public class LendingEntity  implements Serializable {
    
       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lendId;
    @ManyToOne
    private MemberEntity memberEntity;      
    @ManyToOne
    private BookEntity bookEntity;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date lendDate;    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dueDate;   
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date returnDate;   
    
    
    @Column(nullable = true)
    private Integer statusCode;
    @Column(nullable = true)
    private String finePaymentMode;
    @Column(nullable = true)
    private String cardName;
    @Column(nullable = true)
    private String cardNumber;
    @Column(nullable = true)
    private String cardExpiry;
    @Column(nullable = true)
    private String cardPin;
    
    
        
    public LendingEntity() 
    {
    }

    
    
    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardPin() {
        return cardPin;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getFinePaymentMode() {
        return finePaymentMode;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public Long getLendId() {
        return lendId;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    
    
    
    
    
    
    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setFinePaymentMode(String finePaymentMode) {
        this.finePaymentMode = finePaymentMode;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public void setLendId(Long lendId) {
        this.lendId = lendId;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lendId != null ? lendId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the staffId fields are not set
        if (!(object instanceof LendingEntity)) {
            return false;
        }
        LendingEntity other = (LendingEntity) object;
        if ((this.lendId == null && other.lendId != null) || (this.lendId != null && !this.lendId.equals(other.lendId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LendingEntity[ id=" + lendId + " ]";
    }    
    
    
    
    
    
    
    
}
