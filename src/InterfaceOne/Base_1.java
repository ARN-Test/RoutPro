package InterfaceOne;

import java.io.File;
import java.util.Date;

/**
 *
 * @author A.R. Nobel
 */
public class Base_1 extends javax.swing.JFrame {


    File DIRECTORY;
    File[] FILES;
    
    public Base_1() {
        initComponents();
        Initialize();
    }
    

    
    
    private void Initialize(){

        setSize(800,500);
        setResizable(false);
        setDefaultCloseOperation(Base_1.DISPOSE_ON_CLOSE);
        OLD_1.setEditable(false);
        SelectedFileDetails.setEditable(false);
        
        //Intro
        FileList.removeAllItems();
        SelectedFileDetails.setText("");
        OLD_1.setText("Old Files :");
        
        //SetFileList
        DIRECTORY = new File(System.getProperty("user.dir")+"\\AccessDatabase\\");
        FILES = DIRECTORY.listFiles();//(File FILE, String NAME) -> /*NAME.startsWith("temp") &&*/ NAME.endsWith(".accdb")

        for (File FILES1 : FILES) {
            if (FILES1.isFile()) {
                FileList.addItem(FILES1.getName());
            }
        }
                
        //SetOldFiles
        DIRECTORY = new File(System.getProperty("user.dir")+"\\AccessDatabase\\OLD\\");
        FILES = DIRECTORY.listFiles(); //(File FILE, String NAME) -> /*NAME.startsWith("temp") &&*/ NAME.endsWith(".accdb")
        
        for (File FILES1 : FILES) {
            if (FILES1.isFile()) {
                OLD_1.append("\n" + FILES1.getName());
            }
        }
        
        
        
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PANEL_1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Selections = new javax.swing.JLabel();
        FileList = new javax.swing.JComboBox<>();
        SelectedFile = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OLD_1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SelectedFileDetails = new javax.swing.JTextArea();
        Database = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PANEL_1.setBackground(new java.awt.Color(235, 235, 235));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Stanford University Bangladesh - Routine Database");

        Selections.setText("Select Database File :");

        FileList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileListActionPerformed(evt);
            }
        });

        SelectedFile.setText("Currently Selected File :");

        OLD_1.setColumns(20);
        OLD_1.setRows(5);
        OLD_1.setText("Old Files :");
        jScrollPane1.setViewportView(OLD_1);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SelectedFileDetails.setColumns(20);
        SelectedFileDetails.setLineWrap(true);
        SelectedFileDetails.setRows(5);
        jScrollPane2.setViewportView(SelectedFileDetails);

        Database.setText("Load Database");
        Database.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PANEL_1Layout = new javax.swing.GroupLayout(PANEL_1);
        PANEL_1.setLayout(PANEL_1Layout);
        PANEL_1Layout.setHorizontalGroup(
            PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PANEL_1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(PANEL_1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PANEL_1Layout.createSequentialGroup()
                        .addGroup(PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PANEL_1Layout.createSequentialGroup()
                                .addComponent(Selections)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FileList, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(SelectedFile, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(Database, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PANEL_1Layout.setVerticalGroup(
            PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PANEL_1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PANEL_1Layout.createSequentialGroup()
                        .addGroup(PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PANEL_1Layout.createSequentialGroup()
                                .addGroup(PANEL_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Selections)
                                    .addComponent(FileList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addComponent(SelectedFile))
                            .addComponent(Database, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PANEL_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PANEL_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Initialize();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void FileListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileListActionPerformed
        // TODO add your handling code here:
        SelectedFileDetails.setText("");
        
        DIRECTORY = new File(System.getProperty("user.dir")+"\\AccessDatabase\\");
        FILES = DIRECTORY.listFiles();
        Long time;
        Date DT;
        
        try{
        for (File FILES1 : FILES) {
                if (FILES1.getName().equals(FileList.getSelectedItem().toString())) {
                    time = FILES1.lastModified();
                     DT = new Date(time);
                    SelectedFileDetails.append("Database Name: "+FILES1.getName()
                                                +"\nSize: "+FILES1.length()+" bytes"
                                                +"\nPath: "+FILES1.getAbsolutePath()
                                                +"\nLast Modified : "+ DT
                                                /*+"\nLast Access   : "+FILES1.getTotalSpace()*/
                                                /*+"\nCreated at      : "+StringUtils.substringBefore(ATTR.creationTime().toString(), "T")*/);
                }
            }

        }
        catch(NullPointerException e){
            
            //KeepScrollingNothingToSeeHere
            
            //System.out.println(e);
        }
    }//GEN-LAST:event_FileListActionPerformed

    private void DatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatabaseActionPerformed
        // TODO add your handling code here:
        Access_2 A_2 = new Access_2(FileList.getSelectedItem().toString());
        A_2.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_DatabaseActionPerformed

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
            java.util.logging.Logger.getLogger(Base_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Base_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Base_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Base_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Base_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Database;
    private javax.swing.JComboBox<String> FileList;
    private javax.swing.JTextArea OLD_1;
    private javax.swing.JPanel PANEL_1;
    private javax.swing.JLabel SelectedFile;
    private javax.swing.JTextArea SelectedFileDetails;
    private javax.swing.JLabel Selections;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
