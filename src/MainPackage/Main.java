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
        try{
        Statement ST = CON.createStatement();
        ResultSet RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST");
            while(RS.next())
            {
                System.out.println(RS.getString(1) + " " 
                        + RS.getString(2) + " " 
                        + RS.getString(3) + " " 
                        + RS.getString(4) + " "
                        + RS.getString(5) + " "
                        + RS.getString(6) + " "
                        + RS.getString(7) + " "
                        + RS.getString(8) + " "
                        + RS.getString(9) + " "
                        + RS.getString(10) + " ");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
}
