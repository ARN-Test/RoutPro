package MainPackage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author A.R. Nobel
 */
public class Connect {
    public static Connection ConnectDB()
    {
    try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
            // connect using Thin driver
            Connection connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","RTest","stamford");
            return connect;
       }
    catch(Exception e)
       {
            //JOptionPane.showMessageDialog(null, e);
            return null;
       }
    }
}
