// For JSF
package managedbean;

import entity.Customer;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import session.CustomerSessionLocal;

@Named(value = "customerManagedBean")
@ManagedBean
@ViewScoped
public class CustomerManagedBean {

    @EJB
    private CustomerSessionLocal customerSessionLocal;

    private String name;
    private byte gender;
    private Date dob;
    private List<Customer> customers;

    //used by editCustomer.xhtml
    private Long cId;
    private Customer selectedCustomer;

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

    public void loadSelectedCustomer() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            this.selectedCustomer
                    = customerSessionLocal.getCustomer(cId);
            name = this.selectedCustomer.getName();
            gender = this.selectedCustomer.getGender();
            dob = this.selectedCustomer.getDob();
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Unable to load customer"));
        }
    } //end loadSelectedCustomer

    public void updateCustomer(ActionEvent evt) {
        FacesContext context = FacesContext.getCurrentInstance();
        selectedCustomer.setName(name);
        selectedCustomer.setGender(gender);
        selectedCustomer.setDob(dob);
        try {
            customerSessionLocal.updateCustomer(selectedCustomer);
        } catch (Exception e) {
//show with an error icon 
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Unable to update customer")
            );
            return;
        }
//need to make sure reinitialize the customers collection
        context.addMessage(null, new FacesMessage("Success", "Successfully updated customer"));
    } //end updateCustomer

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

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Customer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(Customer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

}
