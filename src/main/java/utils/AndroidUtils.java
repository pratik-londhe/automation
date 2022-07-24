package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AndroidUtils {

    public static String androidVersion() throws IOException {
        final String command = "adb shell getprop ro.build.version.release";
        String deviceVersion = "";
        String[] version = CommandLineUtils.execCommand(command);
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(version);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(pr.getInputStream()));

        // read the output from the command
        String sdk_version = null;
        while ((sdk_version = stdInput.readLine()) != null) {
            if (!sdk_version.contains("daemon")) {
                deviceVersion = sdk_version;
            }
        }
        return deviceVersion;
    }

    public static String deviceinfo() throws IOException {
        String deviceName = "";
        final String command = "adb shell getprop ro.product.model";
        String[] device = CommandLineUtils.execCommand(command);
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(device);
        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(pr.getInputStream()));

        // read the output from the command
        String devicename;
        while ((devicename = stdInput.readLine()) != null) {
            if(!devicename.contains("daemon")) {
                deviceName = devicename;
            }
        }
        return deviceName;
    }

    public static String androidUDID() throws IOException {
        final String command = "adb shell getprop ro.serialno";
        String deviceUDID = "";
        String[] version = CommandLineUtils.execCommand(command);
        Runtime run = Runtime.getRuntime();
        Process pr = run.exec(version);

        BufferedReader stdInput = new BufferedReader(new
                InputStreamReader(pr.getInputStream()));

        // read the output from the command
        String sdk_udid = null;
        while ((sdk_udid = stdInput.readLine()) != null) {
            if (!sdk_udid.contains("daemon")) {
                deviceUDID = sdk_udid;
            }
        }
        return deviceUDID;
    }
}