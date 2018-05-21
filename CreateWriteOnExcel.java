package com.crudonexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateWriteOnExcel {
	private static String sheetColumns[] = {"EmpId" , "EmpName", "DOB", "EmpSal"};
	private static List<Employee> emp = new ArrayList<>();
	
	static{
		Calendar cal = Calendar.getInstance();
		cal.set(2018, 5 , 2);
		emp.add(new Employee(123, "Aman", cal.getTime(), 10000.0));
		
		cal.set(2018, 5, 15);
		emp.add(new Employee(1231, "Rashi", cal.getTime(), 100000.0));
	}
	
	public static void main(String[] args) throws IOException, InvalidFormatException  {
		
		//create a XSSFWorkbook object for workbook to create .xlsx file
		Workbook workbook = new XSSFWorkbook();
		
		
		/* CreationHelper helps us create instances of various things like DataFormat, 
        Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
     CreationHelper createHelper = workbook.getCreationHelper();
     
     	//creating a sheet employee
     	Sheet sheet = workbook.createSheet("Employee");
     
     	//designing font style for headers
     	Font headerFont = workbook.createFont();
     	headerFont.setColor(IndexedColors.RED.getIndex());
     	headerFont.setBold(true);
     	headerFont.setFontHeightInPoints((short) 14);
     	
     	
     	//applying above font-style to header cell 
     	CellStyle headerCellStyle = workbook.createCellStyle();
     	headerCellStyle.setFont(headerFont);
     	
     	//create a header row
     	Row headerRow = sheet.createRow(0);
     	
     	//create cells for header row
     	for (int i = 0; i < sheetColumns.length; i++) {
			Cell headerCell = headerRow.createCell(i);
			headerCell.setCellStyle(headerCellStyle);
			headerCell.setCellValue(sheetColumns[i]);
		}
     	
     	//create cell style for date type
     	CellStyle dateStyle = workbook.createCellStyle();
     	dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
     	
     	int rowNum = 1;
     	for(Employee employee : emp){
     		
     		Row row =sheet.createRow(rowNum++);
     		
     		Cell cell1 = row.createCell(0);
     		cell1.setCellValue(employee.getEmpId());
     		
     		Cell cell2 = row.createCell(1);
     		cell2.setCellValue(employee.getEmpName());
     		
     		Cell dateCell = row.createCell(2);
     		dateCell.setCellValue(employee.getEmpJoinDate());
     		dateCell.setCellStyle(dateStyle);
     		
     		Cell cell4 = row.createCell(3);
     		cell4.setCellValue(employee.getSal());
     	     		
     	}
     	
     	//setting best size of the cells to fit the content
     	for (int i = 0; i < sheetColumns.length; i++) {
     		sheet.autoSizeColumn(i);
		}
     	
     	
     	//writing sheet to a .xlsx file
     	FileOutputStream fis = new FileOutputStream("D:/eclipse_dir/poi-created-xlsxfile.xlsx");
     	workbook.write(fis);
     	
     	fis.close();
     	
     	workbook.close();
	}
	
}
