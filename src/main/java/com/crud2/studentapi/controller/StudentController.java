package com.crud2.studentapi.controller;

import com.crud2.studentapi.entities.StudentInfo;
import com.crud2.studentapi.repos.StudentInfoRepository;
import com.crud2.studentapi.services.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
  private StudentInfoRepository studentInfoRepository;

    @PostMapping("save")
    public ResponseEntity<?> saveStudentInfo(@RequestBody StudentInfo studentInfo){
        int rollNo = studentInfo.getRollNo();
        Optional<StudentInfo> existingStudent = studentInfoService.findByRollNo(rollNo);
        if(existingStudent.isPresent()) {
            return ResponseEntity.badRequest().body("Student with roll number already exists");
        }
        studentInfoService.saveStudentInfo(studentInfo);
        return ResponseEntity.ok("Student saved successfully");
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
    @GetMapping("getBy/{rollNo}")
    public ResponseEntity<?> getByRollNo(@PathVariable int rollNo){
        StudentInfo studentInfo = studentInfoService.getByRollNo(rollNo);
        if(studentInfo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentInfo);
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




//    @PostMapping("not/save/duplicate")
//    public ResponseEntity<String> existsByRollNo(@RequestBody StudentInfo studentInfo){
//        if (studentInfoService.existsByRollNo(studentInfo.getRollNo())){
//            return ResponseEntity.badRequest().body("Roll Number already exists");
//        }
//        studentInfoService.saveStudentInfo(studentInfo);
//        return ResponseEntity.ok("Student saved Successfully");
//    }