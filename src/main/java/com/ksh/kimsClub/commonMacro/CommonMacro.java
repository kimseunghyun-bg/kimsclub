package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.ImageUtil;
import com.ksh.common.utils.Keyboard;
import com.ksh.common.utils.Mouse;
import com.ksh.common.utils.OCRUtil;
import com.ksh.kimsClub.views.Base;
import com.ksh.kimsClub.views.alliance.AllianceGift;
import com.ksh.kimsClub.views.alliance.AllianceHelp;
import com.ksh.kimsClub.views.alliance.AllianceTechnology;
import org.opencv.core.Core;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class CommonMacro {

    private static final int DELAY = 2000;
    private static Logger logger = LoggerFactory.getLogger(CommonMacro.class);

//    @Deprecated
//    public static void clickPosition(Position position) {
//        String script = MouseMacroBuilder.createClickScript(position, 0);
//        runScript(script);
//    }

    public static void waitImgAndClick(ImageInfo img) {
        waitImgAndClick(img, DELAY);
    }

    public static void waitImgAndClick(ImageInfo img, int timeout) {
        Optional.ofNullable(ImageUtil.waitForImgAppear(img.getImgFile().getAbsolutePath(), timeout)).ifPresent(CommonMacro::click);
    }


    public static void waitTimeAndClick(ImageInfo img) {
        waitTimeAndClick(img, 200);
    }

    public static void waitTimeAndClick(ImageInfo img, int waitTime) {
        sleep(waitTime);
        click(img);
    }

    public static void waitTimeAndClick(int x, int y) {
        waitTimeAndClick(x, y, DELAY);
    }

    public static void waitTimeAndClick(int x, int y, int waitTime) {
        sleep(waitTime);
        click(x, y);
    }


    public static void waitTextAndClick(ImageInfo img, String expectText) {
        waitTextAndClick(img, expectText, DELAY);
    }

    public static void waitTextAndClick(ImageInfo img, String expectText, int timeout) {
        Optional.ofNullable(OCRUtil.waitForTextAppear(img, expectText, timeout)).ifPresent(CommonMacro::click);
    }

    public static void click(int x, int y) {
        _click(x, y);
        sleep(200);
    }

    private static synchronized void _click(int x, int y) {
        Mouse.click(x, y);
        logger.info("click x:"+x+", y:"+y);
    }

    public static void click(ImageInfo img) {
        click(img.getCenterX(), img.getCenterY());
    }

    public static void drag(ImageInfo startImage, ImageInfo endImage) {
        drag(startImage.getCenterX(), startImage.getCenterY(), endImage.getCenterX(), endImage.getCenterY());
    }

    public static synchronized void drag(int start_x, int start_y, int end_x, int end_y) {
        sleep(200);
        Mouse.drag(start_x, start_y, end_x, end_y);
    }


    public static synchronized void dragOnBase(int start_x, int start_y, int end_x, int end_y) {
        sleep(200);
        Mouse.dragOnBase(start_x, start_y, end_x, end_y);
    }

    public static void goLeftOnBase(){
        dragOnBase(20,400,240,400);
    }

    public static void goRightOnBase(){
        dragOnBase(420,400,200,400);
    }


    public static void clickAndType(ImageInfo img, String text){
        clickAndType(img.getCenterX(), img.getCenterY(), text);
    }

    public static synchronized void clickAndType(int x, int y, String text) {
        waitTimeAndClick(x, y,200);
        Keyboard.type(text);
    }

    public static void clickBack() {
        logger.info("start clickBack Button");
        waitTimeAndClick(460, 705,200);
        logger.info("end clickBack Button");
    }

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void clickMouseRecorder() {
        waitTimeAndClick(460, 385);

        Mouse.drag(215, 240, 215, 830);
    }

    @Deprecated
    public static void clickPlayMacro() {
        Mouse.click(326, 989);
    }

//    @Deprecated
//    public static void dragCommon(Position startPosition, Position endPosition) {
//        String script = MouseMacroBuilder.createDragScript(startPosition, endPosition, 0);
//        runScript(script);
//    }

//    public static void dragCommon(ImageInfo startImage, ImageInfo endImage) {
//        Mouse.drag(startImage.getCenterX(), startImage.getCenterY(), endImage.getCenterX(), endImage.getCenterY());
//    }

//    private static void runScript(String script) {
//        try {
//            FileUtils.writeStringToFile(Configurations.getMacroFile(), script, "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Mouse.clickPlayMacro();
//
//        int scriptEndTime = MouseMacroBuilder.getLastTime(script);
//        try {
//            Thread.sleep(scriptEndTime + 500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public static void clickImage(ImageInfo targetImage) {
//        Mouse.click(targetImage.getCenterX(), targetImage.getCenterY());
//    }

//    public static boolean clickImageOnScreen(String templateImgPath) {
//        ImageInfo findImage = ImageUtil.findImageOnScreen(templateImgPath);
//        if (findImage.getIsOnScreen()) {
//            Mouse.click(findImage.getCenterX(), findImage.getCenterY());
//            return true;
//        }
//        return false;
//    }

//    public static boolean clickImageOnScreen(ImageInfo targetImage) {
//        return clickImageOnScreen(targetImage.getImgFile().getAbsolutePath());
//    }

//    public static boolean clickImageHasText(ImageInfo targetImage, String expectText) {
//        boolean hasExpectText = OCRUtil.isImgContainsText(targetImage, expectText);
//        if (hasExpectText) {
//            Mouse.click(targetImage.getCenterX(), targetImage.getCenterY());
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        Base.getInstance().gotoBaseHome();
//        Wages.getInstance().gatherAllBox();
//        Optional.ofNullable(Base.getInstance().clickHelpIcon());
//        AllianceTechnology.getInstance().clickRecommendBadge();

        Base base = Base.getInstance();
        base.gotoBaseHome();
        base.clickSettingsIcon();

//        Optional.ofNullable(Buildings.getInstance().rssTrade()).ifPresent(c->c.sellWater());
//        Optional.ofNullable(Buildings.getInstance().rssTrade()).ifPresent(c->c.buyElectricity());
//        Buildings.getInstance().harvest();
//        Base.getInstance().clickAllianceIcon().clickTechnology().contribute();
//        goLeftOnBase();
//        goRightOnBase();
    }
}
