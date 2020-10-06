package com.jlau.scoresystem.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Created by cxr1205628673 on 2020/10/5.
 */
public class FileUploadUtils {

    public static void upload(MultipartFile file,String path,String... extension) throws Exception{
        if(!checkExtension(file,extension)){
            throw new Exception("文件格式错误,需要满足  "+ Arrays.toString(extension));
        }
        byte[] bytes = file.getBytes();
        FileOutputStream outputStream = new FileOutputStream(new File(path));
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }
    private static boolean checkExtension(MultipartFile file,String... ext){
        if(file.getOriginalFilename().contains(".")){
            for (String e:ext) {
                if (file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).equals(e)) {
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }
    public static class FileExtension{
        public static final String[] IMAGE_EXT = new String[]{"jpg","jpeg","png","gif"};
        public static final String[] XLSX_EXT = new String[]{"xlsx","xls"};
        public static final String[] DOCX_EXT = new String[]{"docx","doc"};
    }
}
