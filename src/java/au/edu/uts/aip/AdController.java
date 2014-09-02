

package au.edu.uts.aip;

import java.io.*;
import java.util.ArrayList;
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
    
    public void loadAd(String address) throws DataStoreException{
        AdDAO dao = new AdDAO();
        AdDTO ad = dao.findAd(address);
    }
    
    public String saveChanges(){
        AdDatabase.update(ad);
        return "managelist?faces-redirect=true";
    }
    
    public String delete(){
        AdDatabase.delete(ad.getId());
        return "managelist?faces-redirect=true";
    }
    
           public ArrayList<AdDTO> getAllAds() throws DataStoreException {
        return new AdDAO().findAll();
    }

    
}    
