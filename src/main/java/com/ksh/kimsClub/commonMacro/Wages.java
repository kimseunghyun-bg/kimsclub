package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.ImageUtil;

import java.util.List;

public class Wages {

    private ImageInfo activeTabImg = new ImageInfo(45, 225, 55, 25);
    private ImageInfo attendanceTabImg = new ImageInfo(175, 225, 90, 25);
    private ImageInfo contributionTabImg = new ImageInfo(325, 225, 85, 25);

    private ImageInfo attendanceBoxImg = new ImageInfo(238, 408, 29, 15,"src/main/resources/lastshelter/images/wages/attendanceBoxIcon.jpg");
    private ImageInfo activeBoxImg = new ImageInfo(51, 387, 29, 15,"src/main/resources/lastshelter/images/wages/activeBoxIcon.jpg");
    private ImageInfo rewardButtonImg = new ImageInfo(190, 610, 60, 30);
    private ImageInfo activeRewardButtonImg = new ImageInfo(160, 615, 120, 35);

    private static final Wages instance = new Wages();

    private Wages() {
    }

    public static Wages getInstance() {
        return instance;
    }

    private void clickActiveTab(){
        CommonMacro.clickImageHasText(activeTabImg,"Active");
    }

    private void clickAttendanceTab(){
        CommonMacro.clickImageHasText(attendanceTabImg,"Attendance");
    }

    private void clickContributionTab(){
        CommonMacro.clickImageHasText(contributionTabImg,"Contribution");
    }

    private void clickAllBox(){
        List<ImageInfo> boxList = ImageUtil.findMultiImagesOnScreen(attendanceBoxImg.getImgFile().getAbsolutePath());
        sortBoxArray(boxList);

        for (int i = 0; i < boxList.size(); i++) {
            CommonMacro.clickImage(boxList.get(i));
            if (!CommonMacro.clickImageHasText(rewardButtonImg, "Salary")) {
                CommonMacro.clickBack();
            }
        }
    }

    private void clickActiveAllBox(){
        List<ImageInfo> boxList = ImageUtil.findMultiImagesOnScreen(activeBoxImg.getImgFile().getAbsolutePath());
        sortBoxArray(boxList);

        for (int i = 0; i < boxList.size(); i++) {
            CommonMacro.clickImage(boxList.get(i));
            if (!CommonMacro.clickImageHasText(activeRewardButtonImg, "Rewards")) {
                CommonMacro.clickBack();
            }
        }
    }

    public void gatherAllBox(){
        clickActiveTab();
        clickActiveAllBox();
        clickAttendanceTab();
        clickAllBox();
        clickContributionTab();
        clickAllBox();
    }

    private void sortBoxArray(List<ImageInfo> imageList){
        ImageInfo temp,firstVal,secondVal;

        for (int i = 0; i < imageList.size()-1; i++) {
            for (int j = 0; j < imageList.size()-1-i; j++) {

                firstVal = imageList.get(j);
                secondVal = imageList.get(j+1);

                if (firstVal.getXPosition() > secondVal.getXPosition()) {
                    temp = imageList.get(j);
                    imageList.add(j, secondVal);
                    imageList.remove(j + 1);
                    imageList.add(j + 1, firstVal);
                    imageList.remove(j + 2);
                }
            }
        }
    }
}
