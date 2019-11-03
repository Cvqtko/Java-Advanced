package exercise_15_stream_api_exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

public class Exercise_14 {
	private static final String OUTPUN_FILE = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_15_stream_api_exercise\\Exercise14.xls";
	private static final String INPUT_FILE = "D:\\Java_Softuni_2018\\Java_Advanced\\exercise_15_stream_api_exercise\\Students.txt";
	static int rowNum = 0;
	static int colNum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE));
		String line = reader.readLine();

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("SoftUni OOP Course Results");

		while (line != null) {
			colNum = 0;
			Row row = sheet.createRow(rowNum);
			Arrays.stream(line.split("\\t")).forEach(token -> {

				Cell cell = row.createCell(colNum++);
				if (token instanceof String) {
					cell.setCellValue((String) token);
				}
				try {
					FileOutputStream outputStream = new FileOutputStream(OUTPUN_FILE);
					workbook.write(outputStream);
					workbook.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			rowNum++;
			line = reader.readLine();

		}

	}
}
