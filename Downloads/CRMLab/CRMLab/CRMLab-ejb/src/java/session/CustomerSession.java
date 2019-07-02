/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Contact;
import entity.Customer;
import entity.Field;
import error.NoResultException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author darryl
 */
@Stateless
public class CustomerSession implements CustomerSessionLocal {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Customer> searchCustomers(String name) {
        Query q;
        if(name != null) {
            q = em.createQuery("SELECT c from Customer c WHERE" + "LOWER(c.name) LIKE :name");
            q.setParameter("name", "%" + name.toLowerCase()+"%");
        }else {
            q = em.createQuery("SELECT c from Customer c");
        }
        return q.getResultList();
    }

    @Override
    public Customer getCustomer(Long cId) throws NoResultException {
        Customer c = em.find(Customer.class,cId);
        
        if( c != null ){
            return c;
        }else{
            throw new NoResultException("Not Found");
        }
    }

    @Override
    public void createCustomer(Customer c) {
       em.persist(c);
    }

    @Override
    public void updateCustomer(Customer c) throws NoResultException {
        Customer oldC = em.find(Customer.class, c.getId());
        
        if( oldC != null ){
            oldC.setDob(c.getDob());
            oldC.setGender(c.getGender());
            oldC.setName(c.getName());
        }else{
            throw new NoResultException("Not Found");
        }
    }

    @Override
    public void addContact(Long cId, Contact c) throws NoResultException {
        Customer cust = em.find(Customer.class, cId);
        
        if(cust != null){
            em.persist(c);
            cust.getContacts().add(c);
        }else{
            throw new NoResultException("Not Found");
        }
    }

    @Override
    public void addField(Long cId, Field f) throws NoResultException {
        Customer cust = em.find(Customer.class,cId);
        
        if(cust != null){
            Query q = em.createQuery("SELECT f from Field f WHERE LOWER(f.name) = :name AND LOWER(f.fieldValue) = :fieldValue");
            q.setParameter("name", f.getName().toLowerCase());
            try{
                Field found = (Field) q.getSingleResult();
                f = found;
            }catch(Exception e){
                // not found create the field
                em.persist(f);
            }
            // If cust do not have that field add it to that cust
            if(!cust.getFields().contains(f)){
                cust.getFields().add(f);
            }else{
                throw new NoResultException("Not Found.");
            }
        }
    }

    @Override
    public void deleteContact(Long cId) throws NoResultException {
        Contact c = em.find(Contact.class, cId);
        if(c != null){
            Query q = em.createQuery("SELCT c from Customer c WHERE :contact MEMBER OF c.contacts"); // check if passed in contact is inside of customer contacts collection
            q.setParameter("contact", c);
            
            for( Object cust : q.getResultList()){
                Customer cust1 = (Customer) cust;
                cust1.getContacts().remove(c);
            }// deleting reference before removing the contact from persistent storage
            em.remove(c);
        }else{
            throw new NoResultException("Not Found");
        }
    }

    @Override
    public void deleteField(Long cId, Long fId) throws NoResultException {
        Customer c = em.find(Customer.class, cId);
        Field f =em.find(Field.class,fId);
        if(c != null && f != null){
            c.getFields().remove(f);
            
            //if no other association between field and customer, safe to delete this field
            Query q = em.createQuery("SELECT count(c) FROM Customer c WHERE :field MEMBER OF c.fields");
            q.setParameter("field",f);
            
            long count = (Long) q.getSingleResult();
            
            if(count == 0){
                em.remove(f);
            }
        }else{
            throw new NoResultException("Not Found");
        }
    }

    @Override
    public void deleteCustomer(Long cId) throws NoResultException {
        Customer c = em.find(Customer.class,cId);
        if( c == null){
            throw new NoResultException("Not found");
        }
        
        List<Field> fields = c.getFields();
        c.setFields(null);
        
        for(Field f: fields){
        // if no other association between field and customer, safe to delete this field
        Query q = em.createQuery("SELECT count(c) FROM Customer c WHERE :field MEMBER OF c.fields");
        q.setParameter("field",f);
        
        long count = (Long) q.getSingleResult();
        
        if(count == 0){
            em.remove(f);
        }
    }
        em.remove(c);
    }

    @Override
    public List<Customer> searchCustomersByContact(Contact c) {
        Query q;
        if( c.getPhone() != null){
            q = em.createQuery("SELECT cust FROM Customer cust, Contact c WHERE c MEMBER OF cust.contacts AND LOWER(c.phone) LIKE: phone");
            q.setParameter("phone", "%" +c.getPhone().toLowerCase() +"%");
        }else if(c.getEmail() !=null){
            q = em.createQuery("SELECT cust FROM Customer cust, Contact c WHERE c MEMBER OF cust.contacts AND LOWER(c.email) LIKE :email");
            q.setParameter("email", "%" + c.getEmail().toLowerCase() + "%");
        }else {
            return new ArrayList<Customer>();
        }
        return q.getResultList();
    }

    @Override
    public List<Customer> searchCustomersByField(Field f) {
       Query q = em.createQuery("SELECT cust FROM Customer cust, Field f WHER f MEMBER OF cust.fields AND LOWER(f.name) = :name AND LOWER(f.fieldValue) LIKE :fieldValue");
       q.setParameter("name",f.getName().toLowerCase());
       q.setParameter("fieldValue","%"+ f.getFieldValue().toLowerCase()+"%");
       
       return q.getResultList();
    }

    @Override
    public Set<String> getAllFieldNames() {
       Set<String> results = new HashSet<String>();
       Query q = em.createQuery("SELECT f FROM Field f");
       
       for(Object field : q.getResultList()){
           Field field1 = (Field) field;
           results.add(field1.getName().toLowerCase());
       }
       return results;
    }
    
   
}
