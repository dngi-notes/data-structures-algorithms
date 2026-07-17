package lld.logger_rate_limiter;

import java.util.*;

/**
 * design a logger system that receives a messages from a stream of messages
 * your logger should decide whether to print each message based on its timestamp
 * 
 * a message should be printed only if it has not been printed in the last 10 seconds
 * 
 * implement the LoggerRL class
 * 
 * @constructor
 * Logger() -> initializes the logger object
 * 
 * @method
 * shouldPrintMessage(int timestamp, String message) -> returns true if the message
 *  should printed at the given timestamp, else false
 * 
 * @note
 * - timestamp is in seconds (int tho)
 * - messages may arrive in any order
 */
class LoggerRL {
    Map<String, Integer> logs;

    public LoggerRL() {
        this.logs = new HashMap<>();
    }

    boolean shouldPrintMessage(int timestamp, String message) {
        if (timestamp <= 0) throw new IllegalArgumentException("Invalid input.");

        if (logs.containsKey(message)) {
            if (timestamp - logs.get(message) < 10) {
                return false;
            } else {
                logs.put(message, timestamp);
                return true;
            }
        }

        logs.put(message, timestamp);
        return true;
    }

    public static void main(String[] args) {
        LoggerRL logger = new LoggerRL();

        System.out.println(logger.shouldPrintMessage(1, "foo"));  // expected: true
        System.out.println(logger.shouldPrintMessage(2, "bar"));  // expected: true
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // expected: false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // expected: false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // expected: false
        System.out.println(logger.shouldPrintMessage(11, "foo")); // expected: true

        System.out.println("---");

        LoggerRL logger2 = new LoggerRL();

        System.out.println(logger2.shouldPrintMessage(1, "hello")); // expected: true
        System.out.println(logger2.shouldPrintMessage(11, "hello")); // expected: true

        System.out.println("--- Edge cases ---");

        LoggerRL logger3 = new LoggerRL();

        System.out.println(logger3.shouldPrintMessage(5, "test"));  // expected: true
        System.out.println(logger3.shouldPrintMessage(14, "test")); // expected: false (only 9 seconds)
        System.out.println(logger3.shouldPrintMessage(15, "test")); // expected: true (exactly 10 seconds)

        System.out.println("--- Different messages ---");

        LoggerRL logger4 = new LoggerRL();

        System.out.println(logger4.shouldPrintMessage(1, "a")); // expected: true
        System.out.println(logger4.shouldPrintMessage(2, "b")); // expected: true
        System.out.println(logger4.shouldPrintMessage(3, "c")); // expected: true
        System.out.println(logger4.shouldPrintMessage(4, "a")); // expected: false
        System.out.println(logger4.shouldPrintMessage(12, "a")); // expected: true
    }
}