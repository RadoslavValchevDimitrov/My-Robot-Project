package com.comsystem.homework.rest;

public class RobotNotFoundException extends RuntimeException{

    public RobotNotFoundException(String message) {
        super(message);
    }

    public RobotNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RobotNotFoundException(Throwable cause) {
        super(cause);
    }
}
