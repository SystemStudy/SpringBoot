package com.Lirs.SpringBoot.common;

import com.Lirs.SpringBoot.model.Attrs;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

/**
 * Excel工具类
 */
public class ExcelUtil {

    public static XSSFWorkbook createExcel(List<Attrs> attrs){
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        workbook = createTable(attrs,workbook);
        return workbook;
    }

    private static XSSFWorkbook createTable(List<Attrs> attrs,XSSFWorkbook workbook){
        //创建工作页
        XSSFSheet sheet  =  workbook.createSheet("数据");
        //设置列宽
        sheet.setColumnWidth(0,19 * 256);
        sheet.setColumnWidth(1,23 * 256);
        sheet.setColumnWidth(2,14 * 256);
        sheet.setColumnWidth(3,19 * 256);
        sheet.setColumnWidth(4,15 * 256);
        //创建工作页行数
        XSSFRow row;
        XSSFCell label,type,length,column,explain;
        for(int i = 0 ; i < attrs.size() ;i++){//循环写入行
            row = sheet.createRow(i);
            label = row.createCell(0);//创建单元格
            column = row.createCell(1);
            explain = row.createCell(2);
            type = row.createCell(3);
            length = row.createCell(4);
            //写入单元格
            label.setCellValue(attrs.get(i).getLabel());
            column.setCellValue(attrs.get(i).getColumn());
            explain.setCellValue("");
            type.setCellValue(attrs.get(i).getType());
            if(attrs.get(i).getLength() == null || Integer.valueOf(attrs.get(i).getLength()).equals(0)){
                length.setCellValue("");
            }else{
                length.setCellValue(attrs.get(i).getLength());
            }
        }

        return workbook;

    }



}
