package AccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class AConnect {
    public static Connection ConnectDB()
    {
    try{
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          // connect using Thin driver
          Connection connect = DriverManager.getConnection("jdbc:ucanaccess://"+System.getProperty("user.dir")+"//AccessDatabase//ARTest.accdb;memory=true");
////////  System.out.println("Connection Successful.");
          return connect;
       }
    catch(Exception e)
       {
            //JOptionPane.showMessageDialog(null, e);
            return null;
       }
    }
}
