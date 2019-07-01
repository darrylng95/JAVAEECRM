package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
@Entity
public class ReservationEntity implements Serializable {
    
   private static final long serialVersionUID = 1L;
   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column (nullable = false)
   private Long reservationId;
   
   @ManyToOne
   private MemberEntity memberEntity;      
   @ManyToOne
   private BookEntity bookEntity;
   
   @Column(nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private Date reserveDate;
   
   public ReservationEntity(){}

    public ReservationEntity(Long reservationId, Date reserveDate, MemberEntity memberEntity, BookEntity bookEntity) {
        this.reservationId = reservationId;
        this.memberEntity = memberEntity;
        this.bookEntity = bookEntity;
        this.reserveDate = reserveDate;
    }

    
    
    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public BookEntity getBookEntity() {
        return bookEntity;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public Date getReserveDate() {
        return reserveDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    
    

    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public void setBookEntity(BookEntity bookEntity) {
        this.bookEntity = bookEntity;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReserveDate(Date reserveDate) {
        this.reserveDate = reserveDate;
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
        hash += (reservationId != null ? reservationId.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the memberId fields are not set
        if (!(object instanceof ReservationEntity)) {
            return false;
        }
        ReservationEntity other = (ReservationEntity) object;
        if ((this.reservationId == null && other.reservationId != null) || (this.reservationId != null && !this.reservationId.equals(other.reservationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ReservationEntity[ id=" + reservationId + " ]";
    }    
    
    
    

   

}
