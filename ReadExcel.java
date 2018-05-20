import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcel {

	public static final String FILELOC = "/home/user/Downloads/Newgames/OpsOnExcel/src/emprecord.xls";
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(new File(FILELOC));	
		System.out.println(workbook.getNumberOfSheets());
		
		System.out.println("Retrieving Sheets using for-each loop");
		//DataFormatter contains methods for formatting the value stored in an Cell.
		DataFormatter dataFormatter = new DataFormatter();
        for(Sheet sheet: workbook) {
            System.out.println("=> " + sheet.getSheetName());
            
            for (Row row: sheet) {
                for(Cell cell: row) {
                    String cellValue = dataFormatter.formatCellValue(cell);
                    System.out.print(cellValue + "\t");
                }
                System.out.println();
            }
            
        }
	}
}
