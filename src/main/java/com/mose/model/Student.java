package com.mose.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tble_student",
        uniqueConstraints = @UniqueConstraint(name = "emailid_unique",columnNames = "email"))
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="student_sequence" )
    private long studentId;

   private String firstName;

    private String lastName;
    @Column(nullable = false)
    private String email;
//    private String guardianName;
//    private String guardianEmail;
//    private String guardianMobile;

    @Embedded
    private Guardian guardian;
}
