package com.etiya.cqrsWithCleanArchitecture.application.courses.commands.delete;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class DeleteCourseAggregate {
    @AggregateIdentifier
    private String courseId;

    @CommandHandler
    public DeleteCourseAggregate(DeleteCourseCommand command){
        CourseDeleteEvent courseDeleteEvent=new CourseDeleteEvent();
        BeanUtils.copyProperties(command,courseDeleteEvent);
        AggregateLifecycle.apply(courseDeleteEvent);
    }
    @EventSourcingHandler
    public void delete(CourseDeleteEvent courseDeleteEvent){
        this.courseId=courseDeleteEvent.getCourseId();


    }

}
