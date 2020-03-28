/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.io.Serializable;

/**
 *
 * @author sdist
 */
public class Task implements Serializable{
    String taskId, requirementId;
    int length;
    String output;

    public Task(int length) {
        taskId = "";
        requirementId = "";
        output = "";
        this.length = length;
    }

    public Task(String taskId, String requirementId, int length) {
        this.taskId = taskId;
        this.requirementId = requirementId;
        this.length = length;
        this.output = null;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(String requirementId) {
        this.requirementId = requirementId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Task{" + "taskId=" + taskId + ", requirementId=" + requirementId + ", length=" + length + ", output=" + output + '}';
    }

    
    
    
}
