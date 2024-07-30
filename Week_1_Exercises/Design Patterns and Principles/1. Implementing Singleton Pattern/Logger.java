package singleton;

public class Logger {
    //private static instance of Logger
    private static Logger instance;

    //Make the constructor private
    private Logger() {
        // private constructor to prevent instantiation
    }

    //Public static method to get the instance of Logger
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Logger method to add log messages
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
