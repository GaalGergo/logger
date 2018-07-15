package gaal.gergo.logger.loggers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class FileLogger implements Logger {
    private String name;
    private String format;
    private String path;

    public FileLogger(String name, String format, String path) {
        this.name = name;
        this.format = format;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public void info(String message) throws FileNotFoundException {
        fileWriter(message);
    }

    public void error(String message) throws FileNotFoundException {
        fileWriter(message);
    }

    private String formatMessage(String message){
        return format.replace("[timestamp]", new Date().toString())
                .replace("[name]", this.name)
                .replace("[message]", message);
    }

    private void fileWriter(String message) throws FileNotFoundException {
        File file = new File(path);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, true));
        printWriter.append(formatMessage(message)).println();
        printWriter.close();
    }

    @Override
    public String toString() {
        return "ConsoleLogger{" +
                "name='" + name + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
