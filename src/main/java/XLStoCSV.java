import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;

public class XLStoCSV {

    public XLStoCSV() {
    }

    public void convert(String xlsFilePath, String csvFilePath) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(xlsFilePath));
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        FileOutputStream outputStream = new FileOutputStream(new File(csvFilePath));

        for (Row row : sheet) {
            StringBuilder sb = new StringBuilder();
            for (Cell cell : row) {
                CellType cellType = cell.getCellType();
                if (cellType == CellType.STRING) {
                    String cellValue = cell.getStringCellValue();
                    cellValue = cellValue.replace("\"", "\"\"");
                    sb.append("\"").append(cellValue).append("\",");
                } else if (cellType == CellType.NUMERIC) {
                    sb.append(cell.getNumericCellValue()).append(",");
                } else if (cellType == CellType.BOOLEAN) {
                    sb.append(cell.getBooleanCellValue()).append(",");
                } else if (cellType == CellType.BLANK) {
                    sb.append(",");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("\n");
            outputStream.write(sb.toString().getBytes());
        }

        inputStream.close();
        outputStream.close();
        workbook.close();
    }
}