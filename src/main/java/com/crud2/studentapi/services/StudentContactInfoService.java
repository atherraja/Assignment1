package com.crud2.studentapi.services;

import com.crud2.studentapi.entities.StudentContactInfo;

import java.util.List;

public interface StudentContactInfoService {
    StudentContactInfo saveStudentContactInfo(StudentContactInfo studentContactInfo);
    List<StudentContactInfo> getAllStudentContactInfoList();
    StudentContactInfo updateStudentContactInfo(StudentContactInfo studentContactInfo,
    Long StudentContactId);
    void deleteStudentContactInfoById(Long StudentContactId);
}
