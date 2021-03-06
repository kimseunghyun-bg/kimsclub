package com.ksh.kimsClub.views.settings;

import com.ksh.common.ImageInfo;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class SwitchAccount {
    private ImageInfo im30AccountButtonImg = new ImageInfo(195, 230, 120, 30);
    private ImageInfo facebookAccountButtonImg = new ImageInfo(170, 300, 170, 35);
    private ImageInfo googlePlayAccountButtonImg = new ImageInfo(170, 370, 170, 35);

    private static final SwitchAccount instance = new SwitchAccount();

    private SwitchAccount() {
    }

    public static SwitchAccount getInstance() {
        return instance;
    }

    public AccountList clickIm30AccountButton() {
        CommonMacro.waitTextAndClick(im30AccountButtonImg,"IM30");
//        CommonMacro.clickImageHasText(im30AccountButtonImg,"IM30");
        return AccountList.getInstance();
    }
}
