package com.excelops;

	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.hssf.usermodel.DVConstraint;
	import org.apache.poi.hssf.usermodel.HSSFDataValidation;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.DataValidation;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.util.CellRangeAddressList;

public class CreateDropDown {

	public static void main(String args[]) throws FileNotFoundException {

		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Data Validation");
		CellRangeAddressList addressList = new CellRangeAddressList(2, 2, 0, 0);
		DVConstraint dvConstraint = DVConstraint
				.createExplicitListConstraint(new String[] { "chester", "marshall", "aMaNeM" });
		DataValidation dataValidation = new HSSFDataValidation(addressList, dvConstraint);
		dataValidation.setSuppressDropDownArrow(false);
		sheet.addValidationData(dataValidation);
		File file = new File("/home/amanv/xlsOp/XLCellDropDown.xls");

		FileOutputStream fileOut = new FileOutputStream(file);
		try {
			workbook.write(fileOut);
			System.out.println("done");
			fileOut.close();

			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
