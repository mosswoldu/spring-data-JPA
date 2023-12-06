package com.mose.repository;

import com.mose.model.Course;
import com.mose.model.Student;
import com.mose.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

   @Autowired
   private  CourseRepository courseRepository;

    @Test
    void printCourses(){
        List<Course> courseList=courseRepository.findAll();
        System.out.println(courseList);
    }
@Test
    public void saveCourseWithTeacher(){

    Teacher teacher=Teacher.builder()
            .firstName("John")
            .lastName("Doe")
            .build();
        Course course= Course.builder()
                .title("Calculus")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
}

@Test
    public void findAllPagination(){
    Pageable firstPageWithThreeRecords= PageRequest.of(0,4);

    Pageable secondPageWithTwoRecords=PageRequest.of(1,2);

    List<Course>courses=courseRepository.findAll(firstPageWithThreeRecords)
            .getContent();
long totalPages=courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();


    Long totalElements=courseRepository.findAll(firstPageWithThreeRecords)
            .getTotalElements();
    System.out.println("Courses = " + courses);
    System.out.println("Total elements = " + totalElements);

    System.out.println("Total pages = "+ totalPages);
}

@Test
    public void getAllBySorting(){
        Pageable sortedByCourseTitle=PageRequest.of(
                0,
                3,
                Sort.by("title")
        );

        Pageable sortedByCreditDesc=PageRequest.of(
                0,
                3,
                Sort.by("credit")
                        .descending()
        );

        Pageable sortedByTitleAndCreditDesc=PageRequest.of(
                0,
                4,
                Sort.by("title").descending()
                        .and(Sort.by("credit"))
        );

        List<Course>courses=courseRepository.findAll(sortedByCreditDesc).getContent();

    System.out.println("Sorting by course title = "+sortedByCreditDesc + courses);
}

//customized Page
   @Test
   public void findByTitleContaining(){
        Pageable firstPageEightRecords=PageRequest.of(0, 8);

        List<Course> courses=courseRepository.findByTitleContaining("U",firstPageEightRecords).getContent();

       System.out.println("Courses = " + courses);

    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Bob")
                .lastName("Mehari")
                .build();
        Student student= Student.builder()
                .firstName("Miki")
                .lastName("Boss")
                .email("mikiboss2@gmal.com")
                .build();
        Student student1= Student.builder()
                .firstName("Muna")
                .lastName("Ali")
                .email("munali@gmal.com")
                .build();
        Course course= Course.builder()
                .title("Histology")
                .credit(3)
                .teacher(teacher)
                .build();
        course.addStudents(student);
        course.addStudents(student1);
        courseRepository.save(course);

        System.out.println("Courses = " + course);

    }
}