package au.edu.uts.aip;

public class DataStoreException extends Exception {
    
    public DataStoreException(String message) {
        super(message);
    }
    
    public DataStoreException(Throwable cause) {
        super(cause);
    }
    
    public DataStoreException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
