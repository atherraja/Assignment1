package com.crud2.studentapi.controller;

import com.crud2.studentapi.entities.StudentInfo;
import com.crud2.studentapi.repos.StudentInfoRepository;
import com.crud2.studentapi.services.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private StudentInfoRepository studentInfoRepository;


    @PostMapping("save")
    public StudentInfo saveStudentInfo(
            @RequestBody StudentInfo studentInfo) {
        return studentInfoService.saveStudentInfo(studentInfo);
    }

    @GetMapping("getAllStudents")
    public List<StudentInfo> getAllStudentInfoList() {
        return studentInfoService.getAllStudentInfoList();
    }

    @GetMapping("filtered")
    public List<StudentInfo> getFilteredStudents(@RequestParam List<String> status) {
List<StudentInfo> studentInfoList = studentInfoService.getFilteredStudents(status);
        return studentInfoList;
    }
    @PutMapping("student/{id}")
    public StudentInfo
            updateStudentInfo(@RequestBody StudentInfo studentInfo,
                              @PathVariable ("id") Long StudentId)
    {
        return studentInfoService.updateStudentInfo(studentInfo, StudentId);
    }
    @DeleteMapping("student/{id}")
    public String deleteStudentInfoById(@PathVariable("id")
                                        Long StudentId)
    {
        studentInfoService.deleteStudentInfoById(StudentId);
        return "DeleteSuccessfully";
    }
}
