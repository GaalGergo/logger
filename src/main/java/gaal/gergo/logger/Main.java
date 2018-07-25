package gaal.gergo.logger;

import gaal.gergo.logger.loggers.FileLogger;
import gaal.gergo.logger.loggers.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        List<Logger> loggers = LoggerFactory.getLoggers();
        loggers.get(1).info("Siker");
        loggers.get(1).error("rossz");

        FileLogger fileLogger = FileLogger.builder().fullName(Main.class.getName()).name("").format("[name] [timestamp] [message]").path("C:\\Users\\Gergo\\logger\\file.log").build();

        fileLogger.info("hulala");
    }
}
