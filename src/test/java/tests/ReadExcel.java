package tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class ReadExcel {

    @Test
    public void readExcel() throws IOException {
        String path ="./src/test/resources/Capitals.xlsx"; //Excel dosyamiza ulasmak icin path ini kopyalayip buraya atadik.

        FileInputStream fis = new FileInputStream(path);

        Workbook workbook;
        workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);

        System.out.println(cell);

        String data = workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        System.out.println(data);

        //toplam satir sayisini asagidaki metod ile alabiliriz.
        int rowCount = sheet.getLastRowNum(); // en son satir sayisini yani kac satir oldugunu döndürür.#
        System.out.println("rowCount = " + rowCount);

        int numberOfPhysicalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("numberOfPhysicalRows = " + numberOfPhysicalRows);

        Map<String, String> capitals= new HashMap<>();
        int countryColumn =0;
        int capitalColumn=1;
        int rowNum;

        for (rowNum =1; rowNum<= rowCount; rowNum++){
            String country= sheet.getRow(rowNum).getCell(countryColumn).getStringCellValue();
            String capital = sheet.getRow(rowNum).getCell(capitalColumn).getStringCellValue();
            System.out.println("country = " + country +" \t\tcapital = " + capital);
            capitals.put(country,capital);
        }

        System.out.println(capitals);


    }
}
