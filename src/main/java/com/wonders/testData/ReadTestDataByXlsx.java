package com.wonders.testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wonders.utils.Common;

public class ReadTestDataByXlsx {
	/**
	 * 
	 * @param modlePath: 路径名称 
	 * @param sheetNum: 读取sheet数
	 * @param colum: 读取的列
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("finally")
	public static Object[][] readData(String modlePath, int sheetNum) throws IOException {
		Object[][] result = null;
		FileInputStream fileIn = null;
		FileOutputStream fileOut = null;
		try {
			fileIn = new FileInputStream(new File(modlePath));
			XSSFWorkbook wb = new XSSFWorkbook(fileIn);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);// 获得第1个sheet
			XSSFRow row = sheet.getRow(0);
			// 得到工作表的行数
			int lrnum = sheet.getLastRowNum();
			// 得到工作表的列数
			int lcnum = sheet.getRow(0).getLastCellNum();
			result = new Object[lrnum][lcnum];
			for (int i = 1; i <= lrnum; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < lcnum; j++) {
					result[i-1][j] = Common.dealObj(row.getCell((int) j));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileOut != null)
				fileOut.close();
			if (fileIn != null)
				fileIn.close();
			return result;
		}
	}
}
