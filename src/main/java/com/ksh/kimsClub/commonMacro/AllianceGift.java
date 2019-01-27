package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;

public class AllianceGift {

    private ImageInfo collectButtonImg = new ImageInfo(345, 205, 65, 25);

    private static final AllianceGift instance = new AllianceGift();

    private AllianceGift() {
    }

    public static AllianceGift getInstance() {
        return instance;
    }

    private boolean clickCollectButton(){
        return CommonMacro.clickImageHasText(collectButtonImg,"Collect");
    }

    public void clickAllCollectButton(){
        boolean isOnScreen;
        do {
            isOnScreen = clickCollectButton();
        } while (isOnScreen);
    }
}
