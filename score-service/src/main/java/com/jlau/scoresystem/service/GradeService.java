package com.jlau.scoresystem.service;

import com.jlau.scoresystem.dao.GradeMapper;
import com.jlau.scoresystem.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/17.
 */
@Service
@Transactional
public class GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    public List<Grade> findGradeById(String studentId) throws NumberFormatException{
        List<Grade> grades = gradeMapper.findGradeByStudentId(Integer.valueOf(studentId));
        return grades;
    }
    public List<Grade> findAllGrade(){
        List<Grade> grades = gradeMapper.findAllGrade();
        return grades;
    }
    public int addGrade(Grade grade){
        int result = gradeMapper.addGrade(grade);
        return result;
    }
    public int saveGrade(Grade grade){
        int result = gradeMapper.saveGrade(grade);
        return result;
    }
    public int deleteGrade(String studentId) throws NumberFormatException{
        int result = gradeMapper.deleteGradeById(Integer.valueOf(studentId));
        return result;
    }
    public Integer readExcel(){
        return null;
    }

}

