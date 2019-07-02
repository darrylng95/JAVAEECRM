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
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import util.exception.NoResultException;


/**
 *
 * @author darryl
 */
@Stateless
public class OrderEntityController implements OrderEntityControllerRemote, OrderEntityControllerLocal {
    @PersistenceContext (unitName = "EBay-ejbPU")
    private EntityManager em;
     
    @Override
    public void addOrder(Long userId, OrderEntity order) throws NoResultException {
        UserEntity user = em.find(UserEntity.class, userId);

        if (user != null) {
            em.persist(order);
            user.getOrderEntities().add(order);
        } else {
            throw new NoResultException("Not found");
        }
    }

    @Override
    public void deleteOrder(Long orderId) throws NoResultException {
        OrderEntity order = em.find(OrderEntity.class, orderId);

        if (order != null) {
            Query q = em.createQuery("SELECT u FROM UserEntity u WHERE :order MEMBER OF u.orderEntities");
            q.setParameter("order", order);

            UserEntity user1 = (UserEntity) q.getSingleResult();
            user1.getOrderEntities().remove(order);

            em.remove(order);
        } else {
            throw new NoResultException("Not Found");
        }
    }

    @Override
    public void addItem(Long userId, ItemEntity item) throws NoResultException {
        UserEntity user = em.find(UserEntity.class, userId);

        if (user != null) {
            em.persist(item);
            user.getItemEntities().add(item);
        } else {
            throw new NoResultException("Not found");
        }
    }

}
