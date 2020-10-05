package com.jlau.scoresystem.service;

import com.jlau.scoresystem.dao.ApplyMapper;
import com.jlau.scoresystem.model.Apply;
import com.jlau.scoresystem.utils.FileUploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by cxr1205628673 on 2020/9/18.
 */
@Service
@Transactional
public class ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    @Value("${file.path}")
    private String path;
    public List findApplyByStudentId(String studentId) throws NumberFormatException{
        List applys = applyMapper.findApplyByStudentId(Integer.valueOf(studentId));
        return applys;
    }
    public List findAllApply(){
        List applys = applyMapper.findAllApply();
        return applys;
    }
    public int addApply(Apply apply){
        int result = applyMapper.addApply(apply);
        return result;
    }
    public int saveApply(Apply apply){
        int result = applyMapper.saveApply(apply);
        return result;
    }
    public int deleteApplyById(String id) throws NumberFormatException{
        int result = applyMapper.deleteApplyById(Integer.valueOf(id));
        return result;
    }
    public void handleApplyUpload(MultipartFile file,Apply apply) throws Exception{
        String extensionName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = UUID.randomUUID()+extensionName;
        apply.setStuffPath(fileName);
        apply.setCreateTime(new Date().toString());
        addApply(apply);
        FileUploadUtils.upload(file,fileName,FileUploadUtils.FileExtension.IMAGE_EXT);
    }
}