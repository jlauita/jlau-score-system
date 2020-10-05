package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.model.Apply;
import com.jlau.scoresystem.service.ApplyService;
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
    public Object addApply(@RequestBody @Validated Apply apply){
        applyService.addApply(apply);
        return ResultModel.ok();
    }
    @PostMapping("/apply/save")
    public Object saveApply(@RequestBody @Validated Apply apply){
        applyService.saveApply(apply);
        return ResultModel.ok();
    }
    @GetMapping("/apply/delete/{id}")
    public Object deleteApply(@PathVariable("id")String id){
        applyService.deleteApplyById(id);
        return ResultModel.ok();
    }
    @PostMapping("/apply/upload")
    public Object uploadApply(@RequestParam("file") MultipartFile file, Apply apply) throws Exception{
        applyService.handleApplyUpload(file,apply);
        return ResultModel.ok("上传成功");
    }
}
