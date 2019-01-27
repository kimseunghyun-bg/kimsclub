package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.ImageUtil;
import com.ksh.common.Position;
import com.ksh.common.utils.OCRUtil;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.awt.image.BufferedImage;

public class RecruitHeroes {

    private Position leftHeroCard = new Position(120, 700);
    private Position centerHeroCard = new Position(360, 700);
    private Position rightHeroCard = new Position(600, 700);
    private Position recruitButton = new Position(360, 1220);

    private ImageInfo leftHeroCardImg = new ImageInfo(10, 220, 120, 380);
    private ImageInfo centerHeroCardImg = new ImageInfo(160, 220, 120, 380);
    private ImageInfo rightHeroCardImg = new ImageInfo(310, 220, 120, 380);

    private ImageInfo recruitButtonImg = new ImageInfo(155, 755, 135, 30);

    private static final RecruitHeroes instance = new RecruitHeroes();

    private RecruitHeroes() {
    }

    public static RecruitHeroes getInstance() {
        return instance;
    }

    public void clickRecruitButton() {
        CommonMacro.clickImage(recruitButtonImg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonMacro.clickBack();
    }

    public void clickLeftHeroCard() {
        CommonMacro.clickImage(leftHeroCardImg);
    }

    public void clickRightHeroCard() {
        CommonMacro.clickImage(rightHeroCardImg);
    }

    public void clickCenterHeroCard() {
        CommonMacro.clickImage(centerHeroCardImg);
    }

    public void dragToRightPage() {
        CommonMacro.dragCommon(rightHeroCardImg, leftHeroCardImg);
    }

    public void dragToLeftPage() {
        CommonMacro.dragCommon(leftHeroCardImg, rightHeroCardImg);
    }

    public boolean isFreeRecruit() {
        return OCRUtil.isImgContainsText(recruitButtonImg, "Free");
    }

    public void runFreeRecruit() {
        dragToLeftPage();
        for (int i = 0; i < 2; i++) {
            clickLeftHeroCard();
            if (isFreeRecruit())
                clickRecruitButton();

            clickCenterHeroCard();
            if (isFreeRecruit())
                clickRecruitButton();

            clickRightHeroCard();
            if (isFreeRecruit())
                clickRecruitButton();

            if (i == 0)
                dragToRightPage();
        }
    }
}
