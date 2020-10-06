package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.model.Activity;
import com.jlau.scoresystem.service.ActivityService;
import com.jlau.scoresystem.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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
    public Object saveActivity(@RequestBody @Validated Activity activity){
        activityService.saveActivity(activity);
        return ResultModel.ok();
    }
    @PostMapping("/activity/add")
    public Object addActivity(@RequestBody @Validated Activity activity){
        activityService.addActivity(activity);
        return ResultModel.ok();
    }
    @PostMapping("/activity/delete/{id}")
    public Object deleteActivityById(@PathVariable("id") String id){
        activityService.deleteActivityById(id);
        return ResultModel.ok();
    }
    @PostMapping("/activity/upload")
    public Object uploadActivity(@RequestParam("file") MultipartFile file) throws Exception{
        activityService.handleActivityUpload(file);
        return ResultModel.ok("文件上传成功");
    }
}
