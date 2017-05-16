package se.kth.ict.nextgenpos.model;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Class used to write exception stacktrace to a txt document called "Supermarket-log.txt".
 */
public class LogFileHandler {
    private static final String FILENAME = "Supermarket-log.txt";

    private PrintWriter logFile;

    /**
     * Creates a new instance and a new txt file.
     * @throws IOException
     */
    public LogFileHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(FILENAME), true);
    }

    /**
     * Prints local time and exception stacktrace to logfile.
     *
     * @param exception Exception whos stacktrace is to be printed to file.
     */
    public void logException(Exception exception){
        logFile.println(LocalDateTime.now());
        exception.printStackTrace(logFile);

    }
}
