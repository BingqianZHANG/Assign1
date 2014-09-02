/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.uts.aip;

import java.io.Serializable;



public class AdDTO implements Serializable{
    private String address;
    private String type;
    private int size;
    private int yearofbuilt;
    private String construction;
    
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address =address;
    }
    
    
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type=type;
    }
    
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
   
    public int getYearofbuilt() {
        return yearofbuilt;
    }

    public void setYearofbuilt(int yearofbuilt) {
        this.yearofbuilt= yearofbuilt;
    } 
    
    
    public String getConstruction(){
        return construction;
    }
    
    public void setConstruction(String construction){
        this.construction = construction;
    }
  
    
}
