package utils;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class RunFailedTestSuite {

    public void testToRun() {

        TestNG runner = new TestNG();

        List<String> suiteFiles = new ArrayList<>();

        suiteFiles.add("failedRegressionSuite.xml");

        runner.setTestSuites(suiteFiles);

        runner.run();
    }
}
