package utils;

import org.apache.log4j.Logger;

import java.io.*;

public class LogsTextFile {
    private static final Logger logger = Logger.getLogger(LogsTextFile.class);
    String methodName;

    public void createNewFile(String fileName) {
        String dirPath = System.getProperty("user.dir") + File.separator + "logs" + File.separator + "jserrorlogs";
        methodName = fileName;
        try {
            File workingDirFile = new File(dirPath);
            File testFile = new File(workingDirFile, fileName);

            if (testFile.exists()) {
                logger.info("File already exist.");
                RandomAccessFile randomAccessFile = new RandomAccessFile(testFile, "rw");
                randomAccessFile.setLength(0);
                randomAccessFile.close();
            } else {
                testFile.createNewFile();
                logger.info("File is created.");
            }

        } catch (IOException e) {
            logger.info(e);
        }
    }

    public void createDirIfNotExist() {
        File workingDir = new File(System.getProperty("user.dir") + File.separator + "logs" + File.separator + "jserrorlogs");

        if (!workingDir.exists()) {
            workingDir.mkdir();
            logger.info("Directory is created.");
        } else {
            logger.info("Directory is already exist.");
        }
    }

    public void writeToTextFile(String content) {
        try {
            String filePath = System.getProperty("user.dir") + File.separator + "logs" + File.separator + "jserrorlogs";
            File file = new File(filePath + File.separator + methodName);

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(content);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            logger.info(e);
        }
    }
}