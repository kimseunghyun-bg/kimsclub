package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;

public class Benefits {
    private ImageInfo dailySupplyIconImg = new ImageInfo(120, 770, 65, 20,"src/main/resources/lastshelter/images/benefits/dailySupplyIcon.jpg");
    private ImageInfo claimButtonImg = new ImageInfo(345, 350, 50, 20);
    
    private static final Benefits instance = new Benefits();

    private Benefits() {
    }

    public static Benefits getInstance() {
        return instance;
    }

    private void clickDailySupplyIcon(){
        CommonMacro.clickImageOnScreen(dailySupplyIconImg);
    }

    private void clickClaimButton(){
        CommonMacro.clickImageHasText(claimButtonImg,"Claim");
    }

    public void getDailySupply(){
        clickDailySupplyIcon();
        clickClaimButton();
    }
}
