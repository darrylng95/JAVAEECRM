package entity.pojo;
/**
 * @author pepe the frog
 */
import java.io.Serializable;

public class SearchElement  implements Serializable   {
    private Long bookId;
    private String bookTitle;
    private String reservationStatus;
    private String bookStatus;
    private static final long serialVersionUID = 1234567L;
    
    public SearchElement (){}

    public SearchElement(Long bookId, String bookTitle, String reservationStatus, String bookStatus) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.reservationStatus = reservationStatus;
        this.bookStatus = bookStatus;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

    public Long getBookId() {
        return bookId;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    @Override
    public String toString() {
        return bookId.toString() + ":" +bookStatus+":"+reservationStatus;
    }
    
    
}
