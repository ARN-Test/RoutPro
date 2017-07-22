package MainPackage;

import static MainPackage.Main.CON;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A.R. Nobel
 */
public class TestInterface extends javax.swing.JFrame {

    /**
     * Creates new form TestInterface
     */
    
    private void Initialization(){
        initComponents();
        setSize(800,500);
        setResizable(false);
        
        //Faculty List +
        try{
        Statement ST = CON.createStatement();
        ResultSet RS = ST.executeQuery("SELECT TEACHER_NAME FROM TEACHER_LIST");
            while(RS.next())
            {
                FacultyList.addItem(RS.getString("TEACHER_NAME"));
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
        /// FMT Column Setting
//        RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST");
//        ResultSetMetaData RSMD = RS.getMetaData();
//        int COL = RSMD.getColumnCount();
//        DefaultTableModel TM = new DefaultTableModel();
//        
//        for(int i = 1; i <= COL; i++)
//        {
//            TM.addColumn(RSMD.getColumnName(i));
//        }
//        FMT.setModel(TM);
        
        
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    private void tabInit(String TableName,String Caller)
    {
        try{
        Statement ST = CON.createStatement();
        ResultSet RS = null;
        
        if(Caller.equals("Faculty"))
            RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST WHERE TEACHER_NAME ='"+TableName+"'");;
        if(Caller.equals("Batch"))
            RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST WHERE BATCH ='"+TableName+"'");;
        if(Caller.equals("Day"))
            RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST WHERE DAY ='"+TableName+"'");
        ResultSetMetaData RSMD = RS.getMetaData();
        int COL = RSMD.getColumnCount();
        DefaultTableModel TM = new DefaultTableModel();
        
        for(int i = 1; i <= COL; i++)
        {
            TM.addColumn(RSMD.getColumnName(i));
        }
        if(Caller.equals("Faculty"))
            FMT.setModel(TM);
        if(Caller.equals("Batch"))
            BT.setModel(TM);
        if(Caller.equals("Day"))
            DT.setModel(TM);
        while(RS.next()) {
        TM.addRow(new Object[] {   RS.getString(1) 
                        , RS.getString(2)
                        , RS.getString(3)
                        , RS.getString(4)
                        , RS.getString(5)
                        , RS.getString(6)
                        , RS.getString(7)
                        , RS.getString(8)
                        , RS.getString(9)
                        , RS.getString(10) });
 }
        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public TestInterface() {
        Initialization();
        try{
            //LookandFeelTest
        //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        }
        catch(Exception e){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JTabbedPane();
        FacultyPanel = new javax.swing.JPanel();
        TL2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        FMT = new javax.swing.JTable();
        FacultyList = new javax.swing.JComboBox<>();
        TL1 = new javax.swing.JLabel();
        BatchPanel = new javax.swing.JPanel();
        TL3 = new javax.swing.JLabel();
        BatchList = new javax.swing.JComboBox<>();
        TL4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BT = new javax.swing.JTable();
        DayPanel = new javax.swing.JPanel();
        TL5 = new javax.swing.JLabel();
        DayList = new javax.swing.JComboBox<>();
        TL6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DT = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TL2.setText("Select Faculty Member :");

        FMT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(FMT);

        FacultyList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacultyListActionPerformed(evt);
            }
        });

        TL1.setText("[Select To Initialize]");

        javax.swing.GroupLayout FacultyPanelLayout = new javax.swing.GroupLayout(FacultyPanel);
        FacultyPanel.setLayout(FacultyPanelLayout);
        FacultyPanelLayout.setHorizontalGroup(
            FacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FacultyPanelLayout.createSequentialGroup()
                .addComponent(TL2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FacultyList, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TL1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        FacultyPanelLayout.setVerticalGroup(
            FacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FacultyPanelLayout.createSequentialGroup()
                .addGroup(FacultyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TL2)
                    .addComponent(FacultyList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TL1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        MainPanel.addTab("Faculty", FacultyPanel);

        TL3.setText("Select Batch :");

        BatchList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatchListActionPerformed(evt);
            }
        });

        TL4.setText("[Select To Initialize]");

        BT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(BT);

        javax.swing.GroupLayout BatchPanelLayout = new javax.swing.GroupLayout(BatchPanel);
        BatchPanel.setLayout(BatchPanelLayout);
        BatchPanelLayout.setHorizontalGroup(
            BatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BatchPanelLayout.createSequentialGroup()
                .addComponent(TL3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BatchList, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TL4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        BatchPanelLayout.setVerticalGroup(
            BatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BatchPanelLayout.createSequentialGroup()
                .addGroup(BatchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TL3)
                    .addComponent(BatchList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TL4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        MainPanel.addTab("Batch", BatchPanel);

        TL5.setText("Select Batch :");

        DayList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayListActionPerformed(evt);
            }
        });

        TL6.setText("[Select To Initialize]");

        DT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(DT);

        javax.swing.GroupLayout DayPanelLayout = new javax.swing.GroupLayout(DayPanel);
        DayPanel.setLayout(DayPanelLayout);
        DayPanelLayout.setHorizontalGroup(
            DayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DayPanelLayout.createSequentialGroup()
                .addComponent(TL5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DayList, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TL6, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        DayPanelLayout.setVerticalGroup(
            DayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DayPanelLayout.createSequentialGroup()
                .addGroup(DayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TL5)
                    .addComponent(DayList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TL6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        MainPanel.addTab("Day", DayPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FacultyListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacultyListActionPerformed
        // TODO add your handling code here:
        tabInit(FacultyList.getSelectedItem().toString(),"Faculty");
    }//GEN-LAST:event_FacultyListActionPerformed

    private void BatchListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatchListActionPerformed
        // TODO add your handling code here:
        tabInit(BatchList.getSelectedItem().toString(),"Batch");
    }//GEN-LAST:event_BatchListActionPerformed

    private void DayListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayListActionPerformed
        // TODO add your handling code here:
        tabInit(DayList.getSelectedItem().toString(),"Day");
    }//GEN-LAST:event_DayListActionPerformed

    
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
            java.util.logging.Logger.getLogger(TestInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BT;
    private javax.swing.JComboBox<String> BatchList;
    private javax.swing.JPanel BatchPanel;
    private javax.swing.JTable DT;
    private javax.swing.JComboBox<String> DayList;
    private javax.swing.JPanel DayPanel;
    private javax.swing.JTable FMT;
    private javax.swing.JComboBox<String> FacultyList;
    private javax.swing.JPanel FacultyPanel;
    private javax.swing.JTabbedPane MainPanel;
    private javax.swing.JLabel TL1;
    private javax.swing.JLabel TL2;
    private javax.swing.JLabel TL3;
    private javax.swing.JLabel TL4;
    private javax.swing.JLabel TL5;
    private javax.swing.JLabel TL6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
