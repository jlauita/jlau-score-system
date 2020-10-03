package com.jlau.scoresystem.controller;

import com.jlau.scoresystem.model.PrivilegeUser;
import com.jlau.scoresystem.service.PrivilegeUserService;
import com.jlau.scoresystem.vo.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/20.
 */
@RestController
public class PrivilegeUserController {
    @Autowired
    private PrivilegeUserService privilegeUserService;
    @GetMapping("/user/privilegeuser/findall")
    public ResultModel findAllPrivilegeUser(){
        List users = privilegeUserService.findAllPrivilegeUser();
        return ResultModel.ok("ok",users);
    }
    @PostMapping("/user/privilegeuser/add")
    public ResultModel addPrivilegeUser(@RequestBody @Validated PrivilegeUser privilegeUser) throws Exception{
        int result = privilegeUserService.addPrivilegeUser(privilegeUser);
        return ResultModel.ok();
    }
    @PostMapping("/user/privilegeuser/save")
    public ResultModel savePrivilegeUser(@RequestBody @Validated PrivilegeUser privilegeUser) throws Exception{
        int result = privilegeUserService.savePrivilegeUser(privilegeUser);
        return ResultModel.ok();
    }
    @GetMapping("/user/privilegeuser/delete/{userId}")
    public ResultModel deletePrivilegeUserByUserId(@PathVariable("userId") String userId){
        int result = privilegeUserService.deletePrivilegeUserByUserId(userId);
        return ResultModel.ok();
    }
    @PostMapping("/user/privilegeuser/login")
    public ResultModel privilegeUserLogin(@RequestBody @Validated PrivilegeUser privilegeUser) throws Exception{
        privilegeUserService.privilegeUserLogin(privilegeUser);
        return ResultModel.ok();
    }
}
