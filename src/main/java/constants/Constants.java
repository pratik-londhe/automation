package constants;

public class Constants {
    //SCRIPT FAIL MESSAGE
    public static final String TEST_SCRIPT_FAIL_MSG = "Test Script Failed.";

    //PropertyReader
    public static final String USER_DIR = "user.dir";
    public static final String PROPERTY_FILE_WEB = "/ConfigWeb.properties";
    public static final String PROPERTY_FILE_MOBILE = "/ConfigMobile.properties";
    public static final String LOGGERS_PROPERTY_FILE = "/src/test/resources/testdata/loggersdata/loggers.properties";

    //ExcelReader
    public static final String SHEET_PATH = "/src/test/resources/testdata/exceldata/testDataSheet.xlsx";
    public static final String SHEET_NAME = "testDataSheet";
    public static final String FAIL_MSG = "Fail to read excel file : ";

    //GuiControl
    public static final String DATE_PATTERN = "MM/dd/yyyy";

    //Test Timeout
    public static final int TEST_TIME_OUT = 600000;
    public static final int WAIT_CLICK = 4;
    public static final int THREAD_SLEEP_INSPECTION = 5000;

    //DashboardPage
    public static final String EMAIL_TERMS_COND = "Email Us    |    Terms and Conditions";
    public static final String LANG_CHINESE = "Chinese";
    public static final String LANG_ENGLISH = "English";
    public static final int ELEMENT_PRESENT = 4;

    //LoginPage
    public static final String MSG_AT_LOGIN = "There is some problem performing this operation. Please try again.";

    //GmailPage
    public static final int CLIENT_TEMP_PASS_START = 1;
    public static final int CLIENT_TEMP_PASS_END = 11;
    public static final int NEXT_TAB = 1;
    public static final int PREVIOUS_TAB = 0;
    public static final int SIX_VERIF_CODE_START = 46;
    public static final int SIX_VERIF_CODE_END = 52;
    public static final String WINDOW_OPEN = "window.open()";

    //For Enrollment
    public static final String CLIENT_LIST_HEADER = "By checking any box below, your company profile can be viewed by the specified client. There is an additional cost associated to adding Client's.";
    //CreateLoginPage
    public static final String CIRCLE = "Circle ";
    public static final String BG_COLOR_IS = " background color is ";
    public static final String EMAIL_EXIST_FAIL_MSG = "User with this email address already exists in the system for different user. please provide some different email address.";
    //InfoSectionPage
    public static final String CONT_SIGN_UP = "New Contractor Sign-Up - ";
    public static final String FIVE_STEPS_TEXT = "Enrollment is easy and takes only 5 simple steps. Let’s get started!";
    //PaymentsPage
    public static final String COLOR_BLUE = "rgba(0, 73, 143, 1)";
    public static final String COLOR_GREEN = "rgba(62, 181, 79, 1)";
    public static final String GREEN_COLOR = "rgb(62, 181, 79)";
    public static final String COLOR_LIGHT_WHITE = "rgba(242, 245, 247, 1)";
    public static final String COLOR_RED = "rgba(220, 53, 69, 1)";
    public static final String COLOR_ORANGE = "rgba(253, 126, 20, 1)";
    public static final String COLOR_YELLOW = "rgba(255, 193, 7, 1)";
    public static final String CSS_VAL_BG_COLOR = "background-color";
    public static final String STEPS_FAIL_MSG = "Fail to verify steps.";
    public static final String FIELD_NONE_MSG = " NONE ";
    public static final String NO_ERR_MSG = "NO ERROR MESSAGES.";
    public static final int COL_NO_STEPS = 6;

    //CSUser-CSClient
    public static final int USER_EMAIL_COL = 1;
    public static final String USER_ADDED = "User successfully added.";
    public static final String TITLE_CS_USER = "Create New CS User";

    public static final String CLIENT_ARCHIVED = "Client successfully archived.";
    public static final String CLIENT_ADDED = "Client successfully added.";
    public static final String TITLE_CS_CLIENT = "Create New Client";

    //ChangePasswordCSUserPage
    public static final String PASS_UPDATE_MSG = "Password successfully updated.";

    //SecurityQuestionsCSUserPage
    public static final String SEC_QUESTION_ONE = "2";
    public static final String SEC_QUESTION_TWO = "3";
    public static final String SEC_QUESTION_THREE = "4";
    public static final String QUESTIONS_UPDATE_MSG = "Questions successfully updated.";

