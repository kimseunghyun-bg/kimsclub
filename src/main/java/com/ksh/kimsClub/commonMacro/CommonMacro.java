package com.ksh.kimsClub.commonMacro;

import com.ksh.common.Configurations;
import com.ksh.common.ImageInfo;
import com.ksh.common.Position;
import com.ksh.common.utils.ImageUtil;
import com.ksh.common.utils.MouseUtil;
import com.ksh.common.utils.OCRUtil;
import com.ksh.noxEmulator.MouseMacroBuilder;
import org.apache.commons.io.FileUtils;
import org.opencv.core.Core;

import java.io.IOException;

public class CommonMacro {

//    @Deprecated
//    public static void clickPosition(Position position) {
//        String script = MouseMacroBuilder.createClickScript(position, 0);
//        runScript(script);
//    }

    public static void clickBack() {
        MouseUtil.click(460, 705);
    }

//    @Deprecated
//    public static void dragCommon(Position startPosition, Position endPosition) {
//        String script = MouseMacroBuilder.createDragScript(startPosition, endPosition, 0);
//        runScript(script);
//    }

    public static void dragCommon(ImageInfo startImage, ImageInfo endImage) {
        MouseUtil.drag(startImage.getCenterX(), startImage.getCenterY(), endImage.getCenterX(), endImage.getCenterY());
    }

//    private static void runScript(String script) {
//        try {
//            FileUtils.writeStringToFile(Configurations.getMacroFile(), script, "UTF-8");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        MouseUtil.clickPlayMacro();
//
//        int scriptEndTime = MouseMacroBuilder.getLastTime(script);
//        try {
//            Thread.sleep(scriptEndTime + 500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void clickImage(ImageInfo targetImage) {
        MouseUtil.click(targetImage.getCenterX(), targetImage.getCenterY());
    }

    public static boolean clickImageOnScreen(String templateImgPath) {
        ImageInfo findImage = ImageUtil.findImageOnScreen(templateImgPath);
        if (findImage.getIsOnScreen()) {
            MouseUtil.click(findImage.getCenterX(), findImage.getCenterY());
            return true;
        }
        return false;
    }

    public static boolean clickImageOnScreen(ImageInfo targetImage) {
        return clickImageOnScreen(targetImage.getImgFile().getAbsolutePath());
    }

    public static boolean clickImageHasText(ImageInfo targetImage, String expectText) {
        boolean hasExpectText = OCRUtil.isImgContainsText(targetImage, expectText);
        if (hasExpectText) {
            MouseUtil.click(targetImage.getCenterX(), targetImage.getCenterY());
            return true;
        }
        return false;
    }

    public static boolean waitForImgAppear(ImageInfo targetImg) {
        return waitForImgAppear(targetImg.getImgFile().getAbsolutePath(),2000);
    }

    public static boolean waitForImgAppear(ImageInfo targetImg, int timeout) {
        return waitForImgAppear(targetImg.getImgFile().getAbsolutePath(),timeout);
    }

    private static boolean waitForImgAppear(String targetImgPath, int timeout) {
        ImageInfo findImage;
        long startTime = System.currentTimeMillis();

        do {
            findImage = ImageUtil.findImageOnScreen(targetImgPath);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!findImage.getIsOnScreen() && (System.currentTimeMillis() - startTime) < timeout);

        return findImage.getIsOnScreen();
    }

    public static void main(String[] args) throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

    }
}
