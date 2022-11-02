import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;

public class readexcel {
    public static void main(String args[]) throws IOException
    {
        FileInputStream fis = new FileInputStream(new File("C:\\Legion Back up\\Desktop\\Smart.csv"));
        
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        
        HSSFSheet sheet=wb.getSheetAt(0);
        
        
    }
}
