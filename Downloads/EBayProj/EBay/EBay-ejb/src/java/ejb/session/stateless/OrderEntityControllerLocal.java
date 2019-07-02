/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;


import javax.ejb.Local;
import entity.ItemEntity;
import entity.OrderEntity;
import util.exception.NoResultException;


/**
 *
 * @author darryl
 */
@Local
public interface OrderEntityControllerLocal {
    public void addOrder(Long userId, OrderEntity order) throws NoResultException;
    
    public void deleteOrder(Long orderId) throws NoResultException;
    
    public void addItem(Long userId, ItemEntity item) throws NoResultException;
    
   // public UserEntity retrieveUserByOrder(OrderEntity order);
    
   // public UserEntity retrieveUserByItem(ItemEntity item);
    
   // public void addToCart(ItemEntity item, UserEntity user, int quantity) throws CartException;
    
  //  public void deleteFromCart(OrderEntity order) throws CartException;
    
  //  public int calcCartPrice(UserEntity user) throws CartException;
    
  //  public void checkout(UserEntity user) throws CartException;
    
   // public List<OrderEntity> getOrdersList(UserEntity user);
    
   // public void deleteItemListing(ItemEntity item, UserEntity user) throws Exception;
    
   // public List<OrderEntity> getSellerOrders(UserEntity user);
    
    //public List<String> getAllOrderStatuses();
    
    //public void updateOrder(OrderEntity order);
    
    //public List<OrderEntity> getFulfilledOrders(UserEntity user);
    
    //public void updateFeedback(OrderEntity order, String feedback);
    
    
}
