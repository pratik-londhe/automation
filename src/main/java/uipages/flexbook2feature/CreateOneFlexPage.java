package uipages.flexbook2feature;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import uipages.BasePage;
import utils.GuiControl;

/**
 * Created by pratik.londhe on 8/8/2018.
 */
public class CreateOneFlexPage extends BasePage {
    private final GuiControl dropdownChoose = new GuiControl(getElementMap().get("dropdownChoose"),webDriver);
    private final GuiControl alreadyInLibraryOption = new GuiControl(getElementMap().get("alreadyInLibraryOption"),webDriver);
    private final GuiControl assignOption = new GuiControl(getElementMap().get("assignOption"),webDriver);
    private final GuiControl editOption = new GuiControl(getElementMap().get("editOption"),webDriver);

    public CreateOneFlexPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    public void clickOnChooserDropdown() {
        dropdownChoose.isElementPresent();
        dropdownChoose.click();
    }

    public boolean isAlreadyInLibraryOptionVisible() {
        return alreadyInLibraryOption.isElementPresent();
    }

    public boolean isAssignOptionVisible() {
        return assignOption.isElementPresent();
    }

    public boolean isEditOptionVisible() {
        return editOption.isElementPresent();
    }
}