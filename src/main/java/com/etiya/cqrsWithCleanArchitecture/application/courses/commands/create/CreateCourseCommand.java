package com.etiya.cqrsWithCleanArchitecture.application.courses.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;



@Data
@Builder
public class CreateCourseCommand {
    @TargetAggregateIdentifier
    private String courseId;

    private  String courseName;




}
