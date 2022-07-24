package uipages.geometryinteractive;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import constants.CK12Constant;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import uipages.BasePage;
import utils.GuiControl;

import java.util.ArrayList;
import java.util.List;

public class ThreeDimensionsPage extends BasePage {

    private static final Logger logger = Logger.getLogger(ThreeDimensionsPage.class);
    protected static List<LogEntry> logs = new ArrayList();

    public ThreeDimensionsPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    private final GuiControl interactivePoint = new GuiControl(getElementMap().get("interactivePoint"), webDriver);
    private final GuiControl inlinePoint = new GuiControl(getElementMap().get("inlinePoint"), webDriver);
    private final GuiControl lineSegmentInteractive = new GuiControl(getElementMap().get("lineSegmentInteractive"), webDriver);
    private final GuiControl lineSegment = new GuiControl(getElementMap().get("lineSegment"), webDriver);
    private final GuiControl lengthInteractive = new GuiControl(getElementMap().get("lengthInteractive"), webDriver);
    private final GuiControl length = new GuiControl(getElementMap().get("length"), webDriver);
    private final GuiControl numberLineInteractive = new GuiControl(getElementMap().get("numberLineInteractive"), webDriver);
    private final GuiControl numberLine = new GuiControl(getElementMap().get("numberLine"), webDriver);
    private final GuiControl describePointInteractive = new GuiControl(getElementMap().get("describePointInteractive"), webDriver);
    private final GuiControl describePoint = new GuiControl(getElementMap().get("describePoint"), webDriver);
    private final GuiControl shapeInteractive = new GuiControl(getElementMap().get("shapeInteractive"), webDriver);
    private final GuiControl shape = new GuiControl(getElementMap().get("shape"), webDriver);
    private final GuiControl shapeDimension = new GuiControl(getElementMap().get("shapeDimension"), webDriver);
    private final GuiControl lengthWidthInteractive = new GuiControl(getElementMap().get("lengthWidthInteractive"), webDriver);
    private final GuiControl lengthLW = new GuiControl(getElementMap().get("lengthLW"), webDriver);
    private final GuiControl width = new GuiControl(getElementMap().get("width"), webDriver);
    private final GuiControl rectCoordinate = new GuiControl(getElementMap().get("rectCoordinate"), webDriver);
    private final GuiControl rectCoordinateInteractive = new GuiControl(getElementMap().get("rectCoordinateInteractive"), webDriver);
    private final GuiControl xCoordinateInteractive = new GuiControl(getElementMap().get("xCoordinateInteractive"), webDriver);
    private final GuiControl yCoordinateInteractive = new GuiControl(getElementMap().get("yCoordinateInteractive"), webDriver);
    private final GuiControl xyCoordinate = new GuiControl(getElementMap().get("xyCoordinate"), webDriver);
    private final GuiControl xyCoordinateTwoDia = new GuiControl(getElementMap().get("xyCoordinateTwoDia"), webDriver);

    private final GuiControl pointExampleInteractive = new GuiControl(getElementMap().get("pointExampleInteractive"), webDriver);
    private final GuiControl pointExample = new GuiControl(getElementMap().get("pointExample"), webDriver);
    private final GuiControl threeDimInteractive = new GuiControl(getElementMap().get("threeDimInteractive"), webDriver);
    private final GuiControl lineSegmentExampleInteractive = new GuiControl(getElementMap().get("lineSegmentExampleInteractive"), webDriver);
    private final GuiControl lineSegmentExample = new GuiControl(getElementMap().get("lineSegmentExample"), webDriver);
    private final GuiControl planesInteractive = new GuiControl(getElementMap().get("planesInteractive"), webDriver);
    private final GuiControl solidInteractive = new GuiControl(getElementMap().get("solidInteractive"), webDriver);
    private final GuiControl solid = new GuiControl(getElementMap().get("solid"), webDriver);
    private final GuiControl solidCube = new GuiControl(getElementMap().get("solidCube"), webDriver);

    // Mouse Hover on the Point interactive of Zero dimensions
    public void mouseHoverOnPointInteractive() {
        interactivePoint.mouseHover();
        reportLog("User performed the mouse hover action on Point interactive.");
    }
    // Mouse Hover on the Solid interactive of Three dimensions
    public void mouseHoverOnSolidInteractive() {
        solidInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Solid interactive.");
    }
    // Mouse Hover on the Point interactive of Zero dimensions
    public void mouseHoverOnPlanesInteractive() {
        planesInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Planes interactive.");
    }

    // Mouse Hover on the Point of Example 2 interactive of two dimensions
    public void mouseHoverOnPointOfExampleInteractive() {
        pointExampleInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Point of Example 2 interactive.");
    }

    // Mouse Hover on the Line Segment of Example 3 interactive of two dimensions
    public void mouseHoverOnLineSegmentOfExampleInteractive() {
        lineSegmentExampleInteractive.mouseHover();
        reportLog("User performed the mouse hover action on line segment of Example 3 interactive.");
    }

