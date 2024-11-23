package Excel;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Class01_writing {

	public static void main(String[] args) throws IOException {
		
		String filePath = System.getProperty("user.dir") + "\\testdata\\somethingElse.xlsx";
		FileOutputStream outputStream = new FileOutputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("data00");
		XSSFRow row;
		XSSFCell cell;
		int rowCount = 3, columnCount = 4;
		
		for(int i = 0; i < rowCount; i++) {
			row = sheet.createRow(i);
			for(int j = 0; j < columnCount; j++) {
				cell = row.createCell(j);
				cell.setCellValue("BATMAN");
			}
		}
		workbook.write(outputStream);
		System.out.println("Done!");
		workbook.close();
		outputStream.close();
	}

}
