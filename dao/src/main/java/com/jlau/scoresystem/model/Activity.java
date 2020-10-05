package com.jlau.scoresystem.model;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/8/3.
 */
public class Activity implements Serializable{
    private int id;
    @NotNull(message = "学号不能为空")
    private int studentId;
    @NotBlank(message = "活动名称不能为空")
    private String activityName;
    @Range(min = -100,max = 100)
    private int grade;
    @Range(min = 1,max = 23)
    private int typeId;
    @NotNull(message = "学年不能为空")
    private int schoolYear;
    @NotNull(message = "学期不能为空")
    private int term;
    private String note;
    private String createTime;
    @NotNull(message = "学生干部学号不能为空")
    private int cadreId;
    @NotBlank(message = "学生干部姓名不能为空")
    private String cadreName;
    @NotNull(message = "角色id不能为空")
    private int privilegeUserId;
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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getCadreId() {
        return cadreId;
    }

    public void setCadreId(int cadreId) {
        this.cadreId = cadreId;
    }

    public String getCadreName() {
        return cadreName;
    }

    public void setCadreName(String cadreName) {
        this.cadreName = cadreName;
    }

    public int getPrivilegeUserId() {
        return privilegeUserId;
    }

    public void setPrivilegeUserId(int privilegeUserId) {
        this.privilegeUserId = privilegeUserId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