    // Mouse Hover on the x-coordinate interactive of Two dimensions
    public void mouseHoverOnXCoordinateInteractive() {
        xCoordinateInteractive.mouseHover();
        reportLog("User performed the mouse hover action on x coordinate interactive.");
    }

    // Mouse Hover on the y-coordinate interactive of Zero dimensions
    public void mouseHoverOnYCoordinateInteractive() {
        yCoordinateInteractive.mouseHover();
        reportLog("User performed the mouse hover action on y coordinate interactive.");
    }

    // Mouse Hover on the Rect Co-ordinate interactive of two dimensions
    public void mouseHoverOnRectCoordinateInteractive() {
        rectCoordinateInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Rectangular Co-ordinate interactive.");
    }

    // Mouse Hover on the Length and Width interactive of two dimensions
    public void mouseHoverOnLengthWidthInteractive() {
        lengthWidthInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Length and Width interactive.");
    }

    // Mouse out on the Point interactive of Zero dimensions
    public void mouseOutOnPointInteractive() {
        inlinePoint.click();
        reportLog("User performed the mouse out action on Point interactive.");
    }

    // Mouse out on the Solid interactive of Three dimensions
    public void mouseOutOnSolidInteractive() {
        solidCube.click();
        reportLog("User performed the mouse out action on Point interactive.");
    }

    // Mouse out from the three dimension interactive of Zero dimensions
    public void mouseOutOnThreeDimInteractive() {
        threeDimInteractive.click();
        reportLog("User performed the mouse out action on three dimension interactive.");
    }

    // Mouse out on the Shape interactive of Zero dimensions
    public void mouseOutOnShapeInteractive() {
        shapeDimension.click();
        reportLog("User performed the mouse out action on Shape interactive.");
    }

    // Mouse out on the XYCoordinate interactive of two dimensions
    public void mouseOutOnCoordinateInteractive() {
        xyCoordinateTwoDia.click();
        reportLog("User performed the mouse out action on XY Coordinate interactive.");
    }

    // Mouse Hover on the Describe Point interactive of Zero dimensions
    public void mouseHoverOnDescribePointInteractive() {
        describePointInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Describe Point interactive.");
    }

    // Mouse Hover out the Describe Point interactive of Zero dimensions
    public void mouseOutOnLineSegmentInteractive() {
        lineSegment.mouseHover();
        reportLog("User performed the mouse out action on Line Segment interactive.");
    }

    // Mouse Hover on the Line Segment interactive of One dimensions
    public void mouseHoverOnLineSegmentInteractive() {
        lineSegmentInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Line Segment interactive.");
    }

    // Mouse Hover on the Length interactive of One dimensions
    public void mouseHoverOnLengthInteractive() {
        lengthInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Length interactive.");
    }

    // Mouse Hover on the Number Line interactive of One dimensions
    public void mouseHoverOnNumberLineInteractive() {
        numberLineInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Number Line interactive.");
    }

    // Mouse Hover on the Shape interactive of Zero dimensions
    public void mouseHoverOnShapeInteractive() {
        shapeInteractive.mouseHover();
        reportLog("User performed the mouse hover action on Shape interactive.");
    }

    // Verify the Point interactive behaviour before mouse hover
    public boolean beforeMouseHover() {
        boolean result = false;
        if (inlinePoint.getAttribute(CK12Constant.RADIUS).equals(CK12Constant.RADIUS_VALUE_BEFORE_HOVER)) {
            result = true;
        }
        return result;
    }

    // Verify the Point interactive behaviour after mouse hover
    public boolean afterMouseHover() {
        boolean result = false;
        if (inlinePoint.getAttribute(CK12Constant.RADIUS).equals(CK12Constant.RADIUS_VALUE_AFTER_HOVER)) {
            result = true;
        }
        return result;
    }

    // Verify the event API event is gone or not in the Network tab
    public boolean verifyNetworkEvent() {
        boolean result = false;
        String jsEvent = "var performance = window.console || window.console || window.console || window.console || {}; var network = performance.getEntries() || {}; return network;";
        String networkEvent = ((JavascriptExecutor) webDriver).executeScript(jsEvent).toString();
        reportLog(networkEvent);
        if (!networkEvent.isEmpty()) {
            result = true;
        }
        return result;
    }

    // Verify the event API event is gone or not in the Network tab
    public void clearConsole() {
        JavascriptExecutor javascriptExecutor = ((JavascriptExecutor) webDriver);
        javascriptExecutor.executeScript("console.clear();");
    }

