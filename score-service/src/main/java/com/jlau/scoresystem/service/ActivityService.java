package com.jlau.scoresystem.service;

import com.jlau.scoresystem.dao.ActivityMapper;
import com.jlau.scoresystem.model.Activity;
import com.jlau.scoresystem.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/18.
 */
@Service
@Transactional
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Value("${file.path}")
    private String path;

    public List findActivityByStudentId(String studentId) throws NumberFormatException{
        List activities = activityMapper.findActivityByStudentId(Integer.valueOf(studentId));
        return activities;
    }
    public List findAllActivity(){
        List activities = activityMapper.findAllActivity();
        return activities;
    }
    public int addActivity(Activity activity){
        int result = activityMapper.addActivity(activity);
        return result;
    }
    public int saveActivity(Activity activity){
        int result = activityMapper.saveActivity(activity);
        return result;
    }
    public int deleteActivityById(String id) throws NumberFormatException{
        int result = activityMapper.deleteActivityById(Integer.valueOf(id));
        return result;
    }
    public void handleExcel(MultipartHttpServletRequest request)throws Exception{
        List<MultipartFile> multipartFiles = request.getFiles("file");
        if(multipartFiles.size() == 0) {
            throw new  Exception("Empty Files");
        }
        MultipartFile file = multipartFiles.get(0);
        FileUploadUtils.upload(file,path,FileUploadUtils.FileExtension.IMAGE_EXT);
    }
}
