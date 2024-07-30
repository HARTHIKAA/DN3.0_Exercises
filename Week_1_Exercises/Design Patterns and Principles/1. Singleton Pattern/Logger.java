package com.singletonpattern;

public class Logger {

    //a private static instance of the class (Lazy Initialization)
    private static Logger instance;

    //the constructor is private so no other class can instantiate it
    private Logger() {
        // Optional: Initialization code here
    }

    //a public static method to get the instance of the class
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to demonstrate logging
    public void log(String message) {
        System.out.println("Log Message: " + message);
    }
}
