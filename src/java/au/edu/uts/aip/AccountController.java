
package au.edu.uts.aip;

import java.io.*;
import javax.enterprise.context.*;
import javax.inject.*;


@Named
@RequestScoped
public class AccountController implements Serializable {
    private Account account = new Account();

    public Account getAccount() {
        return account;
    }
    
    /* save current account as new account in to Database*/
    public String saveAccount(){
        /*JDBC code here*/
        return "managelist?faces-redirect=ture";
    }
    
}
