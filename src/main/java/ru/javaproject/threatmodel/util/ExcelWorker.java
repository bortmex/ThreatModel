package ru.javaproject.threatmodel.util;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import ru.javaproject.threatmodel.model.ExcelModelElement;
import ru.javaproject.threatmodel.model.Threat;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelWorker {

    private HSSFWorkbook workbook = new HSSFWorkbook();
    private File file;
    private AtomicInteger index = new AtomicInteger(0);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
    private HSSFCellStyle cellStyle = workbook.createCellStyle();

    public ExcelWorker() {
        this.workbook = new HSSFWorkbook();
        this.index = new AtomicInteger(0);
        this.formatter = DateTimeFormatter.ofPattern("dd:MM:yyyy");
        this.cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
        //cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setWrapText(true);
    }
/*

    public static void main(String[] args) {
        ExcelWorker ew = new ExcelWorker();
        List<ExcelModelElement> data = new ArrayList<>();
        data.add(new ExcelModelElement(new Threat(1, "Угроза автоматического распространения вредоносного кода в грид-системе", "Угроза заключается в возможности внедрения и запуска вредоносного кода от имени доверенного процесса на любом из ресурсных центров грид-системы и его автоматического распространения на все узлы грид-системы.\n" +
                "Данная угроза обусловлена слабостями технологии грид-вычислений – высоким уровнем автоматизации при малой администрируемости грид-системы.\n" +
                "Реализация данной угрозы возможна при условии наличия у нарушителя привилегий легального пользователя грид-системы", "Внешний нарушитель со средним потенциалом, Внутренний нарушитель со средним потенциалом",
                                                  "Ресурсные центры грид-системы", 0, 1, 1,
                                                  LocalDateTime.now(), LocalDateTime.now()), "br11111111111111111111111111111e",
                                                  "inte111111111111g", "viola1111111111111111ti", "Низкий",
                                                  "Средний"+System.lineSeparator()+"Низкий"+System.lineSeparator()+"Высокий", "Средний"+System.lineSeparator()+"Низкий"+System.lineSeparator()+"Высокий", "Высокий", "актуальный"+System.lineSeparator()+"неактуальный"+System.lineSeparator()+"актуальный\n", "\n" +
                "Недостаточный потенциал"));
        ew.createListForExcel(data);
    }
*/

    public void createListForExcel(List<ExcelModelElement> dataList){
        // создание самого excel файла в памяти
        // создание листа с названием "Просто лист"
        HSSFSheet sheet = workbook.createSheet("Лист"+ this.index);
        /*dataModels.add(new DataModel("Howard", "Wolowitz", "Massachusetts", 90000.0));
        dataModels.add(new DataModel("Leonard", "Hofstadter", "Massachusetts", 95000.0));
        dataModels.add(new DataModel("Sheldon", "Cooper", "Massachusetts", 120000.0));*/

        // счетчик для строк
        int rowNum = 0;

        // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue("ID УБИ");
        row.createCell(1).setCellValue("Название угрозы");
        row.createCell(2).setCellValue("Описание угрозы");
        row.createCell(3).setCellValue("Источники угрозы");
        row.createCell(4).setCellValue("Объект воздействия");
        row.createCell(5).setCellValue("Нарушение конфиденциальности");
        row.createCell(6).setCellValue("Нарушение целостности");
        row.createCell(7).setCellValue("Нарушение доступности");
        row.createCell(8).setCellValue("Дата включания угрозы БнД УБИ");
        row.createCell(9).setCellValue("Дата последнего изменения данных");
        row.createCell(10).setCellValue("y1p");
        row.createCell(11).setCellValue("y2");
        row.createCell(12).setCellValue("yj");
        row.createCell(13).setCellValue("xj");
        row.createCell(14).setCellValue("UBIaj");
        row.createCell(15).setCellValue("Обоснование");
        for (int i = 0; i < 16; i++) {
            if(i==0){sheet.setColumnWidth(i, 1000); continue;}
            if(i==2){sheet.setColumnWidth(i, 10000); continue;}
            if(i==8){sheet.setColumnWidth(i, 3000); continue;}
            if(i==9){sheet.setColumnWidth(i, 3000); continue;}
            if(i==10){sheet.setColumnWidth(i, 3000); continue;}
            if(i==11){sheet.setColumnWidth(i, 3000); continue;}
            if(i==12){sheet.setColumnWidth(i, 3000); continue;}
            if(i==13){sheet.setColumnWidth(i, 3000); continue;}
            if(i==15){sheet.setColumnWidth(i, 13000); continue;}
            sheet.setColumnWidth(i, 5000);
        }

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        //cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        HSSFFont fontHeader = workbook.createFont();
        fontHeader.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        cellStyle.setFont(fontHeader);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        cellStyle.setWrapText(true);
        for (int i = 0; i < 16; i++) {
            row.getCell(i).setCellStyle(cellStyle);
        }

        // заполняем лист данными
        for (ExcelModelElement dataModel : dataList) {
            createSheetHeader(sheet, ++rowNum, dataModel);
        }

        // записываем созданный в памяти Excel документ в файл
        String nameFile = System.getProperty("user.home") + "\\Desktop\\File"+index.getAndIncrement()+".xls";
        while (isValidName(nameFile)){
            nameFile = System.getProperty("user.home") + "\\Desktop\\File"+index.getAndIncrement()+".xls";
        }
        try (FileOutputStream out = new FileOutputStream(file)) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // заполнение строки (rowNum) определенного листа (sheet)
    // данными  из dataModel созданного в памяти Excel файла
    private void createSheetHeader(HSSFSheet sheet, int rowNum, ExcelModelElement dataModel) {
        Row row = sheet.createRow(rowNum);

        Cell[] cells = new Cell[16];
        for (int i = 0; i < 16; i++) {
            cells[i] = row.createCell(i);
        }

        if(dataModel.getThreat().getId()==43){
            System.out.println("asd");
        }
        cells[0].setCellValue(dataModel.getThreat().getId());
        cells[1].setCellValue(dataModel.getThreat().getName());
        cells[2].setCellValue(dataModel.getThreat().getDescription());
        cells[3].setCellValue(dataModel.getThreat().getSourceOfThreat());
        cells[4].setCellValue(dataModel.getThreat().getTheObjectOfTheImpact());
        cells[5].setCellValue(dataModel.getBreachOfConfidentiality());
        cells[6].setCellValue(dataModel.getIntegrityViolation());
        cells[7].setCellValue(dataModel.getViolationOfAvailability());
        cells[8].setCellValue(dataModel.getThreat().getDateOfInclusionOfThreatInTheBND().format(formatter));
        cells[9].setCellValue(dataModel.getThreat().getLastModifiedDate().format(formatter));
        cells[10].setCellValue(dataModel.getY1P());
        cells[11].setCellValue(dataModel.getY2());
        cells[12].setCellValue(dataModel.getYJ());
        cells[13].setCellValue(dataModel.getXJ());
        cells[14].setCellValue(dataModel.getUBIaj());
        cells[15].setCellValue(dataModel.getDetailedDescription());
        row.setHeight((short) 1100);

        for (int i = 0; i < 16; i++) {
            cells[i].setCellStyle(cellStyle);
        }
    }

    public boolean isValidName(String text){
        try {
            file = new File(text);
            if(file.createNewFile()) return false;
            return true;
        }
        catch(Exception ex){}
        return false;
    }

}