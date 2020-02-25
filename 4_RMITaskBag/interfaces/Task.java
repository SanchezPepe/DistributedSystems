package interfaces;

import java.io.Serializable;

/**
 * Task
 */
public class Task implements Serializable{

    private static final long serialVersionUID = 1L;
    public String taskId;
    public int length;
    public String output;

    public Task(String id, String out, int len){
        this.taskId = id;
        this.length = len;
        this.output = out;
    }
    
    public String getId(){
        return this.taskId;
    }

    public String getOutput(){
        return this.output;
    }


}