package au.edu.uts.aip;

import java.io.*;
import java.util.*;

public class AccountDatabase implements Serializable {

    // Helper to generate unique identifiers
    private static int idGenerator;
    private static synchronized int generateUniqueId() {
        idGenerator++;
        return idGenerator;
    }
    
    private static LinkedHashMap<Integer, Account> accounts = new LinkedHashMap<>();
    
    public static Collection<Account> findAll() {
        return accounts.values();
    }
    
    public static void create(Account account) {
        account.setId(generateUniqueId());
        accounts.put(account.getId(), account);
    }
    
    public static Account read(int index) {
        return accounts.get(index);
    }
    
    public static void update(Account account) {
        accounts.put(account.getId(), account);
    }
    
    public static void delete(int index) {
        accounts.remove(index);
    }
    
}
