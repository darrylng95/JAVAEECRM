
package ejb.session.stateless;


import javax.ejb.Remote;
import entity.LendingEntity;
import entity.MemberEntity;
import entity.BookEntity;
import entity.pojo.FineElement;
import entity.pojo.SearchElement;
import java.util.ArrayList;
import java.util.List;
import util.exception.MemberHasUnpaidFines;
import util.exception.LendingNotFoundException;
import util.exception.BookOverDueException;


/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */
@Remote
public interface LendingEntityControllerRemote {
    
    // FROM WULIN
    //
    //need to have-jwl request,should be three exception right???
    //public LendingEntity createNewLending(MemberEntity memberEntity, BookEntity bookEntity) throws MemberHasUnpaidFines; 
    //
    //public List<LendingEntity> retrieveAllLendingsByMemberEntity(MemberEntity memberEntity);
    //
    //need to generate fine inside this return book function
    //public void returnBook(Long lendId) throws LendingNotFoundException;
    //
    //public LendingEntity extendBook(Long lendId) throws LendingNotFoundException, BookOverDueException;//four exception right?
    //
    //here, not very sure, the amount of fine should be an attributes of lendingentity right?
    //I assume I can access it by lendingEntity.getFineAmount() now
    //public List<LendingEntity> retrieveUnpaidFineByMemberEntity(MemberEntity memberEntity);
    //
    //public LendingEntity retrieveLendingByLendId(Long lendId)throws LendingNotFoundException;
    //
    //public void payFines(LendingEntity lendingEntity) throws LendingNotFoundException;
    
      
    public void createSampleLendingRecord(BookEntity thisBookEntity , MemberEntity thismemberEntity) ;
    
    public void createNEWLendingRecordAND_DEL_ANYReservation(BookEntity thisBookEntity , MemberEntity thismemberEntity) ;
    
    public void payFineByCreditCard(Long lendID , String cardName , String cardNumber , String cardExpiry , String cardPin);
        
    public void updateLendingRecords(Long memberID) ;
        
    public List<LendingEntity> viewAllLendingRecords();
    
    public ArrayList<FineElement> generateAndReturnFines(Long memberID);
    
    public Boolean checkIfBookIsAvailableInStore(Long bookID);
    
    public Integer checkIfBookIsFreeFromReservation(Long bookID , Long memberID);
            
    public Boolean checkIfMemberHasUnPaidFines(Long memberID);
    
    
    public Integer getCountCurrentBooksBorrowed(Long memberID);
    
    
    public void payFineByCash(Long lendID);
    
    
    public ArrayList<String> fetchListOfLentBooks(String memberidentitynumber);
    
    
    public List<LendingEntity> fetchListOfBooksCurrentlyOnLoan(Long memberID) ;
    
    
    public void extendLoanBy14Days(Long lendingID);
    
    
    public ArrayList<SearchElement> searchBook(String searchTerm);
    
    
    public String returnBook (Long lenddingId) throws Exception;
    
    
    public String extendBookLoan (Long lenddingId);
    
    
    public LendingEntity retrieveLendingByLendId (Long lenddingId);
    
    public String getAvailabilityForBook(BookEntity book);
    
    public Boolean getReservationOfThisBookBoolean(Long bookID);
    
}
