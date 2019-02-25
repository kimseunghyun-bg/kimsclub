package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.common.Position;
import com.ksh.common.utils.OCRUtil;
import com.ksh.kimsClub.commonMacro.CommonMacro;

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
        CommonMacro.click(recruitButtonImg);
        CommonMacro.sleep(500);
        CommonMacro.clickBack();
    }

    public void clickLeftHeroCard() {
        CommonMacro.waitTimeAndClick(leftHeroCardImg,500);
//        CommonMacro.clickImage(leftHeroCardImg);
    }

    public void clickRightHeroCard() {
        CommonMacro.waitTimeAndClick(rightHeroCardImg, 500);
//        CommonMacro.clickImage(rightHeroCardImg);
    }

    public void clickCenterHeroCard() {
        CommonMacro.waitTimeAndClick(centerHeroCardImg, 500);
//        CommonMacro.clickImage(centerHeroCardImg);
    }

    public void dragToRightPage() {
        CommonMacro.drag(rightHeroCardImg, leftHeroCardImg);
//        CommonMacro.dragCommon(rightHeroCardImg, leftHeroCardImg);
    }

    public void dragToLeftPage() {
        CommonMacro.drag(leftHeroCardImg, rightHeroCardImg);
//        CommonMacro.dragCommon(leftHeroCardImg, rightHeroCardImg);
    }

    public boolean isFreeRecruit() {
        CommonMacro.sleep(200);
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
