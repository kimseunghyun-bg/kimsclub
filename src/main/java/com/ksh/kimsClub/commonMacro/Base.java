package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;
import com.ksh.common.Position;
import com.ksh.common.utils.ImageUtil;
import com.ksh.common.utils.MouseUtil;

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

    private static final Base instance = new Base();

    private Base() {
    }

    public static Base getInstance() {
        return instance;
    }

    public void gotoBaseHome() {
        do {
            MouseUtil.click(409, 89);
            CommonMacro.clickBack();
            CommonMacro.clickBack();
        } while (!ImageUtil.findImageOnScreen(quitOkImg.getImgFile().getAbsolutePath()).getIsOnScreen());
        CommonMacro.clickBack();
        CommonMacro.clickImage(outdoorIconImg);
        CommonMacro.waitForImgAppear(heroIconImg,5000);
        CommonMacro.clickBack();
        CommonMacro.waitForImgAppear(heroIconImg,5000);
    }

    public Benefits clickBenefitsIcon(){
        CommonMacro.clickImageOnScreen(benefitsIconImg);
        return Benefits.getInstance();
    }

    public Settings clickSettingsIcon() {
        clickMenuToOpen();
        CommonMacro.clickImageOnScreen(settingsIconImg);
        return Settings.getInstance();
    }

    public Mail clickMailIcon() {
        clickMenuToOpen();
        CommonMacro.clickImageOnScreen(mailIconImg);
        return Mail.getInstance();
    }

    public Item clickItemIcon() {
        clickMenuToOpen();
        CommonMacro.clickImageOnScreen(itemIconImg);
        return Item.getInstance();
    }

    public Alliance clickAllienceIcon() {
        clickMenuToOpen();
        CommonMacro.clickImageOnScreen(allianceIconImg);
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
        boolean isClicked = CommonMacro.clickImageOnScreen(helpIconImg);
        if (isClicked)
            return AllianceHelp.getInstance();
        else
            return null;
    }

    public Hero clickHeroIcon() {
        boolean isClicked = CommonMacro.clickImageOnScreen(heroIconImg);
        if (isClicked)
            return Hero.getInstance();
        else
            return null;
    }

    public AllianceGift clickGiftIcon() {
        CommonMacro.clickImageOnScreen(giftIconImg);
        return AllianceGift.getInstance();
    }

    private void clickMenuIcon() {
        CommonMacro.clickImage(menuIconImg);
    }

    private boolean isMenuOpened() {
        return !isMenuClosed();
    }

    private boolean isMenuClosed() {
        ImageInfo findImage = ImageUtil.findImageOnScreen(menuIconImg.getImgFile().getAbsolutePath());
        return findImage.getIsOnScreen();
    }

}
