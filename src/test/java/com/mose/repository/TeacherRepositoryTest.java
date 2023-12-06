package com.mose.repository;

import com.mose.model.Course;
import com.mose.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class TeacherRepositoryTest {


    @Autowired
    private   TeacherRepository repository;

    @Test
    void saveTeacher(){
        Course  course= Course.builder()
                .title("Anatomy")
                .credit(4)
                .build();
        Course  coursePhysiology= Course.builder()
                .title("Biochemistry")
                .credit(5)
                .build();

        Teacher teacher= Teacher.builder()
                .firstName("Alexa")
                .lastName("Bob")
                //.courses(List.of(course,coursePhysiology))
                .build();
        repository.save(teacher);

        System.out.println("Teacher with courses = "+ teacher);
    }


}