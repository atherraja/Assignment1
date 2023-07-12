package com.crud2.studentapi.repos;

import com.crud2.studentapi.entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {

    List<StudentInfo> findByStatusIn(List<String> status);
}
