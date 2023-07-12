package com.crud2.studentapi.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "student_contact_info")
public class StudentContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_contact_id")
    private Long studentContactId;

    private String address;

    private String city;

    private int countryCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private StudentInfo studentInfo;





}
