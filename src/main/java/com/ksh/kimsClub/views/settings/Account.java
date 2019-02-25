package com.ksh.kimsClub.views.settings;

import com.ksh.common.ImageInfo;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class Account {
    private ImageInfo switchAccountButtonImg = new ImageInfo(140, 575, 155, 35);
    private ImageInfo startNewGameButtonImg = new ImageInfo(140, 630, 155, 35);

    private static final Account instance = new Account();

    private Account() {
    }

    public static Account getInstance() {
        return instance;
    }

    public SwitchAccount clickSwitchAccountButton() {
        CommonMacro.waitTextAndClick(switchAccountButtonImg,"Switch");
//        CommonMacro.clickImageHasText(switchAccountButtonImg,"Switch");
        return SwitchAccount.getInstance();
    }
}
