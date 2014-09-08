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
    
    //SQL 
    //select ad items
    private static final String SELECT_AD =
            "select id,address,propertytype,buildingsize,yearofbuilt,construction " + "from ad ";
    //select all ads
    private static final String AD_ALL = SELECT_AD;
    //select ad with certain primary key
    private static final String AD_ID = SELECT_AD + " where id = ?";
    //creat a new ad record
    private static final String INSERT_AD = "insert into ad (address,propertytype,buildingsize,yearofbuilt,construction) values" +
                                             "(?,?,?,?,?)";
    //update a existing ad
    private static final String UPDATE_AD ="update ad " +
                                            "set address = ?,propertytype = ?,buildingsize = ?,yearofbuilt = ?,construction= ? " +
                                            "where id = ? ";
     //delete an an
    private static final String DELETE_AD="delete from ad " +"where id = ?";
    
    
    // implementation 
   
    private AdDTO createRowDTO(ResultSet rs) throws SQLException {
        AdDTO result = new AdDTO();
        result.setId(rs.getInt("id"));
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
    
    //create(insert) a new ad in database
    
    public void create(AdDTO ad) throws DataStoreException{
        try {
            
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement(INSERT_AD)) {

                ps.setString(1, ad.getAddress());
                ps.setString(2, ad.getType());
                ps.setInt(3, ad.getSize());
                ps.setInt(4, ad.getYearofbuilt());
                ps.setString(5, ad.getConstruction());
                
                ps.executeUpdate();
               
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
        
    }
    
    //update a existing ad
    public void update(AdDTO ad) throws DataStoreException{
        try {
            
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement(UPDATE_AD)) {

                ps.setString(1, ad.getAddress());
                ps.setString(2, ad.getType());
                ps.setInt(3, ad.getSize());
                ps.setInt(4, ad.getYearofbuilt());
                ps.setString(5, ad.getConstruction());
                ps.setInt(6, ad.getId());
                
                ps.executeUpdate();
               
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
        
    }
    
    //delete a select ad
    public void delete(int id) throws DataStoreException {

        try {
            
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement(DELETE_AD)) {

                ps.setInt(1, id);
                
                ps.executeUpdate();
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
    } 
    
    
    //find a certain ad with selected id 
    public AdDTO findAd(int id) throws DataStoreException {

        try {
            
            DataSource ds = InitialContext.doLookup(JNDI_NAME);
            try (Connection conn = ds.getConnection();
                 PreparedStatement ps = conn.prepareStatement(AD_ID)) {

                ps.setInt(1, id);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // found id
                        return createRowDTO(rs);
                    } else {
                        // cannot find id
                        return null;
                    }
                }
            }
        } catch (NamingException | SQLException e) {
            throw new DataStoreException(e);
        }
    }
    
}
