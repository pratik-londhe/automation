package uipages.interactives;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.sun.scenario.effect.Bloom;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import uipages.BasePage;
import utils.GuiControl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class BiologyInteractivesPage extends BasePage {

    private final GuiControl nitrogenBasesImg = new GuiControl(getElementMap().get("nitrogenBasesImg"), webDriver);
    private final GuiControl cellularRespirationIA = new GuiControl(getElementMap().get("cellularRespirationIA"), webDriver);
    private final GuiControl aerobicRespirationIA = new GuiControl(getElementMap().get("aerobicRespirationIA"), webDriver);
    private final GuiControl photosynthesisCplstIA = new GuiControl(getElementMap().get("photosynthesisCplstIA"), webDriver);
    private final GuiControl cellularRespirationMatchSuccess = new GuiControl(getElementMap().get("cellularRespirationMatchSuccess"), webDriver);
    private final GuiControl aerobicRespirationCheckButton = new GuiControl(getElementMap().get("aerobicRespirationCheckButton"), webDriver);
    private final GuiControl aerobicRespirationMessageCard = new GuiControl(getElementMap().get("aerobicRespirationMessageCard"), webDriver);
    private final GuiControl aerobicRespirationMatchMsg = new GuiControl(getElementMap().get("aerobicRespirationMatchMsg"), webDriver);
    private final GuiControl photosynthesisCplstMessageCard = new GuiControl(getElementMap().get("photosynthesisCplstMessageCard"), webDriver);
    private final GuiControl photosynthesisCplstMatchMsg = new GuiControl(getElementMap().get("photosynthesisCplstMatchMsg"), webDriver);
    private final GuiControl doubleHelixBaseImg = new GuiControl(getElementMap().get("doubleHelixBaseImg"), webDriver);
    private final GuiControl dnaReplicaBaseImg = new GuiControl(getElementMap().get("dnaReplicaBaseImg"), webDriver);
    private final GuiControl dnaReplicaIAArrow = new GuiControl(getElementMap().get("dnaReplicaIAArrow"), webDriver);
    private final GuiControl dnaReplicaIAPlayBtn = new GuiControl(getElementMap().get("dnaReplicaIAPlayBtn"), webDriver);
    private final GuiControl enzymesBaseImage = new GuiControl(getElementMap().get("enzymesBaseImage"), webDriver);
    private final GuiControl nucleicAcidBaseImg = new GuiControl(getElementMap().get("nucleicAcidBaseImg"), webDriver);
    private final GuiControl nucleicAcidIAArrow = new GuiControl(getElementMap().get("nucleicAcidIAArrow"), webDriver);
    private final GuiControl significanceOfCarbonMatchTest = new GuiControl(getElementMap().get("significanceOfCarbonMatchTest"), webDriver);
    private final GuiControl proteinStructureMatchTest = new GuiControl(getElementMap().get("proteinStructureMatchTest"), webDriver);
    private final GuiControl matchTestCheckButton = new GuiControl(getElementMap().get("matchTestCheckButton"), webDriver);
    private final GuiControl correctMatch = new GuiControl(getElementMap().get("correctMatch"), webDriver);
    private final GuiControl correctMatchMsg = new GuiControl(getElementMap().get("correctMatchMsg"), webDriver);
    private final GuiControl phActivityIAImage = new GuiControl(getElementMap().get("phActivityIAImage"), webDriver);
    private final GuiControl phActivityIAArrow = new GuiControl(getElementMap().get("phActivityIAArrow"), webDriver);
    private final GuiControl phActivityIARange = new GuiControl(getElementMap().get("phActivityIARange"), webDriver);
    private final GuiControl hydrogenBondBaseImg = new GuiControl(getElementMap().get("hydrogenBondBaseImg"), webDriver);
    private final GuiControl hydrogenBondIAArrow = new GuiControl(getElementMap().get("hydrogenBondIAArrow"), webDriver);
    private final GuiControl cellMembraneStructureMatchTest = new GuiControl(getElementMap().get("cellMembraneStructureMatchTest"), webDriver);
    private final GuiControl cellMembraneStructureCheckButton = new GuiControl(getElementMap().get("cellMembraneStructureCheckButton"), webDriver);
    private final GuiControl cellMembraneStructureCorrectMatch = new GuiControl(getElementMap().get("cellMembraneStructureCorrectMatch"), webDriver);
    private final GuiControl cellMembraneStructureIncorrectMatchMsg = new GuiControl(getElementMap().get("cellMembraneStructureIncorrectMatchMsg"), webDriver);
    private final GuiControl cellStructureMatchTest = new GuiControl(getElementMap().get("cellStructureMatchTest"), webDriver);
    private final GuiControl activeTransportMatchTest = new GuiControl(getElementMap().get("activeTransportMatchTest"), webDriver);
    private final GuiControl naturalSelectionMatchTest = new GuiControl(getElementMap().get("naturalSelectionMatchTest"), webDriver);
    private final GuiControl cellDiffusionIA = new GuiControl(getElementMap().get("cellDiffusionIA"), webDriver);
    private final GuiControl cellDiffusionIAKnob = new GuiControl(getElementMap().get("cellDiffusionIAKnob"), webDriver);
    private final GuiControl cellDiffusionIAKnobBottom = new GuiControl(getElementMap().get("cellDiffusionIAKnobBottom"), webDriver);
    private final GuiControl cellDiffusionIADiffuseButton = new GuiControl(getElementMap().get("cellDiffusionIADiffuseButton"), webDriver);
    private final GuiControl cellDiffusionIAArrow = new GuiControl(getElementMap().get("cellDiffusionIAArrow"), webDriver);
    private final GuiControl mitiosPhaseMatchingIA = new GuiControl(getElementMap().get("mitiosPhaseMatchingIA"), webDriver);
    private final GuiControl dnaInformationIA = new GuiControl(getElementMap().get("dnaInformationIA"), webDriver);
    private final GuiControl dnaInformationSlider = new GuiControl(getElementMap().get("dnaInformationSlider"), webDriver);
    private final GuiControl toolTipHeader = new GuiControl(getElementMap().get("toolTipHeader"), webDriver);
    private final GuiControl toolTipBody = new GuiControl(getElementMap().get("toolTipBody"), webDriver);
    private final GuiControl geneticCodeIA = new GuiControl(getElementMap().get("geneticCodeIA"), webDriver);
    private final GuiControl geneticCodeIAArrow = new GuiControl(getElementMap().get("geneticCodeIAArrow"), webDriver);
    private final GuiControl geneticCodeCheckButton = new GuiControl(getElementMap().get("geneticCodeCheckButton"), webDriver);
    private final GuiControl geneticCodeMsgCard = new GuiControl(getElementMap().get("geneticCodeMsgCard"), webDriver);
    private final GuiControl geneticCodeMatchMsg = new GuiControl(getElementMap().get("geneticCodeMatchMsg"), webDriver);
    private final GuiControl aminoAcidMatchingLeftBlock = new GuiControl(getElementMap().get("aminoAcidMatchingLeftBlock"), webDriver);
    private final GuiControl aminoAcidMatchingRightBlock = new GuiControl(getElementMap().get("aminoAcidMatchingRightBlock"), webDriver);
    private final GuiControl translationMolecularRNAIA = new GuiControl(getElementMap().get("translationMolecularRNAIA"), webDriver);
    private final GuiControl translationMolecularRNAIAArrow = new GuiControl(getElementMap().get("translationMolecularRNAIAArrow"), webDriver);

    Actions actions = new Actions(webDriver);

    // Base images directory path
    String filePathBase = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
            + "biologyBaseAnimation";

    // File Path After comparison difference
    String filePathAfterCmp = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
            + "biologyAfterAnimation";

    // 1.9 concepts matchers
    String[] significanceOfCarbon = {"Protein", "Carbohydrate", "Nucleic Acid", "Lipid"};

    // 1.11 concepts matchers
    String[] proteins = {"Quaternary", "Primary", "Secondary", "Tertiary"};

    // 2.8 concept matchers
    String[] cellStructure = {"Centrioles", "ER", "Golgi Apparatus", "Lysosomes"};

    // 2.14 concept matchers
    String[] activeTransport = {"Exocytosis", "Endocytosis", "Protein pump"};

    //5.21 concept matchers
    String[] naturalConcept = {"Stabilizing Selection", "Disruptive Selection", "Directional Selection"};

    String[] placeHolder;

    String[] biology1dot4 = {"Hot Temperature", "Ideal Temperature", "Cold Temperature"};

    String[] biology1dot5 = {"Cell", "Nucleus", "Chromosome", "DNA", "Gene"};

    String[] biology1dot7part1 = {"Organelle", "Cell", "Tissue", "Organ", "Organ System", "Organism"};

    String[] biology1dot7part2 = {"Organism", "Population", "Community", "Ecosystem", "Biome", "Biosphere"};

    String[] biology1dot10 = {"Monosaccharides", "Disaccharide", "Polysaccharide"};

    String[] biology1dot11 = {"Primary structure", "Secondary structure", "Tertiary structure", "Quaternary structure"};

    String[] biology1dot18 = {"Enzyme", "Substrate binding", "Enzyme-substrate complex", "Product"};

    String[] biology2dot3 = {"Phospholipid", "Phospholipids", "Phospholipid Bilayer"};

    String[] biology2dot32 = {"Gap 1", "Synthesis", "Gap 2", "Mitosis", "Cytokinesis", "Cycle Ends"};

    String[] biology2dot34 = {"Interphase", "Prophase", "Metaphase", "Anaphase", "Telophase", "Cytokinesis"};

    String[] biology2dot34part1 = {"Nucleus--", "Chromosomes--", "Spindle Fibers--", "Centrioles--"};

    String[] biology2dot3part1 = {"H2O--A polar molecule like water will often use a protein to pass through the cell membrane, but it is small enough to pass directly through the cell membrane without the help of a protein.",
            "Gases--Gases like oxygen and carbon dioxide diffuse readily through the membrane.",
            "Steroids--Small lipids like steroids and glycerol pass right through the membrane.",
            "Glucose--Glucose, being a polar solute, needs special proteins to pass through the membrane.",
            "Ions--Ions like Na⁺ and Cl⁻ cannot pass through the membrane. They are exchanged by the cell through special proteins that may need energy to cross the cell membrane."};

    String[] biology2dot2 = {"Ribosome--Ribosomes are structures found in all cells that are the site of protein synthesis.",
            "Mitochondria--Mitochondria are organelles that use energy stored in glucose to make ATP, which cells can use for energy.",
            "Vesicles--Vesicles are small sac-like organelles that transport materials inside a cell.",
            "Lysosomes--Lysosomes are organelles that use enzymes to break down molecules so their components can be recycled.",
            "Golgi apparatus--The Golgi apparatus is an organelle that modifies, sorts, and packages proteins for secretion out of the cell, or for use within the cell.",
            "Nucleus--The nucleus is an organelle that contains most of the cell’s DNA and acts as the control center of the cell.",
            "Chromosomes--Chromosomes are coiled structures made of DNA and protein that are the form of genetic material present during cell division.",
            "Endoplasmic Reticulum--The endoplasmic reticulum is an organelle that helps make proteins and lipids and transports proteins in the cell.",
            "Cytoplasm--The cytoplasm is the material inside the cell membrane, including the watery cytosol and other cell structures except the nucleus.",
            "Cell Membrane--The cell membrane is the thin coat of phospholipids that surrounds a cell and controls what enters and leaves the cell."};

    String[] biology2dot1 = {"Cell Membrane--The cell membrane is a thin coat of phospholipids that surrounds a cell and controls what enters and leaves the cell.",
            "Cytoplasm--Cytoplasm is the material inside the cell membrane, including the watery cytosol and other cell structures except the nucleus if one is present.",
            "Ribosomes--Ribosomes are structures found in cytoplasm that are the site of protein synthesis.",
            "Cytoskeleton--The cytoskeleton consists of filaments and tubules that crisscross the cytoplasm and help maintain the cell’s shape.",
            "DNA--DNA is a nucleic acid found in cells. It contains the genetic instructions that cells need to make proteins."};


    public BiologyInteractivesPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    // This method takes the base images of the animation before to compare with actual image.
    public boolean baseBiologyBookInteractives(String animationEmbedID) {
        int i = 1;

        createFolder(filePathBase);

        String interactiveAnimation = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[1]";
        GuiControl interactiveAnimationImage = new GuiControl(interactiveAnimation, webDriver);

        String interactiveRangeSelector = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[4]";
        GuiControl interactiveArrow = new GuiControl(interactiveRangeSelector, webDriver);

        String interactiveRange = "xpath" + "_TBD_" + "//inline-interactive[@embedid='" + animationEmbedID + "']//div[@class='range__optionBox']//div[@class='range__options']";
        GuiControl rangeOptElements = new GuiControl(interactiveRange, webDriver);

        actions.moveToElement(interactiveAnimationImage.getWebElement()).perform();

        if (interactiveArrow.isElementPresent()) {
            actions.moveToElement(interactiveArrow.getWebElement()).click().perform();
        }
        List<WebElement> rangeElements = rangeOptElements.getWebElements();
        logger.info("No of range options available are " + rangeElements.size());
        waitForSec(7);

        for (WebElement range : rangeElements) {
            try {
                actions.moveToElement(range).click().perform();
                waitForSec(10);

                Shutterbug.shootElementVerticallyCentered(webDriver, interactiveAnimationImage.getWebElement()).withName(i + "_rangeAnimation").save(filePathBase);
                System.out.println(i + " Range Animation is collected and saved into the base folder.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        return true;
    }

    // This methods does the actual verification of interactives animation by comparing base images with actual animation.
    public boolean verifyBiologyConceptInteractives(String animationEmbedID, String unit) {
        int i = 1;
        int correctComparison = 0;

        if (unit.equals("1.4")){
            placeHolder = biology1dot4;
        } else if (unit.equals("1.5")){
            placeHolder = biology1dot5;
        } else if (unit.equals("1.7.1")){
            placeHolder = biology1dot7part1;
        } else if (unit.equals("1.7.2")){
            placeHolder = biology1dot7part2;
        } else if (unit.equals("1.10")){
            placeHolder = biology1dot10;
        } else if (unit.equals("1.11")){
            placeHolder = biology1dot11;
        } else if (unit.equals("1.18")){
            placeHolder = biology1dot18;
        } else if (unit.equals("2.3")){
            placeHolder = biology2dot3;
        } else if (unit.equals("2.32")){
            placeHolder = biology2dot32;
        } else if (unit.equals("2.34")){
            placeHolder = biology2dot34;
        }

        createFolder(filePathAfterCmp);

        baseBiologyBookInteractives(animationEmbedID);
        logger.info("Took all the base interactives image and stored into the folder.");

        String interactiveAnimation = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[1]";
        GuiControl interactiveAnimationImage = new GuiControl(interactiveAnimation, webDriver);

        String interactiveRange = "xpath" + "_TBD_" + "//inline-interactive[@embedid='" + animationEmbedID + "']//div[@class='range__optionBox']//div[contains(normalize-space(@class),'range__label')]";
        GuiControl rangeOptElements = new GuiControl(interactiveRange, webDriver);

        List<WebElement> rangeElements = rangeOptElements.getWebElements();
        waitForSec(2);
        for (WebElement range : rangeElements) {
            try {
                if (range.getText().contains(placeHolder[i-1])){
                    logger.info("Place Holder of Range Option: " + i + " is " + range.getText() + " verified");
                } else {
                    logger.info("Place Holder for range option: " + i + " is incorrect/changed");
                    return false;
                }
                Actions actions = new Actions(webDriver);
                actions.moveToElement(range).click().perform();
                waitForSec(10);

                BufferedImage baseAnimation = ImageIO.read(new File(filePathBase + File.separator + +i + "_rangeAnimation.png"));
                logger.info("Read the base image from the base folder to compare with actual.");
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, interactiveAnimationImage.getWebElement()).
                        equalsWithDiff(baseAnimation, filePathAfterCmp + i + "_rangeAnimation", 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        logger.info("Total interactions verified correctly " + correctComparison);
        return true;
    }

    // This method takes the base images of interactives before compare with actual animation
    public boolean basePHActivityOnEnzymeTnteractives() {
        int i = 1;

        createFolder(filePathBase);

        actions.moveToElement(phActivityIAImage.getWebElement()).perform();

        actions.moveToElement(phActivityIAArrow.getWebElement()).click().perform();
        actions.moveToElement(dnaReplicaIAPlayBtn.getWebElement()).click().perform();
        logger.info("Clicked on the Play button of interactives.");
        List<WebElement> rangeElements = phActivityIARange.getWebElements();
        logger.info("No of range options available are " + rangeElements.size());
        waitForSec(5);
        for (WebElement range : rangeElements) {
            try {
                actions.moveToElement(range).click().perform();
                waitForSec(10);

                Shutterbug.shootElementVerticallyCentered(webDriver, phActivityIAImage.getWebElement()).withName(i + "_pHRangeAnimation").save(filePathBase);
                System.out.println(i + " pH Activity Range Animation is collected and saved into the base folder.");
            } catch (Exception e) {
                logger.info("There an error to perform the interaction with the Enzyme interactive.");
                e.printStackTrace();
            }
            i++;
        }
        return true;
    }

    // This methods does the actual verification of interactives animation by comparing base images with actual animation.
    public boolean verifyPHActivityOnEnzymeInteractives() {
        int i = 1;
        int correctComparison = 0;

        String[] biology1dot18part2 = {"4 - 6", "1 - 3", "> 6"};

        createFolder(filePathAfterCmp);

        basePHActivityOnEnzymeTnteractives();
        logger.info("Took all the base interactives image and stored into the folder.");

        List<WebElement> rangeElements = phActivityIARange.getWebElements();
        waitForSec(2);
        for (WebElement range : rangeElements) {
            try {
                if (range.getText().equals(biology1dot18part2[i-1])){
                    logger.info("Place Holder of Range Option: " + i + " is " + range.getText() + " verified");
                } else {
                    logger.info("Place Holder for range option: " + i + " is incorrect/changed");
                    return false;
                }
                Actions actions = new Actions(webDriver);
                actions.moveToElement(range).click().perform();
                waitForSec(10);

                BufferedImage baseAnimation = ImageIO.read(new File(filePathBase + File.separator + +i + "_pHRangeAnimation.png"));
                logger.info("Read the base image from the base folder to compare with actual.");
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, phActivityIAImage.getWebElement()).
                        equalsWithDiff(baseAnimation, filePathAfterCmp + i + "_pHRangeAnimation", 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }
            } catch (Exception e) {
                logger.info("There an error to perform the interaction with the Enzyme interactive.");
                e.printStackTrace();
            }
            i++;
        }
        logger.info("Total interactions verified correctly " + correctComparison);

        return true;
    }

    // This method takes the base images of interactives before compare with actual animation
    public boolean baseNitrogenBasesInteractives() {
        createFolder(filePathBase);

        actions.moveToElement(nitrogenBasesImg.getWebElement()).perform();
        Shutterbug.shootElementVerticallyCentered(webDriver, nitrogenBasesImg.getWebElement()).withName("beforeNitrogenSPHover").save(filePathBase);
        for (int i = 1; i <= 7; i++) {
            String spLocator = "xpath" + "_TBD_" + "//span[@data-mousein='hover_" + i + "' and @data-embed-id='IG_4_3_2_ChargaffRuleHighlight']";
            GuiControl spElem = new GuiControl(spLocator, webDriver);
            try {
                spElem.mouseHover();
                waitForSec(5);
                Shutterbug.shootElementVerticallyCentered(webDriver, nitrogenBasesImg.getWebElement()).withName(i + "_imgAfterNitrogenSPHover").save(filePathBase);
                System.out.println(i + " Nitrogen Base Image After Hover collected and saved into the base folder");

                nitrogenBasesImg.click();
                waitForSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    // This methods compare the actual animation image with the base images.
    public boolean verifyNitrogenBaseInteractives() {
        int correctComparison = 0;
        createFolder(filePathAfterCmp);
        baseNitrogenBasesInteractives();
        try {
            BufferedImage nitrogenBaseImage = ImageIO.read(new File(filePathBase + File.separator + "beforeNitrogenSPHover.png"));

            if (Shutterbug.shootElementVerticallyCentered(webDriver, nitrogenBasesImg.getWebElement()).
                    equalsWithDiff(nitrogenBaseImage, filePathAfterCmp + "beforeNitrogenSPHover", 0.1)) {
                logger.info("Base Nitrogen Image verified successfully");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 7; i++) {
            String spLocator = "xpath" + "_TBD_" + "//span[@data-mousein='hover_" + i + "' and @data-embed-id='IG_4_3_2_ChargaffRuleHighlight']";
            GuiControl spElem = new GuiControl(spLocator, webDriver);
            try {
                spElem.mouseHover();
                waitForSec(5);
                BufferedImage nitrogenBaseAfter = ImageIO.read(new File(filePathBase + File.separator + i + "_imgAfterNitrogenSPHover.png"));
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, nitrogenBasesImg.getWebElement()).
                        equalsWithDiff(nitrogenBaseAfter, filePathAfterCmp + i + "_imgAfterNitrogenSPHover", 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }
                nitrogenBasesImg.click();
                waitForSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("Total interactives verified correctly " + correctComparison);
        return true;
    }

    // This method takes the base images of interactives before compare with actual animation
    public boolean baseDoubleHelixInteractives() {
        createFolder(filePathBase);

        actions.moveToElement(doubleHelixBaseImg.getWebElement()).perform();
        Shutterbug.shootElementVerticallyCentered(webDriver, doubleHelixBaseImg.getWebElement()).withName("beforeDoubleHelixSPHover").save(filePathBase);
        for (int i = 1; i <= 5; i++) {
            String spLocator = "xpath" + "_TBD_" + "//span[@data-mousein='hover_" + i + "' and @data-embed-id='IG_4_3_3_DnaSmartHighlight']";
            GuiControl spElem = new GuiControl(spLocator, webDriver);
            try {
                spElem.mouseHover();
                for (int j = 1; j <= 2; j++) {
                    waitForSec(2);
                    Shutterbug.shootElementVerticallyCentered(webDriver, doubleHelixBaseImg.getWebElement()).withName(i + "." + j + "_imgAfterDoubleHelixSPHover").save(filePathBase);
                    System.out.println(i + "." + j + " Double Helix Image After Hover collected");
                }
                doubleHelixBaseImg.click();
                waitForSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    // This methods compare the actual animation image with the base images.
    public boolean verifyDoubleHelixInteractives() {
        int correctComparison = 0;
        createFolder(filePathAfterCmp);
        baseDoubleHelixInteractives();
        try {
            BufferedImage doubleHelixBase = ImageIO.read(new File(filePathBase + File.separator + "beforeDoubleHelixSPHover.png"));
            if (Shutterbug.shootElementVerticallyCentered(webDriver, doubleHelixBaseImg.getWebElement()).
                    equalsWithDiff(doubleHelixBase, filePathAfterCmp + "beforeDoubleHelixSPHover", 0.1)) {
                logger.info("Base Double Helix verified");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 5; i++) {
            String spLocator = "xpath" + "_TBD_" + "//span[@data-mousein='hover_" + i + "' and @data-embed-id='IG_4_3_3_DnaSmartHighlight']";
            GuiControl spElem = new GuiControl(spLocator, webDriver);
            try {
                spElem.mouseHover();
                for (int j = 1; j <= 2; j++) {
                    waitForSec(2);
                    BufferedImage nitrogenBaseAfter = ImageIO.read(new File(filePathBase + File.separator + i + "." + j + "_imgAfterDoubleHelixSPHover.png"));
                    boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, nitrogenBasesImg.getWebElement()).
                            equalsWithDiff(nitrogenBaseAfter, filePathAfterCmp + i + "." + j + "_imgAfterDoubleHelixSPHover", 0.1);
                    if (comparison) {
                        correctComparison++;
                        logger.info("The Base image and Actual animation is correct.");
                    }
                }
                nitrogenBasesImg.click();
                waitForSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("Total interactives verified correctly " + correctComparison);
        return true;
    }

    // This method takes the base images of interactives before compare with actual animation
    public boolean baseDNAReplicaInteractive() {
        createFolder(filePathBase);

        dnaReplicaBaseImg.scrollIntoView();
        Shutterbug.shootElementVerticallyCentered(webDriver, dnaReplicaBaseImg.getWebElement()).withName("beforeDNAReplicaPlayButton").save(filePathBase);

        actions.moveToElement(dnaReplicaIAArrow.getWebElement()).click().perform();
        for (int i = 1; i <= 2; i++) {
            try {
                actions.moveToElement(dnaReplicaIAPlayBtn.getWebElement()).click().perform();
                waitForSec(15);
                Shutterbug.shootElementVerticallyCentered(webDriver, dnaReplicaBaseImg.getWebElement()).withName(i + "_afterDNAReplicaPlayButton").save(filePathBase);
                System.out.println(i + " DNA Replication after play button collected");

                dnaReplicaBaseImg.click();
                waitForSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    // This methods compare the actual animation image with the base images.
    public boolean verifyDNAReplicaInteractive() {
        int correctComparison = 0;
        createFolder(filePathAfterCmp);

        baseDNAReplicaInteractive();
        try {
            BufferedImage doubleHelixBase = ImageIO.read(new File(filePathBase + File.separator + "beforeDNAReplicaPlayButton.png"));
            if (Shutterbug.shootElementVerticallyCentered(webDriver, dnaReplicaBaseImg.getWebElement()).
                    equalsWithDiff(doubleHelixBase, filePathAfterCmp + "beforeDNAReplicaPlayButton", 0.1)) {
                logger.info("Base DNA Replication Image verified");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= 2; i++) {
            try {
                actions.moveToElement(dnaReplicaIAPlayBtn.getWebElement()).click().perform();
                waitForSec(15);
                BufferedImage dnaReplicaBaseAfter = ImageIO.read(new File(filePathBase + File.separator + i + "_afterDNAReplicaPlayButton.png"));
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, dnaReplicaBaseImg.getWebElement()).
                        equalsWithDiff(dnaReplicaBaseAfter, filePathAfterCmp + i + "_afterDNAReplicaPlayButton", 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }
                dnaReplicaBaseImg.click();
                waitForSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    // This method takes the base images of interactives before compare with actual animation
    public boolean baseEnzymesInteractive() {
        createFolder(filePathBase);

        enzymesBaseImage.scrollIntoView();
        logger.info("Scrolled to the Enzymes base image.");

        Shutterbug.shootElementVerticallyCentered(webDriver, enzymesBaseImage.getWebElement()).withName("beforeEnzymesInteractivePlayButton").save(filePathBase);
        logger.info("Took base screenshot of Enzymes interactive and stored it into base folder.");

        try {
            actions.moveToElement(dnaReplicaIAPlayBtn.getWebElement()).click().perform();
            logger.info("Clicked on the play button of the interactive.");
            waitForSec(15);
            Shutterbug.shootElementVerticallyCentered(webDriver, enzymesBaseImage.getWebElement()).withName("afterEnzymesInteractivePlayButton").save(filePathBase);
            System.out.println("Enzymes interactive after play button collected");
        } catch (Exception e) {
            logger.info("There an error to perform the interaction with the Enzymes interactive.");
            e.printStackTrace();
        }
        return true;
    }

    // This methods compare the actual animation image with the base images.
    public boolean verifyEnzymesInteractive() {
        int i = 1;
        int correctComparison = 0;
        createFolder(filePathAfterCmp);

        baseEnzymesInteractive();
        logger.info("Took the base images fo the Enzymes interactive.");
        try {
            BufferedImage enzymesInteractiveBaseImage = ImageIO.read(new File(filePathBase + File.separator + "beforeEnzymesInteractivePlayButton.png"));
            logger.info("Read the base interactive image of Enzymes.");
            if (Shutterbug.shootElementVerticallyCentered(webDriver, enzymesBaseImage.getWebElement()).
                    equalsWithDiff(enzymesInteractiveBaseImage, filePathAfterCmp + "beforeEnzymesInteractivePlayButton", 0.1)) {
                logger.info("Base Enzymes Image verified");
            }
        } catch (IOException e) {
            logger.info("There is an error in verifying the base image of Enzymes.");
            e.printStackTrace();
        }
        try {
            actions.moveToElement(dnaReplicaIAPlayBtn.getWebElement()).click().perform();
            logger.info("Clicked on the play button of the interactive.");
            waitForSec(15);
            BufferedImage enzymesBaseAfterAnimation = ImageIO.read(new File(filePathBase + File.separator + "afterEnzymesInteractivePlayButton.png"));
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, enzymesBaseImage.getWebElement()).
                    equalsWithDiff(enzymesBaseAfterAnimation, filePathAfterCmp + "afterEnzymesInteractivePlayButton", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }
        } catch (Exception e) {
            logger.info("There an error to compare the base image and actual image.");
            e.printStackTrace();
        }
        logger.info("Total interactive are verified correctly: " + correctComparison);
        return true;
    }

    // This method takes the base images of interactives before compare with actual animation
    public boolean baseNucleicAcidInteractive() {
        createFolder(filePathBase);

        nucleicAcidBaseImg.scrollIntoView();
        logger.info("Scrolled to the Nucleic Acids base image.");

        Shutterbug.shootElementVerticallyCentered(webDriver, nucleicAcidBaseImg.getWebElement()).withName("beforeNucleicAcidsPlayButton").save(filePathBase);
        logger.info("Took base screenshot of Nucleic Acids interactive and stored it into base folder.");

        actions.moveToElement(nucleicAcidIAArrow.getWebElement()).click().perform();
        for (int i = 1; i <= 2; i++) {
            try {
                actions.moveToElement(dnaReplicaIAPlayBtn.getWebElement()).click().perform();
                logger.info("Clicked on the play button of the interactive.");
                waitForSec(15);
                Shutterbug.shootElementVerticallyCentered(webDriver, nucleicAcidBaseImg.getWebElement()).withName(i + "_afterNucleicAcidsPlayButton").save(filePathBase);
                System.out.println(i + " Nucleic Acids after play button collected");
            } catch (Exception e) {
                logger.info("There an error to perform the interaction with the Nucleic Acids interactive.");
                e.printStackTrace();
            }
        }
        return true;
    }

    // This methods compare the actual animation image with the base images.
    public boolean verifyNucleicAcidInteractive() {
        int correctComparison = 0;
        createFolder(filePathAfterCmp);

        baseNucleicAcidInteractive();
        logger.info("Took the base images fo the Nucleic Acid interactive.");

        try {
            BufferedImage nucleicAcidBaseImage = ImageIO.read(new File(filePathBase + File.separator + "beforeNucleicAcidsPlayButton.png"));
            if (Shutterbug.shootElementVerticallyCentered(webDriver, nucleicAcidBaseImg.getWebElement()).
                    equalsWithDiff(nucleicAcidBaseImage, filePathAfterCmp + "beforeNucleicAcidsPlayButton", 0.1)) {
                logger.info("Base Nucleic Acids Image verified");
            }
        } catch (IOException e) {
            logger.info("There is an error in verifying the base image of Nucleic Acids.");
            e.printStackTrace();
        }
        for (int i = 1; i <= 2; i++) {
            try {
                actions.moveToElement(dnaReplicaIAPlayBtn.getWebElement()).click().perform();
                waitForSec(15);
                BufferedImage nucleicAcidsBaseImageAfter = ImageIO.read(new File(filePathBase + File.separator + i + "_afterNucleicAcidsPlayButton.png"));
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, nucleicAcidBaseImg.getWebElement()).
                        equalsWithDiff(nucleicAcidsBaseImageAfter, filePathAfterCmp + i + "_afterNucleicAcidsPlayButton", 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }
                nucleicAcidBaseImg.click();
                waitForSec(2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("Total interactions are verified correctly: " + correctComparison);
        return true;
    }

    public boolean verifyMatchTheFunctionsInteractive(String test, String endResult) {
        String incorrectMsg = null;
        String msg1 = "Oops! Some of the ";
        String msg2 = " did not ";
        String msg3 = ". Can you give this another try?";
        String[] elementArray = null;
        String toMatch = null;
        String toBeMatchedWith = null;
        if (test.equals("Significance of Carbon")) {
            elementArray = significanceOfCarbon;
            logger.info("Base Array for test is selected for Significance of Carbon");

            toMatch = "//div[contains(text(),'Organic Compounds')]";
            toBeMatchedWith = "//div[contains(text(),'Major Functions')]";

            significanceOfCarbonMatchTest.scrollIntoView();
            logger.info("Scrolled to Significance of Carbon Match Test");

            waitForSec(2);
            incorrectMsg = msg1 + "organic compounds" + msg2 + "match correctly to their functions" + msg3;
        } else if (test.equals("Proteins")) {
            elementArray = proteins;
            logger.info("Base Array for test is selected for Protein Structure");

            toMatch = "//div[contains(text(),'Level of protein structure')]";
            toBeMatchedWith = "//div[contains(text(),'Description')]";

            proteinStructureMatchTest.scrollIntoView();
            logger.info("Scrolled to Protein Structure Match Test interactive.");

            waitForSec(2);
            incorrectMsg = msg1 + "levels of protein structure" + msg2 + "match correctly to their descriptions" + msg3;
        } else if (test.equals("Cell Structure")) {
            elementArray = cellStructure;
            logger.info("Base Array for test is selected for Protein Structure");

            toMatch = "//div[contains(text(),'Organelles')]";
            toBeMatchedWith = "//div[contains(text(),'Major Functions')]";

            cellStructureMatchTest.scrollIntoView();
            logger.info("Scrolled to Protein Structure Match Test interactive.");

            waitForSec(2);
            incorrectMsg = msg1 + "cell organelles" + msg2 + "match correctly to their functions" + msg3;
        } else if (test.equals("Active Transport")) {
            elementArray = activeTransport;
            logger.info("Base Array for test is selected for Active Transport");

            toMatch = "//div[contains(text(),'Types of Active Transport')]";
            toBeMatchedWith = "//div[contains(text(),'Description')]";

            activeTransportMatchTest.scrollIntoView();
            logger.info("Scrolled to Active Transport Match Test interactive.");

            waitForSec(2);
            incorrectMsg = msg1 + "description" + msg2 + "correctly match to the type of active transport" + msg3;
        } else if (test.equals("Natural Selection")) {
            elementArray = naturalConcept;
            logger.info("Base Array for test is selected for Natural Selection");

            toMatch = "//div[contains(text(),'Type of natural selection')]";
            toBeMatchedWith = "//div[contains(text(),'Description')]";

            naturalSelectionMatchTest.scrollIntoView();
            logger.info("Scrolled to Natural Selection Match Test interactive.");

            waitForSec(2);
            incorrectMsg = "Keep trying! Natural selection for a polygenic trait changes the distribution of phenotypes. If a phenotype is selected against, then the phenotype over time will decrease in that population.";
        }

        if (endResult.equals("Correct")) {
            for (int i = 0; i <= elementArray.length - 1; i++) {
                String matchElement = "xpath" + "_TBD_" + toMatch + "//parent::div//div[@type='" + elementArray[i] + "']";
                GuiControl leftElement = new GuiControl(matchElement, webDriver);

                String toMatchElement = "xpath" + "_TBD_" + toBeMatchedWith + "//parent::div//div[@type='" + elementArray[i] + "']";
                GuiControl rightElement = new GuiControl(toMatchElement, webDriver);

                actions.clickAndHold(leftElement.getWebElement()).moveToElement(rightElement.getWebElement()).release(rightElement.getWebElement()).build().perform();
                logger.info("Left item is clicked and hold");

                waitForSec(2);
            }
        } else if (endResult.equals("Incorrect")){
            String matchElement = "xpath" + "_TBD_" + toMatch + "//parent::div//div[normalize-space(@class)='connecting-dot']";
            GuiControl leftElement = new GuiControl(matchElement, webDriver);

            String toMatchElement = "xpath" + "_TBD_" + toBeMatchedWith + "//parent::div//div[normalize-space(@class)='connecting-dot']";
            GuiControl rightElement = new GuiControl(toMatchElement, webDriver);

            List<WebElement> matchDots = leftElement.getWebElements();
            List<WebElement> toMatchDots = rightElement.getWebElements();

            for (int i = 0; i < matchDots.size(); i++){
                actions.clickAndHold(matchDots.get(i)).moveToElement(toMatchDots.get(i)).release(toMatchDots.get(i)).build().perform();
                logger.info("Left item is clicked and hold");

                waitForSec(2);
            }

        }
        waitForSec(5);
        if (matchTestCheckButton.isEnable()) {
            logger.info("Verified that the check it button is enabled.");
            matchTestCheckButton.clickJScript();
            logger.info("Clicked on the Check it button.");
            waitForSec(2);
            if (endResult.equals("Correct") && correctMatch.getText().contains("That’s correct!")) {
                logger.info("Correctly matched all the element");
                return true;
            } else if (endResult.equals("Incorrect") && correctMatch.getText().contains("Incorrect") && correctMatchMsg.getText().contains(incorrectMsg)){
                logger.info("Incorrect matched working");
                return true;
            } else if (endResult.equals("Incorrect") && correctMatch.getText().contains("Keep Trying!") ){
                logger.info("Incorrect matched working with one or two correct answers");
                return true;
            }
        }
        return false;
    }

    public boolean verifyCellMembraneStructureInteractive(String endResult){
        String[] elementArray = {"hydrophobic", "tails", "phospholipid", "bilayer", "peripheral", "proteins", "integral", "proteins", "hydrophilic", "head", "channel", "protein", "cholesterol"};
        logger.info("Base Array for test is selected for Cell Membrane  Structure");

        cellMembraneStructureMatchTest.scrollIntoView();
        logger.info("Scrolled to Cell Membrane Structure Match Test interactive.");

        waitForSec(2);

        String matchElement = null;
        String toMatchElement = null;

        if (endResult.equals("Correct")) {
            for (int i = 0; i <= elementArray.length / 2; i++) {
                if (i == elementArray.length / 2) {
                    matchElement = "id" + "_TBD_" + "label_box__slot" + "-" + elementArray[i + i];

                    toMatchElement = "id" + "_TBD_" + "prefix__slot" + "-" + elementArray[i + i];
                } else {
                    matchElement = "id" + "_TBD_" + "label_box__slot" + "-" + elementArray[i + i] + "-" + elementArray[i + i + 1];

                    toMatchElement = "id" + "_TBD_" + "prefix__slot" + "-" + elementArray[i + i] + "-" + elementArray[i + i + 1];
                }
                GuiControl dragElement = new GuiControl(matchElement, webDriver);
                System.out.println("*************** draglocator is; " + matchElement);

                GuiControl dropElement = new GuiControl(toMatchElement, webDriver);
                System.out.println("*************** droplocator is; " + toMatchElement);

                actions.clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                logger.info("Drag item is clicked and hold");

                waitForSec(2);
            }
        } else if (endResult.equals("Incorrect")){
            matchElement = "cssselector" + "_TBD_" + "div[id*='label_box__slot']";

            toMatchElement = "cssselector" + "_TBD_" + "g[id*='prefix__slot-']";

            GuiControl dragElement = new GuiControl(matchElement, webDriver);
            GuiControl dropElement = new GuiControl(toMatchElement, webDriver);

            List<WebElement> dragBlocks = dragElement.getWebElements();
            List<WebElement> dropBlocks = dropElement.getWebElements();

            for (int i = 0; i < dragBlocks.size(); i++) {
                actions.clickAndHold(dragBlocks.get(i)).moveToElement(dropBlocks.get(i)).release(dropBlocks.get(i)).build().perform();
                logger.info("Drag item is clicked and hold");

                waitForSec(2);
            }
        }
        waitForSec(5);
        String incorrectMsg = "This is incorrect! Please retry organizing the labels for right placement.";
        if (cellMembraneStructureCheckButton.isEnable()) {
            logger.info("Verified that the check it button is enabled.");
            cellMembraneStructureCheckButton.clickJScript();
            logger.info("Clicked on the Check it button.");
            waitForSec(2);
            if (endResult.equals("Correct") && cellMembraneStructureCorrectMatch.getText().contains("Correct!")) {
                logger.info("Correctly matched all the element");
                return true;
            } else if (endResult.equals("Incorrect") && cellMembraneStructureCorrectMatch.getText().contains("Incorrect!") && cellMembraneStructureIncorrectMatchMsg.getText().equals(incorrectMsg)) {
                logger.info("Incorrectly matched all the element and Incorrect Match Message Verified");
                return true;
            }
        }
        return false;
    }

    // This method takes the base images of interactives before compare with actual animation
    public boolean baseHydrogenBondInteractive() {
        createFolder(filePathBase);

        hydrogenBondBaseImg.scrollIntoView();
        logger.info("Scrolled to the Hydrogen Bond base image.");

        if (hydrogenBondIAArrow.isElementPresent()) {
            actions.moveToElement(hydrogenBondIAArrow.getWebElement()).click().perform();
            logger.info("verified the Hydrogen bond AI arrow.");

            for (int i = 2; i >= 1; i--) {
                String optionsSelector = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='BIO_HS_1_19_3_HydrogenBondingDissolving']//*[local-name()='svg'])" + "[" + i + "]";
                GuiControl options = new GuiControl(optionsSelector, webDriver);

                actions.moveToElement(options.getWebElement()).click().perform();
                logger.info("Clicked on the" + i + "options.");

                waitForSec(5);

                Shutterbug.shootElementVerticallyCentered(webDriver, hydrogenBondBaseImg.getWebElement()).withName("InteractiveOption_" + i).save(filePathBase);
                logger.info("Took screenshot of" + i + "Interactive option and stored it into base folder.");
            }
        }
        return true;
    }

    // This methods compare the actual animation image with the base images.
    public boolean verifyHydrogenBondInteractive() {
        int correctComparison = 0;
        createFolder(filePathAfterCmp);

        baseHydrogenBondInteractive();
        logger.info("Took the base images fo the Hydrogen Bond interactive.");

        try {
            for (int i = 2; i >= 1; i--) {
                String optionsSelector = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='BIO_HS_1_19_3_HydrogenBondingDissolving']//*[local-name()='svg'])" + "[" + i + "]";
                GuiControl options = new GuiControl(optionsSelector, webDriver);

                actions.moveToElement(options.getWebElement()).click().perform();
                logger.info("Clicked on the" + i + "options.");

                waitForSec(5);

                BufferedImage option = ImageIO.read(new File(filePathBase + File.separator + "InteractiveOption_" + i + ".png"));
                boolean optionCompare = Shutterbug.shootElementVerticallyCentered(webDriver, hydrogenBondBaseImg.getWebElement()).
                        equalsWithDiff(option, filePathAfterCmp + "option_" + i, 0.1);

                if (optionCompare) {
                    correctComparison++;
                    logger.info("The Hydrogen Bond image and Actual animation is correct.");
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Total interactives are verified correctly: " + correctComparison);
        return true;
    }

    // This method takes the base images of the animation before to compare with actual image.
    public boolean baseBiologyBookCellsInteractives(String animationEmbedID) {
        int i = 1;
        GuiControl interactiveAnimationImage = null;

        createFolder(filePathBase);

        String interactiveRangeSelector = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[4]";
        GuiControl interactiveArrow = new GuiControl(interactiveRangeSelector, webDriver);

        String cellValues = "xpath" + "_TBD_" + "//inline-interactive[@embedid='" + animationEmbedID + "']//label[normalize-space(@class)='btn-item']";
        GuiControl cellTypes = new GuiControl(cellValues, webDriver);

        String interactiveAnimation1 = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[2]";
        GuiControl IA1 = new GuiControl(interactiveAnimation1, webDriver);
        String interactiveAnimation2 = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[1]";
        GuiControl IA2 = new GuiControl(interactiveAnimation2, webDriver);

        if (IA1.isElementPresent()){
            interactiveAnimationImage = IA1;
        } else {
            interactiveAnimationImage = IA2;
        }

        actions.moveToElement(interactiveAnimationImage.getWebElement()).perform();

        if (interactiveArrow.isElementPresent()) {
            actions.moveToElement(interactiveArrow.getWebElement()).click().perform();
        }
        List<WebElement> cellElements = cellTypes.getWebElements();
        logger.info("No of range options available are " + cellElements.size());
        waitForSec(2);

        for (WebElement cellType : cellElements) {
            try {
                actions.moveToElement(cellType).perform();
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", cellType);
                waitForSec(3);

                Shutterbug.shootElementVerticallyCentered(webDriver, interactiveAnimationImage.getWebElement()).withName(i + "_cellAnimation").save(filePathBase);
                System.out.println(i + " Cell Animation is collected and saved into the base folder.");
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        return true;
    }

    // This methods does the actual verification of interactives animation by comparing base images with actual animation.
    public boolean verifyBiologyBookCellInteractives(String animationEmbedID, String unit) {
        int i = 1;
        int correctComparison = 0;
        GuiControl interactiveAnimationImage = null;

        if (unit.equals("2.34")){
            placeHolder = biology2dot34part1;
        } else if (unit.equals("2.3")){
            placeHolder = biology2dot3part1;
        } else if (unit.equals("2.2")){
            placeHolder = biology2dot2;
        } else if (unit.equals("2.1")){
            placeHolder = biology2dot1;
        } else if (unit.equals("2.2part2")){
            placeHolder = null;
        } else if (unit.equals("4.8")){
            placeHolder = null;
        } else if (unit.equals("5.18")){
            placeHolder = null;
        }

        createFolder(filePathAfterCmp);

        baseBiologyBookCellsInteractives(animationEmbedID);
        logger.info("Took all the base interactives image and stored into the folder.");

        String interactiveAnimation1 = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[2]";
        GuiControl IA1 = new GuiControl(interactiveAnimation1, webDriver);
        String interactiveAnimation2 = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='" + animationEmbedID + "']//*[local-name()='svg'])[1]";
        GuiControl IA2 = new GuiControl(interactiveAnimation2, webDriver);

        if (IA1.isElementPresent()){
            interactiveAnimationImage = IA1;
        } else {
            interactiveAnimationImage = IA2;
        }

        String cellValues = "xpath" + "_TBD_" + "//inline-interactive[@embedid='" + animationEmbedID + "']//label[normalize-space(@class)='btn-item']";
        GuiControl cellTypes = new GuiControl(cellValues, webDriver);

        List<WebElement> cellElements = cellTypes.getWebElements();
        waitForSec(2);
        for (WebElement cellType : cellElements) {
            try {
                if (placeHolder != null) {
                    if (cellType.getText().contains(placeHolder[i - 1].split("--")[0])) {
                        logger.info("Cell Type of Range Option: " + i + " is " + cellType.getText() + " verified");
                    } else {
                        logger.info("Cell Type for range option: " + i + " is incorrect/changed");
                        return false;
                    }
                }

                Actions actions = new Actions(webDriver);
                actions.moveToElement(cellType).perform();
                JavascriptExecutor executor = (JavascriptExecutor) webDriver;
                executor.executeScript("arguments[0].click();", cellType);
                waitForSec(3);

                if (placeHolder != null) {
                    if (placeHolder[i - 1].split("--")[1] != null) {
                        if (toolTipHeader.isDisplayed() && toolTipBody.isDisplayed()) {
                            logger.info("Tool Tip is present and visible");
                            if (toolTipHeader.getText().contains(placeHolder[i - 1].split("--")[0]) && toolTipBody.getText().contains(placeHolder[i - 1].split("--")[1])) {
                                logger.info("Tool tip Header: " + toolTipHeader.getText() + " and Tool tip Body is correct and verified");
                            } else {
                                logger.info("Tool tip Header or Body is incorrect/changed");
                                return false;
                            }
                        } else {
                            logger.info("Tool tip not present.visible");
                            return false;
                        }
                    }
                }

                BufferedImage baseAnimation = ImageIO.read(new File(filePathBase + File.separator + +i + "_cellAnimation.png"));
                logger.info("Read the base image from the base folder to compare with actual.");
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, interactiveAnimationImage.getWebElement()).
                        equalsWithDiff(baseAnimation, filePathAfterCmp + i + "_cellAnimation", 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        logger.info("Total interactions verified correctly " + correctComparison);
        return true;
    }

    public boolean baseCellDiffusionInteractive(){
        int i = 1;
        createFolder(filePathBase);

        cellDiffusionIA.scrollIntoView();
        logger.info("Scrolled to the Cell Diffusion Interactive");

        actions.moveToElement(cellDiffusionIAArrow.getWebElement()).click().perform();

        actions.moveToElement(cellDiffusionIAKnob.getWebElement()).click().perform();
        logger.info("Clicked on Cell Diffusion knob to move top");

        Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).withName("_cellDiffusionKnobTop").save(filePathBase);
        System.out.println("Cell Diffusion Top is collected and saved into the base folder.");

        cellDiffusionIADiffuseButton.isEnable();
        logger.info("Diffuse Button is active");
        actions.moveToElement(cellDiffusionIADiffuseButton.getWebElement()).click().perform();
        logger.info("Clicked on Cell Diffuse Button to equilibrium");
        waitForSec(8);

        Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).withName(i + "_cellDiffusionEquilibrium").save(filePathBase);
        System.out.println(i + " Cell Diffusion Equilibrium State is collected and saved into the base folder.");

        i++;

        actions.clickAndHold(cellDiffusionIAKnob.getWebElement()).moveToElement(cellDiffusionIAKnobBottom.getWebElement()).release(cellDiffusionIAKnobBottom.getWebElement()).build().perform();

        Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).withName("_cellDiffusionKnobBottom").save(filePathBase);
        System.out.println("Cell Diffusion Bottom is collected and saved into the base folder.");

        cellDiffusionIADiffuseButton.isEnable();
        logger.info("Diffuse Button is active");
        actions.moveToElement(cellDiffusionIADiffuseButton.getWebElement()).click().perform();
        logger.info("Clicked on Cell Diffuse Button to equilibrium");
        waitForSec(8);

        Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).withName(i + "_cellDiffusionEquilibrium").save(filePathBase);
        System.out.println(i + " Cell Diffusion Equilibrium State is collected and saved into the base folder.");

        return true;
    }

    public boolean baseTranslationMolecularRNAInteractive(){
        createFolder(filePathBase);

        translationMolecularRNAIA.scrollIntoView();
        logger.info("Scrolled to the Cell Diffusion Interactive");

        actions.moveToElement(translationMolecularRNAIAArrow.getWebElement()).click().perform();

        Shutterbug.shootElementVerticallyCentered(webDriver, translationMolecularRNAIA.getWebElement()).withName("_baseTranslationIA").save(filePathBase);
        System.out.println("Base Translation Molecular RNA is collected and saved into the base folder.");

        for (int j = 1; j <= 3; j++) {
            String play = "id" + "_TBD_" + "play-button-sequence-" + j;
            GuiControl playButton = new GuiControl(play, webDriver);

            actions.moveToElement(playButton.getWebElement()).click().perform();
            waitForSec(10);

            Shutterbug.shootElementVerticallyCentered(webDriver, translationMolecularRNAIA.getWebElement()).withName(j + "_translationMolecularIA").save(filePathBase);
            System.out.println("Translation Molecular RNA after selecting " + j + " play button is collected and saved into the base folder.");
        }
        waitForSec(20);

        return true;
    }

    public boolean verifyTranslationMolecularRNAInteractive(){
        int correctComparison = 0;

        createFolder(filePathAfterCmp);

        baseTranslationMolecularRNAInteractive();

        try {

            BufferedImage cellDiffusionTop = ImageIO.read(new File(filePathBase + File.separator + "_baseTranslationIA.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, translationMolecularRNAIA.getWebElement()).
                    equalsWithDiff(cellDiffusionTop, filePathAfterCmp + "_baseTranslationIA", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int j = 1; j <= 3; j++) {
            String play = "id" + "_TBD_" + "play-button-sequence-" + j;
            GuiControl playButton = new GuiControl(play, webDriver);

            actions.moveToElement(playButton.getWebElement()).click().perform();
            waitForSec(10);

            try {
                BufferedImage cellDiffusionTop = ImageIO.read(new File(filePathBase + File.separator + j + "_translationMolecularIA.png"));
                logger.info("Read the base image from the base folder to compare with actual.");
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, translationMolecularRNAIA.getWebElement()).
                        equalsWithDiff(cellDiffusionTop, filePathAfterCmp + j + "_translationMolecularIA", 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        logger.info("Total interactions verified correctly " + correctComparison);
        return true;
    }

    public boolean verifyCellDiffusionInteractive(){
        int i = 1;
        int correctComparison = 0;

        createFolder(filePathAfterCmp);

        baseCellDiffusionInteractive();

        actions.moveToElement(cellDiffusionIAKnob.getWebElement()).click().perform();
        logger.info("Clicked on Cell Diffusion knob to move top");

        try {

            BufferedImage cellDiffusionTop = ImageIO.read(new File(filePathBase + File.separator + "_cellDiffusionKnobTop.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).
                    equalsWithDiff(cellDiffusionTop, filePathAfterCmp + "_cellDiffusionKnobTop", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cellDiffusionIADiffuseButton.isEnable();
        logger.info("Diffuse Button is active");
        actions.moveToElement(cellDiffusionIADiffuseButton.getWebElement()).click().perform();
        logger.info("Clicked on Cell Diffuse Button to equilibrium");
        waitForSec(8);

        try {

            BufferedImage firstCellDiffusionEquilibrium = ImageIO.read(new File(filePathBase + File.separator + i + "_cellDiffusionEquilibrium.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).
                    equalsWithDiff(firstCellDiffusionEquilibrium, filePathAfterCmp + i + "_cellDiffusionEquilibrium", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

            i++;

            actions.clickAndHold(cellDiffusionIAKnob.getWebElement()).moveToElement(cellDiffusionIAKnobBottom.getWebElement()).release(cellDiffusionIAKnobBottom.getWebElement()).build().perform();

        try {

            BufferedImage cellDiffusionBottom = ImageIO.read(new File(filePathBase + File.separator + "_cellDiffusionKnobBottom.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).
                    equalsWithDiff(cellDiffusionBottom, filePathAfterCmp + "_cellDiffusionKnobBottom", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cellDiffusionIADiffuseButton.isEnable();
        logger.info("Diffuse Button is active");
        actions.moveToElement(cellDiffusionIADiffuseButton.getWebElement()).click().perform();
        logger.info("Clicked on Cell Diffuse Button to equilibrium");
        waitForSec(8);

        try {
            BufferedImage secondCellDiffusionEquilibrium = ImageIO.read(new File(filePathBase + File.separator + i + "_cellDiffusionEquilibrium.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, cellDiffusionIA.getWebElement()).
                    equalsWithDiff(secondCellDiffusionEquilibrium, filePathAfterCmp + i + "_cellDiffusionEquilibrium", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("Total interactions verified correctly " + correctComparison);
        return true;
    }

    public boolean verifyBiologyVideoInteractive(String animationEmbedID){
        String videoInteractive = "xpath" + "_TBD_" + "//inline-interactive[@embedid='BIO_HS_" + animationEmbedID + "']";
        GuiControl videoIA = new GuiControl(videoInteractive, webDriver);

        videoIA.scrollIntoView();
        videoIA.isDisplayed();
        logger.info("Video Interactive is displayed");

        String progress = "xpath" + "_TBD_" + "(//inline-interactive[@embedid='BIO_HS_" + animationEmbedID + "']//div)[4]";
        GuiControl progressBar = new GuiControl(progress, webDriver);

        progressBar.isDisplayed();
        logger.info("Video Interactive progress bar is displayed");

        double progressPercentage = Double.parseDouble(progressBar.getAttribute("style").split(";")[1].split(":")[1].split("%")[0]);
        if (progressPercentage>=1){
            logger.info("Video Interactive is working");
        }
        return true;
    }

    public boolean verifyMatchTheChemicalEquation(){
        String[] eleAttributeArr = {"r_1", "r_2", "r_3", "r_4", "r_5"};
        String dropEle = "cssselector" + "_TBD_" + "div.eq-drop-holder div.";
        String dragEle = "cssselector" + "_TBD_" + "div.eq-drop-holder div#";

        cellularRespirationIA.scrollIntoView();
        reportLog("Scrolled to Cellular Respiration Interactive");

        waitForSec(2);
        for (String abt : eleAttributeArr){
            String dropable = dropEle + abt;
            GuiControl dropElement = new GuiControl(dropable, webDriver);

            String dragable = dragEle + abt;
            GuiControl dragElement = new GuiControl(dragable, webDriver);

            actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
            reportLog("Drag item is clicked and hold and Dropped");
        }
        waitForSec(5);
        if (cellularRespirationMatchSuccess.isDisplayed()){
            if (cellularRespirationMatchSuccess.getText().contains("Good Job!")){
                reportLog("Success Message verified and Match Interactive verified");
                return true;
            }
        }
        return false;
    }

    public boolean verifyMatchTheAerobicRespiration(String endResult){
        String[] eleAttributeArr = {"slot-glucose", "slot-CO2", "slot-H2O", "slot-Pyruvate", "slot-32ATP", "slot-2ATP-2", "slot-2ATP-1", "slot-O2"};
        String dropEle = "id" + "_TBD_" + "prefix__";
        String dragEle = "id" + "_TBD_" + "label__";

        aerobicRespirationIA.scrollIntoView();
        reportLog("Scrolled to Cellular Respiration Interactive");

        if (endResult.equals("Correct")) {
            waitForSec(2);
            for (String abt : eleAttributeArr) {
                String dropable = dropEle + abt;
                GuiControl dropElement = new GuiControl(dropable, webDriver);

                String dragable = dragEle + abt;
                GuiControl dragElement = new GuiControl(dragable, webDriver);

                if (abt.equals("slot-H2O")) {
                    dropElement.scrollIntoView();

                    actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                    reportLog("Drag item is clicked and hold and Dropped");

                    aerobicRespirationIA.scrollIntoView();
                } else {
                    actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                    reportLog("Drag item is clicked and hold and Dropped");
                }

                waitForSec(2);
            }
            waitForSec(5);
            if (aerobicRespirationCheckButton.isEnable()) {
                reportLog("Verified that the check it button is enabled.");
                aerobicRespirationCheckButton.clickJScript();
                reportLog("Clicked on the Check it button.");
                waitForSec(2);
                if (aerobicRespirationMessageCard.isDisplayed()) {
                    reportLog("Match the components working fine");
                    return true;
                }
            }
        } else if (endResult.equals("Incorrect")) {
            for (int i = 0; i < eleAttributeArr.length; i++){
                String dropable = dropEle + eleAttributeArr[i];
                GuiControl dropElement = new GuiControl(dropable, webDriver);

                String dragable = dragEle + eleAttributeArr[(eleAttributeArr.length-1) - i];
                GuiControl dragElement = new GuiControl(dragable, webDriver);

                dropElement.scrollIntoView();
                reportLog("Scrolled to the drop elements.");

                actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                reportLog("Drag item is clicked and hold and Dropped");

                waitForSec(2);
            }
            waitForSec(5);

            String incorrectMsg = "This is incorrect! Please retry organizing the labels for right placement.";
            if (aerobicRespirationCheckButton.isElementPresent()) {
                aerobicRespirationCheckButton.scrollIntoView();
                reportLog("Scrolled to check it button");
                if (aerobicRespirationCheckButton.isEnable()) {
                    reportLog("Verified that the check it button is enabled.");
                    aerobicRespirationCheckButton.clickJScript();
                    reportLog("Clicked on the Check it button.");
                    waitForSec(2);
                    if (aerobicRespirationMessageCard.isDisplayed() && aerobicRespirationMessageCard.getText().contains("Incorrect!") && aerobicRespirationMatchMsg.getText().contains(incorrectMsg)) {
                        reportLog("Match the components working fine with negative scenario");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean verifyMatchTheGeneticCode(String endResult){
        String[] eleAttributeArr = {"ONE", "TWO", "THREE", "FOUR"};
        String dropEle = "cssselector" + "_TBD_" + "div[data-droppable-key='G1_ITEM_";
        String dragEle = "cssselector" + "_TBD_" + "div[data-draggable-key='G1_ITEM_";

        geneticCodeIA.scrollIntoView();
        reportLog("Scrolled to Cellular Respiration Interactive");

        geneticCodeIA.click();
        reportLog("Highlight Arrow to Interactive Clicked");

        if (endResult.equals("Correct")) {
            waitForSec(2);
            for (String abt : eleAttributeArr) {
                String dropable = dropEle + abt + "_KEY']";
                GuiControl dropElement = new GuiControl(dropable, webDriver);

                String dragable = dragEle + abt + "_KEY']";
                GuiControl dragElement = new GuiControl(dragable, webDriver);

                actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                reportLog("Drag item is clicked and hold and Dropped");


                waitForSec(2);
            }
            waitForSec(5);
            if (geneticCodeCheckButton.isEnable()) {
                reportLog("Verified that the check it button is enabled.");
                geneticCodeCheckButton.clickJScript();
                reportLog("Clicked on the Check it button.");
                waitForSec(2);
                if (geneticCodeMsgCard.isDisplayed()) {
                    reportLog("Match the components working fine");
                    return true;
                }
            }
        } else if (endResult.equals("Incorrect")) {
            for (int i = 0; i < eleAttributeArr.length; i++){
                String dropable = dropEle + eleAttributeArr[i] + "_KEY']";
                GuiControl dropElement = new GuiControl(dropable, webDriver);

                String dragable = dragEle + eleAttributeArr[(eleAttributeArr.length-1) - i] + "_KEY']";
                GuiControl dragElement = new GuiControl(dragable, webDriver);

                dropElement.scrollIntoView();
                reportLog("Scrolled to the drop elements.");

                actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                reportLog("Drag item is clicked and hold and Dropped");

                waitForSec(2);
            }
            waitForSec(5);

            String incorrectMsg = "Some amino acids are not correctly matched.";
            if (geneticCodeCheckButton.isElementPresent()) {
                geneticCodeCheckButton.scrollIntoView();
                reportLog("Scrolled to check it button");
                if (geneticCodeCheckButton.isEnable()) {
                    reportLog("Verified that the check it button is enabled.");
                    geneticCodeCheckButton.clickJScript();
                    reportLog("Clicked on the Check it button.");
                    waitForSec(2);
                    if (geneticCodeMsgCard.isDisplayed() && geneticCodeMsgCard.getText().contains("Try again!") && geneticCodeMatchMsg.getText().contains(incorrectMsg)) {
                        reportLog("Match the components working fine with negative scenario");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean verifyMatchThePhotosynthesis(String endResult){
        String[] eleAttributeArr = {"slot-1-light", "slot-2-H2O", "slot-3-CO2", "slot-4-light-reactions", "slot-5-calvin-cycle", "slot-6-thylakoid", "slot-7-O2", "slot-8-glucose", "slot-9-stroma"};
        String dropEle = "id" + "_TBD_" + "prefix__";
        String dragEle = "id" + "_TBD_" + "label__";

        photosynthesisCplstIA.scrollIntoView();
        reportLog("Scrolled to Cellular Respiration Interactive");

        if (endResult.equals("Correct")) {
            waitForSec(2);
            for (String abt : eleAttributeArr) {
                String dropable = dropEle + abt;
                GuiControl dropElement = new GuiControl(dropable, webDriver);

                String dragable = dragEle + abt;
                GuiControl dragElement = new GuiControl(dragable, webDriver);

                dropElement.scrollIntoView();
                reportLog("Scrolled to the drop elements.");

                actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                reportLog("Drag item is clicked and hold and Dropped");

                waitForSec(2);
            }

            waitForSec(5);

            if (aerobicRespirationCheckButton.isElementPresent()) {
                aerobicRespirationCheckButton.scrollIntoView();
                reportLog("Scrolled to check it button");
                if (aerobicRespirationCheckButton.isEnable()) {
                    reportLog("Verified that the check it button is enabled.");
                    aerobicRespirationCheckButton.clickJScript();
                    reportLog("Clicked on the Check it button.");
                    waitForSec(2);
                    if (photosynthesisCplstMessageCard.isDisplayed()) {
                        reportLog("Match the components working fine negative scenario");
                        return true;
                    }
                }
            }
        } else if (endResult.equals("Incorrect")) {
            for (int i = 0; i < eleAttributeArr.length; i++){
                String dropable = dropEle + eleAttributeArr[i];
                GuiControl dropElement = new GuiControl(dropable, webDriver);

                String dragable = dragEle + eleAttributeArr[(eleAttributeArr.length-1) - i];
                GuiControl dragElement = new GuiControl(dragable, webDriver);

                dropElement.scrollIntoView();
                reportLog("Scrolled to the drop elements.");

                actions.doubleClick(dragElement.getWebElement()).clickAndHold(dragElement.getWebElement()).moveToElement(dropElement.getWebElement()).release(dropElement.getWebElement()).build().perform();
                reportLog("Drag item is clicked and hold and Dropped");

                waitForSec(2);
            }
            waitForSec(5);

            String incorrectMsg = "This is incorrect! Please retry organizing the labels for right placement.";
            if (aerobicRespirationCheckButton.isElementPresent()) {
                aerobicRespirationCheckButton.scrollIntoView();
                reportLog("Scrolled to check it button");
                if (aerobicRespirationCheckButton.isEnable()) {
                    reportLog("Verified that the check it button is enabled.");
                    aerobicRespirationCheckButton.clickJScript();
                    reportLog("Clicked on the Check it button.");
                    waitForSec(2);
                    if (photosynthesisCplstMessageCard.isDisplayed() && photosynthesisCplstMessageCard.getText().contains("Incorrect!") && photosynthesisCplstMatchMsg.getText().contains(incorrectMsg)) {
                        reportLog("Match the components working fine with negative scenario");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean verifyMitiosMatchingInteractive(){
        String[] columnArray = {"first", "second", "third"};
        String[] boxElements = {"metaphase", "cytokinesis", "telophase", "prophase", "anaphase"};

        int correctComparison = 0;

        createFolder(filePathAfterCmp);
        createFolder(filePathBase);

        mitiosPhaseMatchingIA.scrollIntoView();
        reportLog("Scrolled to Mitios Matching Interactive");

        try {
            Shutterbug.shootElementVerticallyCentered(webDriver, mitiosPhaseMatchingIA.getWebElement()).withName("_baseMitios").save(filePathBase);
            System.out.println("Base Image is collected and saved into the base folder.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < boxElements.length; i++){
            for (int j = 0; j < columnArray.length; j++){
                String box = "xpath" + "_TBD_" + "//li[@type='" + boxElements[i] + "' and @column='" + columnArray[j] + "']";
                GuiControl boxElement = new GuiControl(box, webDriver);

                boxElement.click();
                waitForSec(1);
                reportLog(boxElements[i] + " from " + columnArray[j] + " is selected");
            }
            waitForSec(2);
        }

        waitForSec(3);

        try {
            Shutterbug.shootElementVerticallyCentered(webDriver, mitiosPhaseMatchingIA.getWebElement()).withName("_afterMatchMitios").save(filePathBase);
            System.out.println("After Match Image is collected and saved into the base folder.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.navigate().refresh();
        for (int i = 0; i <= 15; i++) {
            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,300)");
            waitForSec(3);
        }

        mitiosPhaseMatchingIA.scrollIntoView();
        reportLog("Scrolled to Mitios Matching Interactive");

        try {
            BufferedImage baseAnimation = ImageIO.read(new File(filePathBase + File.separator + "_baseMitios.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, mitiosPhaseMatchingIA.getWebElement()).
                    equalsWithDiff(baseAnimation, filePathAfterCmp + "_cellAnimation", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < boxElements.length; i++){
            for (int j = 0; j < columnArray.length; j++){
                String box = "xpath" + "_TBD_" + "//li[@type='" + boxElements[i] + "' and @column='" + columnArray[j] + "']";
                GuiControl boxElement = new GuiControl(box, webDriver);

                boxElement.click();
                waitForSec(1);
                reportLog(boxElements[i] + " from " + columnArray[j] + " is selected");
            }
            waitForSec(2);
        }

        waitForSec(3);

        try {
            BufferedImage baseAnimation = ImageIO.read(new File(filePathBase + File.separator + "_afterMatchMitios.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, mitiosPhaseMatchingIA.getWebElement()).
                    equalsWithDiff(baseAnimation, filePathAfterCmp + "_afterMatchMitios", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info("Total interactions verified correctly " + correctComparison);
        return true;
    }

    public boolean verifyDNAInformationInteractive(){
        int correctComparison = 0;

        createFolder(filePathAfterCmp);
        createFolder(filePathBase);

        dnaInformationIA.scrollIntoView();
        reportLog("Scrolled to DNA Information Interactive");

        try {
            Shutterbug.shootElementVerticallyCentered(webDriver, dnaInformationIA.getWebElement()).withName("_baseDNAInfo").save(filePathBase);
            System.out.println("Base Image is collected and saved into the base folder.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= 3; i++){
            actions.clickAndHold(dnaInformationSlider.getWebElement()).moveByOffset(150,0).build().perform();
            waitForSec(3);
            try {
                Shutterbug.shootElementVerticallyCentered(webDriver, dnaInformationIA.getWebElement()).withName("_imgDNAInfoAfterSlide" + (i+1)).save(filePathBase);
                System.out.println("DNA Information IA image is saved after sliding.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        webDriver.navigate().refresh();
        for (int i = 0; i <= 8; i++) {
            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,300)");
            waitForSec(3);
        }

        dnaInformationIA.scrollIntoView();
        reportLog("Scrolled to DNA Information Interactive");

        try {
            BufferedImage baseAnimation = ImageIO.read(new File(filePathBase + File.separator + "_baseDNAInfo.png"));
            logger.info("Read the base image from the base folder to compare with actual.");
            boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, dnaInformationIA.getWebElement()).
                    equalsWithDiff(baseAnimation, filePathAfterCmp + "_baseDNAInfo", 0.1);
            if (comparison) {
                correctComparison++;
                logger.info("The Base image and Actual animation is correct.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++){
            actions.clickAndHold(dnaInformationSlider.getWebElement()).moveByOffset(150,0).build().perform();
            waitForSec(3);
            try {
                BufferedImage baseAnimation = ImageIO.read(new File(filePathBase + File.separator + "_imgDNAInfoAfterSlide" + (i+1) + ".png"));
                logger.info("Read the base image from the base folder to compare with actual.");
                boolean comparison = Shutterbug.shootElementVerticallyCentered(webDriver, dnaInformationIA.getWebElement()).
                        equalsWithDiff(baseAnimation, filePathAfterCmp + "_afterDNAInfoAfterSlide" + (i+1), 0.1);
                if (comparison) {
                    correctComparison++;
                    logger.info("The Base image and Actual animation is correct.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        logger.info("Total interactions verified correctly " + correctComparison);
        return true;
    }

    public boolean verifyDNAAndRNAMatchingInteractive(String endResult){
        String incorrectMsg = "Some characteristics of DNA and RNA are not correctly sorted.";
        String draggingEleRowOne = "xpath" + "_TBD_" + "//div[@class='labels-drag-container']//div[@data-draggable-typekey='GROUP_ONE_KEY']";
        String droppingEleRowOne = "xpath" + "_TBD_" + "//div[@data-droppable-key='GROUP_ONE_KEY']";
        String draggingEleRowTwo = "xpath" + "_TBD_" + "//div[@class='labels-drag-container']//div[@data-draggable-typekey='GROUP_TWO_KEY']";
        String droppingEleRowTwo = "xpath" + "_TBD_" + "//div[@data-droppable-key='GROUP_TWO_KEY']";

        GuiControl dragRowOne = new GuiControl(draggingEleRowOne, webDriver);
        GuiControl dropRowOne = new GuiControl(droppingEleRowOne, webDriver);
        GuiControl dragRowTwo = new GuiControl(draggingEleRowTwo, webDriver);
        GuiControl dropRowTwo = new GuiControl(droppingEleRowTwo, webDriver);

        if (endResult.equals("Correct")){
            for (int i = 1; i <= 3; i++){
                actions.clickAndHold(dragRowOne.getWebElement()).moveToElement(dropRowOne.getWebElement()).release(dropRowOne.getWebElement()).build().perform();
                logger.info(i + " DNA Element dragged and dropped to correct block");
            }
            for (int i = 1; i <= 3; i++){
                actions.clickAndHold(dragRowTwo.getWebElement()).moveToElement(dropRowTwo.getWebElement()).release(dropRowTwo.getWebElement()).build().perform();
                logger.info(i + " RNA Element dragged and dropped to correct block");
            }
        } else if (endResult.equals("Incorrect")) {
            for (int i = 1; i <= 3; i++){
                actions.clickAndHold(dragRowOne.getWebElement()).moveToElement(dropRowTwo.getWebElement()).release(dropRowTwo.getWebElement()).build().perform();
                logger.info(i + " DNA Element dragged and dropped to correct block");
            }
            for (int i = 1; i <= 3; i++){
                actions.clickAndHold(dragRowTwo.getWebElement()).moveToElement(dropRowOne.getWebElement()).release(dropRowOne.getWebElement()).build().perform();
                logger.info(i + " RNA Element dragged and dropped to correct block");
            }
        }
        if (geneticCodeCheckButton.isEnable()) {
            logger.info("Verified that the check it button is enabled.");
            geneticCodeCheckButton.clickJScript();
            logger.info("Clicked on the Check it button.");
            waitForSec(2);
            if (endResult.equals("Correct") && geneticCodeMsgCard.getText().contains("Great job!")) {
                logger.info("Correctly matched all the element");
                return true;
            } else if (endResult.equals("Incorrect") && geneticCodeMsgCard.getText().contains("Try again!") && geneticCodeMatchMsg.getText().contains(incorrectMsg)){
                logger.info("Incorrect matched working");
                return true;
            }
        }
        return false;
    }

    public boolean verifyAminoAcidMatchInteractive(){
        List<WebElement> leftElements = aminoAcidMatchingLeftBlock.getWebElements();
        List<WebElement> rightElements = aminoAcidMatchingRightBlock.getWebElements();

        for (int i = 0; i < leftElements.size(); i++){
            actions.clickAndHold(leftElements.get(i)).moveToElement(rightElements.get(i)).release(rightElements.get(i)).build().perform();
            logger.info((i+1) + " Left block connected to Right block");
        }
        if (matchTestCheckButton.isEnable()) {
            logger.info("Verified that the check it button is enabled.");
            matchTestCheckButton.clickJScript();
            logger.info("Clicked on the Check it button.");
            waitForSec(2);
            if (correctMatch.getText().contains("Incorrect") || correctMatch.getText().contains("Keep Trying!")) {
                logger.info("Matched all the element");
                return true;
            }
        }
        return false;
    }


    public void createFolder(String dirPath) {
        File folder = new File(dirPath);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }
}