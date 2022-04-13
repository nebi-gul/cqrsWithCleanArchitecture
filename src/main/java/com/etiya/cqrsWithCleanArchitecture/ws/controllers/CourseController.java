package com.etiya.cqrsWithCleanArchitecture.ws.controllers;

import com.etiya.cqrsWithCleanArchitecture.application.courses.commands.create.CreateCourseCommand;
import com.etiya.cqrsWithCleanArchitecture.application.courses.commands.delete.DeleteCourseCommand;
import com.etiya.cqrsWithCleanArchitecture.ws.models.CreateCourseModel;
import com.etiya.cqrsWithCleanArchitecture.ws.models.DeleteCourseModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private CommandGateway commandGateway;

    public CourseController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @PostMapping("/add")
    public void add(@RequestBody CreateCourseModel createCourseModel){
        CreateCourseCommand command=CreateCourseCommand.builder()
                .courseName(createCourseModel.getCourseName())
                .build();

        command.setCourseId(UUID.randomUUID().toString());
        this.commandGateway.sendAndWait(command);

    }
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCourseModel deleteCourseModel){
        DeleteCourseCommand command=DeleteCourseCommand.builder()
                .courseId(deleteCourseModel.getCourseId()).build();

        this.commandGateway.sendAndWait(command);
    }


}
