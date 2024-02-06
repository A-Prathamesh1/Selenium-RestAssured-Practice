package apachePOI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataToExcelFile {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(
				"C:\\Users\\prath\\Documents\\Job\\SDET\\Selenium\\Selenium Project\\selenium-practice\\WritingToThisFile.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("Data1");

		for (int i = 0; i <= 5; i++) {
			XSSFRow row = sheet.createRow(i);

			for (int j = 0; j < 3; j++) {
				row.createCell(j).setCellValue("abc");
			}
		}

		workbook.write(file);
		file.close();

		System.out.println("Written data to file");
	}

}
