package gaal.gergo.logger.loggers;

import java.util.Date;

public class ConsoleLogger implements Logger {

    private String name;
    private String format;

    public ConsoleLogger(String name, String format) {
        this.name = name;
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public void info(String message){
        System.out.println(formatMessage(message));
    }

    public void error(String message){
        System.err.println(formatMessage(message));
    }

    private String formatMessage(String message){
        return format.replace("[timestamp]", new Date().toString())
                .replace("[name]", this.name)
                .replace("[message]", message);
    }

    @Override
    public String toString() {
        return "ConsoleLogger{" +
                "name='" + name + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
