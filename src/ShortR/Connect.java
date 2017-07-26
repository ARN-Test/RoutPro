package ShortR;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static Connection ConnectDB()
    {
    try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
          // connect using Thin driver
          Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RTest","1234");
////////          System.out.println("Connection Successful.");
          return connect;
       }
    catch(Exception e)
       {
            //JOptionPane.showMessageDialog(null, e);
            return null;
       }
    }
}
