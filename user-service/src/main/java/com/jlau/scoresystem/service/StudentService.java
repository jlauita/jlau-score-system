package com.jlau.scoresystem.service;

import cn.yiban.open.Authorize;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlau.scoresystem.dao.StudentMapper;
import com.jlau.scoresystem.model.Student;
import com.jlau.scoresystem.utils.HttpUtils;
import com.jlau.scoresystem.utils.YiBanAppUtils;
import com.jlau.scoresystem.vo.ResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cxr1205628673 on 2020/9/20.
 */
@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ObjectMapper objectMapper;
    private Logger logger = LoggerFactory.getLogger(StudentService.class);
    public List findAllStudent(){
        List students = studentMapper.findAllStudent();
        return students;
    }
    public int addStudent(Student student){
        int result = studentMapper.addStudent(student);
        return result;
    }
    public int saveStudent(Student student) throws Exception{
        Student existsStudent = studentMapper.findStudentByStudentId(student.getStudentId());
        if(existsStudent == null){
            throw new Exception("没有该用户");
        }
        int result = studentMapper.saveStudent(student);
        return result;
    }
    public int deleteStudentByStudentId(String studentId) throws NumberFormatException{
        int result = studentMapper.deleteStudentByStudentId(Integer.valueOf(studentId));
        return result;
    }
    public Student studentLogin(String code) throws Exception{
        Authorize authorize = new Authorize(YiBanAppUtils.APP_ID,YiBanAppUtils.APP_SECRET);
        String text = authorize.querytoken(code,YiBanAppUtils.BACK_URL);
        JsonNode jsonNode = objectMapper.readTree(text);
        String token = null;
        if(jsonNode.has(YiBanAppUtils.KEY_TOKEN)) {
            token = jsonNode.get(YiBanAppUtils.KEY_TOKEN).toString();
            logger.info(text);
            logger.info(token);
        }else{
            throw new Exception("请求失败，没有获得access_token");
        }
        Map<String,Object> params = new HashMap<>();
        params.put("access_token",token);
        String response = HttpUtils.sendPostRequest(YiBanAppUtils.USER_INFO_URL,params);
        JsonNode userInfoJsonNode = objectMapper.readTree(response);
        response = HttpUtils.sendGetRequest(YiBanAppUtils.USER_DETAILS_URL,params);
        JsonNode userDetailInfoNode = objectMapper.readTree(response);
        String ybId,username,userNick,sex,avater,schoolName;
        if(userInfoJsonNode.has("yb_userid") && userInfoJsonNode.has("yb_username") && userInfoJsonNode.has("yb_usernick")
                && userInfoJsonNode.has("yb_sex") && userInfoJsonNode.has("yb_userhead") && userInfoJsonNode.has("yb_schoolname")) {
            ybId = userInfoJsonNode.get("yb_userid").asText();
            username = userInfoJsonNode.get("yb_username").asText();
            userNick = userInfoJsonNode.get("yb_usernick").asText();
            sex = userInfoJsonNode.get("yb_sex").asText();
            avater = userInfoJsonNode.get("yb_userhead").asText();
            schoolName = userInfoJsonNode.get("yb_schoolname").asText();
        }else {
            logger.error(YiBanAppUtils.USER_INFO_URL+" 返回的数据缺少必要的数据.");
            throw new Exception("getting YiBan user information failed , laking some necessary data.");
        }
        String realName,birthDay,studentId;//studentId是学校首选认证类型编号，有可能是学号，也有可能老师弄成了坑爹的易班id
        if(userDetailInfoNode.has("yb_realname") && userDetailInfoNode.has("yb_birthday") && userDetailInfoNode.has("yb_studentid")){
            realName = userDetailInfoNode.get("yb_realname").asText();
            birthDay = userDetailInfoNode.get("yb_birthday").asText();
            studentId = userDetailInfoNode.get("yb_studentid").asText();
        }else {
            logger.error(YiBanAppUtils.USER_DETAILS_URL+" 返回的数据缺少必要的数据.");
            throw new Exception("getting YiBan real user information failed , laking some necessary data.");
        }
        if(schoolName != "吉林农业大学"){
            logger.error("非本校学生登录,"+"real_name:"+realName+" school_name:"+schoolName+" student_id:"+studentId);
            throw new Exception("非本校学生");
        }
        Student student = new Student();
        student.setStudentName(realName);
        student.setGender(sex);
        student.setStudentId(Integer.valueOf(studentId));
        student.setYid(ybId);
        return student;
    }
}
