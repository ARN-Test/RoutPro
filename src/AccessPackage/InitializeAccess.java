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
"    TEACHER_NAME varchar2(50) ," +
"    TEACHER_CODE varchar2(5)  PRIMARY KEY" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);        
        
            // DAY_LIST
        SQL = "CREATE TABLE DAY_LIST (" +
"    DAY TEXT  PRIMARY KEY" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);        
            
            //  ROOM_LIST
        SQL = "CREATE TABLE ROOM_LIST (" +
"    ROOM_NO TEXT  PRIMARY KEY" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
            
            // CLASS_TIME_SLOT
        SQL = "CREATE TABLE CLASS_TIME_SLOTS (" +
"    CLASS_TIME_SLOT varchar2(20)  PRIMARY KEY" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
            
            // LAB_TIME_SLOT
        SQL = "CREATE TABLE LAB_TIME_SLOTS (" +
"    LAB_TIME_SLOT varchar2(20)  PRIMARY KEY" +
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
"    TEACHER_CODE varchar2(5)," +
"    BATCH TEXT," +
"    CLASS_TIME_SLOT varchar2(20)," +
"    " +
"    CONSTRAINT CL_FK1 FOREIGN KEY (DAY) REFERENCES DAY_LIST(DAY)," +
"    CONSTRAINT CL_FK2 FOREIGN KEY (COURSE_CODE) REFERENCES COURSE_LIST(COURSE_CODE)," +
"    CONSTRAINT CL_FK3 FOREIGN KEY (ROOM_NO) REFERENCES ROOM_LIST(ROOM_NO)," +
"    CONSTRAINT CL_FK4 FOREIGN KEY (TEACHER_CODE) REFERENCES FACULTY_LIST(TEACHER_CODE)," +
"    CONSTRAINT CL_FK5 FOREIGN KEY (BATCH) REFERENCES BATCH_LIST(BATCH)," +
"    CONSTRAINT CL_FK6 FOREIGN KEY (CLASS_TIME_SLOT) REFERENCES CLASS_TIME_SLOTS(CLASS_TIME_SLOT)," +
"    CONSTRAINT CL_PK PRIMARY KEY (" +
"        DAY," +
"        COURSE_SHORT," +
"        COURSE_CODE," +
"        ROOM_NO," +
"        TEACHER_CODE," +
"        BATCH," +
"        CLASS_TIME_SLOT)" +
"    )"; 
        ST = ACON.createStatement();
        ST.execute(SQL);
        
            // LAB_ROUTINE
        SQL = "CREATE TABLE LAB_ROUTINE (" +
"    DAY TEXT," +
"    COURSE_SHORT varchar2(25)," +
"    COURSE_CODE TEXT," +
"    ROOM_NO TEXT," +
"    TEACHER_CODE varchar2(5)," +
"    LAB_GROUP TEXT," +
"    LAB_TIME_SLOT varchar2(20)," +
"    " +
"    CONSTRAINT LB_FK1 FOREIGN KEY (DAY) REFERENCES DAY_LIST(DAY)," +
"    CONSTRAINT LB_FK2 FOREIGN KEY (COURSE_CODE) REFERENCES COURSE_LIST(COURSE_CODE)," +
"    CONSTRAINT LB_FK3 FOREIGN KEY (ROOM_NO) REFERENCES ROOM_LIST(ROOM_NO)," +
"    CONSTRAINT LB_FK4 FOREIGN KEY (TEACHER_CODE) REFERENCES FACULTY_LIST(TEACHER_CODE)," +
"    CONSTRAINT LB_FK5 FOREIGN KEY (LAB_GROUP) REFERENCES LAB_GROUPS(LAB_GROUP)," +
"    CONSTRAINT LB_FK6 FOREIGN KEY (LAB_TIME_SLOT) REFERENCES LAB_TIME_SLOTS(LAB_TIME_SLOT)," +
"    CONSTRAINT LB_PK PRIMARY KEY (" +
"        DAY," +
"        COURSE_SHORT," +
"        COURSE_CODE," +
"        ROOM_NO," +
"        TEACHER_CODE," +
"        LAB_GROUP," +
"        LAB_TIME_SLOT)" +
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
