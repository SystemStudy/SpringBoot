package com.Lirs.SpringBoot.controller;

import com.Lirs.SpringBoot.common.ExcelUtil;
import com.Lirs.SpringBoot.common.UuidUtil;
import com.Lirs.SpringBoot.model.Attrs;
import com.Lirs.SpringBoot.model.ModelsDTO;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController()
@RequestMapping("/json")
public class JsonController{

    //private static String classpath = System.getProperty("user.dir") + "\\src\\main\\resources\\excel\\";
    private static String classpath = "/usr/spring/excel/";


    /**
     * 获取前段页面传的json，将里面的内容解析成excel
     * @param attrs
     * @param response
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/buildExcel")
    @ResponseBody
    public String getJson(@RequestBody List<Attrs> attrs, HttpServletResponse response)
            throws UnsupportedEncodingException {
        //构建exccel
        XSSFWorkbook workbook = ExcelUtil.createExcel(attrs);
        try{
            String uuid = UuidUtil.getUUID32();
            File file = new File(classpath + uuid + ".xlsx");
            file.createNewFile();
            OutputStream output = new FileOutputStream(file);
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bufferOutput = new BufferedOutputStream(output);
            workbook.write(bufferOutput);
            bufferOutput.flush();
            bufferOutput.close();
            return uuid;
        }catch (IOException io){
            io.printStackTrace();
            return null;
        }
    }

    @RequestMapping("/getExcel")
    public void getExcel(String id,HttpServletResponse response){
        String fileName = id + ".xlsx";
        File file = new File(classpath + fileName);
        if(file.exists()){
          try{
              XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
              response.setContentType("application/vnd.ms-excel;charset=UTF-8");
              response.addHeader("Content-Disposition", "attachment;filename="
                      + fileName);
              OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
              xssfWorkbook.write(outputStream);
              outputStream.flush();
              outputStream.close();
          }catch(Exception ex){
              ex.printStackTrace();
          }
        }
    }
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
