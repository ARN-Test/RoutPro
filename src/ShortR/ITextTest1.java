package ShortR;

/**
 *
 * @author A.R. Nobel
 */
import static AccessPackage.AMain.ACON;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
//import sandbox.WrapToTest;
 
//@WrapToTest
class SimpleTable {
    public static final String DEST = "results/tables/simple_table.pdf";
 
    public static void main(String[] args) throws IOException,
            DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SimpleTable().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document(new Rectangle(1366, 768));
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();
        PdfPTable table = new PdfPTable(8);
        ResultSet RS=null;
        for(int aw = 0; aw < 16; aw++){
            try{
        Statement ST = ACON.createStatement();
        RS = ST.executeQuery("SELECT * FROM CLASS_LIST NATURAL JOIN FACULTY_LIST");
            RS.next();
            table.addCell(RS.getString(1));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            
        }
        document.add(table);
        document.close();
    }
 
}
