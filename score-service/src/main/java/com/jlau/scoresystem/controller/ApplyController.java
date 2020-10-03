package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.model.Apply;
import com.jlau.scoresystem.service.ApplyService;
import com.jlau.scoresystem.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/18.
 */
@RestController
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @GetMapping("/apply/find/{studentId}")
    public Object findApplyByStudentId(@PathVariable("studentId")String studentId){
        List applys = applyService.findApplyByStudentId(studentId);
        return ResultModel.ok("ok",applys);
    }
    @GetMapping("/apply/findall")
    public Object findAllApply(){
        List applys = applyService.findAllApply();
        return ResultModel.ok("ok",applys);
    }
    @PostMapping("/apply/add")
    public Object addApply(@RequestBody Apply apply){
        applyService.addApply(apply);
        return ResultModel.ok();
    }
    @PostMapping("/apply/save")
    public Object saveApply(@RequestBody Apply apply){
        applyService.saveApply(apply);
        return ResultModel.ok();
    }
    @GetMapping("/apply/delete/{id}")
    public Object deleteApply(@PathVariable("id")String id){
        applyService.deleteApplyById(id);
        return ResultModel.ok();
    }
}
