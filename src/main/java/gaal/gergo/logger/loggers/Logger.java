package gaal.gergo.logger.loggers;

import java.io.FileNotFoundException;

public interface Logger {
    void info(String message) throws FileNotFoundException;
    void error(String message) throws FileNotFoundException;
}
