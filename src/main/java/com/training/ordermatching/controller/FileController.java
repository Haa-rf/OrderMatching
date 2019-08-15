package com.training.ordermatching.controller;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/orderMatching/file")
public class FileController {

    @Value("${order_log.filePathPar}")
    private String parentFilePath;

    @GetMapping("/download")
    public void downloadFile(@RequestParam("specificDate")String specificDate, HttpServletRequest request, HttpServletResponse response){
        String fileName = specificDate+".log";
        String path =parentFilePath+fileName;

        File file = new File(path);
        if(!file.exists()){
            return;
        }

        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        response.setContentType("application/octet-stream");
        try{
            FileInputStream fis = new FileInputStream(path);
            byte[] content = new byte[fis.available()];
            fis.read(content);
            fis.close();

            ServletOutputStream sos = response.getOutputStream();
            sos.write(content);

            sos.flush();
            sos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

