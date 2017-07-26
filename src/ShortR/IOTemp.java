/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShortR;

import java.io.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author A.R. Nobel
 */
public class IOTemp {
    
    //Database db = DatabaseBuilder.create(FileFormat.V2010, new File(dbPath))
    //String dbPath = "C:/Users/Public/newDb.accdb";
    
    /// rs = connChem.getMetaData().getTables(null, null, "%", null); while (rs.next()) { String id = rs.getString(3); }
    ///// FILES LIST
    
    
    /* DatabaseMetaData dmd = conn.getMetaData();
    try (ResultSet rs = dmd.getTables(null, null, "Clients", new String[] { "TABLE" })) {
        if (rs.next()) {
            System.out.println("Table [Clients] already exists.");
        } else {
            System.out.println("Table [Clients] does not exist.");
            try (Statement s = conn.createStatement()) {
                s.executeUpdate("CREATE TABLE Clients (ID COUNTER PRIMARY KEY, LastName TEXT(100))");
                System.out.println("Table [Clients] created.");
            }
        }
    }*/
    
    
   // File dir = new File(directory);

//File[] matches = dir.listFiles(new FilenameFilter()
/*{
  public boolean accept(File dir, String name)
  {
     return name.startsWith("temp") && name.endsWith(".txt");
  }
});*/
    
                /*if (FILES[i].isFile()) {
            //System.out.println("File " + listOfFiles[i].getName());
            
            } 
            else if (listOfFiles[i].isDirectory()) 
            {
            //System.out.println("Directory " + listOfFiles[i].getName());
            }*/
    
    ///////////////// EXCEL P1
public void toExcel(JTable table, File file){
    try{
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);

        for(int i = 0; i < model.getColumnCount(); i++){
            excel.write(model.getColumnName(i) + "\t");
        }

        excel.write("\n");

        for(int i=0; i< model.getRowCount(); i++) {
            for(int j=0; j < model.getColumnCount(); j++) {
                excel.write(model.getValueAt(i,j).toString()+"\t");
            }
            excel.write("\n");
        }

        excel.close();

    }catch(IOException e){ System.out.println(e); }
}



///////////////////// CODE SNIPP
/*DefaultTableModel tableModel = new DefaultTableModel();

for(String columnName : columnNames){
   tableModel.addColumn(columnName);
}

jTable.setModel(tableModel);*/
    
}
