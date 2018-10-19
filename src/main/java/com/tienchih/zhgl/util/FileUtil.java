package com.tienchih.zhgl.util;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * Created by shin on 01/12/2017.
 */
public class FileUtil {

    public static JSONObject getDeviceNormSignalObject(String fileName) {
        String filePath = System.getProperty("user.dir")+"/config/" + fileName;
        String str = "";
        byte[] strBuffer = null;
        int flen = 0;
        File file = new File(filePath);
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            flen = (int) file.length();
            strBuffer = new byte[flen];
            in.read(strBuffer, 0, flen);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        str = new String(strBuffer);
        JSONObject object = JSONObject.parseObject(str);
        return object;
    }

}
