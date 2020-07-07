package com.utils.Excel;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class DownloadExcel {

    /**
     * @function: 下载导出Excel
     * @param sheetName 表格Sheet名
     * @param titles 表格第一行（标题行）
     * @param datas 表格数据，String类型的二维数组
     */
    public static HSSFWorkbook downloadExcel(String sheetName, String[] titles, String[][] datas) {
        // 1. 创建一个Excel文件对象
        HSSFWorkbook workbook = new HSSFWorkbook();

        // 2. 创建样式，设置样式居中
        HSSFCellStyle style = workbook.createCellStyle();


//        style.setAlignment(HorizontalAlignment.CENTER);

        // 3. 在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = workbook.createSheet(sheetName);

        // 4. 在sheet中添加表头第0行，就是标题行
        HSSFRow row = sheet.createRow(0);

        // 5. 声明列对象，并创建标题
        HSSFCell cell = null;

        for (int i = 0, length = titles.length; i < length; i++) {


            HSSFCellStyle style2 = workbook.createCellStyle();
            //设置单元格样式
            style2.setFillForegroundColor(IndexedColors.RED.getIndex());
            style2.setFillPattern(style.getFillPatternEnum().SOLID_FOREGROUND );

            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            //设置样式
            cell.setCellStyle(style2);
        }

        // 6.  创建内容
        for (int i = 0, size = datas.length; i < size; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0, length = datas[i].length; j < length; j++) {
                //将内容按顺序赋给对应的列对象
                cell=row.createCell(j);
                cell.setCellValue(datas[i][j]);
                //居中显示
                cell.setCellStyle(style);
            }
        }
        return workbook;
    }

    /**
     * @function: 下载导出Excel
     * @param sheetName 表格Sheet名
     * @param titles 表格第一行（标题行）
     * @param datas 表格数据，String类型的二维数组
     */
    public static XSSFWorkbook downloadExcelX(String sheetName, String[] titles, String[][] datas) {
        // 1. 创建一个Excel文件对象
        XSSFWorkbook workbook = new XSSFWorkbook();

        // 2. 创建样式，设置样式居中
        XSSFCellStyle style = workbook.createCellStyle();


//        style.setAlignment(HorizontalAlignment.CENTER);

        // 3. 在workbook中添加一个sheet,对应Excel文件中的sheet
        XSSFSheet sheet = workbook.createSheet(sheetName);

        // 4. 在sheet中添加表头第0行，就是标题行
        XSSFRow row = sheet.createRow(0);

        // 5. 声明列对象，并创建标题
        XSSFCell cell = null;

        for (int i = 0, length = titles.length; i < length; i++) {


            XSSFCellStyle style2 = workbook.createCellStyle();
            //设置单元格样式
            style2.setFillForegroundColor(IndexedColors.RED.getIndex());
            style2.setFillPattern(style.getFillPatternEnum().SOLID_FOREGROUND );

            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            //设置样式
            cell.setCellStyle(style2);
        }

        // 6.  创建内容
        for (int i = 0, size = datas.length; i < size; i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0, length = datas[i].length; j < length; j++) {
                //将内容按顺序赋给对应的列对象
                cell=row.createCell(j);
                cell.setCellValue(datas[i][j]);
                //居中显示
                cell.setCellStyle(style);
            }
        }
        return workbook;
    }


}
