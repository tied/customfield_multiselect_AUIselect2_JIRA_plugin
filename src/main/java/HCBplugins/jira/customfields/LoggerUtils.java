package HCBplugins.jira.customfields;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtils {
    private final String logFileName;
    private static Logger oneAndOnlyLogger;

    /**************************************************************************
     * constructor sets the system property defining how log messages will
     * look like and takes the log file path from invoking class
     * @param loggerName - name of the logger instance to be created
     * @param logFileName - full path to log file
     *************************************************************************/
    LoggerUtils(String loggerName, String logFileName) {
        System.setProperty(
                "java.util.logging.SimpleFormatter.format",
                "%4$s %2$s: %5$s%6$s%n");
        this.logFileName = logFileName;
        initializeLogger(loggerName);
    }

    /**************************************************************************
     * method initialises new logger, adds new console and file handlers to it
     * sets the log level to ALL. Log string will look like
     * Apr 29, 2022 5:39:14 PM HCBplugins.rest.LoggerUtils initializeLogger
     * INFO: created logger REST4DevopsLogger... initialized console handler
     *************************************************************************/
    private void initializeLogger(String loggerName) {
        oneAndOnlyLogger = Logger.getLogger(loggerName);
        oneAndOnlyLogger.setUseParentHandlers(false);
        for (Handler handler : oneAndOnlyLogger.getHandlers()) {
            // handler.close();
            oneAndOnlyLogger.removeHandler(handler);
        }
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        oneAndOnlyLogger.addHandler(consoleHandler);
        oneAndOnlyLogger.info("created logger " + loggerName + "... initialized console handler");
        try {
            FileHandler fileHandler = new FileHandler(logFileName, true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new SimpleFormatter());
            oneAndOnlyLogger.addHandler(fileHandler);
            oneAndOnlyLogger.info("logger fileHandler creation success");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
            oneAndOnlyLogger.info("failed to open log file for writing....");
        }
        oneAndOnlyLogger.info("started log....");
        for (Handler handler : oneAndOnlyLogger.getHandlers()) {
            oneAndOnlyLogger.info("handler used " + handler.getClass());
        }
    }

    public static Logger getLogger() {
        return oneAndOnlyLogger;
    }

    /**************************************************************************
     * method for closing the og file. should be called at the end of invoking
     * method
     *************************************************************************/
    public void closeLogFiles() {
        for (Handler handler : oneAndOnlyLogger.getHandlers()) {
            oneAndOnlyLogger.removeHandler(handler);
            handler.close();
        }
    }
}

