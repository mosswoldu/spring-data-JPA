package com.mose.repository;

import com.mose.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

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

    //Native queries
@Query(value = "SELECT * FROM tble_student s where s.email=?1",
         nativeQuery = true)
    Student getStudentByEmailAddressNative(String email);

//Named queries
@Query(value = "SELECT * FROM tble_student s where s.email=:email",
        nativeQuery = true)
Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);

@Modifying
@Transactional
@Query(value="update tble_student set first_name=?1 where email=?2", nativeQuery = true)
int updateStudentByEmail(String firstName, String email);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tble_student WHERE email = :email", nativeQuery = true)
    int deleteStudentByEmail(@Param("email") String email);

}
