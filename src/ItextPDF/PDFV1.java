package ItextPDF;

import static InterfaceOne.Base_1.ACON_2;
import static InterfaceOne.Base_1.EName;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
 
public class PDFV1 {
    private Font font = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);
    //public static String FileName="Testing";
    public static String DEST;      ////Needs to be initialized in function
    public static int G_ROW;        //// Checked and rechecked in many functions
    public static String IMG = "Images\\Logo.png";
    private List<String> TName = new ArrayList<String>();
    private List<String> TCode = new ArrayList<String>();;
 
    //MAIN -- NEEDS TO BE DEPRICATED
    public static void main(String ... args) {
        //new PDFV1().BatchPDF(DEST);
        ///Not using in Interface
    }
    
        public PdfPCell createCell(String content, int colspan, int rowspan, int border) {
        
        PdfPCell cell = new PdfPCell(new Phrase(content, font));
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        cell.setBorder(border);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setNoWrap(true);
        return cell;
    }
        public PdfPCell createCell(Phrase P, int colspan, int rowspan, int border) {
        
        PdfPCell cell = new PdfPCell(P);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        cell.setBorder(border);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setNoWrap(true);
        return cell;
    }
        public PdfPCell createCell(Image content, int colspan, int rowspan, int border) {
        PdfPCell cell = new PdfPCell(content);
        cell.setColspan(colspan);
        cell.setRowspan(rowspan);
        cell.setBorder(border);
        return cell;
    }
        
        public String FindBatch(String Time, String Batch, String Day)
        {
            G_ROW = 1;
            try{
        Statement ST = ACON_2.createStatement();
        ResultSet RS;
        
        RS = ST.executeQuery("SELECT count(*) as RC FROM CLASS_ROUTINE NATURAL JOIN FACULTY_LIST NATURAL JOIN ROOM_LIST "
                                    + "  WHERE BATCH ='"+Batch+"' "
                                    + "AND DAY='"+Day+"' "
                                    + "AND START_TIME='"+Time+"'");
        RS.next();
        
            if(RS.getInt("RC")==0)
                return "";
            else
                {
                        RS = ST.executeQuery("SELECT * as RC FROM CLASS_ROUTINE NATURAL JOIN FACULTY_LIST NATURAL JOIN ROOM_LIST "
                                    + "  WHERE BATCH ='"+Batch+"' "
                                    + "AND DAY='"+Day+"' "
                                    + "AND START_TIME='"+Time+"'");
                        RS.next();
                        if(RS.getString("ATTRIBUTE").equals("LAB"))
                            G_ROW = 2;
                        int flag = 1;
                        
                        if(!TCode.isEmpty())
                            for(String T : TCode)
                            {
                                if(T.equals(RS.getString("MEMBER_CODE")))
                                {    
                                    flag = 0;
                                    break;
                                }
                            }
                        
                        if(flag == 1)
                        {
                            TCode.add(RS.getString("MEMBER_CODE"));
                            TName.add(RS.getString("MEMBER_NAME"));
                        }
                        
                        return RS.getString("COURSE_CODE")+"\n"
                                +RS.getString("COURSE_SHORT")+"\n"
                                +"CT: "+RS.getString("MEMBER_CODE")+"\n"
                                +"R: "+RS.getString("ROOM_NO")+"\n";
                }
        }
         
        
        
        catch(Exception e)
            {
                e.printStackTrace();
            }
        return "ERROR";
        }
        
        public String FindFaculty(String Time, String Member, String Day)
        {
            G_ROW = 1;
            try{
        Statement ST = ACON_2.createStatement();
        ResultSet RS;
        
        RS = ST.executeQuery("SELECT count(*) as RC FROM CLASS_ROUTINE NATURAL JOIN FACULTY_LIST NATURAL JOIN ROOM_LIST "
                                    + "  WHERE MEMBER_NAME ='"+Member+"' "
                                    + "AND DAY='"+Day+"' "
                                    + "AND START_TIME='"+Time+"'");
        RS.next();
        
            if(RS.getInt("RC")==0)
                return "";
            else
                {
                        RS = ST.executeQuery("SELECT * as RC FROM CLASS_ROUTINE NATURAL JOIN FACULTY_LIST NATURAL JOIN ROOM_LIST "
                                    + "  WHERE MEMBER_NAME ='"+Member+"' "
                                    + "AND DAY='"+Day+"' "
                                    + "AND START_TIME='"+Time+"'");
                        RS.next();
                        if(RS.getString("ATTRIBUTE").equals("LAB"))
                            G_ROW = 2;
                        
                        return RS.getString("COURSE_CODE")+"\n"
                                +RS.getString("COURSE_SHORT")+"\n"
                                +"B: "+RS.getString("BATCH")+"\n"
                                +"R: "+RS.getString("ROOM_NO")+"\n";
                }
        }
         
        
        
        catch(Exception e)
            {
                e.printStackTrace();
            }
        return "ERROR";
        }
        
    public void AddHeader(Chapter C, String FileName) throws IOException, DocumentException{
        Image I = Image.getInstance(IMG);
        I.scaleToFit(50, 70);
        
        PdfPTable HT = new PdfPTable(5);
        HT.setWidths(new int[]{ 1,1,3,1,1 });
        
        HT.addCell(createCell(I,1,3,PdfPCell.NO_BORDER));
        
        font = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        
        HT.addCell(createCell("",1,1,PdfPCell.NO_BORDER));
        
        Phrase CompP = new Phrase();
        CompP.add(new Chunk("Stamford University Bangladesh\n",  new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD)));
        CompP.add(new Chunk("Department of Computer Science and Engineering\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
        CompP.add(new Chunk(EName+"\n", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));        
        CompP.add(new Chunk(FileName, new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD)));
        //HT.addCell(CompP);
        
        HT.addCell(createCell(CompP,1,1,PdfPCell.NO_BORDER));
        
        HT.addCell(createCell("",1,3,PdfPCell.NO_BORDER));
        HT.addCell(createCell("",1,3,PdfPCell.NO_BORDER));
        
        HT.setSpacingAfter(40f);
        
        C.add(HT);
        
        font = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);

        //Previuos work at itext****test****
        
    }
    
        public void AddFooter(Chapter C) throws IOException, DocumentException{

        
        PdfPTable FT = new PdfPTable(8);
        FT.setWidths(new int[]{ 1,4,1,4,1,4,1,4 });
        int TSize = 8*(1+(TCode.size()/8));
        
        
        font = new Font(FontFamily.TIMES_ROMAN, 8, Font.BOLD);
        
        for(int i = 0;i<TSize;i++){
            if(i<TCode.size())
            {
                FT.addCell(createCell(TCode.get(i),1,1,PdfPCell.BOX));
                FT.addCell(createCell(TName.get(i),1,1,PdfPCell.BOX));
            }
            else
            {
                FT.addCell(createCell("",1,1,PdfPCell.BOX));
                FT.addCell(createCell("",1,1,PdfPCell.BOX));
            }
        }
        
        C.add(FT);
        
        font = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD);

        //Previuos work at itext****test****
        
    }
 
    public void BatchPDF(/*String EName,Trimister*/ String FileName, String Batch) throws IOException, DocumentException {
        
        DEST = "results/"+FileName+".pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        
        Document PDFdoc = new Document(PageSize.A4.rotate());   //new Rectangle(1056,816)
        PdfWriter.getInstance(PDFdoc, new FileOutputStream(DEST));
        PDFdoc.open();
        
        Chapter C;

        
        C = new Chapter(1);
        AddHeader(C,FileName);

        
        PdfPTable table = new PdfPTable(10);
        //////////////table.setWidths(new int[]{ 10,10,10,10,10,10,10,10,10,10 });
        
        
        PdfPCell cell = createCell("Time\nDay", 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        
        table.addCell(cell);
        
        table.addCell(createCell("8:00 AM\n9:15 AM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("9:15 AM\n10:30 AM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("10:30 AM\n11:45 AM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("11:45 AM\n1:00 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("1:00 PM\n2:15 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("2:15 PM\n3:30 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("3:30 PM\n4:45 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("4:45 PM\n6:00 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("6:00 PM\n9:00 PM", 1, 1, PdfPCell.BOX));
        
        //DAYS - CALC
        String CellDay;
        String Times[] = {"8:00 AM","9:15 AM", "10:30 AM", "11:45 AM", "1:00 PM", "2:15 PM", "3:30 PM", "4:45 PM", "6:00 PM"};

            ////Saturday
        CellDay = "Saturday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindBatch(Time,Batch,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Sunday
        CellDay = "Sunday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindBatch(Time,Batch,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Monday
        CellDay = "Monday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindBatch(Time,Batch,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Tuesday
        CellDay = "Tuesday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindBatch(Time,Batch,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Wednesday
        CellDay = "Wednesday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindBatch(Time,Batch,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Thursday
        CellDay = "Thursday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindBatch(Time,Batch,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Friday
        CellDay = "Friday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindBatch(Time,Batch,CellDay), 1, G_ROW, PdfPCell.BOX));

        table.setSpacingAfter(50f);
        
        C.add(table);
        
        AddFooter(C);
        
        PDFdoc.add(C);
        PDFdoc.close();
    }
    
    
    public void FacultyPDF(/*String EName,*/ String FileName, String Member) throws IOException, DocumentException {
        
        DEST = "results/"+FileName+".pdf";
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        
        Document PDFdoc = new Document(PageSize.A4.rotate());   //new Rectangle(1056,816)
        PdfWriter.getInstance(PDFdoc, new FileOutputStream(DEST));
        PDFdoc.open();
        
        Chapter C;

        
        C = new Chapter(1);
        AddHeader(C,FileName);

        
        PdfPTable table = new PdfPTable(10);
        //////////////table.setWidths(new int[]{ 10,10,10,10,10,10,10,10,10,10 });
        
        
        PdfPCell cell = createCell("Time\nDay", 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        
        table.addCell(cell);
        
        table.addCell(createCell("8:00 AM\n9:15 AM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("9:15 AM\n10:30 AM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("10:30 AM\n11:45 AM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("11:45 AM\n1:00 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("1:00 PM\n2:15 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("2:15 PM\n3:30 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("3:30 PM\n4:45 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("4:45 PM\n6:00 PM", 1, 1, PdfPCell.BOX));
        table.addCell(createCell("6:00 PM\n9:00 PM", 1, 1, PdfPCell.BOX));
        
        //DAYS - CALC
        String CellDay;
        String Times[] = {"8:00 AM","9:15 AM", "10:30 AM", "11:45 AM", "1:00 PM", "2:15 PM", "3:30 PM", "4:45 PM", "6:00 PM"};

            ////Saturday
        CellDay = "Saturday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindFaculty(Time,Member,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Sunday
        CellDay = "Sunday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindFaculty(Time,Member,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Monday
        CellDay = "Monday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindFaculty(Time,Member,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Tuesday
        CellDay = "Tuesday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindFaculty(Time,Member,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Wednesday
        CellDay = "Wednesday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindFaculty(Time,Member,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Thursday
        CellDay = "Thursday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindFaculty(Time,Member,CellDay), 1, G_ROW, PdfPCell.BOX));
        
                    ////Friday
        CellDay = "Friday";
            cell = createCell(CellDay, 1, 1, PdfPCell.BOX);
        cell.setFixedHeight(40f);
        table.addCell(cell);
        
        for(String Time : Times)
            table.addCell(createCell(FindFaculty(Time,Member,CellDay), 1, G_ROW, PdfPCell.BOX));

        table.setSpacingAfter(50f);
        
        C.add(table);
        
        
        PDFdoc.add(C);
        PDFdoc.close();
    }
////////    public void BatchPDF(String dest) throws IOException, DocumentException {
////////        Document PDFdoc = new Document();
////////        PdfWriter.getInstance(PDFdoc, new FileOutputStream(dest));
////////        PDFdoc.open();
////////        PdfPTable table = new PdfPTable(5);
////////        table.setWidths(new int[]{ 1, 2, 2, 2, 1});
////////        PdfPCell cell;
////////        cell = new PdfPCell(new Phrase("S/N"));
////////        cell.setRowspan(2);
////////        table.addCell(cell);
////////        cell = new PdfPCell(new Phrase("Name"));
////////        cell.setColspan(3);
////////        table.addCell(cell);
////////        cell = new PdfPCell(new Phrase("Age"));
////////        cell.setRowspan(2);
////////        table.addCell(cell);
////////        table.addCell("SURNAME");
////////        table.addCell("FIRST NAME");
////////        table.addCell("MIDDLE NAME");
////////        table.addCell("1");
////////        table.addCell("James");
////////        table.addCell("Fish");
////////        table.addCell("Stone");
////////        table.addCell("17");
////////        PDFdoc.add(table);
////////        PDFdoc.close();
////////    }

    
}
