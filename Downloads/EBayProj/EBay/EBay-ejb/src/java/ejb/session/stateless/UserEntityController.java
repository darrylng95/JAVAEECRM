/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import javax.ejb.Stateless;
import entity.ItemEntity;
import entity.OrderEntity;
import entity.UserEntity;
import util.exception.CartException;
import util.exception.InvalidLoginException;
import util.exception.NoResultException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author darryl
 */
@Stateless
public class UserEntityController implements UserEntityControllerRemote, UserEntityControllerLocal {
    @PersistenceContext(unitName = "EBay-ejbPU")
    private EntityManager em;
    
    @Override
    public void createUser (UserEntity user){
        if(em.find(UserEntity.class, user.getUserId())== null)
        em.persist(user);
    }
    
    @Override
    public void updateUser(UserEntity user) throws NoResultException{
        UserEntity oldUser = em.find(UserEntity.class, user.getUserId());
        if(oldUser != null){
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setAddress(user.getAddress());
            oldUser.setPhoneNumber(user.getPhoneNumber());
            oldUser.setUsername(user.getUsername());
            oldUser.setPassword(user.getPassword());
        }else{
            throw new NoResultException("Not Found");
        }
    }
   
    @Override
    public UserEntity retrieveUserByUsername (String username) throws NoResultException {
        Query query = em.createQuery("SELECT u FROM UserEntity u WHERE u.username = ?1");
        query.setParameter(1,username);
        try{
            return (UserEntity) query.getSingleResult();
        }catch(Exception ex){
            throw new NoResultException("Not Found");
        }
    }
}
