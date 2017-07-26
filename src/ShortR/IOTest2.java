//
//package ShortR;
//
//import MainPackage.Main;
//import  java.io.*;  
//import  java.sql.*;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class IOTest2 {
//        public static void main(String[]args){
//        try{
//            String filename=System.getProperty("user.dir")+"\\Test\\data.xlsx"; //"cd\\test\\data.xls" ;
//            XSSFWorkbook wb=new XSSFWorkbook();
//            XSSFSheet sheet =  wb.createSheet("Test Sheet");
//            
//            
//
//            XSSFRow rowhead = sheet.createRow((short)0);
//            rowhead.createCell((short) 0).setCellValue("ROOM_NO");
//            rowhead.createCell((short) 1).setCellValue("TEACHER_CODE");
//            rowhead.createCell((short) 2).setCellValue("TRIMISTER");
//            rowhead.createCell((short) 3).setCellValue("DAY");
//            rowhead.createCell((short) 4).setCellValue("COURSE_SHORT");
//            
//            /*            // Aqua background
//            CellStyle style = wb.createCellStyle();
//            style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
//            //style.setFillPattern(CellStyle.BIG_SPOTS);
//            rowhead.createCell((short) 0).setCellStyle(style);
//            rowhead.createCell((short) 1).setCellStyle(style);
//            rowhead.createCell((short) 2).setCellStyle(style);
//            rowhead.createCell((short) 3).setCellStyle(style);
//            rowhead.createCell((short) 4).setCellStyle(style);*/
//
//            Statement ST = Main.CON.createStatement();
//            ResultSet RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN TEACHER_LIST NATURAL JOIN ROOM_LIST");
//            int i = 1;
//            while(RS.next()){
//            XSSFRow row=   sheet.createRow((short)i);
//            row.createCell((short) 0).setCellValue((RS.getString("ROOM_NO")));
//            row.createCell((short) 1).setCellValue(RS.getString("TEACHER_CODE"));
//            row.createCell((short) 2).setCellValue(RS.getString("TRIMISTER"));
//            row.createCell((short) 3).setCellValue((RS.getString("DAY")));
//            row.createCell((short) 4).setCellValue(RS.getString("COURSE_SHORT"));
//            i++;
//            }
//            FileOutputStream FileOutput =  new FileOutputStream(filename);
//            wb.write(FileOutput);
//            FileOutput.close();
//            System.out.println("Your excel file has been generated!");
//
//        } 
//        catch ( Exception e ) 
//        {
//            System.out.println(e);
//        }
//    }
//}
