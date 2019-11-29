package com.excelops;

import java.io.*;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

public class UpdateExcel {
	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		Workbook workbook = WorkbookFactory.create(new File("poi-created-xlsxfile.xls"));
		
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();
		for(Row row : sheet){
			for(Cell cell : row){
				String cellValue = dataFormatter.formatCellValue(cell);
				if(cellValue.equals("Aman")){
					
					System.out.println(cellValue);
					//cell.setCellType(CellType.STRING);
					cell.setCellValue("Mani");
				}
			}
		}
		
		FileOutputStream fos = new FileOutputStream(new File("poi-created-xlsxfile.xls"));
		workbook.write(fos);
		System.out.println("done");
		fos.close();
		
		workbook.close();
	}
}
