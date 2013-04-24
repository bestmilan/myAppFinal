package com.wonders.testData;

import java.io.IOException;

public class ReadTestData {

	/** 构造方法 */
	public ReadTestData() {
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static Object[][] readData(String fileName, int sheetNum)
			throws IOException {
		/** */
		/** 对文件的合法性进行验证 */
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			return ReadTestDataByXlsx.readData(genPath(fileName), sheetNum);
		} else if (fileName.matches("^.+\\.(?i)(xls)$")) {
			return ReadTestDataByXls.readData(genPath(fileName), sheetNum);
		} else {
			return null;
		}
	}

	public static String genPath(String modlePath) {
		return "testData/" + modlePath;
	}

	/**
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static Object[][] readXmlData(String fileName) throws IOException {
		return ReadTestDataByXml.readData(genXmlPath(fileName));
	}

	public static String genXmlPath(String modlePath) {
		return "dataXml/data/" + modlePath;
	}
}