    //For MasterList
    public static final String COPYRIGHT_TEXT = "Copyright © ConstructSecure, Inc, 2019. All rights reserved.";

    public static final String QUESTION_ADDED = "Question added successfully.";
    public static final String SECTION_ADDED = "Section added successfully.";
    public static final String SECTION_DELETE_MSG = "Success.";
    public static final int SECTION_LABEL_COL = 2;

    //BAH262
    public static final String SELECT_TRADE = "Select Trade Description";
    public static final String FAIL_CROSS_MARK = "Fail to verify cross mark ";
    public static final String FAIL_RADIO_BUTTON = " Fail to verify radio button ";
    public static final int INC_TO_INDEX = 1;
    public static final int COL_NO_TD = 0;

    //BAH263
    public static final String INPUT_TYPE = "text";
    public static final String ATTR_TYPE = "type";
    public static final String SELECT_TYPE = "select";
    public static final String CALENDAR_TYPE = "p-calendar";

    //BAH627
    public static final String BASIC_INFO_TXT = "Enter basic information — your name and email. The email will be used to send a password if you forget it.";

    //BAH649
    public static final String TAG_TD = "td";

    //BAH828
    public static final String ERROR_WHILE_LOGIN = "Error occurred while login!!! Please check username and password.";
    public static final String NO_ERROR_WHILE_LOGIN = "User entered valid username and password and no error message displayed.";
    public static final String CLICK_BUTTON_INVITE_USER = "User clicked on button Invite User.";
    public static final String APPROPRIATE_ERROR_MSG = "Appropriate error message displayed.";
    public static final String CLICK_BUTTON_CANCEL = "User clicked on button Cancel.";

    //BAH989
    public static final String ATTR_VALUE = "value";
    public static final String SUB_QUE_FAIL_MSG = "Fail to verify Mark As Sub-Question text box.";
    public static final int COL_NO_POSITION = 1;
    public static final int COL_NO_FIELD_TYPE = 2;
    public static final int COL_NO_QUE_VIS = 3;
    public static final int COL_NO_SIZE = 4;
    public static final String TXT_FAIL_OPTION = "Fail to verify option ";

    //BAH1025
    public static final int COL_NO_SUPPORT_FIELD = 9;

    //BAH1071
    public static final int COL_FIELD_TYPE = 12;
    public static final int COL_DD_LIMITS = 13;

    //BAH1081
    public static final int COL_PRE_DD = 14;

    //BAH1491
    public static final int COL_SF_TABS = 16;
    public static final int COL_ML_HEADERS = 17;

    //BAH1494
    public static final String CSS_VAL_BACKGROUND = "background-color";
    public static final String COLOR_DARK_BLUE = "rgba(0, 73, 143, 1)";
    public static final int INDEX_BUTTONS = 18;

    //BAH1510
    public static final int TABLE_HEADERS = 19;
    public static final String BLUE_COLOR = "rgb(0, 64, 140)";

    //BAH1529
    public static final int FP_TABS = 20;

    //BAH1549
    public static final String SECTION_DELETE_QUES = "Are you sure want to delete this?";
    public static final String TXT_DELETE = "Delete";
    public static final String SECTION_UPDATE = "Section updated successfully.";

    //BAH1673
    public static final int INDEX_TWENTY_ONE = 21;
    public static final int INDEX_TWENTY_TWO = 22;

    //BAH1676
    public static final String TXT_SUPPORT_FIELD = "Show Supporting Field";

    //BAH1962
    public static final String FAIL_RADIO_LABEL = "Fail to verify radio label.";

    //BAH6445
    public static final String DEFAULT_COUNT = "0";
    //BAH2046
    public static final int INIT_COUNT = 0;
    public static final String LABEL_CONTACT = "Contact";
    public static final String SPLIT_REGEX = "-";
    public static final String SPLIT_REG_EX = "/";
    public static final String LBL_BAH = "BAH2046";

    //BAH2047
    public static final String LABEL_COMPANY = "Company";
    public static final String LABEL_PHONE = "Phone";
    public static final String LABEL_EMAIL = "Email";
    public static final String LABEL_FAX = "Fax";
    public static final int CASE_ONE = 1;
    public static final int CASE_TWO = 2;
    public static final int CASE_THREE = 3;
    public static final int CASE_FOUR = 4;
    public static final String LOGGER_MSG_NOMATCH = "No match found";

