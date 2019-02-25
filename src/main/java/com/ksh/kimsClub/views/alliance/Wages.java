package com.ksh.kimsClub.views.alliance;

import com.ksh.common.ImageInfo;
import com.ksh.kimsClub.commonMacro.CommonMacro;

import java.util.List;

public class Wages {

    private ImageInfo boxCloseButtonImg = new ImageInfo(385, 175, 35, 35);

    private ImageInfo activeTabImg = new ImageInfo(45, 225, 55, 25);
    private ImageInfo attendanceTabImg = new ImageInfo(175, 225, 90, 25);
    private ImageInfo contributionTabImg = new ImageInfo(325, 225, 85, 25);

    private ImageInfo attendanceBoxImg = new ImageInfo(238, 408, 29, 15, "src/main/resources/lastshelter/images/wages/attendanceBoxIcon.jpg");
    private ImageInfo activeBoxImg = new ImageInfo(51, 387, 29, 15, "src/main/resources/lastshelter/images/wages/activeBoxIcon.jpg");
    private ImageInfo rewardButtonImg = new ImageInfo(190, 610, 60, 30);
    private ImageInfo activeRewardButtonImg = new ImageInfo(160, 615, 120, 35);

    private static final Wages instance = new Wages();

    private Wages() {
    }

    public static Wages getInstance() {
        return instance;
    }

    private void clickActiveTab() {
        CommonMacro.waitTextAndClick(activeTabImg, "Active");
//        CommonMacro.waitTimeAndClick(activeTabImg,200);
//        CommonMacro.clickImageHasText(activeTabImg,"Active");
    }

    private void clickAttendanceTab() {
        CommonMacro.waitTextAndClick(attendanceTabImg, "Attendance");
//        CommonMacro.waitTimeAndClick(attendanceTabImg,200);
//        CommonMacro.clickImageHasText(attendanceTabImg,"Attendance");
    }

    private void clickContributionTab() {
        CommonMacro.waitTextAndClick(contributionTabImg, "Contribution");
//        CommonMacro.waitTimeAndClick(contributionTabImg,200);
//        CommonMacro.clickImageHasText(contributionTabImg,"Contribution");
    }

    private void clickAllBox() {
        CommonMacro.waitTimeAndClick(35,415,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(250,415,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(404,415,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(155,435,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(395,435,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);
//        List<ImageInfo> boxList = ImageUtil.findMultiImagesOnScreen(attendanceBoxImg.getImgFile().getAbsolutePath());
//        sortBoxArray(boxList);
//
//        for (ImageInfo aBoxList : boxList) {
//            CommonMacro.waitTimeAndClick(aBoxList,300);
//            CommonMacro.waitTimeAndClick(aBoxList,200);
//            if (OCRUtil.isImgContainsText(rewardButtonImg, "Salary")) {
//                CommonMacro.click(rewardButtonImg);
//            } else {
//                CommonMacro.clickBack();
//            }
//            if (!CommonMacro.clickImageHasText(rewardButtonImg, "Salary")) {
//                CommonMacro.clickBack();
//            }
//        }
    }

    private void clickActiveAllBox() {
        CommonMacro.waitTimeAndClick(64,391,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(110,324,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(166,391,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(218,324,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(266,391,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(319,324,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(370,391,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);

        CommonMacro.waitTimeAndClick(420,324,100);
        CommonMacro.waitTimeAndClick(activeRewardButtonImg,100);
        CommonMacro.waitTimeAndClick(boxCloseButtonImg,100);
//        List<ImageInfo> boxList = ImageUtil.findMultiImagesOnScreen(activeBoxImg.getImgFile().getAbsolutePath());
//        sortBoxArray(boxList);
//
//        for (ImageInfo aBoxList : boxList) {
//            CommonMacro.waitTimeAndClick(aBoxList,300);
//            CommonMacro.waitTimeAndClick(aBoxList,200);
//            if (OCRUtil.isImgContainsText(activeRewardButtonImg, "Rewards")) {
//                CommonMacro.waitTimeAndClick(activeRewardButtonImg);
//            } else {
//                CommonMacro.clickBack();
//            }
////            if (!CommonMacro.clickImageHasText(activeRewardButtonImg, "Rewards")) {
////                CommonMacro.clickBack();
////            }
//        }
    }

    public void gatherAllBox() {
        clickActiveTab();
        clickActiveAllBox();
        clickAttendanceTab();
        clickAllBox();
        clickContributionTab();
        clickAllBox();
    }

    private void sortBoxArray(List<ImageInfo> imageList) {
        ImageInfo temp, firstVal, secondVal;

        for (int i = 0; i < imageList.size() - 1; i++) {
            for (int j = 0; j < imageList.size() - 1 - i; j++) {

                firstVal = imageList.get(j);
                secondVal = imageList.get(j + 1);

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
