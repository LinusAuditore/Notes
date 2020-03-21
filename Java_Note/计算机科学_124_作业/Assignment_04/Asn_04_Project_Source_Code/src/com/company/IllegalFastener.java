package com.company;

public class IllegalFastener extends RuntimeException {
    private String msg;
    public IllegalFastener (String msg){
        this.msg = msg;
    }

}
