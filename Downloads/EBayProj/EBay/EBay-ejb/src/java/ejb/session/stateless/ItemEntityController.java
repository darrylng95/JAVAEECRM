/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import javax.ejb.Stateless;
import entity.ItemEntity;
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
public class ItemEntityController implements ItemEntityControllerRemote, ItemEntityControllerLocal {
    @PersistenceContext (unitName = "EBay-ejbPU")
    private EntityManager em;
    
    @Override
    public void createItem(ItemEntity item){
            em.persist(item);       
    }
    
    @Override
    public List<ItemEntity> getAllItems(){
        Query query = em.createQuery("SELECT i FROM ItemEntity i");
        return query.getResultList();
    }
    
    @Override
    public List<ItemEntity> getFashionItems(){
        Query query = em.createQuery("SELECT i FROM ItemEnity i WHERE i.category = 'Fashion' ");
        return query.getResultList();
    }
    
    @Override
    public List<ItemEntity> getElectronicItems(){
        Query query = em.createQuery("SELECT i FROM ItemEntity WHERE i.category = 'Electronics'");
        return query.getResultList();
    }
    
    
    @Override
    public List<ItemEntity> getHomeLivingItems() {
        Query q = em.createQuery("SELECT i FROM ItemEntity i WHERE i.category = 'Home + Living'");
        return q.getResultList();
    }

    @Override
    public List<ItemEntity> getHobbyItems() {
        Query q = em.createQuery("SELECT i FROM ItemEntity i WHERE i.category = 'Hobbies'");
        return q.getResultList();
    }

    @Override
    public List<String> getAllItemNames() {
        Query q = em.createQuery("SELECT i.name FROM ItemEntity i");
        return q.getResultList();
    }

    @Override
    public List<String> getAllItemCategories() {
        Query q = em.createQuery("SELECT DISTINCT i.category FROM ItemEntity i");
        return q.getResultList();
    }

    @Override
    public void updateItem(ItemEntity item) {
        ItemEntity oldItem = em.find(ItemEntity.class, item.getItemId());
        
        if (oldItem != null) {
            oldItem.setName(item.getName());
            oldItem.setDescription(item.getDescription());
            oldItem.setCategory(item.getCategory());
            oldItem.setPrice(item.getPrice());
            oldItem.setQuantityAvail(item.getQuantityAvail());
        }
    }
}
