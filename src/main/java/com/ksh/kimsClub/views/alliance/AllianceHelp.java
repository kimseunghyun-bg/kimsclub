package com.ksh.kimsClub.views.alliance;

import com.ksh.common.ImageInfo;
import com.ksh.kimsClub.commonMacro.CommonMacro;

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
        CommonMacro.waitTextAndClick(helpAllButtonImg,"Help");
//        CommonMacro.clickImageHasText(helpAllButtonImg,"Help");
    }
}
