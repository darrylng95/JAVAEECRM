
package ejb.session.stateless;

import javax.ejb.Remote;
import java.util.List;
import entity.ReservationEntity;
import util.exception.ReservationNotFoundException;

/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */

@Remote
public interface ReservationEntityControllerRemote {
        
    public ReservationEntity createNewReservation(ReservationEntity reservationEntity);
    
    public List<ReservationEntity> viewAllReservations();
    
    public List<ReservationEntity> retrieveReservationByBookId(Long bookId) throws ReservationNotFoundException;
    
    public ReservationEntity retrieveReservationByReservationId (Long reservationId) throws ReservationNotFoundException;
    
    public void deleteReservation(Long reservationId) throws ReservationNotFoundException;
    
    
    public Boolean checkIfReservationAlreadyExists(Long bookID , Long memberID) ;
}
