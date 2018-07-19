package gaal.gergo.logger.config;

import java.util.List;

public class LoggersConfig {

    private List<LoggerConfig> loggers;
    private String level;

    public List<LoggerConfig> getLoggers() {
        return loggers;
    }

    public void setLoggers(List<LoggerConfig> loggers) {
        this.loggers = loggers;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
