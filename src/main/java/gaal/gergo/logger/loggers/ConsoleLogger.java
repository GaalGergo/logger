package gaal.gergo.logger.loggers;

import gaal.gergo.logger.config.LoggerConfig;
import gaal.gergo.logger.config.LoggersConfig;

import java.sql.SQLOutput;

public class ConsoleLogger extends BasicLogger{

    public ConsoleLogger(LoggerConfig loggerConfig, String level) {
        super(loggerConfig, level);
    }

    public void info(String message){
        System.out.println(formatMessage(message));
    }

    public void error(String message){
        if(("error".equals(getLevel()))){
            System.err.println(formatMessage(message));
        }
    }

}
