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
    
    public void addOrder(Long userId, OrderEntity order) throws NoResultException;
    
    public void deleteOrder(Long orderId) throws NoResultException;
    
    public void addItem(Long userId, ItemEntity item) throws NoResultException;
    
    public UserEntity retrieveUserByOrder(OrderEntity order);
    
    public UserEntity retrieveUserByItem(ItemEntity item);
    
    public void addToCart(ItemEntity item, UserEntity user, int quantity) throws CartException;
    
    public void deleteFromCart(OrderEntity order) throws CartException;
    
    public int calcCartPrice(UserEntity user) throws CartException;
    
    public void checkout(UserEntity user) throws CartException;
    
    public List<OrderEntity> getOrdersList(UserEntity user);
    
    public void deleteItemListing(ItemEntity item, UserEntity user) throws Exception;
    
    public List<OrderEntity> getSellerOrders(UserEntity user);
    
    public List<String> getAllOrderStatuses();
    
    public void updateOrder(OrderEntity order);
    
    public List<OrderEntity> getFulfilledOrders(UserEntity user);
    
    public void updateFeedback(OrderEntity order, String feedback);
    
}
