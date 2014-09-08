
package au.edu.uts.aip;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Named
@RequestScoped
public class AccountController implements Serializable{
    private AccountDTO account = new AccountDTO();
    
    private String username;
    private String password;
    private String cfmpwd;

    public AccountDTO getAccount(){
        return account;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCfmpwd(){
        return cfmpwd;
    }
    
    public void setCfmpwd(String cfmpwd){
        this.cfmpwd= cfmpwd;
    }
    
    // login container-managed
    public String loginContainer() {
        FacesContext context= FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        
        try {
          if (request.getRemoteUser() == null) {
              // user is not logged in
              request.login(username, password);
          
              return "managelist?faces-redirect=true";
          
          } else {
              // user is logged in
              return "managelist?faces-redirect=true";
          }
              
          
        } catch (ServletException e) {
          showError("Incorrect username or password.");
          return null;
        }
    }
    
    //logout the container-managed authentication
    public String logoutContainer() throws ServletException {
        FacesContext context= FacesContext.getCurrentInstance();
        HttpServletRequest request= (HttpServletRequest)context.getExternalContext().getRequest();
        request.logout();
        return "welcome?faces-redirect=true";
    }
    
    //save new account
    public String saveAccount() throws DataStoreException, NoSuchAlgorithmException{
        try{
            if(account.getPassword().equals(cfmpwd)){
                new AccountDAO().create(account);
                return "managelist?faces-redirect=true";
            }else{
                showError("These passwords do not match.");
                return null;
            }
        }catch(DataStoreException e){
            showError("The user name has already been taken. Please try another one.");
            return null;
        }
    }
    //add error message to h:message element
    private void showError(String message) {
        FacesContext context= FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
}
