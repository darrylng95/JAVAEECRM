package entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */

@Entity
public class BookEntity implements Serializable {
    
   private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String isbn;

        
    @OneToMany(mappedBy = "bookEntity")
    private List<LendingEntity> lendingEntities;
    
    @OneToMany(mappedBy = "bookEntity")
    private List<ReservationEntity> reservationEntities;
    
    private String year;    
    
        
    public BookEntity() 
    {
    }


    public BookEntity(String title, String isbn, String year) {
        this.isbn = isbn;
        this.title = title;
        this.reservationEntities = new LinkedList<>();
        this.lendingEntities = new LinkedList<>();
        this.year = year;
    }
    

    public Long getBookId() {
        return bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<ReservationEntity> getReservationEntities() {
        return reservationEntities;
    }

    public List<LendingEntity> getLendingEntities() {
        return lendingEntities;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }



    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setLendingEntities(List<LendingEntity> lendingEntities) {
        this.lendingEntities = lendingEntities;
    }

    public void setReservationEntities(List<ReservationEntity> reservationEntities) {
        this.reservationEntities = reservationEntities;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); 
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the memberId fields are not set
        if (!(object instanceof BookEntity)) {
            return false;
        }
        BookEntity other = (BookEntity) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BookEntity[ id=" + bookId + " ]";
    }  
    
    
    

    
    
    
}
