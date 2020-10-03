package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.model.Activity;
import com.jlau.scoresystem.service.ActivityService;
import com.jlau.scoresystem.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/18.
 */
@RestController
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    @GetMapping("/activity/find/{studentId}")
    public Object findActivityById(@PathVariable("studentId") String studentId){
        List activities = activityService.findActivityByStudentId(studentId);
        return ResultModel.ok("ok",activities);
    }
    @GetMapping("/activity/findall")
    public Object findActivity(){
        List activites = activityService.findAllActivity();
        return ResultModel.ok("ok",activites);
    }
    @PostMapping("/activity/save")
    public Object saveActivity(@RequestBody Activity activity){
        activityService.saveActivity(activity);
        return ResultModel.ok();
    }
    @PostMapping("/activity/add")
    public Object addActivity(@RequestBody Activity activity){
        activityService.addActivity(activity);
        return ResultModel.ok();
    }
    @PostMapping("/activity/delete/{id}")
    public Object deleteActivityById(@PathVariable("id") String id){
        activityService.deleteActivityById(id);
        return ResultModel.ok();
    }
}
