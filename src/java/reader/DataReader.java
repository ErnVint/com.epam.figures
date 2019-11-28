package reader;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class DataReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readData(String filePath) {
        List<String> dataList = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            dataList = bufferedReader.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.FATAL, "Error while opening file: " + filePath, e);
            throw new RuntimeException("Error while opening file", e);
        }
        //Нужно ли ловить SecurityException уже сейчас, если SecurityManager еще не установлен?
        return dataList;
    }
}
