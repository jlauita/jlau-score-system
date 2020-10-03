package com.jlau.scoresystem.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by cxr1205628673 on 2020/8/3.
 */
public class Grade implements Serializable{
    private int id;
    @NotNull(message = "学号不能为空")
    private int studentId;
    @NotNull(message = "考试总成绩不能为空")
    @Min(value = 0,message = "考试总成绩不能小于0")
    private double sumExamScore;//考试总成绩
    @NotNull(message = "考评总成绩不能为空")
    @Min(value = 0,message = "考评总成绩为能小于0")
    private double sumEvaluateScore;//考评总成绩
    private double finalScore;//最终成绩
    private String createTime;
    @Min(value = 0,message = "学年不能为负数")
    private int schoolYear;//学年
    @Min(value = 0,message = "学期不能为负数")
    private int term;//学期

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

    public double getSumExamScore() {
        return sumExamScore;
    }

    public void setSumExamScore(double sumExamScore) {
        this.sumExamScore = sumExamScore;
    }

    public double getSumEvaluateScore() {
        return sumEvaluateScore;
    }

    public void setSumEvaluateScore(double sumEvaluateScore) {
        this.sumEvaluateScore = sumEvaluateScore;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
}
