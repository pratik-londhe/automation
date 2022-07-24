package com.brandlive.qa.automation.greenroom.pages;

import com.brandlive.qa.automation.utils.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BuilderModeNotesDrawer extends Base {

    public void openNotesDrawerInBuilderMode(){
        String notesDrawer = "//*[name()='svg' and @id='icon-notes-tab']";
        WebElement notesDrawerInBuilderMode = waitForDisplayedAndEnabled(By.xpath(notesDrawer),"Notes Drawer in Builder Mode");
        notesDrawerInBuilderMode.click();
    }

    public void addNote(String noteType){
        String createNote = "//div[contains(@class,'create-note-wrapper')]";
        WebElement createNoteDropDown = waitForDisplayedAndEnabled(By.xpath(createNote),"Notes Drawer in Builder Mode");
        createNoteDropDown.click();
        String dropDownOptions = "//div[@class='popover active options']//span";
        clickOnElementFromDropDown(dropDownOptions,noteType);
    }

    public void addNoteDetails(String noteTitle,String noteContent){
        String titleInput = "//button[@class='back']//following-sibling::input";
        WebElement titleInputField = waitForDisplayedAndEnabled(By.xpath(titleInput),"Note title input field in Builder Mode");
        titleInputField.sendKeys(noteTitle);
        sleep(2);
    }

    public void shareNoteWithPresenter(){
        String presenterShare = "//button[contains(@class,'open-share-popover')]";
        WebElement presenterShareList = waitForDisplayedAndEnabled(By.xpath(presenterShare),"Presenter email list in Builder Mode");
        presenterShareList.click();
        String share = "(//div[@class='share-checkbox'])[1]";
        WebElement shareCheckBox = waitForDisplayedAndEnabled(By.xpath(share),"share check box in Builder Mode");
        shareCheckBox.click();
        String shareNote = "//button[@class='share-note']";
        WebElement shareNoteButton = waitForDisplayedAndEnabled(By.xpath(shareNote),"share note button in Builder Mode");
        shareNoteButton.click();
        sleep(5);
    }

    public boolean validateNoteShared(){
        String shareBar = "//div[contains(@class,'presenters')]";
        WebElement noteSharedBar = waitForDisplayedAndEnabled(By.xpath(shareBar),"Presenter note share bar list in Builder Mode");
        return noteSharedBar.isDisplayed();
    }

    public void closeNote(){
        sleep(2);
        String backArrow = "//button[@class='back']";
        WebElement backArrowButton = waitForDisplayedAndEnabled(By.xpath(backArrow),"Back arrow button for note list in Builder Mode");
        backArrowButton.click();
    }

    public boolean validateSharedNoteTileOnPresenter(String noteTitle){
        String presenterNoteTitle  = "(//div[@class='note-meta']//label[contains(@class,'font-weight-heavy')])[2]";
        WebElement presenterNoteTitleText = waitForDisplayedAndEnabled(By.xpath(presenterNoteTitle),"Note title for presenter");
        return presenterNoteTitleText.getText().equalsIgnoreCase(noteTitle);
    }

    public boolean validatePresenterAvatarOnSharedNoteTile(){
        String avatar  = "//div[@class='presenters']";
        WebElement presenterAvatar = waitForDisplayedAndEnabled(By.xpath(avatar),"Avatar for presenter");
        return presenterAvatar.isDisplayed();
    }

}
