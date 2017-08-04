package InterfaceOne;


import static InterfaceOne.Base_1.ACON_2;
import ItextPDF.PDFV1;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A.R. Nobel
 */
public class Access_2 extends javax.swing.JFrame {

    /**
     * Creates new form AC_2
     */
    public Access_2() {
        initComponents();
        Initialize();
    }
    
    private void Initialize(){

        setSize(800,700);
        setResizable(false);
        setDefaultCloseOperation(Base_1.DISPOSE_ON_CLOSE);
        
        //Faculty List +
        try{
        Statement ST = ACON_2.createStatement();
        ResultSet RS = ST.executeQuery("SELECT MEMBER_NAME FROM FACULTY_LIST");
            while(RS.next())
            {
                FacultyList.addItem(RS.getString("MEMBER_NAME"));
            }
        RS = ST.executeQuery("SELECT BATCH FROM BATCH_LIST");
            while(RS.next())
            {
                BatchList.addItem(RS.getString("BATCH"));
            }
        RS = ST.executeQuery("SELECT DAY FROM DAY_LIST");
            while(RS.next())
            {
                DayList.addItem(RS.getString("DAY"));
            } 
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void tabInit(String TableName,String Caller)
    {
        try{
        Statement ST = ACON_2.createStatement();
        ResultSet RS = null;
        
        if(Caller.equals("Faculty"))
            RS = ST.executeQuery("SELECT DAY,BATCH,MEMBER_CODE,COURSE_CODE,COURSE_SHORT,ROOM_NO,ATTRIBUTE,START_TIME,END_TIME,START_TIME,END_TIME,MEMBER_NAME FROM CLASS_ROUTINE NATURAL JOIN FACULTY_LIST NATURAL JOIN ROOM_LIST NATURAL JOIN TIME_SLOTS WHERE MEMBER_NAME ='"+TableName+"'");;
        if(Caller.equals("Batch"))
            RS = ST.executeQuery("SELECT DAY,BATCH,MEMBER_CODE,COURSE_CODE,COURSE_SHORT,ROOM_NO,ATTRIBUTE,START_TIME,END_TIME,START_TIME,END_TIME FROM CLASS_ROUTINE NATURAL JOIN FACULTY_LIST NATURAL JOIN ROOM_LIST NATURAL JOIN TIME_SLOTS WHERE BATCH ='"+TableName+"'");;
        if(Caller.equals("Day"))
            RS = ST.executeQuery("SELECT * FROM CLASS_ROUTINE NATURAL JOIN FACULTY_LIST NATURAL JOIN ROOM_LIST WHERE DAY ='"+TableName+"'");
        
////////        ResultSetMetaData RSMD = RS.getMetaData();
////////        int COL = RSMD.getColumnCount();
        DefaultTableModel TM = new DefaultTableModel();
        
////////        for(int i = 1; i <= COL; i++)
////////        {
////////            TM.addColumn(RSMD.getColumnName(i));
////////        }
        
        TM.addColumn("Day/\nTime");
        TM.addColumn("8:00-9:15");
        TM.addColumn("9:15-10:30");
        TM.addColumn("10:30-11:45");
        TM.addColumn("11:45-1:00");
        TM.addColumn("1:00-2:15");
        TM.addColumn("2:15-3:30");
        TM.addColumn("3:30-4:45");
        TM.addColumn("4:45-6:00");
        TM.addColumn("6:00-9:00");
        
        if(Caller.equals("Faculty"))
            FacultyRoutine.setModel(TM);
        if(Caller.equals("Batch"))
            BatchRoutine.setModel(TM);
        if(Caller.equals("Day"))
            DayRoutine.setModel(TM);
        
        FacultyRoutine.setRowHeight(75);
        BatchRoutine.setRowHeight(75);
        DayRoutine.setRowHeight(75);
        
        TM.addRow(new Object[]{"Saturday"});
        TM.addRow(new Object[]{"Sunday"});
        TM.addRow(new Object[]{"Monday"});
        TM.addRow(new Object[]{"Tuesday"});
        TM.addRow(new Object[]{"Wednesday"});
        TM.addRow(new Object[]{"Thursday"});
        TM.addRow(new Object[]{"Friday"});

        
        while(RS.next()) {
            
          switch (RS.getString("ATTRIBUTE")){
              case "CLASS": {
                    switch(RS.getString("DAY")){
                      case "Saturday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":  TM.setValueAt((Object)S, 0, 1);
                                           break;
                                  case "9:15 AM":  TM.setValueAt((Object)S, 0, 2);
                                           break;
                                  case "10:30 AM":  TM.setValueAt((Object)S, 0, 3);
                                           break;
                                  case "11:45 AM":  TM.setValueAt((Object)S, 0, 4);
                                           break;
                                  case "1:00 PM":  TM.setValueAt((Object)S, 0, 5);
                                           break;
                                  case "2:15 PM":  TM.setValueAt((Object)S, 0, 6);
                                           break;
                                  case "3:30 PM":  TM.setValueAt((Object)S, 0, 7);
                                           break;
                                  case "4:45 PM":  TM.setValueAt((Object)S, 0, 8);
                                           break;

                                      }

                              }
                              break;
                      case "Sunday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":  TM.setValueAt((Object)S, 1, 1);
                                           break;
                                  case "9:15 AM":  TM.setValueAt((Object)S, 1, 2);
                                           break;
                                  case "10:30 AM":  TM.setValueAt((Object)S, 1, 3);
                                           break;
                                  case "11:45 AM":  TM.setValueAt((Object)S, 1, 4);
                                           break;
                                  case "1:00 PM":  TM.setValueAt((Object)S, 1, 5);
                                           break;
                                  case "2:15 PM":  TM.setValueAt((Object)S, 1, 6);
                                           break;
                                  case "3:30 PM":  TM.setValueAt((Object)S, 1, 7);
                                           break;
                                  case "4:45 PM":  TM.setValueAt((Object)S, 1, 8);
                                           break;
                                  
                                      }
                              }
                              break;
                      case "Monday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":  TM.setValueAt((Object)S, 2, 1);
                                           break;
                                  case "9:15 AM":  TM.setValueAt((Object)S, 2, 2);
                                           break;
                                  case "10:30 AM":  TM.setValueAt((Object)S, 2, 3);
                                           break;
                                  case "11:45 AM":  TM.setValueAt((Object)S, 2, 4);
                                           break;
                                  case "1:00 PM":  TM.setValueAt((Object)S, 2, 5);
                                           break;
                                  case "2:15 PM":  TM.setValueAt((Object)S, 2, 6);
                                           break;
                                  case "3:30 PM":  TM.setValueAt((Object)S, 2, 7);
                                           break;
                                  case "4:45 PM":  TM.setValueAt((Object)S, 2, 8);
                                           break;
                                  
                                      }
                              }
                              break;

                      case "Tuesday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":  TM.setValueAt((Object)S, 3, 1);
                                           break;
                                  case "9:15 AM":  TM.setValueAt((Object)S, 3, 2);
                                           break;
                                  case "10:30 AM":  TM.setValueAt((Object)S, 3, 3);
                                           break;
                                  case "11:45 AM":  TM.setValueAt((Object)S, 3, 4);
                                           break;
                                  case "1:00 PM":  TM.setValueAt((Object)S, 3, 5);
                                           break;
                                  case "2:15 PM":  TM.setValueAt((Object)S, 3, 6);
                                           break;
                                  case "3:30 PM":  TM.setValueAt((Object)S, 3, 7);
                                           break;
                                  case "4:45 PM":  TM.setValueAt((Object)S, 3, 8);
                                           break;
                                  
                                      }
                              }
                              break;

