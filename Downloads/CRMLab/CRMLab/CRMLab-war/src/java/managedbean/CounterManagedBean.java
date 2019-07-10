package managedbean;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;


@Named(value = "counterManagedBean")
@ManagedBean
@ViewScoped
public class CounterManagedBean {
    private int counter = 0;
    public CounterManagedBean() {
    }
    
    public void increment (ActionEvent evt){
        setCounter(getCounter() + 1);
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
   
}
