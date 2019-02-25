package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.ImageUtil;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class Buildings {
    private static final Buildings instance = new Buildings();

    private Buildings() {
    }

    public static Buildings getInstance() {
        return instance;
    }

    private ImageInfo harvestIconImg = new ImageInfo(220, 685, 40, 20, "src/main/resources/lastshelter/images/building/harvestIcon.jpg");
    private ImageInfo harvestUseButtonImg = new ImageInfo(190, 590, 60, 30);

    private ImageInfo commercialHubImg = new ImageInfo(68, 565, 30, 20,"src/main/resources/lastshelter/images/building/commercialHub.jpg");
    private ImageInfo tradeIconImg = new ImageInfo(175, 620, 35, 25, "src/main/resources/lastshelter/images/building/tradeIcon.jpg");
    // tradeCenter  68, 565, 30, 20

    private void clickProductionCenter(){
        CommonMacro.waitTimeAndClick(210,635);
    }

    private void clickHarvestIcon(){
        CommonMacro.waitImgAndClick(harvestIconImg);
    }

    private void clickHarvestUseButton(){
        CommonMacro.waitTextAndClick(harvestUseButtonImg,"Use");
        CommonMacro.click(125, 495);
    }

    public void harvest(){
        clickProductionCenter();
        clickHarvestIcon();
        CommonMacro.sleep(200);
        clickHarvestUseButton();
    }

    private void clickCommercialHub(){
        CommonMacro.waitTimeAndClick(commercialHubImg);
    }

    private boolean isCanTrade(){
        return ImageUtil.waitForImgAppear(commercialHubImg,200).getIsOnScreen();
    }

    private CommercialHub clickTradeIcon(){
        CommonMacro.waitImgAndClick(tradeIconImg);
        return CommercialHub.getInstance();
    }

    public CommercialHub rssTrade(){
        clickCommercialHub();
        if (isCanTrade())
            return clickTradeIcon();
        else
            return null;
    }
}
