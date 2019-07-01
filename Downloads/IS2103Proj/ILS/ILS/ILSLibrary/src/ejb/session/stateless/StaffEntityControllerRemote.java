
package ejb.session.stateless;

import entity.LendingEntity;
import entity.StaffEntity;
import java.util.List;
import javax.ejb.Remote;
import util.exception.InvalidLoginCredentialException;
import util.exception.StaffNotFoundException;

/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */

@Remote
public interface StaffEntityControllerRemote {
    
        
    public StaffEntity staffLogin(String username, String password) throws InvalidLoginCredentialException;
    public LendingEntity lendBook(LendingEntity newLendEntity);
    public StaffEntity retrieveStaffByUsername(String username) throws StaffNotFoundException;
    public StaffEntity retrieveStaffByStaffId(Long staffId) throws StaffNotFoundException;
    
    public StaffEntity createNewStaff(StaffEntity newStaffEntity);
    public void updateStaff(StaffEntity staffEntity);
    void deleteStaff(Long staffId) throws StaffNotFoundException;
    List<StaffEntity> retrieveAllStaffs();

}
