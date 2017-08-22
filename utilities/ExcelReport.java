package SharonProject.utilities;

import SharonProject.testNG.TestNGFramework;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by SMaymonX054905 on 22/08/2017.
 */
public class ExcelReport extends TestNGFramework {

    private static HSSFSheet ExcelWSheet;

    private static HSSFWorkbook ExcelWBook;

    private static HSSFCell Cell;

    private static HSSFRow Row;
    static SharonProject.pageObjects.FillForms F;


    public ExcelReport() throws Exception {


    }

public static void FillForm() throws Exception {
    String  Name = getCellData(1, 1);
    String Email = getCellData(1, 2);
    String Mobile = getCellData(1, 3);
    String Country = getCellData(1, 4);
    String YourMessage = getCellData(1, 5);
    F.Name(driver).sendKeys(Name);
    Thread.sleep(4000);
    F.Email(driver).sendKeys(Email);
    Thread.sleep(4000);
    F.Mobile(driver).sendKeys(Mobile);
    Thread.sleep(4000);
    F.Country(driver).sendKeys(Country);
    Thread.sleep(4000);
    F.YourMessage(driver).sendKeys(YourMessage);
    Thread.sleep(4000);
    System.out.println("Great Job.");
   setCellData("Pass", 1, 6);

}

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {

            // Open the Excel file

            FileInputStream ExcelFile = new FileInputStream(Path);

            // Access the required test data sheet

            ExcelWBook = new HSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet(SheetName);

        } catch (Exception e) {

            throw (e);

        }}

        public  static String getCellData(int RowNum, int ColNum) throws Exception{

            try{

                Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

                String CellData = Cell.getStringCellValue();

                return CellData;

            }catch (Exception e){

                return"";

            }

        }
    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception	{

        try{

            Row  = ExcelWSheet.getRow(RowNum);

            Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

            if (Cell == null) {

                Cell = Row.createCell(ColNum);

                Cell.setCellValue(Result);

            } else {

                Cell.setCellValue(Result);

            }

            FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

            ExcelWBook.write(fileOut);

            fileOut.flush();

            fileOut.close();

        }catch(Exception e){

            throw (e);

        }

    }

}