    // Extract the browser console logs
    public List<LogEntry> extractJSLogs() {
        LogEntries logEntries = webDriver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            logs.add(entry);
        }
        return logs;
    }

    // Verify the Console logs for an Events fired for interactive action
    public boolean verifyTheLogs() {
        boolean result = true;
        if (logs.isEmpty()) {
            result = false;
        }
        return result;
    }

    // Clear console logs
    public void clearLogs() {
        logs.clear();
    }

    // Verify the Line Segment interactive behaviour before mouse hover
    public boolean beforeMouseHoverLineSegment() {
        boolean result = false;
        if (lineSegment.getAttribute(CK12Constant.RADIUS).equals(CK12Constant.RADIUS_VALUE_BEFORE_HOVER)) {
            result = true;
        }
        return result;
    }

    // Verify the Line Segment interactive behaviour after mouse hover
    public boolean afterMouseHoverLineSegment() {
        boolean result = false;
        if (lineSegment.getAttribute(CK12Constant.RADIUS).equals(CK12Constant.RADIUS_VALUE_AFTER_HOVER)) {
            result = true;
        }
        return result;
    }

    // Verify the Length interactive behaviour before mouse hover
    public boolean beforeMouseHoverLengthInteractive() {
        boolean result = true;
        try {
            if (length.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Length interactive behaviour after mouse hover
    public boolean afterMouseHoverLengthInteractive() {
        boolean result = false;
        try {
            if (length.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Number Line interactive behaviour before mouse hover
    public boolean beforeMouseHoverNumberLineInteractive() {
        boolean result = true;
        try {
            if (numberLine.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Number Line interactive behaviour after mouse hover
    public boolean afterMouseHoverNumberLineInteractive() {
        boolean result = false;
        try {
            if (numberLine.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Describe Point interactive behaviour after mouse hover
    public boolean afterMouseHoverDescribePointInteractive() {
        boolean result = false;
        if (describePoint.getAttribute(CK12Constant.RADIUS).equals(CK12Constant.RADIUS_VALUE_AFTER_HOVER)) {
            result = true;
        }
        return result;
    }

    // Verify the Describe Point interactive behaviour before mouse hover
    public boolean beforeMouseHoverDescribePointInteractive() {
        boolean result = false;
        if (describePoint.getAttribute(CK12Constant.RADIUS).equals(CK12Constant.RADIUS_VALUE_BEFORE_HOVER)) {
            result = true;
        }
        return result;
    }

    // Verify the Number Share Interactive behaviour after mouse hover
    public boolean afterMouseHoverShareInteractive() {
        boolean result = false;
        try {
            if (shape.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Shape interactive behaviour before mouse hover
    public boolean beforeMouseHoverShapeInteractive() {
        boolean result = true;
        try {
            if (shape.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the XY coordinate interactive behaviour before mouse hover
    public boolean beforeMouseHoverXYCoordinateInteractive() {
        boolean result = true;
        try {
            if (xyCoordinate.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the XY coordinate interactive behaviour after mouse hover
    public boolean afterMouseHoverXYCoordinateInteractive() {
        boolean result = true;
        try {
            if (xyCoordinate.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }


    // Verify the Length and Width interactive behaviour before mouse hover
    public boolean beforeMouseHoverLengthWidthInteractive() {
        boolean result = true;
        try {
            if (lengthLW.isDisplayed() && width.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Length and Width interactive behaviour before mouse hover
    public boolean afterMouseHoverLengthWidthInteractive() {
        boolean result = false;
        try {
            if (lengthLW.isDisplayed() && width.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Rectangular Co-ordinate Interactive behaviour after mouse hover
    public boolean afterMouseHoverRectCoordinateInteractive() {
        boolean result = false;
        try {
            if (rectCoordinate.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify the Rectangular Co-ordinate Interactive behaviour after mouse hover
    public boolean beforeMouseHoverRectCoordinateInteractive() {
        boolean result = true;
        try {
            if (rectCoordinate.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify that all the points of an example 2 are highlighted or not
    public boolean beforeMouseHoverPointInteractive() {
        boolean result = true;
        try {
            List<WebElement> pointSize = pointExample.getWebElements();
            if (pointSize.size() == CK12Constant.SIZE) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify that all the points of an example 2 are highlighted or not
    public boolean afterMouseHoverPointInteractive() {
        boolean result = false;
        try {
            List<WebElement> pointSize = pointExample.getWebElements();
            if (pointSize.size() == CK12Constant.SIZE) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify that all the Line Segment of an example 3 are highlighted or not
    public boolean afterMouseHoverLineSegInteractive() {
        boolean result = false;
        try {
            if (lineSegmentExample.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify that all the points of an example 3 are highlighted or not
    public boolean beforeMouseHoverLineSegInteractive() {
        boolean result = true;
        try {
            if (lineSegmentExample.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify that solid interactive is highlighted or not of Three dimension.
    public boolean beforeMouseHoverSolidInteractive() {
        boolean result = true;
        try {
            if (solid.isDisplayed()) {
                result = false;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }

    // Verify that solid interactive is highlighted or not of Three dimension.
    public boolean afterMouseHoverSolidInteractive() {
        boolean result = false;
        try {
            if (solid.isDisplayed()) {
                result = true;
            }
        } catch (Exception e) {
            logger.info(e);
        }
        return result;
    }
}
