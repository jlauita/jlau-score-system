package com.jlau.scoresystem.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/8/2.
 */
public class Apply implements Serializable{
    private int id;
    @NotNull(message = "学号不能为空")
    private int studentId;
    @NotBlank(message = "原因不能为空")
    private String reason;
    @Range(min = -100,max = 100,message = "分数必须大于-100,小于100")
    private int grade;
    @NotBlank(message = "描述不能为空")
    private String descrip;
    @NotBlank(message = "格式不符合要求")
    @Length(min = 11,max = 11)
    private String phone;
    private String stuffPath;
    @NotBlank(message = "类型不能为空，如志愿服务、学习成绩类型等")
    private String type;
    private String createTime;
    private String result;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descript) {
        this.descrip = descript;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStuffPath() {
        return stuffPath;
    }

    public void setStuffPath(String stuffPath) {
        this.stuffPath = stuffPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
