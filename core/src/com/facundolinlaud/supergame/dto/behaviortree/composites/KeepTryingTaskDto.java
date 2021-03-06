package com.facundolinlaud.supergame.dto.behaviortree.composites;

import com.facundolinlaud.supergame.behaviortree.composites.KeepTryingTask;
import com.facundolinlaud.supergame.behaviortree.Task;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public class KeepTryingTaskDto extends DecoratorTaskDto {
    @Override
    public Task build() {
        return new KeepTryingTask(getChild().build());
    }
}
