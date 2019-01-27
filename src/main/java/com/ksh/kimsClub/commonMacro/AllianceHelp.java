package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;

public class AllianceHelp {
    //360:1240
//    private Position helpAllButton = new Position(360,1240);

    private ImageInfo helpAllButtonImg = new ImageInfo(155, 770, 135, 30);

    private static final AllianceHelp instance = new AllianceHelp();

    private AllianceHelp() {
    }

    public static AllianceHelp getInstance() {
        return instance;
    }

    public void clickHelpAllButton(){
        CommonMacro.clickImageHasText(helpAllButtonImg,"Help");
    }
}
