
package uipages.flexbook2feature;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import uipages.BasePage;
import utils.GuiControl;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javafx.scene.input.KeyCode.L;


public class InteractivesPage extends BasePage {

    private static final Logger logger = Logger.getLogger(InteractivesPage.class);

    private final GuiControl intDropdownOne = new GuiControl(getElementMap().get("intDropdownOne"), webDriver);
    private final GuiControl ddoneOptionOne = new GuiControl(getElementMap().get("ddoneOptionOne"), webDriver);
    private final GuiControl incorrectAnswerImage = new GuiControl(getElementMap().get("incorrectAnswerImage"), webDriver);
    private final GuiControl h3 = new GuiControl(getElementMap().get("h3"), webDriver);
    private final GuiControl ddoneOptionTwo = new GuiControl(getElementMap().get("ddoneOptionTwo"), webDriver);
    private final GuiControl ddoneOptionThree = new GuiControl(getElementMap().get("ddoneOptionThree"), webDriver);
    private final GuiControl txtEmptyError = new GuiControl(getElementMap().get("txtEmptyError"), webDriver);
    private final GuiControl txtWrongError = new GuiControl(getElementMap().get("txtWrongError"), webDriver);
    private final GuiControl placeHolderClassCode = new GuiControl(getElementMap().get("placeHolderClassCode"), webDriver);
    private final GuiControl lineSegmentSP = new GuiControl(getElementMap().get("lineSegmentSP"), webDriver);
    private final GuiControl lineSegmentSVG = new GuiControl(getElementMap().get("lineSegmentSVG"), webDriver);
    private final GuiControl scrollElement = new GuiControl(getElementMap().get("scrollElement"), webDriver);
    private final GuiControl polygonDraggableIA = new GuiControl(getElementMap().get("polygonDraggableIA"), webDriver);
    private final GuiControl polygonDraggableIAButton = new GuiControl(getElementMap().get("polygonDraggableIAButton"), webDriver);
    private final GuiControl polygonDraggableAddSide = new GuiControl(getElementMap().get("polygonDraggableAddSide"), webDriver);
    private final GuiControl polygonDraggableDot = new GuiControl(getElementMap().get("polygonDraggableDot"), webDriver);
    private final GuiControl polygonDraggableReset = new GuiControl(getElementMap().get("polygonDraggableReset"), webDriver);
    private final GuiControl quadrilateralDraggableIA = new GuiControl(getElementMap().get("quadrilateralDraggableIA"), webDriver);
    private final GuiControl quadrilateralDraggableIAButton = new GuiControl(getElementMap().get("quadrilateralDraggableIAButton"), webDriver);
    private final GuiControl quadrilateralDraggableDot = new GuiControl(getElementMap().get("quadrilateralDraggableDot"), webDriver);
    private final GuiControl quadrilateralDraggableReset = new GuiControl(getElementMap().get("quadrilateralDraggableReset"), webDriver);
    private final GuiControl quadrilateralDraggableAddon = new GuiControl(getElementMap().get("quadrilateralDraggableAddon"), webDriver);
    private final GuiControl smartPhases = new GuiControl(getElementMap().get("smartPhases"), webDriver);
    private final GuiControl polygonPIDraggableIA = new GuiControl(getElementMap().get("polygonPIDraggableIA"), webDriver);
    private final GuiControl polygonPIDraggableDot = new GuiControl(getElementMap().get("polygonPIDraggableDot"), webDriver);
    private final GuiControl polygonPIDiagram = new GuiControl(getElementMap().get("polygonPIDiagram"), webDriver);

    // Base images directory path
    String basePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator;

    // File Path After comparison difference
    String filePathAfterCmp = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
            + "geometryAfterAnimation";

    public InteractivesPage(WebDriver webDriver, ExtentTest extentTest, ExtentReports extentReports) {
        super(webDriver, extentTest, extentReports);
    }

    Actions builder = new Actions(webDriver);

    String[] spElementArr;

    String[] animElementArr;

    String[] threeDimensionSPElementArr = {"highlightPoint", "highlightLineSegment", "describeLength", "highlightNumberLine", "describePoint", "highlightDiagram"
        , "highlightLW", "highlightCoordSystem", "describe2DPoint", "describe2DXCoord", "describe2DYCoord", "highlightSolid", "highlightLWH"
        , "highlight3DCoordSystem", "highlight3DZAxis", "highlight3DXAxis", "highlight3DYAxis", "describe3DPoint", "highlight3DXCoord"
        , "highlight3DYCoord", "highlight3DZCoord", "generatePointsOnLine", "showSide", "highlightPoints", "highlightEdges", "highlightFaces"};


    String[] threeDimensionAnimeArr = {"1_1_1", "1_1_2", "1_1_2", "1_1_3", "1_1_3", "1_1_4", "1_1_4", "1_1_5", "1_1_5", "1_1_5", "1_1_5", "1_1_6", "1_1_6", "1_1_7", "1_1_7", "1_1_7", "1_1_7", "1_1_7"
                , "1_1_7", "1_1_7", "1_1_7", "1_1_8", "1_1_9", "1_1_10", "1_1_10", "1_1_10"};

    String[] anglesLinesSPElementArr = {"highlightLineSegment", "highlightLineSegmentEndpoints", "animateHighlightRay", "animateRay", "generateAngleLines", "generateCornerVertex"
            , "highlightCompleteAngle", "highlightZero", "highlightAcute", "highlightRight", "highlightObtuse", "highlightStraight", "showProtractor", "highlightcomplimentaryangles"
            , "highlightManyAngles", "highlightSupplementary", "highlightSameMeasureAngles", "highlightManyAngles", "highlightAllAngles", "highlightAEC", "highlightAED", "highlightBED", "highlightBEC"
            , "animateIntersecting", "animateParallel", "showProtractor"};

    String[] angleslinesAnimeArr = {"1_2_1", "1_2_1", "1_2_1", "1_2_1", "1_2_3", "1_2_3", "1_2_4", "1_2_5", "1_2_5", "1_2_5", "1_2_5", "1_2_5", "1_2_6", "1_2_9", "1_2_10", "1_2_10", "1_2_10", "1_2_12"
            , "1_2_12", "1_2_12", "1_2_12", "1_2_12", "1_2_12", "1_2_13", "1_2_13", "1_2_14"};

    String[] polygonsSPElementArr = {"highlightConvexPolygon", "highlightConcavePolygon", "highlightEquilateralPolygon", "highlightEquiangularPolygon", "highlightRegularPolygon"
            , "highlightPentagon", "highlightNSides", "highlightNTriangles", "highlightInteriorAngles", "highlightInternalAngles", "highlightSupplementaryAngles", "highlightExternalAngles"
            , "highlightStraightAngles", "highlightExternalAngles"};

    String[] polygonsAnimeArr = {"1_3_1", "1_3_2", "1_3_3", "1_3_3", "1_3_3", "1_3_5", "1_3_5", "1_3_5", "1_3_5", "1_3_6", "1_3_7", "1_3_7", "1_3_8", "1_3_8"};

    String[] trianglesSPElementArr = {"highlightScalene", "highlightIsoceles", "highlightEquilateral", "highlightRightTriangle", "highlightAcuteTriangle", "highlightObtuseTriangle"
            , "highlightObtuse", "highlightEquilateral", "highlightC", "highlightA", "highlightB"};

    String[] trianglesAnimeArr = {"1_4_1", "1_4_1", "1_4_1", "1_4_2", "1_4_2", "1_4_2", "1_4_3", "1_4_3", "1_4_5", "1_4_5", "1_4_5"};

    String[] quadrilateralsSPElementArr = {"highlightquadrilateral", "highlightab", "highlightbc", "highlightcd", "highlightda", "highlighta", "highlightb", "highlightc", "highlightd"
            , "highlightac", "highlightbd", "highlightabandad", "highlightkite", "highlightvertexangles", "highlightnonvertexangles", "highlightabequallad", "highlightbcequallcd"
            , "highlightabcequalladc", "highlightangleaob", "highlightangleboc", "highlightanglecod", "highlightangledoa", "highlightboequallod", "highlightbacequalldac", "highlightbcaequalldca", "highlightabccongruentadc"
            , "highlighttrapezoid", "highlightonepair", "highlightabparallelcd", "highlightabcplusbcd", "highlightcdaplusdab", "highlighttrapezoid", "highlightabparallelcd", "highlightabcplusbcd", "highlightcdaplusdab", "highlightabcequalldab", "highlightbcdequallcda"
            , "highlightparallelogram", "highlightwopairs", "highlightRectangle", "highlightAllRightAngles"
            , "highlightRhombus", "showAllSidesEqual", "highlightsquare", "highlightallangles", "highlightalltheangles", "highlightrightangles"};

    String[] quadrilateralsAnimeArr = {"1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_1", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2", "1_5_2"
            , "1_5_3", "1_5_3", "1_5_3", "1_5_3", "1_5_4", "1_5_4", "1_5_4", "1_5_4", "1_5_4", "1_5_4", "1_5_5", "1_5_5", "1_5_6", "1_5_6", "1_5_7", "1_5_7", "1_5_8", "1_5_8", "1_5_9", "1_5_9"};

    String[] aopOfTrianglesAndQuadrilateralSPElementArr = {"highlightperimeter", "highlightsumoflengths", "highlightsquareunit", "highlightarea", "highlightarea", "highlightbase"
            , "highlightheight", "highlightrectangle", "highlightarea", "highlightbase", "highlightheight", "adjacentside", "highlightparallelogram", "highlightarea", "highlightbase"
            , "highlightheight", "highlighthalfparallelogram", "highlightbase", "highlightheight", "highlightarea", "highlightrectangle", "highlightparallelogram", "highlighttriangle"
            , "highlighttrapezoid", "highlightrhombus", "highlightkite", "dehighlightsquare", "highlightheight(h)", "highlightbase(b1)", "highlightbase(b2)", "highlightdiagonals"};

    String[] aopOfTrianglesAndQuadrilateralAnimeArr = {"1_6_1", "1_6_1", "1_6_2", "1_6_2", "1_6_3", "1_6_3", "1_6_3", "1_6_4", "1_6_4", "1_6_4", "1_6_4", "1_6_5", "1_6_6", "1_6_6", "1_6_6", "1_6_6", "1_6_7", "1_6_7"
            , "1_6_7", "1_6_7", "1_6_8", "1_6_9", "1_6_10", "1_6_11", "1_6_12", "1_6_13", "1_6_14", "1_6_16", "1_6_16", "1_6_16", "1_6_17"};

    String[] thePythagoreanTheoremSPElementArr = {"highlightSideA", "highlightSideB", "highlightSideC", "highlightASquare", "highlightBSquare", "highlightCSquare", "showPythagoreanProof", "animateTriangle", "showGeometricProof"
            , "animateCentralSquare", "animateSameLengthLines", "showInnerRightAngles", "showSame3Angles", "animateCentralSquare", "highlightLargeSquare", "showAreaOfTriangles", "showAreaOfSquare", "highlightsumofsides"};

    String[] thePythagoreanTheoremAnimeArr = {"1_7_1", "1_7_1", "1_7_1", "1_7_1", "1_7_1", "1_7_1", "1_7_1", "1_7_3", "1_7_3", "1_7_4", "1_7_4", "1_7_4", "1_7_4", "1_7_4", "1_7_4", "1_7_4", "1_7_4", "1_7_8"};

    String[] circlesSPElementArr = {"highlightAllPoints", "highlightRadius", "highlightDiameter", "highlightCircumference", "showWedges", "showParallelogram", "showRectangle", "showR", "showPiR"
            , "highlightRadius", "highlightArc", "highlightMinorArc", "highlightMajorArc", "highlightSector", "highlightMinorSector", "highlightMajorSector", "highlightArea", "drawPerimeter", "highlightArea", "drawPerimeter"};

    String[] circlesAnimeArr = {"1_8_1", "1_8_1", "1_8_1", "1_8_1", "1_8_2", "1_8_2", "1_8_2", "1_8_2", "1_8_2", "1_8_3", "1_8_4", "1_8_4", "1_8_4", "1_8_6", "1_8_6", "1_8_6", "1_8_8", "1_8_8", "1_8_11", "1_8_11"};

