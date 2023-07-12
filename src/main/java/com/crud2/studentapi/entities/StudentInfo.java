package com.crud2.studentapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_info")
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_contact_id")
    private Long studentId;
    private String studentName;

    private String fatherName;
    private int rollNo;
    private String status;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "student_contact_id")
    private StudentContactInfo studentContactInfo;




}
