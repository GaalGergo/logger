package gaal.gergo.logger.loggers;

import gaal.gergo.logger.config.LoggerConfig;

import java.io.FileNotFoundException;
import java.util.Date;

public abstract class BasicLogger implements Logger {

    private String name;
    private String format;
    private String level;

    public BasicLogger(LoggerConfig loggerConfig, String level) {
        this.name = loggerConfig.getName();
        this.format = loggerConfig.getFormat();
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public String getLevel() {
        return level;
    }

    @Override
    public abstract void info(String message) throws FileNotFoundException;

    @Override
    public abstract void error(String message) throws FileNotFoundException;

    public String formatMessage(String message){
        return format.replace("[timestamp]", new Date().toString())
                .replace("[name]", this.name)
                .replace("[message]", message);
    }
}
