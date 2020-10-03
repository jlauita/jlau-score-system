package com.jlau.scoresystem.service;

import com.jlau.scoresystem.dao.ApplyMapper;
import com.jlau.scoresystem.model.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/18.
 */
@Service
@Transactional
public class ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
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
}