    String[] compositeShapesSPElementArr = {"areaofcompositeshape", "sumofindividualareas", "areaofcompositeshape", "areaoflargeshape", "areaofpiecesoflargeshapenotincluded", "highlightonetriangle", "highlighttworectangles"
            , "highlightrighttriangle", "highlight5incheshypotenuse", "highlight5inchestoprectbottom", "highlight4inches", "highlight10inches", "highlight6inches", "highlight3inches", "highlight15inches", "highlight7inches"
            , "highlight5inchestoprectbase", "highlightperimeter", "highlightarea", "highlightlargerectangle", "highlightunshadedtriangle", "highlightunshadedrectangle", "highlightteninchesunshaded", "highlightfifteeninchesbase"
            , "highlightfiveinches", "highlightsixinchestopright", "highlightfourinches", "highlightteninchestopright", "highlightsixinchesunshadedleft", "highlightthreeinches", "highlightareaofwholecircle", "highlightareaofsquare"
            , "highlightperimeter", "highlightbigrectangle", "highlighttrapezoid"};

    String[] compositeShapesAnimeArr = {"1_9_1", "1_9_1", "1_9_2", "1_9_2", "1_9_2", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_3", "1_9_4"
            , "1_9_4", "1_9_4", "1_9_4", "1_9_4", "1_9_4", "1_9_4", "1_9_4", "1_9_4", "1_9_4", "1_9_4", "1_9_5", "1_9_5", "1_9_6", "1_9_6", "1_9_6"};

    String[] volumeOfSolidsSPElementArr = {"highlightVolumes", "highlightUnitCubes", "highlightPolygonBases", "highlightConnectingRectangle", "highlightBaseShape", "highlightVolume", "highlightCylinderBases", "highlightCurvedSurface"
            , "showVolume", "highlightPolygonBases", "highlightConnectingTriangle", "highlightBaseShape", "highlightConeBase", "highlightCurvedSurface", "highlightConeVertex", "showVolumeRatio", "showEquidistantPoints", "highlightSphereCenter"
            , "highlightSphereRadius", "showCompositeSolid", "showBase", "showHeight", "showCircularBase", "showHeight", "highlightRadius", "highlightCube", "highlightPyramid", "showEdges", "showOverallHeight", "highlightBase", "highlightHeight"};

    String[] volumeOfSolidsAnimeArr = {"1_10_1", "1_10_1", "1_10_2", "1_10_2", "1_10_2", "1_10_2", "1_10_3", "1_10_3", "1_10_3", "1_10_4", "1_10_4", "1_10_4", "1_10_5", "1_10_5", "1_10_5", "1_10_6", "1_10_7", "1_10_7"
            , "1_10_7", "1_10_9", "1_10_10", "1_10_10", "1_10_12", "1_10_12", "1_10_14", "1_10_15", "1_10_15", "1_10_15", "1_10_15", "1_10_16", "1_10_16"};

    String[] surfaceAreaAndNetsSPElementArr = {"showNet", "showNet", "showCongruentRect", "showCongruentTriangles", "showSurfaceArea", "showFiveShapes", "showNet", "showPyramid", "show20Inches", "show12Inches", "showNet", "show5Shapes"
            , "showBaseShape", "showNet", "showNet", "showBase", "show5Triangles", "showHeight", "showNet", "showCongruentRect", "showPentagonalFaces"};

    String[] surfaceAreaAndNetsAnimeArr = {"1_11_1", "1_11_3", "1_11_3", "1_11_3", "1_11_3", "1_11_3", "1_11_5", "1_11_6", "1_11_6", "1_11_6", "1_11_6", "1_11_7", "1_11_9", "1_11_10", "1_11_11", "1_11_12", "1_11_12", "1_11_12", "1_11_14", "1_11_14", "1_11_14"};

    String[] crossSectionsOfSolidsSPElementArr = {"showCrossSection", "showCrossSection", "showCrossSection", "showCrossSection", "showCrossSection", "showCrossSection", "showCrossSection"};

    String[] crossSectionOfSolidsAnimeArr = {"1_12_1", "1_12_2", "1_12_3", "1_12_5", "1_12_6", "1_12_7", "1_12_8"};

    String[] transformationPlaneSPElementArr = {"stretches each point", "length is not preserved", "reflects", "distance", "translate", "distances", "same length"};

    String[] transformationPlaneAnimeArr = {"2_1_1", "2_1_2", "2_1_3", "2_1_3", "2_1_4", "2_1_4", "2_1_5"};

    String[] translationsSPElementArr = {"translated", "translated", "parallel", "v", "points on the image", "translation", "translation", "vector", "vector", "translation", "translation"};

    String[] translationsAnimeArr = {"2_2_11", "2_2_1", "2_2_2", "2_2_3", "2_2_3", "2_2_4", "2_2_5", "2_2_6", "2_2_10", "2_2_7", "2_2_9"};

    String[] geometrySoftwareSPElementArr = {"translate", "translatewithoutgrid"};

    String[] geometrySoftwareAnimeArr = {"2_3_1", "2_3_2"};

    String[] reflectionSPElementArr = {"reflection", "highlightquadrilateral", "highlightreflected", "highlightlineofreflection", "samedistance", "perpendicularbisector", "lineofreflection", "notthesamedistance", "perpendicularline",
            "counttheunits", "samenumberofunits", "midpoint", "lineofreflection"};

    String[] reflectionAnimeArr = {"2_4_1", "2_4_2", "2_4_2", "2_4_2", "2_4_2", "2_4_3", "2_4_5", "2_4_6", "2_4_7", "2_4_7", "2_4_7", "2_4_8", "2_4_8"};

    String[] geometrySoftwareOfReflectionSPElementArr = {"showReflection", "showReflection"};

    String[] geometrySoftwareOfReflectionAnimeArr = {"2_5_1", "2_5_2"};

    String[] reflectionSymmetrySPElementArr = {"showReflectionSymmetry", "showSymmetryLine", "showSymmetryLine", "showReflectionSymmetry", "showReflectionSymmetry", "showSymmetryLine", "showReflectionSymmetry", "showSymmetryLine",
            "showReflectionSymmetry", "showSymmetryLine", "showSymmetryLine", "showSymmetryLine"};

    String[] reflectionSymmetryAnimeArr = {"2_6_1", "2_6_1", "2_6_2", "2_6_2", "2_6_3", "2_6_4", "2_6_5", "2_6_6", "2_6_8", "2_6_9", "2_6_10", "2_6_11"};

    String[] rotationsSPElementArr = {"rotate", "rotate", "rotate", "showCenter", "showDirectionOfRotation", "showDegreeOfRotation", "show135", "show225", "showAngles", "showRotation", "show135", "show225", "rotateClockwise", "rotateCounterClockwise"};

    String[] rotationAnimeArr = {"2_7_1", "2_7_2", "2_7_3", "2_7_3", "2_7_3", "2_7_3", "2_7_5", "2_7_5", "2_7_6", "2_7_7", "2_7_8", "2_7_8", "2_7_9", "2_7_9"};

    String[] geometrySoftwareOfRotationSPElementArr = {"rotationwithoutgrid"};

    String[] geometrySoftwareOfRotationAnimeArr = {"2_8_1"};

    String[] rotationSymmetrySPElementArr = {"order2", "order3", "onebytwo", "onebythree", "180", "120", "rotation symmetry", "rotation symmetry",
            "angles of rotation", "rotation symmetry", "rotate", "rotation symmetry", "rotation symmetry", "rotation symmetry", "rotation symmetry"};

    String[] rotationSymmetryAnimeArr = {"2_9_1", "2_9_1", "2_9_2", "2_9_2", "2_9_3", "2_9_3", "2_9_4", "2_9_5", "2_9_6", "2_9_7", "2_9_9", "2_9_10", "2_9_11", "2_9_12", "2_9_13"};

    String[] compositeTransformationsSPElementArr = {"compositetransformation", "transform", "transform", "180degreerotation", "reflectiona", "reflectionb", "rotated", "translated", "glidereflection", "transform"};

    String[] compositeTransformationsAnimeArr = {"2_10_1", "2_10_2", "2_10_3", "2_10_4", "2_10_5", "2_10_5", "2_10_6", "2_10_6", "2_10_7", "2_10_8"};

    String[] defOfCongruenceSPElementArr = {"reflectTrapezoid", "rotateTrapezoid", "translateTrapezoid", "rotateRectOnAxis", "showCongruentAngles", "showCongruentSides", "rotateCongruentTriangle", "transformCongruentTriangle1", "showCongruentAnglesAF", "showCongruentAnglesCG","showCongruentAnglesBE", "showCongruentSides_AB_EF", "showCongruentSides_AC_FG", "showCongruentSides_BC_EG"};

    String[] defOfCongruenceAnimeArr = {"3_1_1", "3_1_1", "3_1_1", "3_1_3", "3_1_3", "3_1_3", "3_1_4", "3_1_5", "3_1_6", "3_1_6", "3_1_6", "3_1_6", "3_1_6", "3_1_6"};

    String[] aasTriangleCongruenceSPElementArr = {"showCongruentTriangleASA", "showCongruenceTransformationVecPart1", "showCongruenceTransformationPart1", "showCongruentAngleTransform2", "rotateCongruentAngleTransform3", "reflectCongruentAngleTransform4", "showCongruentTranformationEx1", "showCongruentTranformationExTwo"};

    String[] aasTriangleCongruenceAnimeArr = {"3_2_1", "3_2_3", "3_2_3", "3_2_4", "3_2_5", "3_2_6", "3_2_7", "3_2_8"};

    String[] sasTriangleCongruenceSPElementArr = {"showCongruentTriangleSAS", "showCongruenceSASVecPart1", "showCongruenceSASPart1", "showCongruenceSASPart2", "rotateCongruentSASTransform3", "reflectCongruentSASTransform4", "showSAStranformationEx1", "showCongruentSASex2"};

    String[] sasTriangleCongruenceAnimeArr = {"3_3_1", "3_3_3", "3_3_3", "3_3_4", "3_3_5", "3_3_6", "3_3_7", "3_3_8"};

    String[] sssTriangleCongruenceSPElementArr = {"showSSSCongruence", "vector", "translate", "angleabd", "rotatedef", "reflectdef", "circlecenteredate", "circlecenteredatd", "thirdside", "congruent", "congruent"};

    String[] sssTriangleCongruenceAnimeArr = {"3_4_1", "3_4_3", "3_4_3", "3_4_5", "3_4_4", "3_4_6", "3_4_7", "3_4_7", "3_4_8", "3_4_8", "3_4_9"};

    String[] appCongruentTriangleSPElementArr = {"showAC≅CD", "show∠ACB≅∠DCB", "showBC", "showSSS", "showSAS", "showHL", "showSAS", "showASA"};

    String[] appCongruentTriangleAnimeArr = {"3_5_1", "3_5_1", "3_5_1", "3_5_2", "3_5_2", "3_5_2", "3_5_3", "3_5_4"};

