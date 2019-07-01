
package ejb.session.stateless;

import javax.ejb.Remote;
import entity.MemberEntity;
import java.util.List;
import util.exception.InvalidLoginCredentialException;
import util.exception.MemberNotFoundException;


/**
 * @author Darryl,Paul,WuLin,ZhiKuan
 */


@Remote
public interface MemberEntityControllerRemote {
             
    public MemberEntity createNewMember(MemberEntity newMemberEntity);
    
    public MemberEntity retrieveMemberByMemberId (Long memberId) throws MemberNotFoundException;
    
    public void updateMember(MemberEntity memberEntity);
    
    void deleteMember(Long memberId) throws MemberNotFoundException;
    
    public List<MemberEntity> retrieveAllMembers();
    
    //need to have-jwl request
    public MemberEntity retrieveMemberByIdentityNumber (String identityNumber) throws MemberNotFoundException;
    
    public MemberEntity memberLogin(String identityNumber, String securityCode) throws InvalidLoginCredentialException;
    
    
    
    public void bruteForceDeleteMember (Long memberId);
}
