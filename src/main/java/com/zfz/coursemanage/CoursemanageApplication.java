package com.zfz.coursemanage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.zfz.coursemanage.config")
@ComponentScan("com.zfz.coursemanage.*")
@SpringBootApplication
public class CoursemanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursemanageApplication.class, args);
    }

}
