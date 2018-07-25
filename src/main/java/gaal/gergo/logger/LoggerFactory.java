package gaal.gergo.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import gaal.gergo.logger.config.LoggerConfig;
import gaal.gergo.logger.config.LoggersConfig;
import gaal.gergo.logger.loggers.ConsoleLogger;
import gaal.gergo.logger.loggers.FileLogger;
import gaal.gergo.logger.loggers.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoggerFactory {

    private static ObjectMapper om = new ObjectMapper();

    public static List<Logger> getLoggers() throws IOException, URISyntaxException {
        return getLoggers("config.json");
    }

    public static List<Logger> getLoggers(String configFile) throws URISyntaxException, IOException {
        Path path = Paths.get(LoggerFactory.class.getClassLoader().getResource(configFile).toURI());
        String content = new String(Files.readAllBytes(path));
        LoggersConfig logconfig = om.readValue(content, LoggersConfig.class);
        List<Logger> loggers = new ArrayList<>();
        for (LoggerConfig loggerConfig : logconfig.getLoggers()) {
            switch (loggerConfig.getType()){
                case "console":
                    loggers.add(new ConsoleLogger(loggerConfig, logconfig.getLevel()));
                    break;
                case "file" :
                    loggers.add(new FileLogger(loggerConfig, logconfig.getLevel(), LoggerFactory.class.getName()));
            }
        }
        return loggers;
    }
}