    String[] theoremProofSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6", "hover_1", "hover_2", "hover_3", "hover_4",
            "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6"};

    String[] theoremProofAnimeArr = {"4_1_1", "4_1_1", "4_1_1", "4_1_1", "4_1_1", "4_1_1", "4_1_2", "4_1_2", "4_1_2", "4_1_2", "4_1_2", "4_1_2", "4_1_4", "4_1_4", "4_1_4", "4_1_4", "4_1_5", "4_1_5", "4_1_5", "4_1_5", "4_1_5", "4_1_5", "4_1_6", "4_1_6", "4_1_6", "4_1_6", "4_1_6", "4_1_6"};

    String[] theoremLinesAngleSPElementArr = {"showTransversal", "showCorrespondingAngles", "showSameSideInteriorAngles", "showAlternateInteriorAngles", "showAlternateExteriorAngles", "showSameSideExteriorAngles", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_1", "hover_1"};

    String[] theoremLinesAngleAnimeArr = {"4_3_2", "4_3_2", "4_3_2", "4_3_2", "4_3_2", "4_3_2", "4_2_2", "4_2_2", "4_2_2", "4_2_2", "4_2_2", "4_2_3", "4_2_4"};

    String[] appLinesAngleTheoremSPElementArr = {"showVerticalAngles", "showTransversal", "showCorrespondingAngles", "showSameSideInteriorAngles", "showAlternateInteriorAngles", "showAlternateExteriorAngles", "showSameSideExteriorAngles", "showVertical", "showCorresponding", "showSupplementary", "showMidpoint", "show∠CDB", "showPerpBis", "showEquidistant",
            "showAD||BC", "showAB||DC", "show∠DAC≅∠BCA", "show∠ACD≅∠CAB", "showAC≅AC", "showΔABC≅ΔCDA", "showAC≅CB", "showAD≅DB", "showPerpBisector", "showVertAngle1", "showVertAngle2", "showInteriorAngles", "showCorrespondingAngles"};

    String[] appLinesAngleTheoremAnimeArr = {"4_3_1", "4_3_2", "4_3_2", "4_3_2", "4_3_2", "4_3_2", "4_3_2", "4_3_3", "4_3_3", "4_3_3", "4_3_4", "4_3_4", "4_3_4", "4_3_4", "4_3_5", "4_3_5", "4_3_5", "4_3_5", "4_3_5", "4_3_5", "4_3_6", "4_3_6", "4_3_6", "4_3_7", "4_3_7", "4_3_7", "4_3_7"};

    String[] theoremTriangleSPElementArr = {"highlightScalene", "highlightIsoceles", "highlightEquilateral", "highlightRightTriangle", "highlightAcuteTriangle", "highlightObtuseTriangle", "showParallel", "show∠DBA≅∠A", "show∠EBC≅∠C", "showm∠DBA+m∠ABC+m∠EBC=180°", "showm∠A+m∠ABC+m∠C=180°", "showBaseAngles", "showAB_AC", "showAB≅AC", "showAngleBisector",
            "showAF≅AF", "show∠BAF≅∠CAF", "showΔABF≅ΔACF", "show∠B≅∠C", "showExteriorAngles", "showRemoteInteriorAngles", "showDC≅AD", "showCE≅EB", "showDE≅EF", "show∠CED≅∠FEB", "showBF||AD"};

    String[] theoremTriangleAnimeArr = {"4_4_1", "4_4_1", "4_4_1", "4_4_2", "4_4_2", "4_4_2", "4_4_3", "4_4_4", "4_4_4", "4_4_4", "4_4_4", "4_4_6", "4_4_6", "4_4_7", "4_4_7", "4_4_7", "4_4_7", "4_4_7", "4_4_7", "4_4_9", "4_4_9", "4_4_11", "4_4_11", "4_4_11", "4_4_11", "4_4_11"};

    String[] theoremConcurrenceTriangleSPElementArr = {"medians", "centroid", "altitudes", "orthocenter", "perpendicularbisectors", "circumcenter", "circumcircle", "anglebisectors", "incenter", "incircle", "collinear", "concurrency", "equidistant1", "medians", "fdhalfac", "hjhalfac", "m", "n", "pprime"};

    String[] theoremConcurrenceTriangleAnimeArr = {"4_5_1_Interactive", "4_5_1_Interactive", "4_5_2_Interactive", "4_5_2_Interactive", "4_5_3_Interactive", "4_5_3_Interactive", "4_5_3_Interactive", "4_5_4_Interactive", "4_5_4_Interactive", "4_5_4_Interactive", "4_5_5_Interactive", "4_5_5_a", "4_5_7", "4_5_8", "4_5_8", "4_5_9_1", "4_5_9_1", "4_5_9_2"};

    String[] appTriangleTheoremSPElementArr = {"centroid", "incenter", "orthocenter", "circumcenter", "centroid", "abcongac", "addbaeeccong", "abccongacb", "bccongbc", "dbccongecb", "dccongeb", "centroid", "anglebcd", "remoteinterior"};

    String[] appTriangleTheoremAnimeArr = {"4_6_0_a_Centroid", "4_6_0_a_Incenter", "4_6_0_a_Orthocenter", "4_6_0_a_Circumcenter", "4_6_1", "4_6_3", "4_6_3", "4_6_3", "4_6_3", "4_6_3", "4_6_3", "4_6_4", "4_6_5", "4_6_5"};

    String[] theoremQuadrilateralSPElementArr = {"hover_1", "hover_1", "hover_1", "hover_1", "hover_1", "hover_1", "hover_2", "hover_3", "hover_4", "hover_11", "hover_12", "hover_7", "hover_8", "hover_9", "hover_1", "hover_2", "hover_3", "hover_4", "show∠A&∠D", "showAB||DC", "showAD||BC", "showOB=OD", "showOA=OC", "showBO=DO", "showBC=DC", "showOC=OC",
            "showAB≅AD", "showCB≅CD", "showAC≅AC", "showAB≅AD", "showCB≅CD", "showAC≅AC"};

    String[] theoremQuadrilateralAnimeArr = {"4_7_1a", "4_7_1b", "4_7_1c", "4_7_1d", "4_7_1e", "4_7_2", "4_7_2", "4_7_2", "4_7_2", "4_7_3", "4_7_3", "4_7_3", "4_7_3", "4_7_3", "4_7_4", "4_7_4", "4_7_4", "4_7_4", "4_7_6", "4_7_6", "4_7_6", "4_7_10", "4_7_10", "4_7_10", "4_7_10", "4_7_10", "4_7_11", "4_7_11", "4_7_11", "4_7_12", "4_7_12", "4_7_12"};

    String[] appQuadrilateralTheoremSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_2", "hover_1", "hover_2", "hover_1", "hover_2", "hover_1", "hover_2", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6"};

    String[] appQuadrilateralTheoremAnimeArr = {"4_8_1", "4_8_1", "4_8_1", "4_8_1", "4_8_2a", "4_8_2a", "4_8_2b", "4_8_2b", "4_8_2c", "4_8_2c", "4_8_3", "4_8_3", "4_8_4", "4_8_4", "4_8_4", "4_8_4", "4_8_4", "4_8_4", "4_8_8", "4_8_8", "4_8_8", "4_8_8", "4_8_8", "4_8_8"};

    String[] copyLineSegAnglesSPElementArr = {"hover_1", "hover_1", "hover_1", "showEndPoint", "showDrawArc", "showCongruence", "showDrawAOB", "showRayMN", "showArc", "showPointD", "showDrawArc", "hover_1", "showDrawArc", "showDrawRay", "showDrawRay", "showLengthMeasure", "showMarking", "hover_2", "hover_3", "hover_1", "hover_1", "hover_1", "hover_2"};

    String[] copyLineSegAnglesAnimeArr = {"5_1_1", "5_1_2", "5_1_3", "5_1_4", "5_1_4", "5_1_5", "5_1_6", "5_1_7", "5_1_7", "5_1_7", "5_1_8", "5_1_9", "5_1_10", "5_1_11", "5_1_12", "5_1_13", "5_1_13", "5_1_14", "5_1_14", "5_1_15", "5_1_16", "5_1_17", "5_1_18"};

    String[] bisectorLineSegAnglesSPElementArr = {"showPerpBisector", "showEquidistant", "showAngleBisector", "showEquidistant", "fold", "showEquidistant", "showA", "showB", "showPQ", "drawLine", "fold", "showD", "showA", "showEquidistant", "showAB≅CB"};

    String[] bisectorLineSegAnglesAnimeArr = {"5_2_1", "5_2_1", "5_2_2", "5_2_2", "5_2_4", "5_2_5", "5_2_7", "5_2_7", "5_2_8", "5_2_9", "5_2_11", "5_2_14", "5_2_15", "5_2_16", "5_2_18"};

    String[] parallelPerpLineConstSPElementArr = {"showP", "drawLine", "showP", "showQ", "drawArc1", "drawArc2", "showParallel", "showP", "showAB", "showCompass", "showCircle1", "showCircle2", "showCD", "showLine", "showPerpendicular", "showVertexB", "showVertexC", "showOrthocenter", "showExtend", "showParallelogram"};

    String[] parallelPerpLineConstAnimeArr = {"5_3_1", "5_3_2", "5_3_2", "5_3_2", "5_3_4", "5_3_4", "5_3_5", "5_3_6", "5_3_7", "5_3_8", "5_3_8", "5_3_8", "5_3_8", "5_3_8", "5_3_11", "5_3_12", "5_3_12", "5_3_15", "5_3_15"};

    String[] constRegularPolygonsSPElementArr = {"drawLineSegment", "vertexA", "joinAtoC", "constructCircle", "foldCircleInHalf", "perpendicular", "aobocodo", "fullcircle", "evenlyspaced", "point", "mark", "sameDistance"};

    String[] constRegularPolygonsAnimeArr = {"5_4_2", "5_4_3", "5_4_4", "5_4_5", "5_4_6", "5_4_7", "5_4_8", "5_4_9", "5_4_10", "5_4_11", "5_4_12", "5_4_13"};

    String[] dilationsSPElementArr = {"showDilation", "showScaleFactor", "showCollinearPoints", "showNonPreservedLength", "showPreservedAngles", "showScaleFactor", "showLine", "showDilation", "showFinal", "showHypotenuse", "showTriangle", "showScaleFactor"};

    String[] dilationsAnimeArr = {"6_1_1", "6_1_2", "6_1_2", "6_1_2", "6_1_2", "6_1_3", "6_1_4", "6_1_4", "6_1_4", "6_1_5", "6_1_5", "6_1_10"};

    String[] defSimilaritySPElementArr = {"showReflection", "showRotation", "showDilation", "showScaleFactor2", "showCongruence", "showAngleDilation", "showScaleFactor2", "showRotation", "showDilation", "showAngles", "showSides", "rotate", "showScaleFactor"};

    String[] defSimilarityAnimeArr = {"6_2_1", "6_2_1", "6_2_1", "6_2_1", "6_2_1", "6_2_1", "6_2_1", "6_2_2", "6_2_2", "6_2_3", "6_2_3", "6_2_4", "6_2_4"};

    String[] aaTriangleSimilaritySPElementArr = {"angles_a_d", "angles_b_e", "angles_c_f", "dilation_abcprime_abc", "angles_b_prime_e_prb1", "angles_b_prime_e", "angles_a_prime_f", "one_pair", "another_pair", "angle_agd_63ex1", "angle_acb_63ex1", "angle_bac_63ex2", "angle_efc_63ex2", "angle_agd_63ex3", "angle_acb_63ex3"};

    String[] aaTriangleSimilarityAnimeArr = {"6_3_1", "6_3_1", "6_3_1", "6_3_3", "6_3_3", "6_3_4", "6_3_4", "6_3_5", "6_3_5", "6_3_6", "6_3_6", "6_3_7", "6_3_7", "6_3_8", "6_3_8"};

    String[] sasTriangleSimilaritySPElementArr = {"angles_a_d_6_4_1", "sides_ac_df_6_4_1", "sides_ab_de_6_4_1", "sides_bc_ef_6_4_1", "angles_b_e_6_4_1", "congruent_6_4_2", "sides_de_ac_6_4_2", "sides_de_ac_6_4_3", "sides_fe_bc_6_4_3", "angles_c_d_6_4_4", "sides_bc_6_4_4", "sides_ac_ed_6_4_5", "angles_c_d_6_4_5"};

    String[] sasTriangleSimilarityAnimeArr = {"6_4_1", "6_4_1", "6_4_1", "6_4_1", "6_4_1", "6_4_2", "6_4_2", "6_4_3", "6_4_3", "6_4_4", "6_4_4", "6_4_5", "6_4_5"};

    String[] sssTriangleSimilaritySPElementArr = {"sides_bc_ef_6_5_1", "sides_ac_df_6_5_1", "sides_ab_de_6_5_1", "angles_b_e_6_5_1", "angles_c_f_6_5_1", "sides_de_ca_6_5_3", "sides_de_cb_6_5_3", "sides_fe_ab_6_5_3", "sides_de_cb_6_5_4", "sides_fe_ab_6_5_4", "sides_ac_fd_6_5_5", "sides_cb_de_6_5_5", "showSame", "showDF/AC", "showDE/AB", "showDF/AC", "showEF/BC"};

    String[] sssTriangleSimilarityAnimeArr = {"6_5_1", "6_5_1", "6_5_1", "6_5_1", "6_5_1", "6_5_3", "6_5_3", "6_5_3", "6_5_4", "6_5_4", "6_5_5", "6_5_5", "6_5_6", "6_5_7", "6_5_7", "6_5_8", "6_5_8"};

    String[] theoryInsolveSimilaritySPElementArr = {"angleabc", "angleade", "angleacb", "angleaed", "tridbc", "angleeac", "angledca", "anglebae", "bd", "angleabc", "baperpad", "tribac", "tribcd", "tricad", "a", "b", "c", "cabybc", "adBYac", "cdbybc"};

    String[] theoryInsolveSimilarityAnimeArr = {"6_6_1", "6_6_1", "6_6_1", "6_6_1", "6_6_2", "6_6_2", "6_6_2", "6_6_2", "6_6_3", "6_6_3", "6_6_3", "6_6_4", "6_6_4", "6_6_4", "6_6_5", "6_6_5", "6_6_5", "6_6_6", "6_6_6", "6_6_6"};

    String[] appSimilarTriangleSPElementArr = {"abceqdef", "bcaeqefd", "cabeqfde", "tridef", "ad", "bc", "tridgc", "angleabg", "angleg", "dgccongegf"};

    String[] appSimilarTriangleAnimeArr = {"6_7_1", "6_7_1", "6_7_1", "6_7_1", "6_7_2", "6_7_2", "6_7_2", "6_7_2", "6_7_2", "6_7_2"};

    String[] tangentRatioSPElementArr = {"two pairs", "df", "ac", "leg opposite", "leg adjacent", "tan c", "opposite leg", "adjacent leg", "angle increases", "congruent"};

    String[] tangentRatioAnimeArr = {"7_1_1", "7_1_1", "7_1_1", "7_1_1", "7_1_1", "7_1_2", "7_1_3", "7_1_3", "7_1_5", "7_1_6"};

    String[] sineAndCosineRatioSPElementArr = {"three pairs", "opposite leg", "hypotenuse", "adjacent leg", "sina", "cosa", "adjacent leg", "hypotenuse", "opposite leg", "adjacent leg", "hypotenuse", "cosa", "opposite leg", "hypotenuse"};

    String[] sineAndCosineRatioAnimeArr = {"7_2_1", "7_2_1", "7_2_1", "7_2_1", "7_2_2", "7_2_2", "7_2_4", "7_2_4", "7_2_8", "7_2_8", "7_2_8", "7_2_9", "7_2_10", "7_2_10"};

    String[] sineAndCosineCompAnglesSPElementArr = {"sine", "cosine", "right angle triangle", "inverse"};

    String[] sineAndCosineCompAnglesAnimeArr = {"7_3_1", "7_3_1", "7_3_2", "7_3_4"};

    String[] inverseTrigonometricRatioSPElementArr = {"opposite", "hypotenuse", "opposite", "adjacent", "adjacent", "hypotenuse", "opposite", "adjacent", "opposite", "adjacent"};

    String[] inverseTrigonometricRatioAnimeArr = {"7_4_1", "7_4_1", "7_4_2", "7_4_2", "7_4_4", "7_4_4", "7_4_6", "7_4_6", "7_4_7", "7_4_7"};

    String[] sineFindAreaOfTriangleSPElementArr = {"two right triangles", "opposite", "hypotenuse", "right triangle" ,"base", "exterior angle", "opposite", "hypotenuse", "altitude", "exterior angle"};

    String[] sineFindAreaOfTriangleAnimeArr = {"7_5_1", "7_5_1", "7_5_1", "7_5_1", "7_5_2", "7_5_4", "7_5_4", "7_5_4", "7_5_5", "7_5_5"};

    String[] lawOfSineSPElementArr = {"angles and opposite sides", "abc", "altitude", "two right triangles", "left triangle", "right triangle", "c", "ab", "b", "ssa"};

    String[] lawOfSineAnimeArr = {"7_6_1", "7_6_2", "7_6_2", "7_6_2", "7_6_2", "7_6_2", "7_6_3", "7_6_3", "7_6_4", "7_6_5"};

    String[] lawOfCosineSPElementArr = {"abc", "adc", "adb"};

    String[] lawOfCosineAnimeArr = {"7_7_1", "7_7_1", "7_7_1"};

    String[] triangleAppliedProblemSPElementArr = {"highlightASquare", "highlightBSquare", "highlightCSquare", "hypotenuse", "adjacent leg", "opposite leg", "southwest", "north-northwest", "two sides", "included angle", "third side", "two right triangles", "small brown(brown color needs to change in doc) triangle",
            "large right triangle", "right triangles", "angle", "side", "two pieces", "two sides", "included angle", "third side", "perimeter", "a", "b"};

    String[] triangleAppliedProblemAnimeArr = {"7_8_12", "7_8_12", "7_8_12", "7_8_1", "7_8_1", "7_8_1", "7_8_2", "7_8_2", "7_8_3", "7_8_3", "7_8_3", "7_8_4", "7_8_4", "7_8_4",
            "7_8_5", "7_8_5", "7_8_5", "7_8_5", "7_8_6", "7_8_6", "7_8_6", "7_8_7", "7_8_8", "7_8_8"};

    String[] circleSimilaritySPElementArr = {"showSetOfAllPoints", "showCenter", "showRadius", "showCircleA", "showCircleA", "showVector", "showTranslate", "showDilation", "showCircleD", "showCircleA", "showVector", "showDilation", "showRadii", "showSmallCircleCirc", "showLargeCircleCirc"};

    String[] circleSimilarityAnimeArr = {"8_1_1", "8_1_1", "8_1_1", "8_1_2", "8_1_2", "8_1_3", "8_1_3", "8_1_4", "8_1_4", "8_1_5", "8_1_5", "8_1_5", "8_1_6", "8_1_6", "8_1_6"};

    String[] areaCircumferenceCircleSPElementArr = {"showSetOfAllPoints", "showRadius", "showDiameter", "showWedges", "showPiR", "showR", "showOctagon", "showHeight", "showAreaOfOctagon", "showAngles", "showHeight", "showRadius", "showAngles", "showHeight", "showRadius", "showBase"};

    String[] areaCircumferenceCircleAnimeArr = {"8_2_1", "8_2_1", "8_2_1", "8_2_3", "8_2_3", "8_2_3", "8_2_5", "8_2_6", "8_2_6", "8_2_7", "8_2_7", "8_2_7", "8_2_8", "8_2_8", "8_2_9", "8_2_9"};

    String[] centralAngleChordSPElementArr = {"showCentralAngle", "show∠BAC", "showArc", "showMinorArc", "showMajorArc", "showChord", "showCE", "showArcCE", "showmCDE", "showmCD=mFE", "showΔACD", "showΔAFE", "showCD≅FE", "showΔACD", "showΔAFE", "showAtoE", "showAtoF", "showAtoEF", "showAB", "showAC", "showEB", "showCF", "showmBC"};

    String[] centralAngleChordAnimeArr = {"8_3_1", "8_3_1", "8_3_1", "8_3_2", "8_3_2", "8_3_3", "8_3_3", "8_3_3", "8_3_4", "8_3_5", "8_3_5", "8_3_5", "8_3_6", "8_3_6", "8_3_6", "8_3_7", "8_3_7", "8_3_7", "8_3_8", "8_3_8", "8_3_9", "8_3_9", "8_3_9"};

    String[] inscribedAngleSPElementArr = {"hover_1", "hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_2", "hover_1", "hover_2", "hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_2", "hover_3", "hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_2", "hover_1", "hover_2", "hover_1", "hover_2", "hover_3"};

    String[] inscribedAngleAnimeArr = {"8_4_1", "8_4_2", "8_4_2", "8_4_2", "8_4_2", "8_4_3_1", "8_4_3_1", "8_4_3_2", "8_4_3_2", "8_4_4", "8_4_4", "8_4_4", "8_4_4", "8_4_5", "8_4_5", "8_4_5", "8_4_6", "8_4_6", "8_4_6", "8_4_6", "8_4_7", "8_4_7", "8_4_8", "8_4_8", "8_4_9", "8_4_9", "8_4_9"};

    String[] inscribedCircleTriangleSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_1", "hover_1", "hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_1", "hover_1", "hover_1", "hover_2", "hover_3", "hover_4"};

    String[] inscribedCircleTriangleAnimeArr = {"8_5_1", "8_5_1", "8_5_1", "8_5_1", "8_5_3", "8_5_4", "8_5_5", "8_5_6", "8_5_6", "8_5_6", "8_5_6", "8_5_7", "8_5_8", "8_5_9", "8_5_10", "8_5_10", "8_5_10", "8_5_10"};

    String[] quadrilateralInscribedCircleSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_1", "hover_2", "hover_3", "hover_1", "hover_2", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6", "hover_7", "hover_8"};

    String[] quadrilateralInscribedCircleAnimeArr = {"8_6_1", "8_6_1", "8_6_1", "8_6_2_Interactive", "8_6_2_Interactive", "8_6_2_Interactive", "8_6_3", "8_6_3", "8_6_4", "8_6_4", "8_6_4", "8_6_4", "8_6_4", "8_6_4", "8_6_7", "8_6_7", "8_6_7", "8_6_7", "8_6_7", "8_6_7", "8_6_7", "8_6_7"};

    String[] tangentLineCircleSPElementArr = {"showLine", "showCircle", "showPoint", "showLine" , "showCircle", "showPerpendicular", "showPC≅QC", "showAC≅AC", "showPA≅QA", "show∠PAQ", "show∠AQC", "show∠CPA", "showPoint", "showLine", "showDA", "showEA", "showEC"};

    String[] tangentLineCircleAnimeArr = {"8_7_1", "8_7_1", "8_7_1", "8_7_2", "8_7_2", "8_7_3", "8_7_4", "8_7_5", "8_7_5", "8_7_6", "8_7_6", "8_7_6", "8_7_7", "8_7_7", "8_7_11", "8_7_11", "8_7_11"};

    String[] secantLineCircleSPElementArr = {"twoPoints", "ce", "db", "tricef", "anglebce", "arcbe", "ced", "ecf", "db", "cbd", "bde", "anglebfe", "arcbe", "cb+bf", "cfb+bfg"};

    String[] secantLineCircleAnimeArr = {"8_8_1", "8_8_2", "8_8_2", "8_8_2", "8_8_2", "8_8_2", "8_8_3", "8_8_3", "8_8_4", "8_8_4", "8_8_4", "8_8_5", "8_8_5", "8_8_6", "8_8_6"};

    String[] arcLengthSPElementArr = {"arcdc", "arcgh", "oneradian", "equalltoradius", "twosectors", "samecentralangle", "vector", "translate", "rotate", "dilate", "onesectortoanother", "r", "samecentralangle", "mGH", "arcGH"};

    String[] arcLengthAnimeArr = {"8_9_1", "8_9_1", "8_9_2", "8_9_2", "8_9_3_1", "8_9_3_1", "8_9_3_2", "8_9_3_2", "8_9_3_3", "8_9_4", "8_9_4", "8_9_5", "8_9_5", "8_9_6", "8_9_6"};

    String[] sectorAreaSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_1", "hover_1", "hover_2", "hover_3", "hover_1", "hover_1", "hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_2"};

    String[] sectorAreaAnimeArr = {"8_10_1", "8_10_1", "8_10_1", "8_10_1", "8_10_1", "8_10_2", "8_10_3", "8_10_3", "8_10_3", "8_10_4", "8_10_6", "8_10_7", "8_10_7", "8_10_7", "8_10_7", "8_10_8", "8_10_8"};

    String[] cylindersSPElementArr = {"showRectangularPrism", "showCylinder", "showArea", "showHeight", "showCrossSection", "showVolume", "showHeight", "showBase", "showHeight"};

    String[] cylindersAnimeArr = {"9_1_1", "9_1_1", "9_1_1", "9_1_1", "9_1_1", "9_1_1", "9_1_2", "9_1_2", "9_1_4"};

    String[] pyramidsAndConeSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_1", "hover_2", "hover_1", "hover_1", "hover_1", "hover_2", "hover_1"};

    String[] pyramidsAndConeAnimeArr = {"9_2_1", "9_2_1", "9_2_1", "9_2_2", "9_2_2", "9_2_2", "9_2_2", "9_2_2", "9_2_3", "9_2_3", "9_2_4", "9_2_5", "9_2_6", "9_2_6", "9_2_7"};

    String[] spheresSPElementArr = {"showEquidistantPoints", "highlightSphereRadius", "highlightSphereCenter", "highlightGreatCircle", "highlightSmallCircle", "showCylinderVolume", "showSphereVolume", "shshowConeVolumeowBase", "showDoubleConeVolume", "showSpaceBetween",
            "showHalfCone", "showHalfSphere", "showCylinderTop", "showSphereTop", "showConeCrossSection", "showSphereCrossSection", "showConeArea", "showSphereArea"};

    String[] spheresAnimeArr = {"9_3_1", "9_3_1", "9_3_1", "9_3_1", "9_3_1", "9_3_2", "9_3_2", "9_3_2", "9_3_2", "9_3_2", "9_3_3", "9_3_3", "9_3_3", "9_3_3", "9_3_4", "9_3_4", "9_3_5", "9_3_5"};

    String[] connectionTwoThreeDimSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_1", "hover_1", "hover_2", "hover_3", "hover_1", "hover_5", "hover_2", "hover_3", "hover_4", "hover_1", "hover_2", "hover_3", "hover_1", "hover_2", "hover_3"};

    String[] connectionTwoThreeDimAnimeArr = {"9_4_1", "9_4_1", "9_4_1", "9_4_1", "9_4_1b", "9_4_2", "9_4_3", "9_4_3", "9_4_3", "9_4_4", "9_4_4", "9_4_4", "9_4_4", "9_4_4", "9_4_6", "9_4_6", "9_4_6", "9_4_8", "9_4_8", "9_4_8"};

    String[] modelingThreeDimSPElementArr = {"between0and4", "maximumvolume"};

    String[] modelingThreeDimAnimeArr = {"9_5_2", "9_5_3"};

    String[] designProblemThreeDimSPElementArr = {"showUnwrap", "showArcLength", "showSlantHeight"};

    String[] designProblemThreeDimAnimeArr = {"9_7_6", "9_7_6", "9_7_6"};

    String[] conicSectionsSPElementArr = {"circle", "ellipse", "parabola", "hyperbola", "crossSection", "crossSection", "crossSection", "crossSection", "point", "line", "intersectingline"};

    String[] conicSectionsAnimeArr = {"10_1_1", "10_1_1", "10_1_1", "10_1_1", "10_1_6", "10_1_7", "10_1_9", "10_1_10", "10_1_11", "10_1_11", "10_1_11"};

    String[] equationCirclesSPElementArr = {"pxy", "op", "righttriangle", "pxy", "center", "radius", "xminush", "yminusk", "r", "xsquare"};

    String[] equationCirclesAnimeArr = {"10_2_1", "10_2_1", "10_2_1", "10_2_2", "10_2_3_1", "10_2_3_1", "10_2_3_2", "10_2_3_2", "10_2_3_2", "10_2_3a"};

    String[] equationParabolaSPElementArr = {"parabola", "setOfPoints", "focus", "directrix", "vertex", "pfromfocus", "pfromvertex", "directrix", "focus", "point", "righttriangle", "twolegs", "hypotenuse", "directrix", "distance", "samedistance", "distanceincreases", "sketch", "sketch"};

    String[] equationParabolaAnimeArr = {"10_3_1", "10_3_1", "10_3_1", "10_3_1", "10_3_2", "10_3_2", "10_3_2", "10_3_2", "10_3_2", "10_3_3", "10_3_3", "10_3_4", "10_3_4", "10_3_4a", "10_3_5", "10_3_5", "10_3_6", "10_3_7", "10_3_8"};

    String[] slopeParallelPerpndLineSPElementArr = {"hover_1", "hover_1", "hover_1", "hover_2", "hover_1", "hover_2", "hover_3", "hover_4", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_1", "hover_2", "hover_3", "hover_4", "hover_5", "hover_6", "hover_7", "hover_8"};

    String[] slopeParallelPerpndLineAnimeArr = {"10_4_1", "10_4_2", "10_4_3", "10_4_3", "10_4_3a", "10_4_3a", "10_4_3a", "10_4_3a", "10_4_4_1", "10_4_4_2", "10_4_4_2", "10_4_4_2", "10_4_4_2", "10_4_4a", "10_4_4a", "10_4_4a", "10_4_4a", "10_4_4a", "10_4_4a", "10_4_4a", "10_4_4a"};

    String[] distanceFormulaSPElementArr = {"showDistance", "showBC", "showAC", "showCounting", "showAB", "showDistance", "showRightTriangle", "showX2-X1", "showY2-Y1", "showHypotenuse", "showDistance", "showPerimeter", "showAB", "showBC", "showAC", "showArea", "showPtOfIntersection", "showBase", "showHeight", "showSameLength", "showPerimeter"};

    String[] distanceFormulaAnimeArr = {"10_5_1", "10_5_2", "10_5_2", "10_5_2", "10_5_2", "10_5_3", "10_5_4", "10_5_4", "10_5_4", "10_5_4", "10_5_5", "10_5_9", "10_5_9", "10_5_9", "10_5_9", "10_5_11", "10_5_13", "10_5_13", "10_5_13", "10_5_14", "10_5_14"};

    String[] pointPartLineSegSPElementArr = {"showAB", "showP", "showAP", "showPB", "showRightTriangles", "showAP", "showPB", "showBase", "showHeight", "showRightAngle", "showAB", "showA=(10,2)", "showB=(4,1)", "showP", "show3Medians", "showCentroid", "showMidpointBC"};

    String[] pointPartLineSegAnimeArr = {"10_6_1", "10_6_1", "10_6_1", "10_6_1", "10_6_2", "10_6_2", "10_6_2", "10_6_2", "10_6_2", "10_6_2", "10_6_5", "10_6_5", "10_6_5", "10_6_5", "10_6_6", "10_6_6", "10_6_6"};

    String[] coordinateProofSPElementArr = {"hover_1", "hover_2", "hover_3", "hover_1", "hover_2", "hover_3", "hover_1", "hover_1", "hover_2", "hover_1", "hover_2", "hover_1", "hover_1"};

    String[] coordinateProofAnimeArr = {"10_7_1", "10_7_1", "10_7_1", "10_7_2", "10_7_2", "10_7_2", "10_7_2a", "10_7_3", "10_7_3", "10_7_5", "10_7_5", "10_7_6", "10_7_7"};

    String[] descriptionEventSPElementArr = {"experiment", "oneOutcome", "secondOutcome", "samplespace", "eventE", "eventF", "samplespace", "evente", "eventf", "bothevents", "notInEventF", "union", "intersection", "threeCoins", "sampleSpace", "eventA", "eventB", "spades", "diamonds", "clubs", "hearts", "eventD", "eventE", "dedUnionE", "exactlytwoheads", "notexactlytwoheads"};

    String[] descriptionEventAnimeArr = {"11_1_0a", "11_1_0a", "11_1_0a", "11_1_0a", "11_1_0b", "11_1_0b", "11_1_1", "11_1_1", "11_1_1", "11_1_1", "11_1_2", "11_1_3", "11_1_4", "11_1_5", "11_1_5", "11_1_5", "11_1_5", "11_1_5a", "11_1_5a", "11_1_5a", "11_1_5a", "11_1_5b", "11_1_5b", "11_1_5b", "11_1_6", "11_1_6"};

    String[] independentEventSPElementArr = {"numberofgreensectors", "numberofsectors", "numberofvowelcards", "numberofcards", "probability", "samplespace", "exactlyonce", "probabilitya", "samplespace", "firstCoinHead", "secondCoinTail", "headFirstTailSecond", "samplespace", "firstCoinIsHead", "bothCoinsAreHead"};

    String[] independentEventAnimeArr = {"11_2_0b", "11_2_0b", "11_2_0b", "11_2_0b", "11_2_0c", "11_2_0d", "11_2_0d", "11_2_0d", "11_2_0f", "11_2_0f", "11_2_0f", "11_2_0g", "11_2_0h", "11_2_0h", "11_2_0h"};

    String[] conditionProbabilitySPElementArr = {"ninthgrade", "gotana", "sampleSpace", "studentGotA", "restrict", "gettingAtleast2Heads", "getting3Heads", "sampleSpace", "gettingAtleast2Heads", "regularcoin", "specialcoin", "heads", "outcome", "specialCoinAndHeads", "heads"};

    String[] conditionProbabilityAnimeArr = {"11_3_1", "11_3_1", "11_3_1a", "11_3_1a", "11_3_1a", "11_3_1b", "11_3_1b", "11_3_1b", "11_3_1c", "11_3_1e", "11_3_1e", "11_3_1e", "11_3_1e", "11_3_1f", "11_3_1f"};

    String[] twoWayFrequencySPElementArr = {"showCable", "showVacation", "showVacationAndCable", "showNoVacationAndCable", "showCableTotal", "showNoCableTotal", "showVacation", "showVacation", "showCable", "showCableTotal", "showVacationAndCable", "showVacation", "showSampleSpace", "showMasqueradeTotal", "showCatsTotal", "show10Total"};

    String[] twoWayFrequencyAnimeArr = {"11_4_1", "11_4_1", "11_4_1", "11_4_1", "11_4_1", "11_4_1", "11_4_2", "11_4_3", "11_4_3", "11_4_3", "11_4_3", "11_4_4", "11_4_5", "11_4_5", "11_4_6", "11_4_6"};

    String[] everydayProbabilitySPElementArr = {"showFormerOlympian", "showConditionalProbability", "showRandomPlayer", "showTruePositive", "showFalseNegative", "showSpam", "showFiltered", "showSpam", "showNotSpam1", "showSpam2", "showBus"};

    String[] everydayProbabilityAnimeArr = {"11_5_1", "11_5_1", "11_5_1", "11_5_2", "11_5_2", "11_5_3", "11_5_3", "11_5_5", "11_5_6", "11_5_6", "11_5_7"};

    String[] probabilityUnionSPElementArr = {"showSampleSpace", "showA", "showB", "showUnion", "showIntersection", "showA", "showB", "showA", "showB", "showUnion", "showA"};

    String[] probabilityUnionAnimeArr = {"11_6_1", "11_6_2", "11_6_2", "11_6_3", "11_6_3", "11_6_4", "11_6_4", "11_6_6", "11_6_6", "11_6_6", "11_6_7"};

    String[] probabilityIntersectionSPElementArr = {"showSampleSpace", "showA", "showB", "showIntersection", "showA", "showB", "showUnion", "showIntersection", "showIntersection"};

    String[] probabilityIntersectionAnimeArr = {"11_7_1", "11_7_1", "11_7_1", "11_7_1", "11_7_2", "11_7_2", "11_7_2", "11_7_2", "11_7_3"};

    String[] permutationCombSPElementArr = {"show5Flavours", "showDishOrCone", "show10IceCream", "showA", "showB", "showCombo"};

    String[] permutationCombAnimeArr = {"11_8_1", "11_8_1", "11_8_1", "11_8_2", "11_8_2", "11_8_2"};

    String[] probabilityToAnalyzeSPElementArr = {"showRed", "showSilver", "showSampleSpace", "showMoreHeads", "showMoreTails", "showFairGame", "showSampleSpace", "showEvenHead", "showOddHead", "showFairGame"};

    String[] probabilityToAnalyzeAnimeArr = {"11_9_1", "11_9_1", "11_9_3", "11_9_3", "11_9_3", "11_9_3", "11_9_4", "11_9_4", "11_9_4", "11_9_4"};

    public boolean baseGeometrySPImages(String[] spArr, String[] animeArr, String unit) {
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathBase);

        String[] smartPhaseElementArr = spArr;
        String[] animationElementArr = animeArr;

        int totalSPVerified=0;
        for(int count = 0; count < smartPhaseElementArr.length; count++) {
            String splocator = "xpath" + "_TBD_" + "//span[@data-embed-id='IG_" + animationElementArr[count] + "' and @data-mousein='" + smartPhaseElementArr[count]+ "']";
            String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='IG_" + animationElementArr[count] + "']//*[local-name()='svg']";
            System.out.println("*************** splocator is; " + splocator);
            System.out.println("*************** svglocator is; " + animlocator);
            GuiControl spElem = new GuiControl(splocator, webDriver);
            GuiControl animElem = new GuiControl(animlocator, webDriver);

            try {
                waitForSec(1);
                Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName(count+"_imgBefore").save(filePathBase);
                System.out.println("###################################################Path is: " + filePathBase +count+"_imgBefore.png");

                spElem.mouseHover();
                waitForSec(5);
                Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName(count+"_imgAfter").save(filePathBase);
                System.out.println("###################################################Path is: " + filePathBase +count+"_imgAfter.png");

                animElem.click();
                waitForSec(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            totalSPVerified++;
        }
        System.out.println("Total Smart Phrases verified: " + totalSPVerified);
        return true;
    }

    public boolean verifyGeometrySmartPhases(String test, String unit) {
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathAfterCmp);

        if (test.equals("Three Dimension")){
            spElementArr = threeDimensionSPElementArr;
            animElementArr = threeDimensionAnimeArr;
        } else if (test.equals("Angles and Lines")){
            spElementArr = anglesLinesSPElementArr;
            animElementArr= angleslinesAnimeArr;
        } else if (test.equals("Polygons")){
            spElementArr = polygonsSPElementArr;
            animElementArr= polygonsAnimeArr;
        } else if (test.equals("Triangles")){
            spElementArr = trianglesSPElementArr;
            animElementArr= trianglesAnimeArr;
        } else if (test.equals("Quadrilaterals")){
            spElementArr = quadrilateralsSPElementArr;
            animElementArr= quadrilateralsAnimeArr;
        } else if (test.equals("Area or Perimeter of Triangles and Quadrilaterals")){
            spElementArr = aopOfTrianglesAndQuadrilateralSPElementArr;
            animElementArr= aopOfTrianglesAndQuadrilateralAnimeArr;
        } else if (test.equals("The Pythagorean Theorem")){
            spElementArr = thePythagoreanTheoremSPElementArr;
            animElementArr= thePythagoreanTheoremAnimeArr;
        } else if (test.equals("Circles")){
            spElementArr = circlesSPElementArr;
            animElementArr= circlesAnimeArr;
        } else if (test.equals("Composite Shapes")){
            spElementArr = compositeShapesSPElementArr;
            animElementArr= compositeShapesAnimeArr;
        } else if (test.equals("Volume Of Solids")){
            spElementArr = volumeOfSolidsSPElementArr;
            animElementArr= volumeOfSolidsAnimeArr;
        } else if (test.equals("Cross Sections of Solids")){
            spElementArr = crossSectionsOfSolidsSPElementArr;
            animElementArr= crossSectionOfSolidsAnimeArr;
        } else if (test.equals("Surface Area and Nets")){
            spElementArr = surfaceAreaAndNetsSPElementArr;
            animElementArr= surfaceAreaAndNetsAnimeArr;
        } else if (test.equals("Transformations in the Plane")){
            spElementArr = transformationPlaneSPElementArr;
            animElementArr= transformationPlaneAnimeArr;
        } else if (test.equals("Translations")){
            spElementArr = translationsSPElementArr;
            animElementArr= translationsAnimeArr;
        } else if (test.equals("Geometry Software for Translations")){
            spElementArr = geometrySoftwareSPElementArr;
            animElementArr= geometrySoftwareAnimeArr;
        } else if (test.equals("Reflections")){
            spElementArr = reflectionSPElementArr;
            animElementArr= reflectionAnimeArr;
        } else if (test.equals("Geometry Software for Reflections")){
            spElementArr = geometrySoftwareOfReflectionSPElementArr;
            animElementArr= geometrySoftwareOfReflectionAnimeArr;
        } else if (test.equals("Reflection Symmetry")){
            spElementArr = reflectionSymmetrySPElementArr;
            animElementArr= reflectionSymmetryAnimeArr;
        } else if (test.equals("Rotations")){
            spElementArr = rotationsSPElementArr;
            animElementArr= rotationAnimeArr;
        } else if (test.equals("Geometry Software for Rotations")){
            spElementArr = geometrySoftwareOfRotationSPElementArr;
            animElementArr= geometrySoftwareOfRotationAnimeArr;
        } else if (test.equals("Rotation Symmetry")){
            spElementArr = rotationSymmetrySPElementArr;
            animElementArr= rotationSymmetryAnimeArr;
        } else if (test.equals("Composite Transformations")){
            spElementArr = compositeTransformationsSPElementArr;
            animElementArr= compositeTransformationsAnimeArr;
        } else if (test.equals("Tangent Ratio")){
            spElementArr = tangentRatioSPElementArr;
            animElementArr= tangentRatioAnimeArr;
        } else if (test.equals("Sine and Cosine Ratios")){
            spElementArr = sineAndCosineRatioSPElementArr;
            animElementArr= sineAndCosineRatioAnimeArr;
        } else if (test.equals("Sine and Cosine of Complementary Angles")){
            spElementArr = sineAndCosineCompAnglesSPElementArr;
            animElementArr= sineAndCosineCompAnglesAnimeArr;
        } else if (test.equals("Inverse Trigonometric Ratios")){
            spElementArr = inverseTrigonometricRatioSPElementArr;
            animElementArr= inverseTrigonometricRatioAnimeArr;
        } else if (test.equals("Sine to Find the Area of a Triangle")){
            spElementArr = sineFindAreaOfTriangleSPElementArr;
            animElementArr= sineFindAreaOfTriangleAnimeArr;
        } else if (test.equals("Law of Sines")){
            spElementArr = lawOfSineSPElementArr;
            animElementArr= lawOfSineAnimeArr;
        } else if (test.equals("Law of Cosines")){
            spElementArr = lawOfCosineSPElementArr;
            animElementArr= lawOfCosineAnimeArr;
        } else if (test.equals("Triangles in Applied Problems")){
            spElementArr = triangleAppliedProblemSPElementArr;
            animElementArr= triangleAppliedProblemAnimeArr;
        } else if (test.equals("Cylinders")){
            spElementArr = cylindersSPElementArr;
            animElementArr= cylindersAnimeArr;
        } else if (test.equals("Pyramids and Cones")){
            spElementArr = pyramidsAndConeSPElementArr;
            animElementArr= pyramidsAndConeAnimeArr;
        } else if (test.equals("Spheres")){
            spElementArr = spheresSPElementArr;
            animElementArr= spheresAnimeArr;
        } else if (test.equals("Connections Between Two and Three Dimensions")){
            spElementArr = connectionTwoThreeDimSPElementArr;
            animElementArr= connectionTwoThreeDimAnimeArr;
        } else if (test.equals("Modeling in Three Dimensions")){
            spElementArr = modelingThreeDimSPElementArr;
            animElementArr= modelingThreeDimAnimeArr;
        } else if (test.equals("Design Problems in Three Dimensions")){
            spElementArr = designProblemThreeDimSPElementArr;
            animElementArr= designProblemThreeDimAnimeArr;
        } else if (test.equals("Conic Sections")){
            spElementArr = conicSectionsSPElementArr;
            animElementArr= conicSectionsAnimeArr;
        } else if (test.equals("Equations of Circles")){
            spElementArr = equationCirclesSPElementArr;
            animElementArr= equationCirclesAnimeArr;
        } else if (test.equals("Equations of Parabolas")){
            spElementArr = equationParabolaSPElementArr;
            animElementArr= equationParabolaAnimeArr;
        } else if (test.equals("Slope of Parallel and Perpendicular Lines")){
            spElementArr = slopeParallelPerpndLineSPElementArr;
            animElementArr= slopeParallelPerpndLineAnimeArr;
        } else if (test.equals("The Distance Formula")){
            spElementArr = distanceFormulaSPElementArr;
            animElementArr= distanceFormulaAnimeArr;
        } else if (test.equals("Points that Partition Line Segments")){
            spElementArr = pointPartLineSegSPElementArr;
            animElementArr= pointPartLineSegAnimeArr;
        } else if (test.equals("Coordinate Proofs")){
            spElementArr = coordinateProofSPElementArr;
            animElementArr= coordinateProofAnimeArr;
        } else if (test.equals("Descriptions of Events")){
            spElementArr = descriptionEventSPElementArr;
            animElementArr= descriptionEventAnimeArr;
        } else if (test.equals("Independent Events")){
            spElementArr = independentEventSPElementArr;
            animElementArr= independentEventAnimeArr;
        } else if (test.equals("Conditional Probability")){
            spElementArr = conditionProbabilitySPElementArr;
            animElementArr= conditionProbabilityAnimeArr;
        } else if (test.equals("Two-Way Frequency Tables")){
            spElementArr = twoWayFrequencySPElementArr;
            animElementArr= twoWayFrequencyAnimeArr;
        } else if (test.equals("Everyday Examples of Independence and Probability")){
            spElementArr = everydayProbabilitySPElementArr;
            animElementArr= everydayProbabilityAnimeArr;
        } else if (test.equals("Probability of Unions")){
            spElementArr = probabilityUnionSPElementArr;
            animElementArr= probabilityUnionAnimeArr;
        } else if (test.equals("Probability of Intersections")){
            spElementArr = probabilityIntersectionSPElementArr;
            animElementArr= probabilityIntersectionAnimeArr;
        } else if (test.equals("Permutations and Combinations")){
            spElementArr = permutationCombSPElementArr;
            animElementArr= permutationCombAnimeArr;
        } else if (test.equals("Probability to Analyze Fairness and Decisions")){
            spElementArr = probabilityToAnalyzeSPElementArr;
            animElementArr= probabilityToAnalyzeAnimeArr;
        } else if (test.equals("Definition of Congruence")){
            spElementArr = defOfCongruenceSPElementArr;
            animElementArr= defOfCongruenceAnimeArr;
        } else if (test.equals("ASA and AAS Triangle Congruence")){
            spElementArr = aasTriangleCongruenceSPElementArr;
            animElementArr= aasTriangleCongruenceAnimeArr;
        } else if (test.equals("SAS Triangle Congruence")){
            spElementArr = sasTriangleCongruenceSPElementArr;
            animElementArr= sasTriangleCongruenceAnimeArr;
        } else if (test.equals("SSS Triangle Congruence")){
            spElementArr = sssTriangleCongruenceSPElementArr;
            animElementArr= sssTriangleCongruenceAnimeArr;
        } else if (test.equals("Applications of Congruent Triangles")){
            spElementArr = appCongruentTriangleSPElementArr;
            animElementArr= appCongruentTriangleAnimeArr;
        } else if (test.equals("Theorems and Proofs")){
            spElementArr = theoremProofSPElementArr;
            animElementArr= theoremProofAnimeArr;
        } else if (test.equals("Theorems about Lines and Angles")){
            spElementArr = theoremLinesAngleSPElementArr;
            animElementArr= theoremLinesAngleAnimeArr;
        } else if (test.equals("Applications of Line and Angle Theorems")){
            spElementArr = appLinesAngleTheoremSPElementArr;
            animElementArr= appLinesAngleTheoremAnimeArr;
        } else if (test.equals("Theorems about Triangles")){
            spElementArr = theoremTriangleSPElementArr;
            animElementArr= theoremTriangleAnimeArr;
        } else if (test.equals("Theorems about Concurrence in Triangles")){
            spElementArr = theoremConcurrenceTriangleSPElementArr;
            animElementArr= theoremConcurrenceTriangleAnimeArr;
        } else if (test.equals("Applications of Triangle Theorems")){
            spElementArr = appTriangleTheoremSPElementArr;
            animElementArr= appTriangleTheoremAnimeArr;
        } else if (test.equals("Theorems about Quadrilaterals")){
            spElementArr = theoremQuadrilateralSPElementArr;
            animElementArr= theoremQuadrilateralAnimeArr;
        } else if (test.equals("Applications of Quadrilateral Theorems")){
            spElementArr = appQuadrilateralTheoremSPElementArr;
            animElementArr= appQuadrilateralTheoremAnimeArr;
        } else if (test.equals("Copies of Line Segments and Angles")){
            spElementArr = copyLineSegAnglesSPElementArr;
            animElementArr= copyLineSegAnglesAnimeArr;
        } else if (test.equals("Bisectors of Line Segments and Angles")){
            spElementArr = bisectorLineSegAnglesSPElementArr;
            animElementArr= bisectorLineSegAnglesAnimeArr;
        } else if (test.equals("Parallel and Perpendicular Line Constructions")){
            spElementArr = parallelPerpLineConstSPElementArr;
            animElementArr= parallelPerpLineConstAnimeArr;
        } else if (test.equals("Constructions of Regular Polygons")){
            spElementArr = constRegularPolygonsSPElementArr;
            animElementArr= constRegularPolygonsAnimeArr;
        } else if (test.equals("Dilations")){
            spElementArr = dilationsSPElementArr;
            animElementArr= dilationsAnimeArr;
        } else if (test.equals("Definition of Similarity")){
            spElementArr = defSimilaritySPElementArr;
            animElementArr= defSimilarityAnimeArr;
        } else if (test.equals("AA Triangle Similarity")){
            spElementArr = aaTriangleSimilaritySPElementArr;
            animElementArr= aaTriangleSimilarityAnimeArr;
        } else if (test.equals("SAS Triangle Similarity")){
            spElementArr = sasTriangleSimilaritySPElementArr;
            animElementArr= sasTriangleSimilarityAnimeArr;
        } else if (test.equals("SSS Triangle Similarity")){
            spElementArr = sssTriangleSimilaritySPElementArr;
            animElementArr= sssTriangleSimilarityAnimeArr;
        } else if (test.equals("Theorems Involving Similarity")){
            spElementArr = theoryInsolveSimilaritySPElementArr;
            animElementArr= theoryInsolveSimilarityAnimeArr;
        } else if (test.equals("Applications of Similar Triangles")){
            spElementArr = appSimilarTriangleSPElementArr;
            animElementArr= appSimilarTriangleAnimeArr;
        } else if (test.equals("Circles and Similarity")){
            spElementArr = circleSimilaritySPElementArr;
            animElementArr= circleSimilarityAnimeArr;
        } else if (test.equals("Area and Circumference of Circles")){
            spElementArr = areaCircumferenceCircleSPElementArr;
            animElementArr= areaCircumferenceCircleAnimeArr;
        } else if (test.equals("Central Angles and Chords")){
            spElementArr = centralAngleChordSPElementArr;
            animElementArr= centralAngleChordAnimeArr;
        } else if (test.equals("Inscribed Angles")){
            spElementArr = inscribedAngleSPElementArr;
            animElementArr= inscribedAngleAnimeArr;
        } else if (test.equals("Inscribed and Circumscribed Circles of Triangles")){
            spElementArr = inscribedCircleTriangleSPElementArr;
            animElementArr= inscribedCircleTriangleAnimeArr;
        } else if (test.equals("Quadrilaterals Inscribed in Circles")){
            spElementArr = quadrilateralInscribedCircleSPElementArr;
            animElementArr= quadrilateralInscribedCircleAnimeArr;
        } else if (test.equals("Tangent Lines to Circles")){
            spElementArr = tangentLineCircleSPElementArr;
            animElementArr= tangentLineCircleAnimeArr;
        } else if (test.equals("Secant Lines to Circles")){
            spElementArr = secantLineCircleSPElementArr;
            animElementArr= secantLineCircleAnimeArr;
        } else if (test.equals("Arc Length")){
            spElementArr = arcLengthSPElementArr;
            animElementArr= arcLengthAnimeArr;
        } else if (test.equals("Sector Area")){
            spElementArr = sectorAreaSPElementArr;
            animElementArr= sectorAreaAnimeArr;
        }

        baseGeometrySPImages(spElementArr, animElementArr, unit);


        int totalSPVerified=0;
        int correctBeforeImageComparisons=0;
        int correctAfterImageComparisons=0;

        for(int count = 0; count < spElementArr.length; count++) {
            String splocator = "xpath" + "_TBD_" + "//span[@data-embed-id='IG_" +animElementArr[count] + "' and @data-mousein='" + spElementArr[count]+ "']";
            String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='IG_" + animElementArr[count] + "']//*[local-name()='svg']";
            System.out.println("*************** splocator is; " + splocator);
            System.out.println("*************** svglocator is; " + animlocator);
            GuiControl spElem = new GuiControl(splocator, webDriver);
            GuiControl animElem = new GuiControl(animlocator, webDriver);

            try {
                waitForSec(1);
                BufferedImage biBefore = ImageIO.read(new File(filePathBase + File.separator +count+"_imgBefore.png"));
                boolean beforeComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                        equalsWithDiff(biBefore, filePathAfterCmp +count+"_imgBeforeDiff", 0.1);

                if(beforeComp) {
                    correctBeforeImageComparisons++;
                }

                spElem.mouseHover();
                waitForSec(5);
                BufferedImage biAfter = ImageIO.read(new File(filePathBase + File.separator +count+"_imgAfter.png"));
                boolean afterComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                        equalsWithDiff(biAfter, filePathAfterCmp +count+"_imgAfterDiff", 0.1);

                if(afterComp) {
                    correctAfterImageComparisons++;
                }

                waitForSec(1);
                animElem.click();

            } catch (Exception e) {
                e.printStackTrace();
            }
            totalSPVerified++;
        }
        System.out.println("Total Smart Phrases verified: " + totalSPVerified);
        System.out.println("Total before images verifed correctly " + correctBeforeImageComparisons);
        System.out.println("Total after images verifed correctly " + correctAfterImageComparisons);
        return true;
    }

    public boolean baseDraggableInteractives(String interactive, String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathBase);

        GuiControl draggableDot = null;

        String interactiveButton = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.interactivity-button.interactive-button";
        String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='IG_" + interactive + "']//*[local-name()='svg']";
        GuiControl IAButton = new GuiControl(interactiveButton, webDriver);
        GuiControl animElem = new GuiControl(animlocator, webDriver);
        System.out.println("*************** IAButton is; " + interactiveButton);
        System.out.println("*************** svglocator is; " + animlocator);

        builder.moveToElement(IAButton.getWebElement()).build().perform();
        IAButton.click();

        waitForSec(1);
        Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName("baseDraggableIA").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "baseDraggableIA.png");

        String draggable1 = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g circle[data-index='0']";
        GuiControl dragDot1 = new GuiControl(draggable1, webDriver);
        System.out.println("*************** 1st Draggable dot is; " + draggable1);
        String draggable2 = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g circle[data-index='1']";
        GuiControl dragDot2 = new GuiControl(draggable2, webDriver);
        System.out.println("*************** 1st Draggable dot is; " + draggable2);
        if (dragDot1.isElementPresent()){
            draggableDot = dragDot1;
        } else {
            draggableDot = dragDot2;
        }
        draggableDot.doubleClick();
        builder.moveToElement(draggableDot.getWebElement(), 15, 15);
        System.out.println("Element Dragged");
        waitForSec(2);

        Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName("afterDraggableIA").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "afterDraggableIA.png");

        String reset = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.reset-button.interactive-button";
        GuiControl resetButton = new GuiControl(reset, webDriver);
        System.out.println("*************** Reset Button; " + resetButton);
        resetButton.click();
        waitForSec(2);

        return true;
    }

    public boolean verifyDraggableInteractive(String interactive, String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathAfterCmp);

        GuiControl draggableDot = null;

        int correctBeforeImageComparisons=0;
        int correctAfterImageComparisons=0;

        baseDraggableInteractives(interactive, unit);

        String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='IG_" + interactive + "']//*[local-name()='svg']";
        GuiControl animElem = new GuiControl(animlocator, webDriver);
        System.out.println("*************** svglocator is; " + animlocator);

        try {
            BufferedImage biBefore = ImageIO.read(new File(filePathBase + File.separator +"baseDraggableIA.png"));
            boolean beforeComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                    equalsWithDiff(biBefore, filePathAfterCmp +"baseDraggableIADiff", 0.1);

            if(beforeComp) {
                correctBeforeImageComparisons++;
            }

            String draggable1 = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g circle[data-index='0']";
            GuiControl dragDot1 = new GuiControl(draggable1, webDriver);
            System.out.println("*************** 1st Draggable dot is; " + draggable1);
            String draggable2 = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g circle[data-index='1']";
            GuiControl dragDot2 = new GuiControl(draggable2, webDriver);
            System.out.println("*************** 1st Draggable dot is; " + draggable2);
            if (dragDot1.isElementPresent()){
                draggableDot = dragDot1;
            } else {
                draggableDot = dragDot2;
            }
            draggableDot.doubleClick();
            builder.moveToElement(draggableDot.getWebElement(), 35, 35);
            System.out.println("Element Dragged");
            waitForSec(2);

            BufferedImage biAfter = ImageIO.read(new File(filePathBase + File.separator + "afterDraggableIA.png"));
            boolean afterComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                    equalsWithDiff(biAfter, filePathAfterCmp + "afterDraggableIADiff", 0.1);

            if(afterComp) {
                correctAfterImageComparisons++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Total before images verifed correctly " + correctBeforeImageComparisons);
        System.out.println("Total after images verifed correctly " + correctAfterImageComparisons);
        return true;
    }

    public boolean baseEquationInteractive(String interactive, String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathBase);

        String interactiveButton = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.play-button.interactive-button";
        String forward = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.skip-to-next-button.interactive-button";
        String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='IG_" + interactive + "']//*[local-name()='svg']";
        String reset = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.reset-button.interactive-button";
        GuiControl playIAButton = new GuiControl(interactiveButton, webDriver);
        GuiControl fastForward = new GuiControl(forward, webDriver);
        GuiControl animElem = new GuiControl(animlocator, webDriver);
        GuiControl resetButton = new GuiControl(reset, webDriver);
        System.out.println("*************** playIAButton is; " + interactiveButton);
        System.out.println("*************** fastForwardButton is; " + forward);
        System.out.println("*************** svglocator is; " + animlocator);
        System.out.println("*************** resetButton is; " + reset);

        builder.moveToElement(playIAButton.getWebElement()).build().perform();

        waitForSec(1);
        Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName("baseEquationIA").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "baseEquationIA.png");

        playIAButton.click();

        for (int i=0; i<10; i++){
            fastForward.click();
            waitForSec(1);
        }
        System.out.println("*************** Fast Forwarded");

        Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName("afterEquationIAPlayed").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "afterEquationIAPlayed.png");

        resetButton.isEnable();
        resetButton.click();

        return true;
    }

    public boolean verifyEquationInteractive(String interactive, String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathAfterCmp);

        int correctBeforeImageComparisons=0;
        int correctAfterImageComparisons=0;

        baseEquationInteractive(interactive, unit);

        String interactiveButton = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.play-button.interactive-button";
        String forward = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.skip-to-next-button.interactive-button";
        String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='IG_" + interactive + "']//*[local-name()='svg']";
        String reset = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_" + interactive + "'] g.reset-button.interactive-button";
        GuiControl playIAButton = new GuiControl(interactiveButton, webDriver);
        GuiControl fastForward = new GuiControl(forward, webDriver);
        GuiControl animElem = new GuiControl(animlocator, webDriver);
        GuiControl resetButton = new GuiControl(reset, webDriver);
        System.out.println("*************** playIAButton is; " + interactiveButton);
        System.out.println("*************** fastForwardButton is; " + forward);
        System.out.println("*************** svglocator is; " + animlocator);
        System.out.println("*************** resetButton is; " + reset);

        try {
            BufferedImage biBefore = ImageIO.read(new File(filePathBase + File.separator +"baseEquationIA.png"));
            boolean beforeComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                    equalsWithDiff(biBefore, filePathAfterCmp +"baseEquationIADiff", 0.1);

            if(beforeComp) {
                correctBeforeImageComparisons++;
            }

            playIAButton.click();

            for (int i=0; i<10; i++){
                fastForward.click();
                waitForSec(1);
            }
            System.out.println("*************** Fast Forwarded");

            BufferedImage biAfter = ImageIO.read(new File(filePathBase + File.separator + "afterEquationIAPlayed.png"));
            boolean afterComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                    equalsWithDiff(biAfter, filePathAfterCmp + "afterEquationIAPlayedDiff", 0.1);

            if(afterComp) {
                correctAfterImageComparisons++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Total before images verifed correctly " + correctBeforeImageComparisons);
        System.out.println("Total after images verifed correctly " + correctAfterImageComparisons);

        return true;
    }

    public boolean basePolygonDraggableInteractive(String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathBase);

        builder.moveToElement(polygonDraggableIAButton.getWebElement()).build().perform();
        polygonDraggableIAButton.click();

        waitForSec(1);
        Shutterbug.shootElementVerticallyCentered(webDriver, polygonDraggableIA.getWebElement()).withName("baseDraggableIA").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "baseDraggableIA.png");

        for (int count=1; count<=7; count++){
            polygonDraggableAddSide.click();
            waitForSec(1);
            Shutterbug.shootElementVerticallyCentered(webDriver, polygonDraggableIA.getWebElement()).withName(count+"_imgAfterSideAdded").save(filePathBase);
            System.out.println("###################################################Path is: " + filePathBase +count+"_imgAfterSideAdded.png");
        }

        polygonDraggableDot.doubleClick();
        builder.moveToElement(polygonDraggableDot.getWebElement(), 35, 35);
        System.out.println("Element Dragged");
        waitForSec(2);

        Shutterbug.shootElementVerticallyCentered(webDriver, polygonDraggableIA.getWebElement()).withName("afterDraggableIA").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "afterDraggableIA.png");

        polygonDraggableReset.isEnable();
        polygonDraggableReset.click();
        waitForSec(2);
        return true;
    }

    public boolean verifyPolygonDraggableInteractive(String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathAfterCmp);

        int correctBeforeImageComparisons=0;
        int correctAfterImageComparisons=0;

        basePolygonDraggableInteractive(unit);

        try {
            BufferedImage biBefore = ImageIO.read(new File(filePathBase + File.separator +"baseDraggableIA.png"));
            boolean beforeComp = Shutterbug.shootElementVerticallyCentered(webDriver, polygonDraggableIA.getWebElement()).
                    equalsWithDiff(biBefore, filePathAfterCmp +"baseDraggableIADiff", 0.1);

            if(beforeComp) {
                correctBeforeImageComparisons++;
            }

            for (int count=1; count<=7; count++){
                polygonDraggableAddSide.click();
                waitForSec(1);
                BufferedImage biAfter = ImageIO.read(new File(filePathBase + File.separator +count+"_imgAfterSideAdded.png"));
                boolean afterComp = Shutterbug.shootElementVerticallyCentered(webDriver, polygonDraggableIA.getWebElement()).
                        equalsWithDiff(biAfter, filePathAfterCmp +count+"_imgAfterSideAddedDiff", 0.1);

                if(afterComp) {
                    correctAfterImageComparisons++;
                }
            }

            polygonDraggableDot.doubleClick();
            builder.moveToElement(polygonDraggableDot.getWebElement(), 35, 35);
            System.out.println("Element Dragged");
            waitForSec(2);

            BufferedImage biAfterDrag = ImageIO.read(new File(filePathBase + File.separator +"afterDraggableIA.png"));
            boolean afterDrag = Shutterbug.shootElementVerticallyCentered(webDriver, polygonDraggableIA.getWebElement()).
                    equalsWithDiff(biAfterDrag, filePathAfterCmp +"afterDraggableIADiff", 0.1);

            if(afterDrag) {
                correctBeforeImageComparisons++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Total before images verifed correctly " + correctBeforeImageComparisons);
        System.out.println("Total after images verifed correctly " + correctAfterImageComparisons);
        return true;
    }

    public boolean baseQuadrilateralDraggableInteractive(String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathBase);
        int count = 1;

        builder.moveToElement(quadrilateralDraggableIAButton.getWebElement()).build().perform();
        quadrilateralDraggableIAButton.click();

        waitForSec(1);
        Shutterbug.shootElementVerticallyCentered(webDriver, quadrilateralDraggableIA.getWebElement()).withName("baseDraggableIA").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "baseDraggableIA.png");

        List<WebElement> addOns = quadrilateralDraggableAddon.getWebElements();

        for (WebElement addOn : addOns){
            addOn.click();
            waitForSec(1);
            Shutterbug.shootElementVerticallyCentered(webDriver, quadrilateralDraggableIA.getWebElement()).withName(count+"_imgAfterAddOn").save(filePathBase);
            System.out.println("###################################################Path is: " + filePathBase +count+"_imgAfterAddOn.png");
            count++;
        }

        quadrilateralDraggableDot.doubleClick();
        builder.moveToElement(quadrilateralDraggableDot.getWebElement(), 35, 35);
        System.out.println("Element Dragged");
        waitForSec(2);

        Shutterbug.shootElementVerticallyCentered(webDriver, quadrilateralDraggableIA.getWebElement()).withName("afterDraggableIA").save(filePathBase);
        System.out.println("###################################################Path is: " + filePathBase + "afterDraggableIA.png");

        quadrilateralDraggableReset.isEnable();
        quadrilateralDraggableReset.click();
        waitForSec(2);
        return true;
    }

    public boolean verifyQuadrilateralDraggableInteractive(String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathAfterCmp);
        int count = 1;

        int correctBeforeImageComparisons=0;
        int correctAfterImageComparisons=0;

        baseQuadrilateralDraggableInteractive(unit);

        try {
            BufferedImage biBefore = ImageIO.read(new File(filePathBase + File.separator +"baseDraggableIA.png"));
            boolean beforeComp = Shutterbug.shootElementVerticallyCentered(webDriver, quadrilateralDraggableIA.getWebElement()).
                    equalsWithDiff(biBefore, filePathAfterCmp +"baseDraggableIADiff", 0.1);

            if(beforeComp) {
                correctBeforeImageComparisons++;
            }

            List<WebElement> addOns = quadrilateralDraggableAddon.getWebElements();

            for (WebElement addOn : addOns){
                addOn.click();
                waitForSec(1);
                BufferedImage biAfter = ImageIO.read(new File(filePathBase + File.separator +count+"_imgAfterAddOn.png"));
                boolean afterComp = Shutterbug.shootElementVerticallyCentered(webDriver, quadrilateralDraggableIA.getWebElement()).
                        equalsWithDiff(biAfter, filePathAfterCmp +count+"_imgAfterAddOnDiff", 0.1);

                if(afterComp) {
                    correctAfterImageComparisons++;
                }
                count++;
            }

            quadrilateralDraggableDot.doubleClick();
            builder.moveToElement(quadrilateralDraggableDot.getWebElement(), 35, 35);
            System.out.println("Element Dragged");
            waitForSec(2);

            BufferedImage biAfterDrag = ImageIO.read(new File(filePathBase + File.separator +"afterDraggableIA.png"));
            boolean afterDrag = Shutterbug.shootElementVerticallyCentered(webDriver, quadrilateralDraggableIA.getWebElement()).
                    equalsWithDiff(biAfterDrag, filePathAfterCmp +"afterDraggableIADiff", 0.1);

            if(afterDrag) {
                correctBeforeImageComparisons++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Total before images verifed correctly " + correctBeforeImageComparisons);
        System.out.println("Total after images verifed correctly " + correctAfterImageComparisons);
        return true;
    }

    public void createFolder(String dirPath) {
        File folder = new File(dirPath);
        if(!folder.exists()) {
            folder.mkdir();
        }
    }

    public void collectBaseSmartPhaseImages(String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathBase);

        int count = 1;
        int totalSPVerified=0;
        Actions builder = new Actions(webDriver);
        List<WebElement> sPhases = smartPhases.getWebElements();
        reportLog("Total number of Smart Phases " + sPhases.size());
        if (!sPhases.isEmpty()) {
            for (WebElement smartPhase : sPhases) {
                String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='" + smartPhase.getAttribute("data-embed-id") + "']//*[local-name()='svg']";
                System.out.println("*************** smartPhase is; " + smartPhase.getText());
                System.out.println("*************** svglocator is; " + animlocator);
                GuiControl animElem = new GuiControl(animlocator, webDriver);

                try {
                    waitForSec(1);
                    Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName(count+"_imgBefore").save(filePathBase);
                    System.out.println("###################################################Path is: " + filePathBase +count+"_imgBefore.png");

                    builder.moveToElement(smartPhase).build().perform();
                    waitForSec(5);
                    Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).withName(count+"_imgAfter").save(filePathBase);
                    System.out.println("###################################################Path is: " + filePathBase +count+"_imgAfter.png");

                    animElem.click();
                    waitForSec(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
                totalSPVerified++;
            }
            System.out.println("Total Smart Phrases verified: " + totalSPVerified);
        }
    }

    public boolean verifySmartPhases(String unit){
        String filePathBase = basePath + unit + "GeometryBaseAnimation";
        createFolder(filePathAfterCmp);

        collectBaseSmartPhaseImages(unit);

        int count =0;
        int totalSPVerified=0;
        int correctBeforeImageComparisons=0;
        int correctAfterImageComparisons=0;

        Actions builder = new Actions(webDriver);
        List<WebElement> sPhases = smartPhases.getWebElements();
        reportLog("Total number of Smart Phases " + sPhases.size());
        if (!sPhases.isEmpty()) {
            for (WebElement smartPhase : sPhases) {
                String animlocator = "xpath" + "_TBD_" + "//inline-interactive[@embedid='" + smartPhase.getAttribute("data-embed-id") + "']//*[local-name()='svg']";
                System.out.println("*************** smartPhase is; " + smartPhase.getText());
                System.out.println("*************** svglocator is; " + animlocator);
                GuiControl animElem = new GuiControl(animlocator, webDriver);

                try {
                    waitForSec(1);
                    BufferedImage biBefore = ImageIO.read(new File(filePathBase + File.separator +count+"_imgBefore.png"));
                    boolean beforeComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                            equalsWithDiff(biBefore, filePathAfterCmp +count+"_imgBeforeDiff", 0.1);

                    if(beforeComp) {
                        correctBeforeImageComparisons++;
                    }

                    builder.moveToElement(smartPhase).build().perform();
                    waitForSec(5);
                    BufferedImage biAfter = ImageIO.read(new File(filePathBase + File.separator +count+"_imgAfter.png"));
                    boolean afterComp = Shutterbug.shootElementVerticallyCentered(webDriver, animElem.getWebElement()).
                            equalsWithDiff(biAfter, filePathAfterCmp +count+"_imgAfterDiff", 0.1);

                    if(afterComp) {
                        correctAfterImageComparisons++;
                    }

                    animElem.click();
                    waitForSec(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                count++;
                totalSPVerified++;
            }
            System.out.println("Total Smart Phrases verified: " + totalSPVerified);
            System.out.println("Total before images verifed correctly " + correctBeforeImageComparisons);
            System.out.println("Total after images verifed correctly " + correctAfterImageComparisons);
        }
        return true;
    }

    public void scrollTop() {
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0, 0);");
        waitForSec(1);
    }

    public boolean verifyPolygonPiDiagram(){
        String[] dropVerifier = {"4-Triangle", "5-Pentagon", "6-Hexagon", "7-Heptagon", "8-Octagon", "9-Nonagon", "10-Decagon", "11-Hendecagon", "12-Dodecagon", "13-Tridecagon", "14-Tetradecagon", "15-Pentadecagon"};

        polygonPIDraggableIA.scrollIntoView();
        builder.moveToElement(polygonPIDraggableIA.getWebElement());

        for (int i = 0; i<dropVerifier.length; i++){
            String dropable = "cssselector" + "_TBD_" + "inline-interactive[embedid='IG_8_2_2'] g line#line-" + dropVerifier[i].split("-")[0];
            GuiControl dropEle = new GuiControl(dropable, webDriver);
            System.out.println("*************** 1st Draggable dot is; " + dropable);


            builder.clickAndHold(polygonPIDraggableDot.getWebElement()).moveToElement(dropEle.getWebElement()).release().build().perform();
            System.out.println("Dragged Succesfully");
            waitForSec(3);

            if (polygonPIDiagram.getText().equals(dropVerifier[i].split("-")[1])){
                System.out.println("Polygon changed correctly to " + dropVerifier[i].split("-")[1]);
            }
        }
        return true;
    }
}

