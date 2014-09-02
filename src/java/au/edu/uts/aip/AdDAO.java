/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.uts.aip;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

public class AdDAO {
    
     private static final String JNDI_NAME = "jdbc/aip";
    
    private static final String SELECT_AD =
            "select address,propertytype,buildingsize,yearofbuilt,construction " +
            "from ad ";
    private static final String AD_ALL = SELECT_AD;
    private static final String AD_ADDRESS = SELECT_AD + " where address = ?";
    
    // implementation 
   
    private AdDTO createRowDTO(ResultSet rs) throws SQLException {
        AdDTO result = new AdDTO();
        result.setAddress(rs.getString("address"));
        result.setType(rs.getString("propertytype"));
        result.setSize(rs.getInt("buildingsize"));
        result.setYearofbuilt(rs.getInt("yearofbuilt"));
        result.setConstruction(rs.getString("construction"));
        return result;
    }

   //find all ads
    public ArrayList<AdDTO> findAll() throws DataStoreException {
        ArrayList<AdDTO> results = new ArrayList<>();
        try {
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(AD_ALL)) {

                while (rs.next()) {
                    results.add(createRowDTO(rs));
                }
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
        return results;
    }
    
    //find a certain ad with selected address 
    public AdDTO findAd(String address) throws DataStoreException {
        try {
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement(AD_ADDRESS)) {

                ps.setString(1, address);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // found address
                        return createRowDTO(rs);
                    } else {
                        // cannot find address
                        return null;
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
    }
    
}
