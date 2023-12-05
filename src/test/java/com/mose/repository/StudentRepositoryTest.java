package com.mose.repository;
import com.mose.model.Guardian;
import com.mose.model.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    @DisplayName("save student to db")
    public void saveStudent(){
        Student student= Student.builder()
                .firstName("Sari")
                .lastName(null)
                .email("sarii@bes.edu")
//                .guardianName("Muse")
//                .guardianEmail("musi@gmail.com")
//                .guardianMobile("12222222")
                .build();

        studentRepository.save(student);
    }

   @Test
   public  void saveStudentWithGuardian(){
        Guardian guardian= Guardian.builder()
                .name("Sandro")
                .email("sanduro22@gmail.com")
               .mobile("99353522222")
                .build();

        Student student1= Student.builder()
                .firstName("Daniello")
                .lastName("Mesi")
                .email("damesi@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student1);
    }

    @Test
    public void getAllStudents(){
        List<Student> students=studentRepository.findAll();
        System.out.println("Students list: " + students);
    }

    @ Test
    public void findByFirstName(){
        List<Student>std=studentRepository.findByFirstName("Sari");

        System.out.println("List of Students with first name Sari= " + std);
    }

    @Test
    public void printFirstNameContaining(){
        List<Student> stds=studentRepository.findByFirstNameContaining("ar");

        System.out.println("First name containing ar = " + stds);
    }
    @Test

    public  void printLatNameNotNull(){
        List<Student>studentList=studentRepository.findByLastNameNotNull();
        System.out.println(studentList);
    }
      @Test
    public void printGuardianName(){
        List<Student> std2=studentRepository.findByGuardianName("Muse");
          System.out.println("Guardian name with Muse =" + std2);
      }

    @Test
    public void printByFirstAndLatNames(){
        List<Student> stdss=studentRepository.findByFirstNameAndLastName("Sari","Mosi");
        System.out.println("List of students =  " +stdss);
    }

    @Test
    void printDistinctFirstName(){
        List<Student> distinctName=studentRepository.findDistinctByFirstName("Sari");
        System.out.println("List of distinct names are : " + distinctName);
    }

    @Test

    void printStudentByEmail(){
        Student stdd=studentRepository.getStudentByEmailAddress("sarita2@bes.edu");
        System.out.println(stdd);
    }

    @Test
    void printStudentFirstByEmail(){
        String studentFirstName=studentRepository.getStudentFirstNameByEmailAddress("sarita2@bes.edu");
        System.out.println("First name = "+ studentFirstName);
    }
}