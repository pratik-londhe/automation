package testscriptsmobile.loginfeatures;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscriptsmobile.BaseTestScriptMobile;
import uipages.pagecontrolmobile.ExamplePage;


/**
 * @author Afreen Shaikh (ashaikh)
 */
public class ExampleTest extends BaseTestScriptMobile {

    @Test(dataProvider = "mobileTestDataProvider",description = "Verify all elements on first page and click on login button")
    public void login(String userName, String password) {
        ExamplePage examplePage = new ExamplePage(appiumDriver);
        examplePage.clickOnLogin();
        extentTest.log(LogStatus.PASS, "Clicked on login button");
        examplePage.loginUser(userName,password);
        extentTest.log(LogStatus.PASS, "Logged into application");

        Assert.assertTrue(examplePage.verifyLogin());

//        examplePage.navigateToPointsTab();
//        extentTest.log(LogStatus.PASS, "navigated to Points page");
//        examplePage.navigateToAccountTab();
//        examplePage.logout();
    }
}
