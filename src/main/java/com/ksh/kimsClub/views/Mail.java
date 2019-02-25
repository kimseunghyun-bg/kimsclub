package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.ImageUtil;
import com.ksh.kimsClub.commonMacro.CommonMacro;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Mail {
    String[] mailList = {"message", "alliance", "battleReport", "activities", "lastShelterStudio", "system"};
    private ImageInfo giftIconImg = new ImageInfo(317, 124, 30, 30, "src/main/resources/lastshelter/images/mail/giftIcon.jpg");
//    private ImageInfo title = new ImageInfo(190,40,55,30);
    //    String[] reportList =
    private Map<String, ImageInfo> alertImgs = new HashMap<>();

    private static final Mail instance = new Mail();

    private Mail() {
        int yGap = 62;
        for (int i = 0; i < 6; i++) {
            alertImgs.put(this.mailList[i] + "AlertImg", new ImageInfo(390, 103 + (yGap * i), 23, 23, "src/main/resources/lastshelter/images/mail/noNewAlert.jpg"));
        }
    }

    public static Mail getInstance() {
        return instance;
    }

    public void readAllMails() {
        CommonMacro.sleep(1000);
        for (String mailName : mailList) {
            readMail(mailName);
        }
    }

    public void readMail(String mailName) {
        if (isNewAlert(mailName)) {
            if (mailName.equals("activities") || mailName.equals("lastShelterStudio") || mailName.equals("system")) {
                clickMail(mailName);
                clickAllGiftIcon();
                CommonMacro.clickBack();
            }
            markAsViewed(mailName);
        }
    }

    private void markAsViewed(String mailName) {
        ImageInfo selectedImgInfo = findMailImgInfo(mailName);

//        Position startPosition = Convertor.imageInfo2Position(selectedImgInfo);
//        Position endPosition = new Position(startPosition.getX() - 200, startPosition.getY());
//        CommonMacro.dragCommon(startPosition, endPosition);
//        CommonMacro.clickPosition(startPosition);
        CommonMacro.drag(selectedImgInfo,
                new ImageInfo(selectedImgInfo.getXPosition() - 200, selectedImgInfo.getYPosition(),
                        selectedImgInfo.getWidth(), selectedImgInfo.getHeight())
        );
        CommonMacro.waitTimeAndClick(selectedImgInfo,500);
    }

    public void clickGiftIcon() {
        CommonMacro.waitImgAndClick(giftIconImg,1000);
//        return CommonMacro.clickImageOnScreen(giftIconImg);

//        String giftIconImgPath = "src/main/resources/lastshelter/images/mail/giftIcon.jpg";
//        ImageInfo giftIconImg = ImageUtil.findImageOnScreen(giftIconImgPath);
//        System.out.println(giftIconImg.getXPosition());
//        if (giftIconImg.getXPosition() < 315){
//            return false;
//        }
//        CommonMacro.clickPosition(Convertor.imageInfo2Position(giftIconImg));
//        return true;
    }

    private void clickAllGiftIcon() {
        boolean isExist;
        do {
            clickGiftIcon();
            isExist = ImageUtil.findImageOnScreen(giftIconImg.getImgFile().getAbsolutePath()).getIsOnScreen();
//            isExist = clickGiftIcon();
        } while (isExist);
    }

    private ImageInfo findMailImgInfo(String mailName) {
        ImageInfo selectedImgInfo = null;
        for (String alertName :
                this.alertImgs.keySet()) {
            if (alertName.contains(mailName)) {
                selectedImgInfo = this.alertImgs.get(alertName);
                break;
            }
        }
        return selectedImgInfo;
    }

    private boolean isNewAlert(String mailName) {
        ImageInfo selectedImgInfo = findMailImgInfo(mailName);

        if (selectedImgInfo == null) {
            throw new NullPointerException(mailName + " is wrong name");
        }

        BufferedImage captureImg = null;
        BufferedImage expectedImg = null;

        try {
            captureImg = ImageUtil.createScreenCapture(selectedImgInfo);
            expectedImg = ImageIO.read(selectedImgInfo.getImgFile());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert expectedImg != null;
        return ImageUtil.getDifferencePercent(captureImg, expectedImg) > 0.1;
    }

    private void clickMail(String mailName) {
        ImageInfo selectedImgInfo = findMailImgInfo(mailName);
        if (selectedImgInfo == null) {
            throw new NullPointerException(mailName + " is wrong name");
        }

        CommonMacro.waitTimeAndClick(selectedImgInfo,500);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
