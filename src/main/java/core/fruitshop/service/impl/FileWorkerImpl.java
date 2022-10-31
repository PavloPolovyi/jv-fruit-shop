package core.fruitshop.service.impl;

import core.fruitshop.service.FileWorker;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileWorkerImpl implements FileWorker {
    @Override
    public List<String> readFromFile(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    @Override
    public void writeToFile(String fileName, String header,
                            String columnSeparator, Map<String, Integer> data) throws IOException {
        try (BufferedWriter writer =
                     Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(header);
            writer.newLine();
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                writer.write(entry.getKey() + columnSeparator + entry.getValue());
                writer.newLine();
            }
        }
    }
}