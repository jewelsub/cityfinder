package cityfinder.service;

import cityfinder.domain.City;
import cityfinder.exception.FileWritingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@Component
public class CsvWriter {
    private static final Logger log = LoggerFactory.getLogger(CsvWriter.class);
    private static final String COMMA_DELIMITER = ",";
    private static String FILE_NAME = "output.csv";
    private static String newline = System.getProperty("line.separator");

    public void writeFile(List<City> cities) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(FILE_NAME);
        } catch (IOException e) {
            throw new FileWritingException("Error while creating fileWriter");
        }

        final FileWriter finalFileWriter = fileWriter;
        cities.forEach(c -> {
            log.info(c.toString());
            try {
                finalFileWriter.append(String.valueOf(c.getId()))
                        .append(COMMA_DELIMITER)
                        .append(c.getName())
                        .append(COMMA_DELIMITER)
                        .append(c.getType())
                        .append(COMMA_DELIMITER)
                        .append(String.valueOf(c.getGeoPosition().getLatitude()))
                        .append(COMMA_DELIMITER)
                        .append(String.valueOf(c.getGeoPosition().getLongitude()))
                        .append(newline);
            } catch (IOException e) {
                throw new FileWritingException("Error while appending to fileWriter");
            }
        });

        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new FileWritingException("Error while flushing/closing fileWriter");
        }
    }
}
