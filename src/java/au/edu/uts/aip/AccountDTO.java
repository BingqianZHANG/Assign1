/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.uts.aip;
import java.io.Serializable;
import javax.validation.constraints.*;

public class AccountDTO implements Serializable{
    private String username;
    private String agencyno;
    private String password;
    
    @Size(min=1)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    @Size(min=1)
    public String getAgencyno() {
        return agencyno;
    }

    public void setAgencyno(String agencyno) {
        this.agencyno = agencyno;
    }
    
    @Size(min=1)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
