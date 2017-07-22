package MainPackage;

import java.sql.*;

/**
 *
 * @author A.R. Nobel
 */
public class Main {
    public static Connection CON = Connect.ConnectDB(); //For Connection in all Pages
    
    
    //main - function
    public static void main(String[] args)
    {
        TestInterface TI = new TestInterface();//
        TI.setVisible(true);//
        
        try{
        Statement ST = CON.createStatement();
        ResultSet RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST");
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
        
        System.out.format("%5s %7s %10s %10s %10s %10s %5s %15s %30s %12s", 
                          RS.getString(1) 
                        , RS.getString(2)
                        , RS.getString(3)
                        , RS.getString(4)
                        , RS.getString(5)
                        , RS.getString(6)
                        , RS.getString(7)
                        , RS.getString(8)
                        , RS.getString(9)
                        , RS.getString(10));
        System.out.println();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
