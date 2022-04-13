package com.etiya.cqrsWithCleanArchitecture.application.courses.commands.delete;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteCourseCommand {
    @TargetAggregateIdentifier
    private String courseId;
}
