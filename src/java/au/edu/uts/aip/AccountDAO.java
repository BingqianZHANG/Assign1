
package au.edu.uts.aip;
import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

public class AccountDAO {
    private static final String JNDI_NAME = "jdbc/aip";
    private static final String INSERT_ACCOUNT = "insert into account (username, password, agencyno) values" +
                                             "(?,?,?)";
    
    //create a new account
    public void create(AccountDTO account) throws DataStoreException{
        try {
            
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement(INSERT_ACCOUNT)) {

                ps.setString(1, account.getUsername());
                ps.setString(2, account.getPassword());
                ps.setString(3, account.getAgencyno());
                
                
                ps.executeUpdate();
               
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
        
    }
}
