package com.jlau.scoresystem.service;

import com.jlau.scoresystem.dao.ActivityMapper;
import com.jlau.scoresystem.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/18.
 */
@Service
@Transactional
public class ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
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

}
