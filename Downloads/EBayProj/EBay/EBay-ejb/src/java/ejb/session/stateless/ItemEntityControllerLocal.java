/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import javax.ejb.Local;
import entity.ItemEntity;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author darryl
 */
@Local
public interface ItemEntityControllerLocal {
    
    public void createItem(ItemEntity item);
    
    public List<ItemEntity> getAllItems();
    
    public List<ItemEntity> getFashionItems();
    
    public List<ItemEntity> getElectronicItems();
    
    public List<ItemEntity> getHomeLivingItems();
    
    public List<ItemEntity> getHobbyItems();
    
    public List<String> getAllItemNames();
    
    public List<String> getAllItemCategories();
    
    public void updateItem(ItemEntity item);
    
}
