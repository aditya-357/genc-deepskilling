package org.example;

public class Mathsum {

    private  Calculator obj;

    public Mathsum(Calculator obj){
        this.obj = obj;
    }

    public int solve(){
        return obj.add(30,20);
    }
}