    //BAH2060
    public static final String SPLIT_REGEX_AGAIN = "_";
    public static final int INDEX_ONE = 0;
    public static final int INDEX_TWO = 1;
    public static final int START_INDEX = 1;
    public static final int INDEX_LIMIT = 5;
    public static final String ATTR_DISABLED = "disabled";

    //BAH2048
    public static final int INDEX_THREE = 3;
    public static final int INDEX_FOUR = 4;
    public static final String ACCEPT_MSG = " is accepted by text box % of Assets allocated.";
    public static final String NO_ACCEPT_MSG = "Text box % of Assets allocated accepts only numeric data.";

    //BAH2049
    public static final int INDEX_FIVE = 5;
    public static final int INDEX_TEN = 10;
    public static final int INDEX_FIFTEEN = 15;
    public static final int INDEX_TWENTY = 20;

    //BAH2070
    public static final int INDEX_SIX = 6;
    public static final int INDEX_SEVEN = 7;
    // CS Tracker - BAH 7494
    public static final String PPE_ERROR_MESSAGE = "This field is required";
    //BAH2587
    public static final String TOAST_MSG = "Toast message displayed : ";

    //BAH2878
    public static final String FOOTER_TEXT = "Copyright © ConstructSecure, Inc, 2019. All rights reserved.Email Us    |    Terms and Conditions";
    public static final String ATTR_ARIA_EXPAND = "aria-expanded";
    public static final String VAL_TRUE = "true";

    //BAH2883
    public static final String CDD_VISIBLE = "Client drop down is visible.";
    public static final String CDD_NOT_VISIBLE = "Client drop down is not visible.";
    public static final int INDEX_EIGHT = 8;
    public static final String COLOR_LIGHT_BLUE = "rgba(0, 0, 0, 0)";

    //BAH2885
    public static final String ROW_SMD = "Safety Manual Document";
    public static final String ROW_OSHA = "OSHA 300A Summary Form";
    public static final String ROW_EMR = "Insurance EMR Rating";

    //BAH2886
    public static final String SUBT_DESC = "Discrepancies";
    public static final String SUBT_SMS = "Safety Management Systems";
    public static final String SUBT_SPE = "Safety Program Elements";
    public static final String SUBT_SE = "Special Elements";
    public static final String DESC_TEXT = "Each item below notes a question that was answered \"Yes\" \n" +
            "but there was not enough information in your Safety Manual to support the “Yes” answer. ";
    public static final String EMPTY_STR = "";

    //BAH2895
    public static final String COLOR_WHITE = "rgba(0, 0, 0, 0)";
    public static final String WHITE_COLOR = "rgb(0, 0, 0)";
    public static final String FAIL_TAB_COLOR = "Fail to verify background color of tab.";

    //BAH2902
    public static final String COLOR_LIGHT_GREEN = "rgba(153, 217, 172, 1)";
    public static final String LIGHT_GREEN_COLOR = "rgb(153, 217, 172)";
    public static final String COLOR_DARK_GREEN = "rgba(5, 117, 61, 1)";
    public static final String DARK_GREEN_COLOR = "rgba(5, 117, 61)";
    public static final String COLOR_LIGHT_RED = "rgba(255, 121, 132, 1)";
    public static final String LIGHT_RED_COLOR = "rgba(255, 121, 132)";
    public static final String COLOR_DARK_RED = "rgba(142, 33, 47, 1)";
    public static final String DARK_RED_COLOR = "rgba(142, 33, 47)";
    public static final String CSS_VAL_TXT_COLOR = "color";

