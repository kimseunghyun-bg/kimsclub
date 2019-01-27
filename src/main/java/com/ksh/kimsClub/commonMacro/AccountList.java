package com.ksh.kimsClub.commonMacro;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.Keyboard;
import com.ksh.common.Position;

public class AccountList {

    private ImageInfo addAccountButtonImg = new ImageInfo(175, 750, 90, 30);
    private ImageInfo idBoxImg = new ImageInfo(45, 335, 25, 25);
    private ImageInfo pwdBoxImg = new ImageInfo(45, 395, 25, 25);
    private ImageInfo mailLoginButtonImg = new ImageInfo(175, 490, 90, 30);
    private ImageInfo okButtonImg = new ImageInfo(150, 485, 150, 30, "src/main/resources/lastshelter/images/accountList/okButton.jpg");

    private static final AccountList instance = new AccountList();

    private AccountList() {
    }

    public static AccountList getInstance() {
        return instance;
    }

    private void clickAddAccountButton() {
        CommonMacro.clickImageHasText(addAccountButtonImg, "Add");
    }

    private void clickIdTextBox() {
        CommonMacro.clickImage(idBoxImg);
    }

    private void clickPwdTextBox() {
        CommonMacro.clickImage(pwdBoxImg);
    }

    private void clickMailLoginButton() {
        CommonMacro.clickImageHasText(mailLoginButtonImg, "login");
    }

    private void clickOkButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonMacro.clickImageOnScreen(okButtonImg);
    }

    private void insertId(String id) {
        clickIdTextBox();
        Keyboard.type(id);
    }

    private void insertPwd(String pwd) {
        clickPwdTextBox();
        Keyboard.type(pwd);
    }

    public void login(String id, String pwd) {
        clickAddAccountButton();
        insertId(id);
        clickPwdTextBox();
        insertPwd(pwd);
        clickMailLoginButton();
        clickOkButton();
        clickOkButton();
    }

}
