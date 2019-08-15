package com.training.ordermatching.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
@Slf4j
public class OrderLog {

    @Value("${order_log.filePathPar}")
    private String parentFilePath;

    public void createFile(String filePath) {

        try {
            File file = new File(parentFilePath + filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("------ createFile");
    }

    public void writeFileAppend(String filePath, String Content) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(parentFilePath + filePath, true);
            fw.write(Content);
            fw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
