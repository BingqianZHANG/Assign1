
package au.edu.uts.aip;

import au.edu.uts.aip.pre.Ad;
import java.io.*;
import java.util.*;
import javax.enterprise.context.*;
import javax.inject.*;

@Named
@RequestScoped
public class ManagelistController implements Serializable {
    
    public Collection<Ad> getAds() {
        return AdDatabase.findAll();
    }
    
}
