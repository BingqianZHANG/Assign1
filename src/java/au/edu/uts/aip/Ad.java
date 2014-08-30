
package au.edu.uts.aip;
import java.io.*;
import javax.validation.constraints.*;


public class Ad implements Serializable{
    private int id;
    private String address;
    private String type;
    private Double size;
    private int yearofbuilt;
    private String construction;
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id =id;
    }
    
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
    
    @Min(0)
    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
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

