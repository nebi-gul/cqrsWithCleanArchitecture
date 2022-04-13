package com.etiya.cqrsWithCleanArchitecture.application.courses.commands.create;

import com.etiya.cqrsWithCleanArchitecture.domain.Course;
import com.etiya.cqrsWithCleanArchitecture.persistence.CourseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseCreateEventHandler {
    private CourseRepository courseRepository;

    @Autowired
    public CourseCreateEventHandler(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @EventHandler
    public  void  on(CourseCreatedEvent courseCreatedEvent){
        checkIfCourseName(courseCreatedEvent.getCourseName());
        Course course= new Course();
        BeanUtils.copyProperties(courseCreatedEvent,course);
        this.courseRepository.save(course);

    }
    private void checkIfCourseName (String courseName){
        if (courseRepository.existsByCourseNameIgnoreCase(courseName)){
            throw new RuntimeException("FARKLI KURS İSMİ OLMALI");
        }
    }


}
