package testscripts.regression.teacherlogin.GroupsFeature;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import testscripts.BaseTestScript;
import uipages.flexbook2feature.*;

public class CreateClassAndAddStudentTest extends BaseTestScript {
    private static final Logger logger = Logger.getLogger(CreateClassAndAddStudentTest.class);

    @Test(priority = 1, dataProvider = "CK12DataProvider", description = "Verify Functionality of 'Create New Class' Button  After Clicking On Join Plus Icon")
    public void verifyFunctionalityOfCreateNewClassButton(String email, String password) {
        boolean result = true;
        try {
            TeacherDashboardPage teacherDashboardPage = new TeacherDashboardPage(webDriver, extentTest, extentReports);
            PageMenuTab pageMenuTab = new PageMenuTab(webDriver, extentTest, extentReports);
            AddCoTeacherInClass addCoTeacherInClass = new AddCoTeacherInClass(webDriver, extentTest, extentReports);
            CreateNewClassAndDeleteClass createNewClassAndDeleteClass = new CreateNewClassAndDeleteClass(webDriver, extentTest, extentReports);
            LoginPage loginPage = new LoginPage(webDriver,extentTest,extentReports);

            new LoginPage(webDriver, extentTest, extentReports).teacherLogin(email, password);

            loginPage.clickOkOnTouPopUp();
            Assert.assertTrue(teacherDashboardPage.verifyTeacherProfileOnGamma(), "Failed to verify.");
            extentTest.log(LogStatus.PASS, "User Successfully logged in and verified profile icon.");
            logger.info("User Successfully verify and Verify icon as well");

            pageMenuTab.clickOnClassesTab();

            Assert.assertTrue(addCoTeacherInClass.verifyPlusDropDown(), "Failed to verify Plus DropDown");
            extentTest.log(LogStatus.PASS, "Successfully Verify Plus DropDown");
            logger.info("Teacher successfully Verified Plus DropDown");

            addCoTeacherInClass.clickOnPlusDropDown();

            Assert.assertTrue(addCoTeacherInClass.verifyJoinClassButton(), "Failed to verify Join Class Button");
            extentTest.log(LogStatus.PASS, "Successfully verify Join Class Button");
            logger.info("Teacher successfully verify Join Class Button");

            Assert.assertTrue(createNewClassAndDeleteClass.verifyCreateNewClassButton(), "Failed to verify Create New Class Button");
            extentTest.log(LogStatus.PASS, "Successfully verify Create New Class Button");
            logger.info("Teacher successfully verify Create New Class Button");

            createNewClassAndDeleteClass.clickOnCreateNewClassButton();

            Assert.assertTrue(createNewClassAndDeleteClass.verifyCreateAClassButton(), "Failed to verify Create Class Button");
            extentTest.log(LogStatus.PASS, "Successfully verify Create Class Button");
            logger.info("Teacher successfully verify Create Class Button");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 2, description = "Verify Functionality of 'Create Class' Button Without Entering Class Name")
    public void verifyFunctionalityCreateClassButtonWithoutName() {
        boolean result = true;
        try {
            /*CreateNewClassAndDeleteClass createNewClassAndDeleteClass = new CreateNewClassAndDeleteClass(webDriver, extentTest, extentReports);

            createNewClassAndDeleteClass.clickOnCreateAClassButton();

            Assert.assertTrue(createNewClassAndDeleteClass.verifyCreateAClassButton(), "Failed to verify Create Class Button");
            extentTest.log(LogStatus.PASS, "Successfully verify Create Class Button");
            logger.info("Teacher successfully verify Create Class Button");

            createNewClassAndDeleteClass.clickOnCreateAClassButton();

            Assert.assertTrue(createNewClassAndDeleteClass.verifyErrorClassNameMessage(), "Failed to verify Error Class Name Message");
            extentTest.log(LogStatus.PASS, "Successfully verify Error Class Name Message");
            logger.info("Teacher successfully verify Error Class Name Message");*/

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 3, description = "Verify Functionality of 'Create Class' Button With Valid Class Name")
    public void verifyFunctionalityCreateClassButtonWithValidName() {
        boolean result = true;
        try {
            CreateNewClassAndDeleteClass createNewClassAndDeleteClass = new CreateNewClassAndDeleteClass(webDriver, extentTest, extentReports);
            createNewClassAndDeleteClass.clickOnCreateAClassButton();

            String name = "Class1";

            createNewClassAndDeleteClass.setValueInClassNamePlaceHolderAgain(name);

            Assert.assertTrue(createNewClassAndDeleteClass.verifyCreateClassButton(), "Failed to verify Create Class Button");
            extentTest.log(LogStatus.PASS, "Successfully verify Create Class Button");
            logger.info("Teacher successfully verify Create Class Button");

            createNewClassAndDeleteClass.clickOnCreateClassButton();

            Assert.assertTrue(createNewClassAndDeleteClass.verifyNewClassIsAddedInList(), "Failed to verify Newly Added Class");
            extentTest.log(LogStatus.PASS, "Successfully verify Newly Added Class");
            logger.info("Teacher successfully verify Newly Added Class");

        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }

    @Test(priority = 5, description = "Verify Functionality of 'Recently Added Class' Icon")
    public void verifyAddStudentInClass() {
        String tempFirstName = "A_testuser";
        String tempUniqueNameAgain = "Student_";
        String tempPass = "Teacher1";

        boolean result = true;
        try {
            CreateNewClassAndDeleteClass createNewClassAndDeleteClass = new CreateNewClassAndDeleteClass(webDriver, extentTest, extentReports);
            TeacherAddStudentInClass teacherAddStudentInClass = new TeacherAddStudentInClass(webDriver, extentTest, extentReports);
            TeacherGroupDiscussionInClass teacherGroupDiscussionInClass = new TeacherGroupDiscussionInClass(webDriver, extentTest, extentReports);
            ClassPage classPage = new ClassPage(webDriver, extentTest, extentReports);

            teacherAddStudentInClass.clickOnClassNameIcon();

            Assert.assertTrue(teacherGroupDiscussionInClass.verifyButtonQAndA(), "Failed to verify Q And A Button");
            extentTest.log(LogStatus.PASS, "Successfully Verify Q And A Button");
            logger.info("Teacher successfully Verified Q And A Button");

            Assert.assertTrue(createNewClassAndDeleteClass.verifyWelcomeInNewClassText(), "Failed to verify Welcome In Class Text");
            extentTest.log(LogStatus.PASS, "Successfully verify Welcome In Class Text");
            logger.info("Teacher successfully verify Welcome In Class Text");

            Assert.assertTrue(classPage.verifySettingsOption(), "Failed to verify Settings section on class page.");
            extentTest.log(LogStatus.PASS, "Settings section is displaying on class page.");
            logger.info("Settings section is displaying on class page.");

            teacherAddStudentInClass.clickOnAddStudentButton();
            teacherAddStudentInClass.clickOnAddStudentWithoutEmail();
            teacherAddStudentInClass.setFirstName(tempFirstName);
            teacherAddStudentInClass.setUniqueName(tempUniqueNameAgain);
            teacherAddStudentInClass.setUserPassword(tempPass);
            teacherAddStudentInClass.clickOnCreate();
            teacherAddStudentInClass.clickOnViewReport();
            teacherAddStudentInClass.verifyAddStudentButton();
        } catch (Exception e) {
            result = handleException(e);
        }
        Assert.assertTrue(result, "Test script failed : " + errorMessage);
    }
}
