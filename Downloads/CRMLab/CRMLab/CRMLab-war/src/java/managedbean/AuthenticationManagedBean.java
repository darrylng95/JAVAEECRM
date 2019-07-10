package managedbean;

import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;


@Named(value = "authenticationManagedBean")
@ManagedBean
@SessionScoped
public class AuthenticationManagedBean implements Serializable {
    private String username = null;
    private String password = null;
    private int userId = -1;
    
    public AuthenticationManagedBean() {
    }
    
    public String login(){
        //Supposed to do validation using a session bean
        
        //simulate username/password
        
        if(getUsername().equals("user1") && getPassword().equals("password")){
            //login successful
            //store the logged in user id;
            setUserId(10);
            
            //do redirect
            return "/secret/secret.xhtml?faces-redirect=true";
        }else{
            //login filed
            setUsername(null);
            setPassword(null);
            setUserId(-1);
            return "login.xhtml";
        }
    }
    
    public String logout(){
        setUsername(null);
        setPassword(null);
        setUserId(-1);
        
        return "/login.xhtml?faces-redirect=true";
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}
