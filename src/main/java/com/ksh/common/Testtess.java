package com.ksh.common;

import net.sourceforge.tess4j.*;

import java.io.File;

public class Testtess {

    public static void main(String[] args) {
        Tesseract tesseract = new Tesseract();
        try {
            tesseract.setDatapath("C:/IdeaProjects/kimsclub/src/main/resources/tessdata");
            tesseract.setLanguage("eng");
            String text = tesseract.doOCR(new File("C:/IdeaProjects/kimsclub/src/main/resources/lastshelter/images/base/test2.jpg"));
            System.out.print(text);
        } catch (TesseractException e) {
            e.printStackTrace();
        }

    }

}