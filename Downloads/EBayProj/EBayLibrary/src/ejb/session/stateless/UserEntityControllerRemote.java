/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.UserEntity;
import javax.ejb.Remote;
import util.exception.InvalidLoginException;
import util.exception.NoResultException;

/**
 *
 * @author darryl
 */
@Remote
public interface UserEntityControllerRemote {
    public void createUser(UserEntity user);
    
    public void updateUser(UserEntity user) throws NoResultException;
    
    public void deleteUser(UserEntity user) throws NoResultException;
    
    public UserEntity retrieveUserByUsername(String username) throws NoResultException;
    
    public UserEntity userLogin(String username, String password) throws InvalidLoginException;
}
