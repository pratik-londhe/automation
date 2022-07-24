package uipages.pagecontrolweb;

import constants.Constants;
import org.openqa.selenium.WebDriver;
import uipages.BasePageWeb;
import utils.GuiControlWeb;

public class DashboardPage extends BasePageWeb {
    private final GuiControlWeb buttonProfileDropdown = new GuiControlWeb(getElementMap().get("buttonProfileDropdown"), webDriver);

    public DashboardPage(WebDriver webDriver) {
        super(webDriver);
    }

    //Verify profile drop down visibility
    public boolean isProfileDropDownVisible() {
        return buttonProfileDropdown.isElementPresent(Constants.ELEMENT_PRESENT);
    }
}