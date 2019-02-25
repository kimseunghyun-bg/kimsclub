package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.ImageUtil;
import com.ksh.kimsClub.commonMacro.CommonMacro;

public class CommercialHub {
    private static final CommercialHub instance = new CommercialHub();

    private CommercialHub() {
    }

    public static CommercialHub getInstance() {
        return instance;
    }

    private ImageInfo buyIconImg = new ImageInfo(375,225,50, 50,"src/main/resources/lastshelter/images/commecialHub/buyIcon.jpg");
    private ImageInfo sellIconImg = new ImageInfo(375,310,50, 50,"src/main/resources/lastshelter/images/commecialHub/sellIcon.jpg");

    private ImageInfo waterIconImg = new ImageInfo(35,530,25, 25,"src/main/resources/lastshelter/images/commecialHub/waterIcon.jpg");
    private ImageInfo electricityIconImg = new ImageInfo(35,655,25, 25,"src/main/resources/lastshelter/images/commecialHub/electricityIcon.jpg");

    private ImageInfo buyButtonImg = new ImageInfo(195,765,55, 30,"src/main/resources/lastshelter/images/commecialHub/buyButton.jpg");
    private ImageInfo sellButtonImg = new ImageInfo(195,765,55, 30,"src/main/resources/lastshelter/images/commecialHub/sellButton.jpg");

    private void clickBuyIcon(){
        CommonMacro.waitImgAndClick(buyIconImg);
    }

    private void clickSellIcon(){
        CommonMacro.waitImgAndClick(sellIconImg);
    }

    private ImageInfo findRssIcon(ImageInfo rssImg){
        ImageInfo findImage = ImageUtil.findImageOnScreen(rssImg);
        if (findImage.getIsOnScreen()) {
            return findImage;
        } else {
            CommonMacro.drag(rssImg.getCenterX(), rssImg.getCenterY(),
                    rssImg.getCenterX(), rssImg.getCenterY()-300);
            CommonMacro.sleep(500);
            return ImageUtil.findImageOnScreen(rssImg);
        }
    }

    public void sellWater(){
        clickSellIcon();
        ImageInfo waterIcon = findRssIcon(this.waterIconImg);
        if (waterIcon.getIsOnScreen()) {
            CommonMacro.drag(310, waterIcon.getCenterY(), 325, waterIcon.getCenterY());
            CommonMacro.sleep(200);
            CommonMacro.waitTextAndClick(sellButtonImg,"Sell");
        }
    }

    public void buyElectricity(){
        clickBuyIcon();
        ImageInfo electricityIcon = findRssIcon(this.electricityIconImg);
        if (electricityIcon.getIsOnScreen()) {
            CommonMacro.drag(310, electricityIcon.getCenterY(), 325, electricityIcon.getCenterY());
            CommonMacro.sleep(200);
            CommonMacro.waitTextAndClick(buyButtonImg,"Buy");
        }
    }
}
