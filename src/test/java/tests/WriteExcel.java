package tests;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {
        String path ="/Users/imrenasan/I-Informatik I/TestNG/src/test/resources/Capitals.xlsx"; //Excel dosyamiza ulasmak icin path ini kopyalayip buraya atadik.

        FileInputStream file = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.createCell(4);
        cell.setCellValue("POPULATION");

        workbook.getSheetAt(0).getRow(1).createCell(4).setCellValue("100000000");
        workbook.getSheetAt(0).getRow(2).createCell(4).setCellValue("200000000");
        workbook.getSheetAt(0).getRow(3).createCell(4).setCellValue("300000000");

        List<String> list = new ArrayList<>();
        list.add("000000");
        list.add("111111");
        list.add("3333333");
        list.add("444444");

        for (int i = 0; i < list.size(); i++) {
            workbook.getSheetAt(0).getRow(i + 5).createCell(5).setCellValue(list.get(i));
        }



        //Alttaki islemler olmadan Excel dosyasina bilgiler yazdirilmaz.
        FileOutputStream fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close(); //Kaydetmesi icin onemli
        file.close();
        workbook.close();

    }
}
