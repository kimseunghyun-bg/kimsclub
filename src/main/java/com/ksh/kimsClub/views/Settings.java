package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.common.Position;
import com.ksh.kimsClub.views.settings.Account;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class Settings {

    private ImageInfo accountIconImg = new ImageInfo(123, 202, 93, 93, "src/main/resources/lastshelter/images/settings/accountIcon.jpg");

    private Position accountButton = new Position(280,350);

    private static final Settings instance = new Settings();

    private Settings() {
    }

    public static Settings getInstance() {
        return instance;
    }

    public Account clickAccountButton() {
        CommonMacro.waitImgAndClick(accountIconImg);
//        CommonMacro.clickImageOnScreen(accountIconImg);
        return Account.getInstance();
    }
}
