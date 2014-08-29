

package au.edu.uts.aip;

import java.io.*;
import javax.enterprise.context.*;
import javax.inject.*;


@Named
@RequestScoped
public class AdController implements Serializable {
    private Ad ad = new Ad();

    public Ad getAd() {
        return ad;
    }
}    
