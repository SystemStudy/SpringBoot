package com.Lirs.SpringBoot.util;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TableUtil {
    //因为读取到的文件较多，为避免Arraylist频繁扩充数组大小，将初始值尽可能设置一个较大值
    private ArrayList<String> tables = new ArrayList<>(20000);
    private ArrayList<String> warnTables = new ArrayList<>(128);   //格式：类名+表名+长度

    private BufferedReader input;

    public void search(File file, int sqlLength){
        try{
            //获取目标目录下的所有文件夹和文件
            File childs[] = file.listFiles();
            //遍历所有文件夹和文件
            for(int i = 0;i < childs.length ; i++){
                if(childs[i].isFile()){//如果是文件，则进一步判断是否为java文件
                    if(childs[i].getName().endsWith(".java")){//判断是否以.java文件结尾
                        input = new BufferedReader(new FileReader(childs[i]));
                        String table = input.readLine();
                        while(!table.startsWith("@Table")){
                            if(!input.ready()) break;
                            table = input.readLine();
                        }
                        //如果检索到的类中没有table标签，则进入下一次循环
                        if(!table.startsWith("@Table"))
                            continue;
                        //检索包名和类名，拼接成完整类名
                        String fname = childs[i].getName().substring(0,childs[i].getName().length() - 5);
                        input = new BufferedReader(new FileReader(childs[i]));
                        String pkg = input.readLine();
                        while(!pkg.startsWith("package")){
                            if(!input.ready()) break;
                            pkg = input.readLine();
                        }
                        pkg = pkg.replace("package ","");
                        pkg = pkg.replace(";","");
                        String className = pkg + fname;
                        int index = KmpMatch.kmpMatch(table,"name");
                        if(index < 0){//如果@Table注解内没有name属性，则对类名进行转换:LinkPermsInfo -> link_perms_info
                            table = buidSqlName(fname);
                            String classAndTable = className + " : " + table;
                            if(table.length() > sqlLength){
                                warnTables.add(classAndTable);
                            }else{
                                tables.add(classAndTable);
                            }
                        }else{
                            table = getTableName(table.substring(index,table.length()));
                            String classAndTable = className + " : " + table;
                            if(table.length() > sqlLength){
                                warnTables.add(table);
                            }else{
                                tables.add(classAndTable);
                            }
                        }



                    }
                }

                if(childs[i].isDirectory()){
                    search(childs[i],sqlLength);
                }
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<String> getTables(){
        return tables;
    }

    public List<String> getWarnTables(){
        return warnTables;
    }

    private String buidSqlName(String str){
        str = str.replaceAll("[A-Z]", "_$0").toLowerCase();
        return str.substring(1,str.length());
    }

    private String getTableName(String str){
        char chs[] = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i = 4; i<str.length();i++) {
            if (chs[i] == '\"') {//判断是否已经将双引号中的内容读取完毕
                if (count < 2) {
                    count++;
                    continue;
                } else {
                    break;
                }
            }
            if (chs[i] >= 'A' && chs[i] <= 'z')
                sb.append(chs[i]);
        }
        return sb.toString();
    }
}
