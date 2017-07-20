package MainPackage;

import java.sql.Connection;

/**
 *
 * @author A.R. Nobel
 */
public class Main {
    public Connection ConnectDB;
    
    //Main - Constructor
    public Main() {
        this.ConnectDB = Connect.ConnectDB();
    }
    
    //main - function
    public static void main(String[] args)
    {
        
    }

    
}
