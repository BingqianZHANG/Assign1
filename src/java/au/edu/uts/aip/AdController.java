

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
        return ad;
    }
    
    public String saveAsnew() throws DataStoreException{
        new AdDAO().create(ad);
        return "managelist?faces-redirect=true";
    }
    
    public void loadAd(String address) throws DataStoreException{
        ad =new AdDAO().findAd(address);
    }
    
    public String saveChanges(){
//        AdDatabase.update(ad);
        return "managelist?faces-redirect=true";
    }
    
    public String delete(){
//        AdDatabase.delete(ad.getId());
        return "managelist?faces-redirect=true";
    }
    
    public ArrayList<AdDTO> getAllAds() throws DataStoreException {
        return new AdDAO().findAll();
    }

    
}    
