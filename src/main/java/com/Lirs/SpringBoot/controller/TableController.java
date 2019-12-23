package com.Lirs.SpringBoot.controller;

import com.Lirs.SpringBoot.util.TableUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/table")
public class TableController {
    @Autowired
    TableUtil tableUtil;

    @RequestMapping("/hello")
    public String masterSayHello(){
        return "helloWworld";
    }

    public String testMerge(){
        return "测试合并分支";
    }
}
