package google.easy.lc359_logger_rate_limiter;

import java.util.*;

/**
 * Design a logger system that receives a stream of messages along with their
 * timestamps.
 * Each unique message should only be printed if it has not been printed in the
 * last 10 seconds.
 * 
 * Implement the Logger class:
 * 
 * Logger() Initializes the logger object.
 * 
 * boolean shouldPrintMessage(int timestamp, String message)
 * Returns true if the message should be printed now based on the timestamp,
 * otherwise returns false.
 * 
 * Notes:
 * 
 * A message is printed if it has never been printed before or was last printed
 * more than or equal to 10 seconds ago.
 * 
 * Timestamps are in seconds and are strictly increasing for each call.
 */

public class Logger {
    private Map<String, Integer> messageHistory;

    public Logger() {
        this.messageHistory = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageHistory.containsKey(message)) {
            messageHistory.put(message, timestamp);
            return true;
        }

        int existingMessageTimestamp = messageHistory.get(message);
        if (timestamp - existingMessageTimestamp >= 10) {
            messageHistory.put(message, timestamp);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Logger logger = new Logger();

        System.out.println(logger.shouldPrintMessage(1, "foo")); // returns true
        System.out.println(logger.shouldPrintMessage(2, "bar")); // returns true
        System.out.println(logger.shouldPrintMessage(3, "foo")); // returns false (3 - 1 < 10)
        System.out.println(logger.shouldPrintMessage(8, "bar")); // returns false (8 - 2 < 10)
        System.out.println(logger.shouldPrintMessage(10, "foo")); // returns false (10 - 1 < 10)
        System.out.println(logger.shouldPrintMessage(11, "foo")); // returns true (11 - 1 >= 10)
    }
}
