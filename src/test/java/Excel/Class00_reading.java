package Excel;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Class00_reading {

	public static void main(String[] args) throws IOException {
		
		String filePath = System.getProperty("user.dir") + "\\testdata\\something.xlsx";
		FileInputStream inputStream = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row;
		
		for(int i = 0; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			for(int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).toString() + "\t\t");
			}
			System.out.println();
		}
		
		workbook.close();
		inputStream.close();
	}

}
