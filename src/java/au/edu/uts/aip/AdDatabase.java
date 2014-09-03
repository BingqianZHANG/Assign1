package au.edu.uts.aip;

import au.edu.uts.aip.pre.Ad;
import java.io.*;
import java.util.*;

public class AdDatabase implements Serializable {

    // Helper to generate unique identifiers
    private static int idGenerator;
    private static synchronized int generateUniqueId() {
        idGenerator++;
        return idGenerator;
    }
    
    private static LinkedHashMap<Integer, Ad> ads = new LinkedHashMap<>();
    
    public static Collection<Ad> findAll() {
        return ads.values();
    }
    
    public static void create(Ad ad) {
        ad.setId(generateUniqueId());
        ads.put(ad.getId(), ad);
    }
    
    public static Ad read(int index) {
        return ads.get(index);
    }
    
    public static void update(Ad ad) {
        ads.put(ad.getId(), ad);
    }
    
    public static void delete(int index) {
        ads.remove(index);
    }
    
}

