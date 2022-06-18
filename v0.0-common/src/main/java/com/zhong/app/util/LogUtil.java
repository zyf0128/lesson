package com.zhong.app.util;

import com.zhong.app.entity.LogEntity;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * @author zhuyin
 */
public class LogUtil {

    public static List<LogEntity> parseLog(String fileName) throws IOException {

        List<LogEntity> logList = new LinkedList<>();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while((line = br.readLine()) != null){
            if(line.matches("\\d{4}-\\d{2}-\\d{2}.*")){
                String[] logs = line.split("\\| ");
                LogEntity le = new LogEntity();
                le.setDate(logs[0].trim());
                le.setLevel(logs[1].trim());
                le.setThread(logs[2].trim());
                le.setClassName(logs[3].substring(0,logs[3].lastIndexOf(".")));
                le.setMethodName(logs[3].substring(logs[3].lastIndexOf(".")+1,logs[3].lastIndexOf(":")));
                le.setLineNumber(logs[3].substring(logs[3].lastIndexOf(":")+1));
                le.setMessage(logs[4]);
                logList.add(le);
            }
        }
        br.close();
        return logList;
    }

}
