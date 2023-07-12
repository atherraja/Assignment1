package com.crud2.studentapi.services.impl;

import com.crud2.studentapi.entities.StudentInfo;
import com.crud2.studentapi.repos.StudentInfoRepository;
import com.crud2.studentapi.services.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentInfoRepository studentInfoRepository;
    @Override
    public StudentInfo saveStudentInfo(StudentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }
    @Override
    public Optional<StudentInfo> findByRollNo(int rollNo) {
        Optional<StudentInfo> studentInfo = studentInfoRepository.findByRollNo(rollNo);
        return Optional.ofNullable(studentInfo.orElse(null));
    }

    @Override
    public List<StudentInfo> getAllStudentInfoList() {
        return (List<StudentInfo>)
                studentInfoRepository.findAll();
    }
    @Override
    public List<StudentInfo> getFilteredStudents(List<String> status) {
        return studentInfoRepository.findByStatusIn(status);
    }
    @Override
    public StudentInfo updateStudentInfo(StudentInfo studentInfo, Long StudentId)
    {
        StudentInfo studentInfo1
                = studentInfoRepository.findById(StudentId).get();
        return studentInfoRepository.save(studentInfo1);
    }

    @Override
    public void deleteStudentInfoById(Long StudentId) {
        studentInfoRepository.deleteById(StudentId);

    }
}
