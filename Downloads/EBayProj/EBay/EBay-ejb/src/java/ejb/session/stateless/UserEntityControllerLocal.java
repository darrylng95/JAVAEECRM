/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.ItemEntity;
import entity.OrderEntity;
import entity.UserEntity;
import util.exception.CartException;
import util.exception.InvalidLoginException;
import util.exception.NoResultException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author darryl
 */
@Local
public interface UserEntityControllerLocal {
    
    public void createUser(UserEntity user);
    
    public void updateUser(UserEntity user) throws NoResultException;
    
    public void deleteUser(UserEntity user) throws NoResultException;
    
    public UserEntity retrieveUserByUsername(String username) throws NoResultException;
    
    public UserEntity userLogin(String username, String password) throws InvalidLoginException;
    
}
