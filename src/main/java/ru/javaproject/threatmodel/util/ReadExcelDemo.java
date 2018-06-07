package ru.javaproject.threatmodel.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING;
//C:/Users/Денис/Desktop/thrlist.xlsx
public class ReadExcelDemo {

    public static void main(String[] args) {
        String text = parse("C:/Users/Денис/Desktop/thrlist_copy.xlsx");
        System.out.println(text);
        writeInFile(text, "C:/Users/Денис/Desktop/pizdec.txt");
        /*Pattern p = Pattern.compile("'[\\d+]{2}.[\\d+]{2}.[\\d+]{4}'");
        String text = "'10.04.2118'dfsdf '10.01.2018' adfsfgsdgf";
        Matcher m = p.matcher(text);
        while (m.find()){
            String date = m.group();
            String resultDate = "'" + date.substring(7,11) + "-"
                    + date.substring(4,6) + "-" + date.substring(1,3);
            text = text.replaceAll(date, resultDate);
        }
        System.out.println(text);*/
    }

    private static String parse(String fileName){
        //инициализируем потоки
        String result = "('";
        //разбираем первый лист входного файла на объектную модель
        Workbook wb = null;
        try {
            wb = WorkbookFactory.create(new File(fileName));
        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
        }
        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.rowIterator();
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                //перебираем возможные типы ячеек
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + "', '";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result += cell.getNumericCellValue() + "', '";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "'),\n ('";
        }
        result = result.replaceAll("_x000d_", "");
        result = result.replaceAll("\\('[\\d{1,3}]+.0', ", "(");
        result = result.replaceAll(", ''", "");
        result = result.replaceAll(".0'", "'");
        result = result.replaceAll("\\('Общая информация', '\\|\\|\\|\\|Последствия', '\\|\\|Дополнительно', '\\|'\\),\\n \\('Идентификатор УБИ', 'Наименование УБИ', 'Описание', 'Источник угрозы \\(характеристика и потенциал нарушителя\\)', 'Объект воздействия', 'Нарушение конфиденциальности', 'Нарушение целостности', 'Нарушение доступности', 'Дата включения угрозы в БнД УБИ', 'Дата последнего изменения данных'\\),\\n "
 , "");
        result = result.substring(0,result.length()-5);
        result = replaysAllDateFormatddmmyyyytoyyyyddmm(result);
        result+=";";
        result= "INSERT INTO threat (name, description, source_of_threat, the_object_of_the_impact,\n" +
                "                  breach_of_confidentiality, integrity_violation,\n" +
                "                  violation_of_availability, date_of_inclusion_of_threat_in_the_BND,\n" +
                "                  last_modified_date) VALUES\n" +
                "  " + result;
        return result;
    }

    private static String replaysAllDateFormatddmmyyyytoyyyyddmm(String text){
        Pattern p = Pattern.compile("'[\\d+]{2}.[\\d+]{2}.[\\d+]{4}'");
        Matcher m = p.matcher(text);
        while (m.find()){
            String date = m.group();
            String resultDate = "'" + date.substring(7,11) + "-"
                    + date.substring(4,6) + "-" + date.substring(1,3) + "'";
            text = text.replaceAll(date, resultDate);
        }
        return text;
    }

    private static void writeInFile(String text, String path){
        try(FileWriter writer = new FileWriter(path, false))
        {
            // запись всей строки
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}