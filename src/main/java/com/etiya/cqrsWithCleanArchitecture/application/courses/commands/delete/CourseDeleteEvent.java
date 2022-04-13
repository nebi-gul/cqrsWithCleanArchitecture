package com.etiya.cqrsWithCleanArchitecture.application.courses.commands.delete;

import lombok.Data;

@Data
public class CourseDeleteEvent {
    private  String courseId;
}


