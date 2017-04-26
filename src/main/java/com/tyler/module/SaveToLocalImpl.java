package com.tyler.module;

import com.tyler.model.DownloadResult;
import com.tyler.model.NewsDetails;
import com.tyler.util.UrlMd5;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by tyler on 2017/4/25.
 */
public class SaveToLocalImpl implements SaveToLocal{
    public String saveToLocal(DownloadResult downloadResult) {
        Date date = downloadResult.getDownloadTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        String separator = File.separator;
        String suffix = downloadResult.getUrl().substring(downloadResult.getUrl().lastIndexOf("."));
        String path = "D:"+separator+calendar.get(Calendar.YEAR)+separator+(calendar.get(Calendar.MONTH)+1)+separator+calendar.get(Calendar.DAY_OF_MONTH)+separator;
        String filename = UrlMd5.md5(downloadResult.getUrl())+suffix;
        String absPath = path+filename;
        String content = downloadResult.getPage();
        Scanner input = new Scanner(content+"\n");
        File file = new File(path);
        FileOutputStream fos = null;
        try {
            if(!file .exists()){
                file.mkdirs();
            }
            fos = new FileOutputStream(new File(absPath));
            while (input.hasNext()) {
                String a = input.next();
                fos.write((a + "\r\n").getBytes(downloadResult.getCharset()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos != null){
                    fos.close();
                }
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return absPath;
    }
}
