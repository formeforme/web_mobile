package Test.LoginTest;

import Pages.Login.User;


import org.testng.annotations.DataProvider;


public class LoginPageData {
    @DataProvider(name = "PTData")
    public static Object[][] PTData() {
        return new Object[][]{
                {new User() {{
                    setUsername("admin");
                    setPassword("789456");
                }},}
        };
    }

    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new User()},
                {new User() {{
                    setUsername("admin");
                }},},
                {new User() {{
                    setUsername("another");
                    setPassword("another");
                }},},
                {new User() {{
                    setPassword("789456");
                }},}

        };
    }
   /* public static List<String> parseFile(String file){
        String FilePath = "./data/data.xlsx";
        FileInputStream fs = null;
        Workbook wb = null;
        try {
            fs = new FileInputStream(FilePath);
            wb = Workbook.getWorkbook(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheet(0);
        for (int j = 0; j < sheet.getColumns(); j++)
        {
            for (int i = 0; i < sheet.getRows(); i++)
            {
                Cell cell = sheet.getCell(j, i);
                System.out.println(cell.getContents());
            }
        }
        return null;
    }
*/

}
/*
class ExcelUtils {


    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    //This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e){

            throw (e);

        }

    }

    //This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public static String getCellData(int RowNum, int ColNum) throws Exception{

        try{

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

            String CellData = Cell.getStringCellValue();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+CellData);

            return CellData;

        }catch (Exception e){

            return"";

        }

    }
    */

