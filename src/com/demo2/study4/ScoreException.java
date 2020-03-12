package com.demo2.study4;

/*
自定义异常
 */
public class ScoreException extends Exception {
    public ScoreException() {
    }

    public ScoreException(String message) {
        super(message);
    }
}
