package com.etiya.cqrsWithCleanArchitecture.application.courses.commands.delete;

import com.etiya.cqrsWithCleanArchitecture.persistence.CourseRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDeleteEventHandler {
    private CourseRepository courseRepository;

    @Autowired
    public CourseDeleteEventHandler(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @EventHandler
    public void delete(CourseDeleteEvent courseDeleteEvent){
        this.courseRepository.deleteById(courseDeleteEvent.getCourseId());
    }
}