    //BAH2903_2904
    public static final String CAT_DART = "DART";
    public static final String DART_STRENGTH_MSG = "Days Away case and Restricted 'Recordable Case' is better than industry average";
    public static final float DART_SCORE_STRENGTH = 11f;
    public static final String CAT_RC = "RECORDABLE CASES";
    public static final String RC_STRENGTH_MSG = "Recordable Cases is better than industry average";
    public static final float RC_SCORE_STRENGTH = 11f;
    public static final String CAT_EMR = "EMR";
    public static final String EMR_STRENGTH_MSG = "EMR is better than the industry average";
    public static final float EMR_SCORE_STRENGTH = 1f;
    public static final float SMS_SCORE_STRENGTH = 20f;
    public static final float SPE_SCORE_STRENGTH = 7f;
    public static final String CAT_SE = "Special Elements";
    public static final String CAT_SMD = "Safety Manual Document";
    public static final String SMD_STRENGTH_MSG = "No points deducted from Safety Documentation";
    public static final String SMD_ZERO_DEDUCT = "0 Points Deducted";
    public static final String CAT_FAT = "FATALITIES";
    public static final String FAT_STRENGTH_MSG = "No fatalities in the past";
    public static final String FAT_SCORE_STRENGTH = "Points Awarded";
    public static final String FAIL_STRENGTH_MSG = "Fail to verify strength message for category : ";
    public static final String CAT_NO_MSG = "NO MESSAGE FOR THIS CATEGORY";
    public static final String TXT_CAT = "Category: ";
    public static final String TXT_SCORE = "SCORE: ";
    public static final String TXT_MSG_STRENGTH = "MESSAGE IN STRENGTH SECTION:";
    public static final String STR_SEP = " | ";

    //BAH2906
    public static final String NO_AWARD = "No Award For This User.";
    //BAH3198
    public static final int TEXT_FIELD_HOURS = 20;

    //BAH2386
    public static final String CLIENT_NAME = "Client Name: ";
    public static final String CLIENT_STATUS = "Client Status: ";
    public static final String QUESTION_ANSWERED = " Question Answered: ";
    public static final String QUESTION_PERCENT = " Percentage: ";

    //BAH2391
    public static final String ATTR_CLASS = "class";
    public static final String CLASS_VALUE = "ui-chkbox-icon ui-clickable";

    //BAH3073
    public static final String CLICK_ADD_INSPECTION = "Client clicked on button Add Inspection.";

    //BAH3074
    public static final String NO_DATA_FOUND = "No data found!!!";

    //BAH3111
    public static final String CLICK_BUTTON_EDIT = "Client clicked on button Edit to open Edit Inspection pop up.";

    //BAH3629
    public static final String ADD_CATEGORY = "Add Category";

    //BAH3811
    public static final String EDIT_INSPECTION_TYPE = "Edit Inspection Type";

    //BAH3812
    public static final String EDIT_CATEGORY = "Edit Category";

    //BAH3477
    public static final String SEGMENT_TITLE = "Segment Component";

    //BAH3482
    public static final String COMPONENT_SEGMENT = "Segment";

    //BAH3527
    public static final String COLOR_GREY = "rgb(177, 189, 209)";
    public static final String GREY_COLOR = "rgba(177, 189, 209, 1)";

    //BAH3780
    public static final String TITLE_FLAG_SETTINGS = "Flag Settings";

    //BAH3981
    public static final String ICON_COLOR_WHITE = "rgb(255, 255, 255)";
    public static final String ICON_WHITE_COLOR = "rgba(255, 255, 255, 1)";

    //BAH4369
    public static final String REGION_ADDED = "Region added in table.";

    //BAH4371
    public static final String ADD_REGION = "Add Region";

    //BAH3523
    public static final String LBL_ACTUAL_VALUE = " | Actual Value: ";
    public static final String LBL_EXPECT_VALUE = " | Expected Value: ";
    public static final String LBL_CORRECT = " | CORRECT |";
    public static final String LBL_INCORRECT = " | INCORRECT |";
    public static final int INDEX_NINE = 9;
    public static final int THREAD_SLEEP_FP = 15000;

    //BAH3527
    public static final String DATA_VALUE = "data-value";

    //BAH3550
    public static final int ARRAY_INDEX_ZERO = 0;
    public static final int ARRAY_INDEX_ONE = 1;
    public static final int ARRAY_INDEX_TWO = 2;
    public static final int ARRAY_INDEX_THREE = 3;

    //BAH4035 - Amount Options
    public static final String MILLION_VALUE = "000,000";
    public static final String RUPEES = "rupees";
    public static final String CAD = "cad";

    //BAH3528 Help Message
    public static final String HELP_MESSAGE = "If 'No', Please enter correct values above and confirm data is correct by selecting 'Yes'";
    public static final String ATTRIBUTE_VALUE = "true";
    public static final String ANSI_RED = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";

    //BAH5246
    public static final String LABEL_ERROR = "*Field label is required";
    public static final String ASTERISK_SIGN = "*";

    private Constants() {
    }
}