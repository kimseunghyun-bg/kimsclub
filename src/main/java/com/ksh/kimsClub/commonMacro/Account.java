package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;

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
        CommonMacro.clickImageHasText(switchAccountButtonImg,"Switch");
        return SwitchAccount.getInstance();
    }
}
