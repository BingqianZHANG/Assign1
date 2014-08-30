

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
    
    
    public String saveAsnew(){
        AdDatabase.create(ad);
        return "managelist?faces-redirect=true";
    }
    
    public void loadAd(int index){
        ad = AdDatabase.read(index);
    }
    
    public String saveChanges(){
        AdDatabase.update(ad);
        return "managelist?faces-redirect=true";
    }
    
    public String delete(){
        AdDatabase.delete(ad.getId());
        return "managelist?faces-redirect=true";
    }
}    
