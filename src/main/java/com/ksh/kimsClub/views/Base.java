package com.ksh.kimsClub.views;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.ImageUtil;
import com.ksh.common.utils.OCRUtil;
import com.ksh.kimsClub.commonMacro.*;
import com.ksh.kimsClub.views.alliance.AllianceGift;
import com.ksh.kimsClub.views.alliance.AllianceHelp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base {

    private ImageInfo benefitsIconImg = new ImageInfo(395, 220, 25, 30, "src/main/resources/lastshelter/images/base/benefitsIcon.jpg");

    private ImageInfo settingsIconImg = new ImageInfo(396, 376, 29, 20, "src/main/resources/lastshelter/images/base/settingsIcon.jpg");
    private ImageInfo mailIconImg = new ImageInfo(396, 426, 29, 20, "src/main/resources/lastshelter/images/base/mailIcon.jpg");
    private ImageInfo itemIconImg = new ImageInfo(396, 476, 29, 20, "src/main/resources/lastshelter/images/base/itemIcon.jpg");
    private ImageInfo allianceIconImg = new ImageInfo(396, 526, 29, 20, "src/main/resources/lastshelter/images/base/allianceIcon.jpg");

    private ImageInfo giftIconImg = new ImageInfo(396, 571, 29, 29, "src/main/resources/lastshelter/images/base/giftIcon.jpg");
    private ImageInfo helpIconImg = new ImageInfo(404, 536, 21, 15, "src/main/resources/lastshelter/images/base/helpIcon.jpg");

    private ImageInfo menuIconImg = new ImageInfo(396, 571, 29, 29, "src/main/resources/lastshelter/images/base/menuIcon.jpg");
    private ImageInfo heroIconImg = new ImageInfo(396, 631, 29, 29, "src/main/resources/lastshelter/images/base/heroIcon.jpg");

    private ImageInfo outdoorIconImg = new ImageInfo(385, 760, 42, 42, "src/main/resources/lastshelter/images/base/outdoorIcon.jpg");

    private ImageInfo quitOkImg = new ImageInfo(135, 480, 165, 40, "src/main/resources/lastshelter/images/base/quitOkButton.jpg");

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final Base instance = new Base();

    private Base() {
    }

    public static Base getInstance() {
        return instance;
    }

    public void gotoBaseHome() {
        logger.info("start gotoBaseHome");
        do {
            CommonMacro.click(409, 89);
            CommonMacro.clickBack();
            CommonMacro.clickBack();
        } while (!OCRUtil.isImgContainsText(quitOkImg, "K"));
        CommonMacro.clickBack();
        CommonMacro.waitImgAndClick(outdoorIconImg);
//        CommonMacro.clickImage(outdoorIconImg);
//        CommonMacro.sleep(100);
        ImageUtil.waitForImgAppear(heroIconImg, 5000);
        CommonMacro.clickBack();
        ImageUtil.waitForImgAppear(heroIconImg, 5000);
        logger.info("finish gotoBaseHome");
    }

    public Benefits clickBenefitsIcon() {
        CommonMacro.waitImgAndClick(benefitsIconImg);
//        CommonMacro.clickImageOnScreen(benefitsIconImg);
        return Benefits.getInstance();
    }

    public Settings clickSettingsIcon() {
        clickMenuToOpen();
        CommonMacro.waitImgAndClick(settingsIconImg);
//        CommonMacro.clickImageOnScreen(settingsIconImg);
        return Settings.getInstance();
    }

    public Mail clickMailIcon() {
        clickMenuToOpen();
        CommonMacro.waitImgAndClick(mailIconImg);
//        CommonMacro.clickImageOnScreen(mailIconImg);
        return Mail.getInstance();
    }

    public Item clickItemIcon() {
        clickMenuToOpen();
        CommonMacro.waitImgAndClick(itemIconImg);
//        CommonMacro.clickImageOnScreen(itemIconImg);
        return Item.getInstance();
    }

    public Alliance clickAllianceIcon() {
        clickMenuToOpen();
        CommonMacro.waitImgAndClick(allianceIconImg);
//        CommonMacro.clickImageOnScreen(allianceIconImg);
        return Alliance.getInstance();
    }

    private void clickMenuToOpen() {
        clickMenuToClose();
        clickMenuIcon();
    }

    private void clickMenuToClose() {
        if (isMenuOpened()) {
            clickMenuIcon();
        }
    }

    public AllianceHelp clickHelpIcon() {
        clickMenuToClose();
        ImageInfo findImage = ImageUtil.findImageOnScreen(helpIconImg.getImgFile().getAbsolutePath());
        if (findImage.getIsOnScreen()) {
            CommonMacro.waitTimeAndClick(findImage, 100);
            return AllianceHelp.getInstance();
        }else{
            return null;
        }
    }

    public Hero clickHeroIcon() {
        clickMenuToClose();
        ImageInfo findImage = ImageUtil.findImageOnScreen(heroIconImg.getImgFile().getAbsolutePath());
        if (findImage.getIsOnScreen()) {
            CommonMacro.waitTimeAndClick(heroIconImg, 100);
            return Hero.getInstance();
        }else{
            return null;
        }
    }

    public AllianceGift clickGiftIcon() {
        ImageInfo findImage = ImageUtil.findImageOnScreen(giftIconImg.getImgFile().getAbsolutePath());
        if (findImage.getIsOnScreen()) {
            CommonMacro.waitTimeAndClick(findImage, 100);
            return AllianceGift.getInstance();
        }else{
            return null;
        }
    }

    private void clickMenuIcon() {
        CommonMacro.waitTimeAndClick(menuIconImg,500);
//        CommonMacro.clickImage(menuIconImg);
    }

    private boolean isMenuOpened() {
        return !isMenuClosed();
    }

    private boolean isMenuClosed() {
        ImageInfo findImage = ImageUtil.findImageOnScreen(menuIconImg.getImgFile().getAbsolutePath());
        return findImage.getIsOnScreen();
    }

}
