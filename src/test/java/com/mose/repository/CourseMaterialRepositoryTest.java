package com.mose.repository;

import com.mose.model.Course;
import com.mose.model.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class CourseMaterialRepositoryTest {

    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;

    @Test

    void saveCourseMaterial(){

        Course course= Course.builder()
                .title("Mechanical Engineering")
                .credit(4)
                .build();
       CourseMaterial courseMaterial= CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    //if fetching is lazy use toString Method to print only the course materials attributes
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList=courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }

}