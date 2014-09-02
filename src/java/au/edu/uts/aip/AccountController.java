
package au.edu.uts.aip;

import java.io.*;
import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Named
@RequestScoped
public class AccountController {
        private String username;
    private String password;

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
    /* login container-managed*/
    public String loginContainer() {
        FacesContext context= FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
        
        try {
          request.login(username, password);
          return "managelist?faces-redirect=true";
          
        } catch (ServletException e) {
          showError("Incorrect username or password.");
          e.printStackTrace();
          return null;
        }
    }
    
    /*logout the container-managed authentication*/
    public String logoutContainer() throws ServletException {
        FacesContext context= FacesContext.getCurrentInstance();
        HttpServletRequest request= (HttpServletRequest)context.getExternalContext().getRequest();
        request.logout();
        return "welcome?faces-redirect=true";
    }
    
    /*add error message to h:message element*/
    private void showError(String message) {
        FacesContext context= FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(message));
    }
}
