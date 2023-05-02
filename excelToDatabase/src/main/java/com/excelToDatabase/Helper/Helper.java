package com.excelToDatabase.Helper;

import com.excelToDatabase.Entity.ExcerlEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    public static boolean checkExcelFormate(MultipartFile file){
        String contentType = file.getContentType();
        if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.shee"))
        {
            return true;
        }else
        {
            return false;
        }
    }


    public static List<ExcerlEntity> convertExcelToListOfEntity(InputStream is)
    {
        List<ExcerlEntity> list =new ArrayList<>();
        try{
            XSSFWorkbook workbook = new XSSFWorkbook(is);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowNumber=0;
            Iterator<Row> iterator = sheet.iterator();

            while(iterator.hasNext())
            {
                Row row = iterator.next();
                if (rowNumber==0)
                {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cells = row.iterator();
                int cid=0;
                ExcerlEntity ee = new ExcerlEntity();
                while(cells.hasNext())
                {
                    Cell cell = cells.next();
                    switch (cid)
                    {
                        case 0:
                            ee.setStudentid((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            ee.setFirstname(cell.getStringCellValue());
                            break;
                        case 2:
                            ee.setLastname(cell.getStringCellValue());
                            break;
                        case 3:
                            ee.setAddress(cell.getStringCellValue());
                            break;
                        case 4:
                            ee.setPhone((long)cell.getNumericCellValue());
                            break;
                        case 5:
                            ee.setEmail(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    cid++;
                }
                list.add(ee);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
    }
        return list;
    }
}
