Below are the details of the project framework,

Prerequisites:

1. IntelliJ latest version must be installed.
2. JDK 1.8 version must be installed.
3. Chrome version should be latest.

Steps to install and execute the framework:

1. Take a clone of "qatests" repo on your local machine by executing the below command.
   --> git clone https://github.com/CK-12/qatests.git

2. Open the IntelliJ editor.

3. Click on the "Import Project" button.

4. Select the repo from local where you have cloned and then click on "Open".

5. On IntelliJ, Select the option "Import Project From External Model" and "Maven" then click on "Next".
   Cd .

6. Change Root directory(recommend to keep as it is) then click on "Next".

7. On the next window, Maven project will be selected automatically. Just click on "Next" button.

8. On the "Please select project SDK"  window Click on the "Next" button.

9. On the "Please enter a name to create a new IntelliJ IDEA project" window click on "Finish" button.

10. You will see the project structure on the left side of IntelliJ. Wait until All Maven Dependencies resolve.

11. Expand the "qatests" repo in the IntelliJ.

12. To execute individual test scripts go to the "src-->test-->java--> testscripts-->regression-->studentlogin/teacherlogin" and select any test script, right click and select Run.

13. To execute the complete test suite, Select and Right click on regressionSuit.xml file and Run.

14. After execution of a test script or the test suite, Just open the "ExtendReport.html" file in web to see the execution report.

15. Please ignore the following files/directories if they show up as “untracked” on your git console:
    .idea/
    CK12Automation.iml
    ExtentReport.html
    logs/
    target/

