package com.jlau.scoresystem.dao;

import com.jlau.scoresystem.model.PrivilegeUser;
import com.jlau.scoresystem.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/13.
 */
@Mapper
public interface PrivilegeUserMapper {
    PrivilegeUser findPrivilegeUserById(int userId);
    List findAllPrivilegeUser();
    Integer addPrivilegeUser(PrivilegeUser user);
    Integer addUserRole(@Param("uid") int userId,@Param("rid") int roleId);
    Integer savePrivilegeUser(PrivilegeUser user);
    Integer deletePrivilegeUserById(int userId);
    Integer deleteAllUserRoleByUserId(int userId);
    Integer deleteUserRoleById(int id);
}
