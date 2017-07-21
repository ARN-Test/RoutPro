package MainPackage;


import  java.io.*;  
import  java.sql.*;
import  org.apache.poi.hssf.usermodel.HSSFSheet;  
import  org.apache.poi.hssf.usermodel.HSSFWorkbook; 
import  org.apache.poi.hssf.usermodel.HSSFRow;
//import  org.apache.poi.hssf.usermodel.HSSFCell;  

class TestExcelFile{
    public static void main(String[]args){
        try{
            String filename=System.getProperty("user.dir")+"\\Test\\data.xls"; //"cd\\test\\data.xls" ;
            HSSFWorkbook hwb=new HSSFWorkbook();
            HSSFSheet sheet =  hwb.createSheet("Test Sheet");

            HSSFRow rowhead=   sheet.createRow((short)0);
            rowhead.createCell((short) 0).setCellValue("ROOM_NO");
            rowhead.createCell((short) 1).setCellValue("TEACHER_CODE");
            rowhead.createCell((short) 2).setCellValue("TRIMISTER");
            rowhead.createCell((short) 3).setCellValue("DAY");
            rowhead.createCell((short) 4).setCellValue("COURSE_SHORT");

            Statement ST = Main.CON.createStatement();
            ResultSet RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST");
            int i = 1;
            while(RS.next()){
            HSSFRow row=   sheet.createRow((short)i);
            row.createCell((short) 0).setCellValue((RS.getString("ROOM_NO")));
            row.createCell((short) 1).setCellValue(RS.getString("TEACHER_CODE"));
            row.createCell((short) 2).setCellValue(RS.getString("TRIMISTER"));
            row.createCell((short) 3).setCellValue((RS.getString("DAY")));
            row.createCell((short) 4).setCellValue(RS.getString("COURSE_SHORT"));
            i++;
            }
            FileOutputStream FileOutput =  new FileOutputStream(filename);
            hwb.write(FileOutput);
            FileOutput.close();
            System.out.println("Your excel file has been generated!");

        } 
        catch ( Exception e ) 
        {
            System.out.println(e);
        }
    }
}
