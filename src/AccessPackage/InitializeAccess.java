package AccessPackage;

import static AccessPackage.AMain.ACON;
import java.sql.Statement;

/**
 *
 * @author A.R. Nobel
 */
public class InitializeAccess {
    
    public static void Create_Tables()
    {
        try{
            // BATCH_LIST
        Statement ST;
        String SQL = "CREATE TABLE BATCH_LIST (BATCH TEXT PRIMARY KEY)"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
            
            // LAB_GROUPS
        SQL = "CREATE TABLE LAB_GROUPS (" +
"    BATCH TEXT," +
"    LAB_GROUP TEXT  PRIMARY KEY," +
"    CONSTRAINT LG_FK  FOREIGN KEY (BATCH) REFERENCES BATCH_LIST(BATCH)" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
        
            //FACULTY_LIST
        SQL = "CREATE TABLE FACULTY_LIST (" +
"    MEMBER_NAME varchar2(50) ," +
"    MEMBER_CODE varchar2(15)  PRIMARY KEY" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);        
        
////////////////            // DAY_LIST
////////////////        SQL = "CREATE TABLE DAY_LIST (" +
////////////////"    DAY TEXT  PRIMARY KEY" +
////////////////"    )"; 
////////////////        ST = ACON.createStatement();
////////////////        ST.execute(SQL);        
            
            //  ROOM_LIST
        SQL = "CREATE TABLE ROOM_LIST (" +
"    ROOM_NO TEXT  PRIMARY KEY," +
"    ROOM_ATTRIBUTE TEXT" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
            
            // CLASS_TIME_SLOT
        SQL = "CREATE TABLE TIME_SLOTS (" +
"    ATTRIBUTE varchar2(20) ," +
"    START_TIME varchar2(20) ," +
"    END_TIME varchar2(20) ," +
"    CONSTRAINT TS_PK PRIMARY KEY(START_TIME, END_TIME, ATTRIBUTE)" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
            
        
            // COURSE_LIST
        SQL = "CREATE TABLE COURSE_LIST (" +
"    COURSE_TITLE varchar2(50) ," +
"    COURSE_SHORT varchar2(25) ," +
"    COURSE_CODE TEXT  PRIMARY KEY" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
        
            //CLASS_ROUTINE
        SQL = "CREATE TABLE CLASS_ROUTINE (" +
"    DAY TEXT," +
"    COURSE_SHORT varchar2(25)," +
"    COURSE_CODE TEXT," +
"    ROOM_NO TEXT," +
"    MEMBER_CODE varchar2(5)," +
"    BATCH TEXT," +
"    START_TIME varchar2(20)," +
"    END_TIME varchar2(20)," +
"    ATTRIBUTE varchar2(20)," +
"    " +
"    CONSTRAINT CL_FK2 FOREIGN KEY (COURSE_CODE) REFERENCES COURSE_LIST(COURSE_CODE)," +
"    CONSTRAINT CL_FK3 FOREIGN KEY (ROOM_NO) REFERENCES ROOM_LIST(ROOM_NO)," +
"    CONSTRAINT CL_FK4 FOREIGN KEY (MEMBER_CODE) REFERENCES FACULTY_LIST(MEMBER_CODE)," +
"    CONSTRAINT CL_FK5 FOREIGN KEY (BATCH) REFERENCES BATCH_LIST(BATCH)," +
"    CONSTRAINT CL_FK6 FOREIGN KEY (START_TIME,END_TIME,ATTRIBUTE) REFERENCES TIME_SLOTS(START_TIME,END_TIME,ATTRIBUTE)," +
"    CONSTRAINT CHK_DAY CHECK (DAY IN ('Saturday', 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday'))," +
"    CONSTRAINT CL_PK PRIMARY KEY (" +
"        DAY," +
"        COURSE_CODE," +
"        ROOM_NO," +
"        MEMBER_CODE," +
"        BATCH," +
"        ATTRIBUTE)" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
        
     
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
