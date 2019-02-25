package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.kimsClub.commonMacro.CommonMacro;
import com.ksh.kimsClub.views.alliance.AllianceTechnology;
import com.ksh.kimsClub.views.alliance.Wages;

public class Alliance {

    private ImageInfo salaryIconImg = new ImageInfo(360, 553, 30, 30, "src/main/resources/lastshelter/images/alliance/salaryIcon.jpg");
    private ImageInfo technologyIconImg = new ImageInfo(50, 645, 40, 35, "src/main/resources/lastshelter/images/alliance/technologyIcon.jpg");


    private static final Alliance instance = new Alliance();

    private Alliance() {
    }

    public static Alliance getInstance() {
        return instance;
    }

    public Wages clickSalary(){
        CommonMacro.waitImgAndClick(salaryIconImg);
//        CommonMacro.clickImageOnScreen(salaryIconImg);
        return Wages.getInstance();
    }

    public AllianceTechnology clickTechnology(){
        CommonMacro.waitImgAndClick(technologyIconImg);
//        CommonMacro.clickImageOnScreen(salaryIconImg);
        return AllianceTechnology.getInstance();
    }
}
