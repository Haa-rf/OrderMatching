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

    public void writeFileOverlay(String filePath, String Content) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(parentFilePath + filePath);
            pw.write(Content);
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }

    public void readFile(String filePath) {
        InputStreamReader in = null;
        BufferedReader br = null;
        try {
            File file = new File(parentFilePath + filePath);
            in = new InputStreamReader(new FileInputStream(file), "gbk");
            br = new BufferedReader(in);
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
