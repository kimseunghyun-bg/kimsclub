package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class Hero {
    private ImageInfo recruitButtonImg = new ImageInfo(120, 770, 65, 20);

    private static final Hero instance = new Hero();

    private Hero() {
    }

    public static Hero getInstance() {
        return instance;
    }

//    public RecruitHeroes clickRecruitButton() {
//        CommonMacro.clickPosition(recruitButton);
//        return RecruitHeroes.getInstance();
//    }

    public RecruitHeroes clickRecruitButton() {
        CommonMacro.waitTextAndClick(recruitButtonImg,"Recruit");
//        CommonMacro.clickImageHasText(recruitButtonImg, "Recruit");
        return RecruitHeroes.getInstance();
    }

}
