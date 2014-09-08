

package au.edu.uts.aip;

import java.io.*;
import java.util.ArrayList;
import javax.enterprise.context.*;
import javax.inject.*;


@Named
@RequestScoped
public class AdController implements Serializable {
    private AdDTO ad = new AdDTO();

    public AdDTO getAd() {
        //System.out.println("inside getAd");
        return ad;
    }
    
    public String saveAsnew() throws DataStoreException{
        new AdDAO().create(ad);
        return "managelist?faces-redirect=true";
    }
    
    public void loadAd(int id) throws DataStoreException{
//        System.out.println("Address: " + address);
//        System.out.println("SDFSDFSDFDS");
        ad =new AdDAO().findAd(id);
    }
    
    public String saveChanges() throws DataStoreException{
//        AdDatabase.update(ad);
        new AdDAO().update(ad);
        return "managelist?faces-redirect=true";
    }
    
    public String delete() throws DataStoreException{
//        AdDatabase.delete(ad.getId());
        new AdDAO().delete(ad.getId());
        return "managelist?faces-redirect=true";
    }
    
    public ArrayList<AdDTO> getAllAds() throws DataStoreException {
        return new AdDAO().findAll();
    }

    
}    
