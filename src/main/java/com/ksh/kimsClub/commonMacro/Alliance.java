package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;

public class Alliance {

    private ImageInfo salaryIconImg = new ImageInfo(360, 553, 30, 30, "src/main/resources/lastshelter/images/alliance/salaryIcon.jpg");


    private static final Alliance instance = new Alliance();

    private Alliance() {
    }

    public static Alliance getInstance() {
        return instance;
    }

    public Wages clickSalary(){
        CommonMacro.clickImageOnScreen(salaryIconImg);
        return Wages.getInstance();
    }
}
