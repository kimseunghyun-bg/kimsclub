package com.ksh.kimsClub.views.alliance;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.OCRUtil;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class AllianceGift {

    private ImageInfo collectButtonImg = new ImageInfo(345, 205, 65, 25);

    private static final AllianceGift instance = new AllianceGift();

    private AllianceGift() {
    }

    public static AllianceGift getInstance() {
        return instance;
    }

    private void clickCollectButton(){
        CommonMacro.waitTextAndClick(collectButtonImg,"Collect");
//        return CommonMacro.clickImageHasText(collectButtonImg,"Collect");
    }

    public void clickAllCollectButton(){
        boolean isOnScreen;
        do {
            clickCollectButton();
            isOnScreen = OCRUtil.isImgContainsText(collectButtonImg, "Collect");
        }while (isOnScreen);
//        do {
//            isOnScreen = clickCollectButton();
//        } while (isOnScreen);
    }
}
