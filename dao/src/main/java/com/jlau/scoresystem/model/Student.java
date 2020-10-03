package com.jlau.scoresystem.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/8/2.
 */
public class Student extends User implements Serializable{
    @NotNull(message = "学号不能为空")
    private int studentId;
    @NotBlank(message = "学生姓名不能为空")
    private String studentName;
    @NotBlank(message = "性别不能为空")
    private String gender;
    @NotBlank(message = "手机号不能为空")
    @Length(min = 11,max = 11,message = "手机号格式不正确")
    private String phone;
    private String nationality;
    @NotBlank(message = "政治面貌不能为空")
    private String political;
    @NotBlank(message = "学院不能为空")
    private String academic;//学院
    @NotBlank(message = "专业不能为空")
    private String major;//专业
    private String yid;//易班id

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getAcademic() {
        return academic;
    }

    public void setAcademic(String academic) {
        this.academic = academic;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYid() {
        return yid;
    }

    public void setYid(String yid) {
        this.yid = yid;
    }
}
