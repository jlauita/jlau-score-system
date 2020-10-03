package com.jlau.scoresystem.dao;

import com.jlau.scoresystem.model.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/13.
 */
@Mapper
public interface ActivityMapper {
    List findAllActivity();
    String findActivityType(int typeId);
    List findActivityByStudentId(int studentId);
    Integer saveActivity(Activity activity);
    Integer addActivity(Activity activity);
    Integer deleteActivityById(int id);
}
