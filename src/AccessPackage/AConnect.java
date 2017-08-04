package AccessPackage;

import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AConnect {
    public static Connection ConnectDB()
    {
        
        ////// ****** CREATE DATABASE FILE FIRST ****** ///////
        String DBPath = System.getProperty("user.dir")+"/AccessDatabase/Test.accdb";
        try {
            Database DB = DatabaseBuilder.create(Database.FileFormat.V2007, new File(DBPath));
        } catch (IOException ex) {
            Logger.getLogger(AMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //// FORM CONNECTION ////
    try{
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          // connect using Thin driver
          Connection connect = DriverManager.getConnection("jdbc:ucanaccess://"+System.getProperty("user.dir")+"//AccessDatabase//Test.accdb;memory=true");
////////  System.out.println("Connection Successful.");
          return connect;
       }
    catch(Exception e)
       {
            //JOptionPane.showMessageDialog(null, e);
            return null;
       }
    }
    
    
    public static Connection ConnectDB(String Database)
    {
    try{
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
          // connect using Thin driver
          Connection connect = DriverManager.getConnection("jdbc:ucanaccess://"+System.getProperty("user.dir")+"//AccessDatabase//"+Database+";memory=true");
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
