package com.mose.repository;

import com.mose.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    List<Student> findDistinctByFirstName(String firstName);

    //JPQL Queries
    @Query("select s from Student s where s.email= ?1")
    Student getStudentByEmailAddress(String email);
    @Query("select s.firstName from Student s where s.email= ?1")
    String getStudentFirstNameByEmailAddress(String email);


}
