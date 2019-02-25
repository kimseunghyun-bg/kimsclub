package com.ksh.common.utils;

import com.ksh.common.ImageInfo;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;

public class OCRUtil {
    public static boolean isImgContainsText(ImageInfo targetImg, String expectText) {
        BufferedImage captureImg = ImageUtil.createScreenCapture(targetImg);

        String text = extractText(captureImg);

        if (!text.contains(expectText)) {
            ImageUtil.negativeColorImage(captureImg);
            text = extractText(captureImg);
        }

        return text.contains(expectText);
    }

    private static String extractText(BufferedImage img){
        Tesseract tesseract = new Tesseract();
        String text = "";
        try {
            tesseract.setDatapath("C:/IdeaProjects/kimsclub/src/main/resources/tessdata");
            tesseract.setLanguage("eng");
            text = tesseract.doOCR(img);
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        System.out.println("readText : "+text);
        return text;
    }


    public static ImageInfo waitForTextAppear(ImageInfo targetImg, String text, int timeout) {
        boolean isAppear;
        long startTime = System.currentTimeMillis();

        do {
            isAppear = OCRUtil.isImgContainsText(targetImg, text);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!isAppear && (System.currentTimeMillis() - startTime) < timeout);

        if (isAppear) {
            return targetImg;
        } else {
            return null;
        }
    }

}
