package by.bsc.miac.helper;

import by.bsc.miac.entity.ReportEntity;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

public class ExcelHelperForm12 {
    // All main types: https://developer.mozilla.org/ru/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"; // xls & xlsx
    static String[] HEADERs = { "Объем произведенной", "Объем отгруженной", "Складской запас", "Контрактная стоимость" };
    static String[] SUBHEADERs = { "с начала года", "с начала месяца" };
    static String[] SHEETs = {"ОТЧЕТ_произ_отгр", "ОТЧЕТ_отгр_экспорт"};

    public static boolean hasExcelFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static ReportEntity excelToReport(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet[] sheets = {workbook.getSheet(SHEETs[0]), workbook.getSheet(SHEETs[1])};
            ReportEntity reportEntity = new ReportEntity();

            readOneSheet(reportEntity, sheets[0]);
            readOneSheet(reportEntity, sheets[1]);

            workbook.close();

            return reportEntity;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

    private static void readOneSheet(ReportEntity reportEntity, Sheet sheet){
        Iterator<Row> rows = sheet.iterator();

        Row rowNumber = null;
        Cell cellNumber = null;
        if (sheet.getSheetName().equalsIgnoreCase(SHEETs[0])){
            rowNumber.setRowNum(18);
            cellNumber = rowNumber.getCell(4);
            reportEntity.setProduceAll((float) cellNumber.getNumericCellValue());
        }else {
            rowNumber.setRowNum(19);
            cellNumber = rowNumber.getCell(6);
            reportEntity.setExportUnitAll((float) cellNumber.getNumericCellValue());
        }
    }
}
