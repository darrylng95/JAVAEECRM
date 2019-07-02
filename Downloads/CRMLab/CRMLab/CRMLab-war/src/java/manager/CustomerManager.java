/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import entity.Customer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import session.CustomerSessionLocal;

/**
 *
 * @author darryl
 */
// Calling the Session Bean methods Similar to CLI interface in IS2103 but without the user input parts
public class CustomerManager {
    private CustomerSessionLocal customerSessionLocal;
    
    public CustomerManager(){
        
    }
    public CustomerManager(CustomerSessionLocal customerSessionLocal){
        this.customerSessionLocal = customerSessionLocal;
    }
    
    public Customer getCustomer(Long cId) throws Exception {
        return customerSessionLocal.getCustomer(cId);
    }
    
    public void updateCustomer (Long cId, String name, byte gender, String dob) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Date dob1 = df.parse(dob);
        Customer c = new Customer();
        c.setId(cId);
        c.setName(name);
        c.setDob(dob1);
        c.setCreated(new Date());
        
        customerSessionLocal.updateCustomer(c);
    }
    
    public List<Customer> searchCustomer(String name){
        return customerSessionLocal.searchCustomers(name);
    }
    
}
