/*Author: Madder Li
 * */
package com.wonders.utils;

import java.util.List;

import browser.common.*;

public class WebTable {

	private static IGenericWebTable _tblList;
	private static List<IGenericWebTableRow> _lstWebTableRows;

	public WebTable(IGenericWebDriver driver) {
		_tblList = driver.findTable(Find.byIndex(0));
		_lstWebTableRows = GetAllRows();
	}

	public WebTable(IGenericWebDriver driver, FindBy findBy) {
		_tblList = driver.findTable(findBy);
		_lstWebTableRows = GetAllRows();
	}

	/*
	 * GetAllRows: Get the all rows of the table
	 */
	public IGenericWebElementCollection<IGenericWebTableRow> GetAllRows() {
		return _tblList.findTableRows(Find.byTagName("tr"));
	}

	/*
	 * GetTableHeader: Get the header of the table
	 */
	public IGenericWebElementCollection<IGenericWebTableCell> GetTableHeader() {

		return _lstWebTableRows.get(0).findTableCells(Find.all());
	}

	/*
	 * GetIndexOfHeader: Get the index of table header sHeader: The header name
	 * shown in the table
	 */
	public int GetIndexOfHeader(String sHeader) {

		IGenericWebElementCollection<IGenericWebTableCell> _header = _lstWebTableRows
				.get(0).findTableCells(Find.all());

		int iSize = _header.size();

		for (int i = 0; i < iSize; i++) {

			if (_header.get(i).getText().equals(sHeader)) {
				return i;
			}
		}

		return -1;
	}

	/*
	 * GetSpecifiedRow: Get the specified row using index index: The index of
	 * table row.
	 */
	public IGenericWebTableRow GetRow(int index) {
		return _lstWebTableRows.get(index);
	}

	/*
	 * GetSpecifiedRow: Get the specified row according to specified content.
	 * sConditionHeader: The header name shown in the table sConditionContent:
	 * The content shown in the table and used to search a row.
	 */
	public IGenericWebTableRow GetRow(String sConditionHeader,
			String sConditionContent) {

		int iSize = _lstWebTableRows.size();
		int iIndex = GetIndexOfHeader(sConditionHeader);

		IGenericWebTableRow tblRow = null;

		for (int i = 0; i < iSize; i++) {

			tblRow = _lstWebTableRows.get(i);

			if (tblRow.findTableCell(Find.byIndex(iIndex + 1)).getText()
					.equals(sConditionContent)) {
				return tblRow;
			}
		}

		return null;
	}

	/*
	 * GetCellsOfRow: Get all cells of a specified row according to index.
	 * index: The index of table row.
	 */
	public IGenericWebElementCollection<IGenericWebTableCell> GetCellsOfRow(
			int index) {

		if (index == 0) {

			return GetTableHeader();

		} else if (index < 0) {

			return null;

		} else {

			return _lstWebTableRows.get(index).findTableCells(
					Find.byTagName("td"));

		}

	}

	/*
	 * GetCellsOfRow: Get all cells of a specified row which is found using
	 * specified content. sConditionHeader: The header name shown in the table
	 * sConditionContent: The content shown in the table and used to search a
	 * row.
	 */
	public IGenericWebElementCollection<IGenericWebTableCell> GetCellsOfRow(
			String sConditionHeader, String sConditionContent) {

		int iSize = _lstWebTableRows.size();
		int iIndex = GetIndexOfHeader(sConditionHeader);

		IGenericWebElementCollection<IGenericWebTableCell> _webTableCells = null;

		for (int i = 0; i < iSize; i++) {

			_webTableCells = GetCellsOfRow(i);

			if (_webTableCells.get(iIndex).getText().equals(sConditionContent)) {
				return _webTableCells;
			}
		}

		return null;
	}

	public String GetCellsOfRow2(int colIndex, int rowIndex) {
		IGenericWebElementCollection<IGenericWebTableCell> _webTableCells = null;
		_webTableCells = GetCellsOfRow(rowIndex);
		return _webTableCells.get(colIndex).getText();

	}

	/*
	 * GetSpecifiedCellOfRow: Get a specified cell of a specified row which is
	 * found using specified content. sConditionHeader: The header name shown in
	 * the table. sConditionContent: The content shown in the table and used to
	 * search a row. sObjectiveHeader: The header name corresponding the
	 * objective content which want to search.
	 */
	public IGenericWebTableCell GetCellOfRow(String sConditionHeader,
			String sConditionContent, String sObjectiveHeader) {

		IGenericWebElementCollection<IGenericWebTableCell> _webTableCells = GetCellsOfRow(
				sConditionHeader, sConditionContent);

		int index = GetIndexOfHeader(sObjectiveHeader);

		return _webTableCells.get(index + 1);

	}

}