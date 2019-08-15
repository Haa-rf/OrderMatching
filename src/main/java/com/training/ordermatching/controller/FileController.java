package com.training.ordermatching.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin
@Controller
@RequestMapping("/orderMatching/file")
public class FileController {

    @Value("${order_log.filePathPar}")
    private String parentFilePath;

    @GetMapping("/download")
    public void downloadFile( HttpServletRequest request, HttpServletResponse response){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String specificDate = dateFormat.format(date);
        try (
                InputStream inputStream = new FileInputStream(new File(parentFilePath, specificDate + ".log"));
                OutputStream outputStream = response.getOutputStream()
        ) {
            response.setContentType("application/x-download");
            String fileName = specificDate + ".log";
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);

            IOUtils.copy(inputStream, outputStream);

            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

