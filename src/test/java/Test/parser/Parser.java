package Test.parser;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Parser {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;

    public static void setExcelFile(String Path, String SheetName) {
        try {
            FileInputStream ExcelFile = new FileInputStream(Path);
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<List<String>> parseFile(String path, String sheetName){
        setExcelFile(path,sheetName);
        List<List<String>> data = new LinkedList<List<String>>();
        List<String> elements;
        Iterator rows =  ExcelWSheet.rowIterator();
        XSSFRow row = (XSSFRow) rows.next();
        while (rows.hasNext()){
            elements = new LinkedList<String>();
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()){
                XSSFCell cell = (XSSFCell)cells.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                elements.add(cell.getStringCellValue());
            }
            data.add(elements);
        }
        return data;
    }
}
