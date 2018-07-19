package gaal.gergo.logger.loggers;

import gaal.gergo.logger.config.LoggerConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileLogger extends BasicLogger{
    private String path;

    public FileLogger(LoggerConfig loggerConfig, String level) {
        super(loggerConfig, level);
        this.path = loggerConfig.getPath();
    }

    public void info(String message) throws FileNotFoundException {
        fileWriter(message);
    }

    public void error(String message) throws FileNotFoundException {
        if("error".equals(getLevel())){
            fileWriter(message);
        }
    }

    private void fileWriter(String message) throws FileNotFoundException {
        File file = new File(path);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true));
        printWriter.append(formatMessage(message)).println();
        printWriter.close();
    }
}
