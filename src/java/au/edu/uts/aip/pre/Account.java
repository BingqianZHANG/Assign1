
package au.edu.uts.aip.pre;
import java.io.*;

public class Account implements Serializable {

    private int id;
    private String username;
    private String agencyno;
    private String password;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public String getAgencyno() {
        return agencyno;
    }

    public void setAgencyno(String agencyno) {
        this.agencyno = agencyno;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    
}
