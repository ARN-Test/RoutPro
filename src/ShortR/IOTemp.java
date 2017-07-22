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
