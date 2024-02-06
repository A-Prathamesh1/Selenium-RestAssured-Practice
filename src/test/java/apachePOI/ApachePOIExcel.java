package apachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ApachePOIExcel {
	public static void main(String[] args) throws IOException {

		// XSSF Extensible Mark-up Language SpreadSheet Format
		// Excel -> Work Books -> Sheet -> Rows -> Column -> Cell
		// FileInputStream -> XSSFWorkbook -> XSSFSheet -> sheet.getRow() ->
		// row.getLastCellNum() -> row.getCell(1);
		// currRow.getCell()

		FileInputStream file = new FileInputStream(
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium Project\\selenium-practice\\MyWorkSheet.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

//		XSSFSheet sheet = workbook.getSheetAt(0); reading with sheet index

		int rowCount = sheet.getLastRowNum() + 1;

		int colCount = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < rowCount; i++) {

			XSSFRow currRow = sheet.getRow(i); // focuses on current row

			for (int j = 0; j < colCount; j++) {
				// getCell(j).getNumericCellValue();
				// .getStringCellValue();
				// .getBooleanCellValue();
				// to read generic value .toString() is used
				String value = currRow.getCell(j).toString(); // read value from a cell

				System.out.print("    " + value);
			}
			System.out.println();
		}
	}
}
