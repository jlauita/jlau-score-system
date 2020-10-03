package com.jlau.scoresystem.dao;

import com.jlau.scoresystem.model.Apply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/13.
 */
@Mapper
public interface ApplyMapper {
    List findApplyByStudentId(int studentId);
    Apply findApplyById(int id);
    List findAllApply();
    Integer addApply(Apply apply);
    Integer saveApply(Apply apply);
    Integer deleteApplyById(int id);
}
