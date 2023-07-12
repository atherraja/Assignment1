package com.crud2.studentapi.services.impl;

import com.crud2.studentapi.entities.StudentContactInfo;
import com.crud2.studentapi.repos.StudentContactInfoRepository;
import com.crud2.studentapi.services.StudentContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentContactInfoServiceImpl implements StudentContactInfoService {
    @Autowired
    private StudentContactInfoRepository studentContactInfoRepository;
  @Override
    public StudentContactInfo saveStudentContactInfo(StudentContactInfo studentContactInfo) {
       return studentContactInfoRepository.save(studentContactInfo);
      }

    @Override
    public List<StudentContactInfo> getAllStudentContactInfoList() {
        return (List<StudentContactInfo>)
                studentContactInfoRepository.findAll();

    }

    @Override
    public StudentContactInfo updateStudentContactInfo(StudentContactInfo studentContactInfo, Long StudentContactId) {
        StudentContactInfo studentContactInfo1
                =studentContactInfoRepository.findById(StudentContactId).get();
        return studentContactInfoRepository.save(studentContactInfo1);
    }

    @Override
    public void deleteStudentContactInfoById(Long StudentContactId) {
        studentContactInfoRepository.deleteById(StudentContactId);
    }
}
