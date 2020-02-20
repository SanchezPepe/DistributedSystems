package interfaces;

import java.io.Serializable;

/**
 * Task
 */
public class Task implements Serializable{

    public int taskId;
    public int requirementId;
    public int length;
    public int output;

    public Task(int id, int reqId, int len, int out){
        this.taskId = id;
        this.requirementId = reqId;;
        this.length = len;
        this.output = out;
    }
    

    
}