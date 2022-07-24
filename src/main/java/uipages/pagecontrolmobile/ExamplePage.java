package uipages.pagecontrolmobile;

import io.appium.java_client.AppiumDriver;
import uipages.BasePageMobile;
import utils.GuiControlMobile;

/**
 * @author Afreen Shaikh (ashaikh)
 */
public class   ExamplePage extends BasePageMobile {
    private final GuiControlMobile linkSignIn = new GuiControlMobile(getElementMap().get("linkSignIn"), appiumDriver);
    private final GuiControlMobile userNameTextField = new GuiControlMobile(getElementMap().get("userNameTextField"), appiumDriver);
    private final GuiControlMobile passwordTextField = new GuiControlMobile(getElementMap().get("passwordTextField"), appiumDriver);
    private final GuiControlMobile loginButton = new GuiControlMobile(getElementMap().get("loginButton"), appiumDriver);
    private final GuiControlMobile glamBagTab = new GuiControlMobile(getElementMap().get("glamBagTab"), appiumDriver);
    private final GuiControlMobile shopperTab = new GuiControlMobile(getElementMap().get("shopperTab"), appiumDriver);
    private final GuiControlMobile pointsTab = new GuiControlMobile(getElementMap().get("pointsTab"), appiumDriver);
    private final GuiControlMobile accountTab = new GuiControlMobile(getElementMap().get("accountTab"), appiumDriver);
    private final GuiControlMobile logOut = new GuiControlMobile(getElementMap().get("logOut"), appiumDriver);
    private final GuiControlMobile ipsyCareOption = new GuiControlMobile(getElementMap().get("ipsyCareOption"), appiumDriver);
    private final GuiControlMobile search = new GuiControlMobile(getElementMap().get("search"), appiumDriver);

    public ExamplePage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickOnLogin(){
        if("web".equalsIgnoreCase(getPlatform())) {
            linkSignIn.click();
        }else if("android".equalsIgnoreCase(getPlatform())){

            
        }else if("ios".equalsIgnoreCase(getPlatform())){

        }
    }

    public void loginUser(String username, String password){
      userNameTextField.setText(username);
      passwordTextField.setText(password);
      hideKeyboard(appiumDriver);
      loginButton.click();
      waitForPageLoaded(appiumDriver);
    }

    public boolean verifyLogin(){
     return glamBagTab.isDisplayed();
    }

    public void navigateToShopperTab(){
       shopperTab.click();
       waitForPageLoaded(appiumDriver);
    }

    public void navigateToPointsTab(){
        pointsTab.click();
        waitForPageLoaded(appiumDriver);
    }

    public void navigateToAccountTab(){
        accountTab.click();
        waitForPageLoaded(appiumDriver);
    }

    public void logout(){
        ipsyCareOption.scrollToElement();
        logOut.clickJScript();
    }
}
