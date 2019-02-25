package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.OCRUtil;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class Benefits {
    private ImageInfo dailySupplyIconImg = new ImageInfo(120, 770, 65, 20,"src/main/resources/lastshelter/images/benefits/dailySupplyIcon.jpg");
    private ImageInfo claimButtonImg = new ImageInfo(345, 370, 50, 20);
    
    private static final Benefits instance = new Benefits();

    private Benefits() {
    }

    public static Benefits getInstance() {
        return instance;
    }

    private void clickDailySupplyIcon(){
        CommonMacro.waitImgAndClick(dailySupplyIconImg);
//        CommonMacro.clickImageOnScreen(dailySupplyIconImg);
    }

    private void clickClaimButton(){
        CommonMacro.waitTextAndClick(claimButtonImg, "Claim",1000);
//        CommonMacro.clickImageHasText(claimButtonImg,"Claim");
    }

    public void getDailySupply(){
        clickDailySupplyIcon();
        clickClaimButton();
    }
}
