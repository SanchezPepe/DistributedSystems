/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.Serializable;

/**
 *
 * @author sdist
 */
public class Creds implements Serializable{
    String name, edo, id;
    int DoB;

    public Creds(String name, String edo, String id, int DoB) {
        this.name = name;
        this.edo = edo;
        this.id = id;
        this.DoB = DoB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEdo() {
        return edo;
    }

    public void setEdo(String edo) {
        this.edo = edo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDoB() {
        return DoB;
    }

    public void setDoB(int DoB) {
        this.DoB = DoB;
    }

    @Override
    public String toString() {
        return "Creds{" + "name=" + name + ", edo=" + edo + ", id=" + id + ", DoB=" + DoB + '}';
    }
    
    
}
