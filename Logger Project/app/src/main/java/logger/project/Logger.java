package logger.project;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String LOG_FILE = "application.log";
    private FileWriter fileWriter;
    private final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Private constructor
    private Logger() {
        try {
            fileWriter = new FileWriter(LOG_FILE, true);
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize logger", e);
        }
    }

    // Static inner class for Singleton
    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    // LOG METHOD
    public synchronized void log(LogLevel level, String message) {
        String timestamp = LocalDateTime.now().format(dtFormatter);
        String formatted = "[" + timestamp + "][" + level + "] " + message;

        // Print to console
        System.out.println(formatted);

        // Write to file
        try {
            fileWriter.write(formatted + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void warn(String message) {
        log(LogLevel.WARNING, message);
    }

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }
}

