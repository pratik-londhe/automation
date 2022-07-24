package utils;

import environment.PropertyReader;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVReader {
    private static final Logger logger = Logger.getLogger(CSVReader.class);
    protected static Properties configProperty;

    //Retrieve data from .csv file
    public synchronized Iterator<Object[]> getData(String fileName, String packageName, String methodName) {
        configProperty = PropertyReader.getConfigData();
        String line;
        String[] data;
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        List<Object[]> testData = new ArrayList<>();
        try {
            fileReader = new FileReader(getAddress(packageName));
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split("\\s*,\\s*");
                if (data[0].equals(fileName) && data[1].equals(methodName)) {
                    data = Arrays.copyOfRange(data, 2, data.length);
                    for (int temp = 0; temp <= data.length - 1; temp++) {
                        if (data[temp].contains("^")) {
                            data[temp] = data[temp].replace("^", ",");
                        }
                    }
                    testData.add(data);
                }
            }
            fileReader.close();
        } catch (IOException io) {
            logger.error(io);
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
                if (bufferedReader != null)
                    bufferedReader.close();
            } catch (IOException io) {
                logger.error(io);
            }
        }
        return testData.iterator();
    }

    //Get path of .csv file
    public String getAddress(String packageName) {
        String address = packageName.split(" ")[1].split("\\.")[1];
        if (Boolean.parseBoolean(configProperty.getProperty("isWebExe"))) {
            return "src/test/resources/testdata/csvdata/csvweb/" + address + ".csv";
        }
        if (Boolean.parseBoolean(configProperty.getProperty("isMobileExe"))) {
            return "src/test/resources/testdata/csvdata/csvmobile/" + address + ".csv";
        }
        return address;
    }
}