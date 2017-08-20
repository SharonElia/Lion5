package SharonProject.pageObjects;
//import static SharonProject.utilities.Functions.initReportTest;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.json.simple.parser.JSONParser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.Iterator;
import java.io.FileReader;
/**
 * Created by SMaymonX054905 on 12/08/2017.
 */
public class WorkingWithFiles {


  //  private static final String FILE_NAME = "/test/Book1.xls";

    public static void WriteExcel(String FILE_NAME)

            throws IOException {
       HSSFWorkbook workbook = new HSSFWorkbook();
       HSSFSheet sheet = workbook.createSheet("SharonTest2");

        Object[][] bookData = {
                {"Hili", "Maymon", 2},
                {"Elia", "Maymon", 3},
                {"Hana", "Maymon", 36},
                {"Sharon", "Maymon", 40},
        };

        int rowCount = 0;

        for (Object[] aBook : bookData) {
          Row row = sheet.createRow(++rowCount);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }

        try (FileOutputStream outputStream = new FileOutputStream(FILE_NAME)) {
            workbook.write(outputStream);


        }
    }
        public static void ReadExcel(String excelFilePath) throws IOException {

        FileInputStream inputStream =new FileInputStream(new File(excelFilePath));
        Workbook workbook =new HSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator <Row> iterator = firstSheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator <Cell> cellIterator = nextRow.cellIterator();
            while (cellIterator.hasNext()) {

                Cell cell = cellIterator.next();
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.print(cell.getBooleanCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.print(cell.getNumericCellValue());
                        break;
                }
                System.out.print(" - ");
            }
            System.out.println();
        }
        inputStream.close();
        }

    public static void xmlReader(String fXmlFile)
    {

     //   File fXmlFile = new File("/test/XMLTest.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("staff");
            //  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Staff id : " + eElement.getAttribute("id"));
                    System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                    // System.out.println("Elia");

                }}}
        catch (Exception e) {
            e.printStackTrace();
        }}


        public static void TxtReader(String FILENAME)
        {



                BufferedReader br = null;
                FileReader fr = null;

            try {

                    br = new BufferedReader(new FileReader(FILENAME));
                    fr = new FileReader(FILENAME);
                    br = new BufferedReader(fr);

                    String sCurrentLine;

                    while ((sCurrentLine = br.readLine()) != null) {
                        System.out.println(sCurrentLine);
                    }

                } catch (IOException e) {

                    e.printStackTrace();

                } finally {

                    try {

                        if (br != null)
                            br.close();

                        if (fr != null)
                            fr.close();

                    } catch (IOException ex) {

                        ex.printStackTrace();

                    }}}


                public static void JsonReader(String FILENAME)   {

                JSONParser parser = new JSONParser( );

                try {

                    Object obj = parser.parse(new FileReader(FILENAME));


                    JSONObject jsonObject = (JSONObject) obj;

                    String name = (String) jsonObject.get("Name");
                    String author = (String) jsonObject.get("Author");
                    JSONArray companyList = (JSONArray) jsonObject.get("Company List");

                    System.out.println("Name: " + name);
                    System.out.println("Author: " + author);
                    System.out.println("\nCompany List:");
                    Iterator<String> iterator = companyList.iterator();
                    while (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



        }

















