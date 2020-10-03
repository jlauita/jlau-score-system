package com.jlau.scoresystem.service;

import com.jlau.scoresystem.dao.PrivilegeUserMapper;
import com.jlau.scoresystem.model.PrivilegeUser;
import com.jlau.scoresystem.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/20.
 */
@Service
@Transactional
public class PrivilegeUserService {
    @Autowired
    private PrivilegeUserMapper privilegeUserMapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    private Logger logger = LoggerFactory.getLogger(PrivilegeUserService.class);
    public List findAllPrivilegeUser(){
        List users = privilegeUserMapper.findAllPrivilegeUser();
        return users;
    }
    public int addPrivilegeUser(PrivilegeUser user) throws Exception{
        PrivilegeUser existsUser = privilegeUserMapper.findPrivilegeUserById(user.getUserId());
        if(existsUser != null){
            throw new Exception("已经存在该用户");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        List<Role> roles = user.getRoles();
        for(Role role:roles){
            privilegeUserMapper.addUserRole(user.getUserId(),role.getId());
        }
        int result = privilegeUserMapper.addPrivilegeUser(user);
        return result;
    }
    public int savePrivilegeUser(PrivilegeUser user) throws Exception{
        PrivilegeUser existsUser = privilegeUserMapper.findPrivilegeUserById(user.getUserId());
        if(existsUser == null){
            throw new Exception("不存在该用户");
        }
        List<Role> roles = user.getRoles();
        int userId = Integer.valueOf(user.getUserId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        privilegeUserMapper.deleteAllUserRoleByUserId(userId);
        for(Role role:roles){
            privilegeUserMapper.addUserRole(userId,role.getId());
        }
        int saveUserResult = privilegeUserMapper.savePrivilegeUser(user);

        return saveUserResult;
    }
    public int deletePrivilegeUserByUserId(String userId) throws NumberFormatException{
        int deleteUserResult = privilegeUserMapper.deletePrivilegeUserById(Integer.valueOf(userId));
        int deleteRoleResult = privilegeUserMapper.deleteAllUserRoleByUserId(Integer.valueOf(userId));
        return deleteRoleResult;
    }
    public int privilegeUserLogin(PrivilegeUser privilegeUser) throws Exception{
        PrivilegeUser user = privilegeUserMapper.findPrivilegeUserById(privilegeUser.getUserId());
        if(user == null){
            throw new Exception("不存砸该用户");
        }
        String encodePassword = passwordEncoder.encode(privilegeUser.getPassword());
        if(encodePassword.equals(user.getPassword())){
            return 1;
        }else{
            logger.info(privilegeUser.getUserId()+": 用户名或密码错误...");
            throw new Exception("用户名或密码错误");
        }
    }
}
