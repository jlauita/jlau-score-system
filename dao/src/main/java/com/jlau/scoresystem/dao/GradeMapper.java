package com.jlau.scoresystem.dao;

import com.jlau.scoresystem.model.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/13.
 */
@Mapper
public interface GradeMapper {
    List findGradeByStudentId(int studentId);
    List findAllGrade();
    Integer saveGrade(Grade grade);
    Integer addGrade(Grade grade);
    Integer deleteGradeById(int id);
}
