package com.liquidityone.Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log4j {
    // Initialize log4j2 instance
    private static final Logger log = LogManager.getLogger(Log4j.class);


    // Info levels log
    public static void info(String message) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String timestamp = sdf.format(date);
        message = String.format("INFO: [%s] %s", timestamp, message);
        System.out.println("--> " + message);
    }

    public static void info(String message, Throwable throwable) {
        log.info(message);
    }

    //Warn Level Logs
    public static void warn(String message) {
        log.warn(message);
    }

    //Error Level Logs
    public static void error(String message) {
        log.error(message);
    }

    public static void error(Object message) {
        log.error(message);
    }

    public static void error(Object message, Throwable throwable) {
        log.error(message);
    }

    public static void error(String message, Throwable throwable) {
        log.error(message);
    }

    //Fatal Level Logs
    public static void fatal(String message) {
        log.fatal(message);
    }

    //Debug Level Logs
    public static void debug(String message) {
        log.debug(message);
    }
}
