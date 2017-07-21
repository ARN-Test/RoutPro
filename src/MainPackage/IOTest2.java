/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

/**
 *
 * @author A.R. Nobel
 */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumn;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableColumns;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTTableStyleInfo;

class insertTable
{
  public static void main(String[] args)
    throws FileNotFoundException, IOException
  {
   /* Read the input file that contains the data to be converted to table */
   FileInputStream input_document = new FileInputStream(new File(System.getProperty("user.dir")+"\\Test\\data.xls"));    
   /* Create Workbook */
   XSSFWorkbook my_xlsx_workbook = new XSSFWorkbook(input_document); 
   /* Read worksheet */
   XSSFSheet sheet = my_xlsx_workbook.getSheetAt(0); 
   /* Create Table into Existing Worksheet */
   XSSFTable my_table = sheet.createTable();    
   /* get CTTable object*/
   CTTable cttable = my_table.getCTTable();
   /* Define Styles */    
   CTTableStyleInfo table_style = cttable.addNewTableStyleInfo();
   table_style.setName("TableStyleMedium9");           
   /* Define Style Options */
   table_style.setShowColumnStripes(false); //showColumnStripes=0
   table_style.setShowRowStripes(true); //showRowStripes=1    
   /* Define the data range including headers */
   AreaReference my_data_range = new AreaReference(new CellReference(0, 0), new CellReference(5, 2));    
   /* Set Range to the Table */
   cttable.setRef(my_data_range.formatAsString());
   cttable.setDisplayName("MYTABLE");      /* this is the display name of the table */
   cttable.setName("Test");    /* This maps to "displayName" attribute in &lt;table&gt;, OOXML */            
   cttable.setId(1L); //id attribute against table as long value
   /* Add header columns */               
   CTTableColumns columns = cttable.addNewTableColumns();
   columns.setCount(3L); //define number of columns
   /* Define Header Information for the Table */
    for (int i = 0; i < 3; i++)
    {
    CTTableColumn column = columns.addNewTableColumn();   
    column.setName("Column" + i);      
        column.setId(i+1);
    }   
    /* Write output as File */
    FileOutputStream fileOut = new FileOutputStream("Excel_Format_As_Table.xlsx");
    my_xlsx_workbook.write(fileOut);
    fileOut.close();
  }
  
}