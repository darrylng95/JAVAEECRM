// For JSF
package managedbean;

import entity.Customer;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import session.CustomerSessionLocal;

@Named(value = "customerManagedBean")
@ManagedBean
@RequestScoped
public class CustomerManagedBean {

    @EJB
    private CustomerSessionLocal customerSessionLocal;

    private String name;
    private byte gender;
    private Date dob;
    private List<Customer> customers;

    public CustomerManagedBean() {
    }

    @PostConstruct
    public void init() {
        setCustomers(customerSessionLocal.searchCustomers(null));
    }

    //methods
    public void addCustomer(ActionEvent evt) {
        /*  SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date dob1 = null;
        try {
            dob1 = df.parse(dob);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Customer c = new Customer();
        c.setName(name);
        c.setGender(gender);
        c.setDob(dob);
        c.setCreated(new Date());

        customerSessionLocal.createCustomer(c);
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
