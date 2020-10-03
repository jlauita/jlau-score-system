package com.jlau.scoresystem.dao;

import com.jlau.scoresystem.model.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by cxr1205628673 on 2020/9/13.
 */
@Mapper
public interface StudentMapper {
    Student findStudentByStudentId(int studentId);
    List findAllStudent();
    Integer addStudent(Student student);
    Integer saveStudent(Student student);
    Integer deleteStudentByStudentId(int studentId);
}
