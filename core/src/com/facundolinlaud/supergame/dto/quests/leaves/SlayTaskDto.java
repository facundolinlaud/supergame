package com.facundolinlaud.supergame.dto.quests.leaves;

import com.facundolinlaud.supergame.dto.behaviortree.TaskDto;
import com.facundolinlaud.supergame.behaviortree.Task;
import com.facundolinlaud.supergame.quests.leaves.SlayTask;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include= JsonTypeInfo.As.PROPERTY, property="@class")
public class SlayTaskDto extends TaskDto {
    private String agentId;
    private int total;

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public Task build() {
        return new SlayTask(agentId, total);
    }

    @Override
    public String toString() {
        return "SlayTaskDto{" +
                "agentId=" + agentId +
                ", total=" + total +
                '}';
    }
}
