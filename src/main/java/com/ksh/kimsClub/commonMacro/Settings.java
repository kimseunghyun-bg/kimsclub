package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;
import com.ksh.common.Position;

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
        CommonMacro.clickImageOnScreen(accountIconImg);
        return Account.getInstance();
    }
}
