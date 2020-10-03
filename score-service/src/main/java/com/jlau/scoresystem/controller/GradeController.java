package com.jlau.scoresystem.controller;

/**
 * Created by cxr1205628673 on 2020/9/17.
 */

import com.jlau.scoresystem.model.Grade;
import com.jlau.scoresystem.service.GradeService;
import com.jlau.scoresystem.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/17.
 */
@RestController
public class GradeController {
    @Autowired
    private GradeService gradeService;
    @GetMapping("/grade/find/{studentId}")
    public ResultModel findGrade(@PathVariable("studentId") String studengId){
        try {
            List<Grade> grades = gradeService.findGradeById(studengId);
            return ResultModel.ok("ok", grades);
        }catch (NumberFormatException ne){
            return ResultModel.fail("学号检查异常");
        }
    }
    @GetMapping("/grade/findall")
    public ResultModel findGrade(){
        List<Grade> grades = gradeService.findAllGrade();
        return ResultModel.ok("ok",grades);
    }
    @PostMapping("/grade/add")
    public ResultModel addGrade(@RequestBody @Validated Grade grade){
        int result = gradeService.addGrade(grade);
        return ResultModel.ok("ok");
    }
    @PostMapping("/grade/save")
    public ResultModel saveGrade(@RequestBody @Validated Grade grade){
        int result = gradeService.saveGrade(grade);
        return ResultModel.ok("ok");
    }
    @GetMapping("/grade/delete/{studentId}")
    public ResultModel deleteGrade(@PathVariable("studentId") String studentId){
        int result = gradeService.deleteGrade(studentId);
        return ResultModel.ok("ok");
    }
}
