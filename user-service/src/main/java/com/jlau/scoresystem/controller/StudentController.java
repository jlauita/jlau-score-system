package com.jlau.scoresystem.controller;


import com.jlau.scoresystem.model.Student;
import com.jlau.scoresystem.service.StudentService;
import com.jlau.scoresystem.utils.YiBanAppUtils;
import com.jlau.scoresystem.vo.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/20.
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/user/student/callback")
    public ResultModel callback(@RequestParam(YiBanAppUtils.KEY_CODE) String code) throws Exception{
        //用户易班第三方登录授权回调接口
        if(code == null || "".equals(code)){
            return ResultModel.fail("code invalid");
        }else {
            Student student = studentService.studentLogin(code);
            return ResultModel.ok("ok",student);
        }
    }
    @GetMapping("/user/student/findall")
    public ResultModel findAllStudent(){
        List students = studentService.findAllStudent();
        return ResultModel.ok("ok",students);
    }
    @PostMapping("/user/student/add")
    public ResultModel addStudent(@RequestBody @Validated Student student){
        int result = studentService.addStudent(student);
        return ResultModel.ok();
    }
    @PostMapping("/user/student/save")
    public ResultModel saveStudent(@RequestBody @Validated Student student) throws Exception{
        int result = studentService.saveStudent(student);
        return ResultModel.ok();
    }
    @GetMapping("/user/student/delete/{studentId}")
    public ResultModel deleteStudentByStudentId(@PathVariable("studentid") String studentId){
        int result = studentService.deleteStudentByStudentId(studentId);
        return ResultModel.ok();
    }
}
