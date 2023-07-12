package com.crud2.studentapi.repos;

import com.crud2.studentapi.entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {

    List<StudentInfo> findByStatusIn(List<String> status);
    Optional<StudentInfo> findByRollNo(int rollNo);

}
