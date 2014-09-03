
package au.edu.uts.aip.pre;
import java.io.*;
import javax.validation.constraints.*;


public class Ad implements Serializable{
    private int id;
    private String address;
    private String type;
    private int size;
    private int yearofbuilt;
    private String construction;
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id =id;
    }
    
    @Size(min=1)
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address =address;
    }
    
    @Size(min=1)
    public String getType(){
        return type;
    }
    
    public void setType(String type){
        this.type=type;
    }
    
    @Min(1)
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
   @Min(1)
    public int getYearofbuilt() {
        return yearofbuilt;
    }

    public void setYearofbuilt(int yearofbuilt) {
        this.yearofbuilt= yearofbuilt;
    } 
    
    @Size(min=1)
    public String getConstruction(){
        return construction;
    }
    
    public void setConstruction(String construction){
        this.construction = construction;
    }
  
}

