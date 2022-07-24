package utils;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.io.FileReader;

/**
 * Created by pratik.londhe on 8/18/2018.
 */
public class CSVReader {
    private static final Logger logger = Logger.getLogger(CSVReader.class);

    public Iterator<Object[]> getData(String fileName, String packageName) {
        String line;
        String data[];
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        List<Object[]> testData = new ArrayList<Object[]>();
        try {
            fileReader = new FileReader(getAddresss(packageName));
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split("\\s*,\\s*");
                if (data[0].equals(fileName)) {
                    data = Arrays.copyOfRange(data, 1, data.length);
                    for (int temp = 0; temp <= data.length - 1; temp++) {
                        if (data[temp].contains("^")) {
                            data[temp].replace("^", ",");
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

    public String getAddresss(String packageName) {
        String address = packageName.split(" ")[1].split("\\.")[2];
        return "src/test/resources/testdata/" + address + ".csv";
    }
}
