package AccessPackage;

//import MainPackage.Connect;
//import com.healthmarketscience.jackcess.Database;
//import com.healthmarketscience.jackcess.Database.FileFormat;
//import com.healthmarketscience.jackcess.DatabaseBuilder;
//import java.io.File;
//import java.io.IOException;
import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;




public class AMain {
    
    public static Connection ACON = AConnect.ConnectDB(); //For Connection in all Pages
    
    public static void main(String args[])
    {
        /*String DBPath = System.getProperty("user.dir")+"/newDb.accdb";
        try {
            Database DB = DatabaseBuilder.create(FileFormat.V2007, new File(DBPath));
        } catch (IOException ex) {
            Logger.getLogger(AMain.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        ////////////////////////////////////////////////////////////////////////InitializeAccess.Create_Tables();
           /*try{
        Statement ST = ACON.createStatement();
        ResultSet RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN FACULTY_LIST");
//        ResultSetMetaData RSMD = RS.getMetaData();
//        
//        System.out.format("%7s %15s %15s %15s %15s %15s %15s %15s %30s %12s", 
//                          RSMD.getColumnName(1) 
//                        , RSMD.getColumnName(2)
//                        , RSMD.getColumnName(3)
//                        , RSMD.getColumnName(4)
//                        , RSMD.getColumnName(5)
//                        , RSMD.getColumnName(6)
//                        , RSMD.getColumnName(7)
//                        , RSMD.getColumnName(8)
//                        , RSMD.getColumnName(9)
//                        , RSMD.getColumnName(10));
            while(RS.next())
            {
        
        System.out.format("%5s %7s %10s %10s %10s %10s %5s %15s %30s", 
                          RS.getString(1) 
                        , RS.getString(2)
                        , RS.getString(3)
                        , RS.getString(4)
                        , RS.getString(5)
                        , RS.getString(6)
                        , RS.getString(7)
                        , RS.getString(8)
                        , RS.getString(9)
                        );
        System.out.println();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }*/
    }
}
