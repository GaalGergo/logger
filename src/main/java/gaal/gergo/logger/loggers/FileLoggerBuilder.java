package gaal.gergo.logger.loggers;

import gaal.gergo.logger.config.LoggerConfig;

public class FileLoggerBuilder {

    private String name;
    private String format;
    private String path;
    private String level;
    private String fullName;


    public FileLoggerBuilder name(String name){
        this.name = name;
        return this;
    }

    public FileLoggerBuilder format(String format){
        this.format = format;
        return this;
    }

    public FileLoggerBuilder path(String path){
        this.path = path;
        return this;
    }

    public FileLoggerBuilder level(String level){
        this.level = level;
        return this;
    }

    public FileLoggerBuilder fullName(String fullName){
        this.fullName = fullName;
        return this;
    }

    public FileLogger build(){
        LoggerConfig loggerConfig = new LoggerConfig();
        loggerConfig.setName(name);
        loggerConfig.setFormat(format);
        loggerConfig.setPath(path);

        return new FileLogger(loggerConfig, level, fullName);
    }
}
