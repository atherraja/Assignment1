package com.crud2.studentapi.services;

import com.crud2.studentapi.entities.StudentInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface StudentInfoService {
    StudentInfo saveStudentInfo(StudentInfo studentInfo);
Optional<StudentInfo> findByRollNo(int rollNo);
StudentInfo getByRollNo(int rollNo);
    List<StudentInfo> getAllStudentInfoList();
    List<StudentInfo> getFilteredStudents(@RequestParam List<String> status);
    StudentInfo updateStudentInfo(StudentInfo studentInfo,
                                  Long StudentId);
    void deleteStudentInfoById(Long StudentId);

}
