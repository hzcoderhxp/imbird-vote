package com.stone.exception;

/**
 * Created by chenghao on 2/16/17.
 */
public class StoneException extends RuntimeException{
    public StoneException(){

    }

    public StoneException(String msg){
        super(msg);
    }
}