                      case "Wednesday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":  TM.setValueAt((Object)S, 4, 1);
                                           break;
                                  case "9:15 AM":  TM.setValueAt((Object)S, 4, 2);
                                           break;
                                  case "10:30 AM":  TM.setValueAt((Object)S, 4, 3);
                                           break;
                                  case "11:45 AM":  TM.setValueAt((Object)S, 4, 4);
                                           break;
                                  case "1:00 PM":  TM.setValueAt((Object)S, 4, 5);
                                           break;
                                  case "2:15 PM":  TM.setValueAt((Object)S, 4, 6);
                                           break;
                                  case "3:30 PM":  TM.setValueAt((Object)S, 4, 7);
                                           break;
                                  case "4:45 PM":  TM.setValueAt((Object)S, 4, 8);
                                           break;
                                  
                                      }
                              }
                              break;

                      case "Thursday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":  TM.setValueAt((Object)S, 5, 1);
                                           break;
                                  case "9:15 AM":  TM.setValueAt((Object)S, 5, 2);
                                           break;
                                  case "10:30 AM":  TM.setValueAt((Object)S, 5, 3);
                                           break;
                                  case "11:45 AM":  TM.setValueAt((Object)S, 5, 4);
                                           break;
                                  case "1:00 PM":  TM.setValueAt((Object)S, 5, 5);
                                           break;
                                  case "2:15 PM":  TM.setValueAt((Object)S, 5, 6);
                                           break;
                                  case "3:30 PM":  TM.setValueAt((Object)S, 5, 7);
                                           break;
                                  case "4:45 PM":  TM.setValueAt((Object)S, 5, 8);
                                           break;
                                  
                                      }
                              }
                              break;

                          }
              }
              break;
              case "LAB":{
                                      switch(RS.getString("DAY")){
                      case "Saturday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                    case "8:00 AM":     {
                                    TM.setValueAt((Object)S, 0, 1);
                                    TM.setValueAt("<<<<<<<<<|", 0, 2);
                                    }
                             break;
                    case "10:30 AM":     {
                                    TM.setValueAt((Object)S, 0, 3);
                                    TM.setValueAt("<<<<<<<<<|", 0, 4);
                                    }
                             break;
                    case "1:00 PM":     {
                                    TM.setValueAt((Object)S, 0, 5);
                                    TM.setValueAt("<<<<<<<<<|", 0, 6);
                                    }
                             break;
                    case "3:30 PM":     {
                                    TM.setValueAt((Object)S, 0, 7);
                                    TM.setValueAt("", 0, 8);
                                    }
                             break;


                                      }

                              }
                              break;
                      case "Sunday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":     {
                                                  TM.setValueAt((Object)S, 1, 1);
                                                  TM.setValueAt("<<<<<<<<<|", 1, 2);
                                                  }
                                           break;
                                  case "10:30 AM":     {
                                                  TM.setValueAt((Object)S, 1, 3);
                                                  TM.setValueAt("<<<<<<<<<|", 1, 4);
                                                  }
                                           break;
                                  case "1:00 PM":     {
                                                  TM.setValueAt((Object)S, 1, 5);
                                                  TM.setValueAt("<<<<<<<<<|", 1, 6);
                                                  }
                                           break;
                                  case "3:30 PM":     {
                                                  TM.setValueAt((Object)S, 1, 7);
                                                  TM.setValueAt("<<<<<<<<<|", 1, 8);
                                                  }
                                           break;
                                  
                                      }
                              }
                              break;
                      case "Monday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":     {
                                                  TM.setValueAt((Object)S, 2, 1);
                                                  TM.setValueAt("<<<<<<<<<|", 2, 2);

                                                  }
                                           break;
                                  case "10:30 AM":     {
                                                  TM.setValueAt((Object)S, 2, 3);
                                                  TM.setValueAt("<<<<<<<<<|", 2, 4);
                                                  }
                                           break;
                                  case "1:00 PM":     {
                                                  TM.setValueAt((Object)S, 2, 5);
                                                  TM.setValueAt("<<<<<<<<<|", 2, 6);
                                                  }
                                           break;
                                  case "3:30 PM":     {
                                                  TM.setValueAt((Object)S, 2, 7);
                                                  TM.setValueAt("<<<<<<<<<|", 2, 8);
                                                  }
                                           break;

                                  
                                      }
                              }
                              break;

                      case "Tuesday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":     {
                                                  TM.setValueAt((Object)S, 3, 1);
                                                  TM.setValueAt("<<<<<<<<<|", 3, 2);
                                                  }
                                           break;
                                  case "10:30 AM":     {
                                                  TM.setValueAt((Object)S, 3, 3);
                                                  TM.setValueAt("<<<<<<<<<|", 3, 4);
                                                  }
                                           break;
                                  case "1:00 PM":     {
                                                  TM.setValueAt((Object)S, 3, 5);
                                                  TM.setValueAt("<<<<<<<<<|", 3, 6);
                                                  }
                                           break;
                                  case "3:30 PM":     {
                                                  TM.setValueAt((Object)S, 3, 7);
                                                  TM.setValueAt("<<<<<<<<<|", 3, 8);
                                                  }
                                           break;
                                  
                                      }
                              }
                              break;

                      case "Wednesday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
                                  case "8:00 AM":     {
                                                  TM.setValueAt((Object)S, 4, 1);
                                                  TM.setValueAt("<<<<<<<<<|", 4, 2);
                                                  }
                                           break;
                                  case "10:30 AM":     {
                                                  TM.setValueAt((Object)S, 4, 3);
                                                  TM.setValueAt("<<<<<<<<<|", 4, 4);
                                                  }
                                           break;
                                  case "1:00 PM":     {
                                                  TM.setValueAt((Object)S, 4, 5);
                                                  TM.setValueAt("<<<<<<<<<|", 4, 6);
                                                  }
                                           break;
                                  case "3:30 PM":     {
                                                  TM.setValueAt((Object)S, 4, 7);
                                                  TM.setValueAt("<<<<<<<<<|", 4, 8);
                                                  }
                                           break;
                                  
                                      }
                              }
                              break;

                      case "Thursday":{
                                      String S = "<html>"+
                                              RS.getString("COURSE_CODE")+"<br>"+
                                              RS.getString("COURSE_SHORT")+"<br>"+
                                         "B:"+RS.getString("BATCH")+"<br>"+
                                         "R:"+RS.getString("ROOM_NO")+"<br>";

                                      switch (RS.getString("START_TIME")) {
case "8:00 AM":     {
                                                  TM.setValueAt((Object)S, 5, 1);
                                                  TM.setValueAt("<<<<<<<<<|", 5, 2);
                                                  }
                                           break;
                                  case "10:30 AM":     {
                                                  TM.setValueAt((Object)S, 5, 3);
                                                  TM.setValueAt("<<<<<<<<<|", 5, 4);
                                                  }
                                           break;
                                  case "1:00 PM":     {
                                                  TM.setValueAt((Object)S, 5, 5);
                                                  TM.setValueAt("<<<<<<<<<|", 5, 6);
                                                  }
                                           break;
                                  case "3:30 PM":     {
                                                  TM.setValueAt((Object)S, 5, 7);
                                                  TM.setValueAt("<<<<<<<<<|", 5, 8);
                                                  }
                                           break;
                                  
                                      }
                              }
                              break;

                          }
              }
              break;
              
          }

 }
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AccessPanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BatchRoutine = new javax.swing.JTable();
        Text_1 = new javax.swing.JLabel();
        BatchList = new javax.swing.JComboBox<>();
        ExportBatch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Text_2 = new javax.swing.JLabel();
        FacultyList = new javax.swing.JComboBox<>();
        ExportFaculty = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        FacultyRoutine = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        Text_4 = new javax.swing.JLabel();
        DayList = new javax.swing.JComboBox<>();
        ExportBatch1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        DayRoutine = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setText("Test");

        BatchRoutine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(BatchRoutine);

        Text_1.setText("Select Batch :");
        Text_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BatchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatchListActionPerformed(evt);
            }
        });

        ExportBatch.setText("Export");
        ExportBatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportBatchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text_1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BatchList, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                .addComponent(ExportBatch))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_1)
                    .addComponent(BatchList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportBatch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Batch", jPanel2);

        Text_2.setText("Select Faculty Member :");
        Text_2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        FacultyList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyListActionPerformed(evt);
            }
        });

        ExportFaculty.setText("Export");
        ExportFaculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportFacultyActionPerformed(evt);
            }
        });

        FacultyRoutine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(FacultyRoutine);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text_2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FacultyList, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ExportFaculty))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_2)
                    .addComponent(FacultyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportFaculty))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Faculty", jPanel3);

        Text_4.setText("Select Day :");
        Text_4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayListActionPerformed(evt);
            }
        });

        ExportBatch1.setText("Export");

        DayRoutine.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(DayRoutine);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text_4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DayList, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                .addComponent(ExportBatch1))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_4)
                    .addComponent(DayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportBatch1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Day Summary", jPanel4);

        javax.swing.GroupLayout AccessPanelLayout = new javax.swing.GroupLayout(AccessPanel);
        AccessPanel.setLayout(AccessPanelLayout);
        AccessPanelLayout.setHorizontalGroup(
            AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        AccessPanelLayout.setVerticalGroup(
            AccessPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccessPanelLayout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AccessPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AccessPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BatchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatchListActionPerformed
        // TODO add your handling code here:
        tabInit(BatchList.getSelectedItem().toString(),"Batch");
    }//GEN-LAST:event_BatchListActionPerformed

    private void DayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayListActionPerformed
        // TODO add your handling code here:
        tabInit(DayList.getSelectedItem().toString(),"Day");
    }//GEN-LAST:event_DayListActionPerformed

    private void FacultyListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyListActionPerformed
        // TODO add your handling code here:
       tabInit(FacultyList.getSelectedItem().toString(),"Faculty");
    }//GEN-LAST:event_FacultyListActionPerformed

    private void ExportBatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportBatchActionPerformed
        // TODO add your handling code here:
        String CTime = new SimpleDateFormat("     dd.MM.yyyy"/*   hh.mm"*/).format(new Date());
        try{
            PDFV1 P = new PDFV1();
            P.BatchPDF("CSE-S-"+BatchList.getSelectedItem().toString()+"  "+CTime,BatchList.getSelectedItem().toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
 
    }//GEN-LAST:event_ExportBatchActionPerformed

    private void ExportFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportFacultyActionPerformed
        // TODO add your handling code here:
                String CTime = new SimpleDateFormat("      dd.MM.yyyy"/*   hh.mm"*/).format(new Date());
        try{
            PDFV1 P = new PDFV1();
            P.FacultyPDF("Name of the Faculty Member - "+FacultyList.getSelectedItem().toString()+"  "+CTime,FacultyList.getSelectedItem().toString());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_ExportFacultyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Access_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Access_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Access_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Access_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Access_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccessPanel;
    private javax.swing.JComboBox<String> BatchList;
    private javax.swing.JTable BatchRoutine;
    private javax.swing.JComboBox<String> DayList;
    private javax.swing.JTable DayRoutine;
    private javax.swing.JButton ExportBatch;
    private javax.swing.JButton ExportBatch1;
    private javax.swing.JButton ExportFaculty;
    private javax.swing.JComboBox<String> FacultyList;
    private javax.swing.JTable FacultyRoutine;
    private javax.swing.JLabel Text_1;
    private javax.swing.JLabel Text_2;
    private javax.swing.JLabel Text_4;
    private javax.swing.JLabel Title;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
