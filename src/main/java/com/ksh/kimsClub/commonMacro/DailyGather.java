package com.ksh.kimsClub.commonMacro;

import org.opencv.core.Core;

import java.util.Date;

public class DailyGather {
    public static void main(String[] args) {
        Base base = Base.getInstance();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        String[] ids = {"bogus-h-think@hanmail.net", "tptkddlf@mailinator.com","kimseunghyun.bg@gmail.com"
                ,"tptkddlf1@mailinator.com", "tptkddlf3@mailinator.com", "tptkddlf7@mailinator.com", "tptkddlf11@mailinator.com"
                };
        String pwd = "eyggtm78!";
        for (String id : ids) {
            long startTime = System.currentTimeMillis();

            // 로그인
            base.gotoBaseHome();
            base.clickSettingsIcon().clickAccountButton().clickSwitchAccountButton().clickIm30AccountButton().login(id, pwd);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 연맹 도움
            base.gotoBaseHome();
            AllianceHelp allianceHelp = base.clickHelpIcon();
            if (allianceHelp != null)
                allianceHelp.clickHelpAllButton();

            // 연맹 선물
            base.gotoBaseHome();
            AllianceGift allianceGift = base.clickGiftIcon();
            if (allianceGift != null)
                allianceGift.clickAllCollectButton();

            // 매일보급
            base.gotoBaseHome();
            base.clickBenefitsIcon().getDailySupply();

            // 일일 영웅 소환
            base.gotoBaseHome();
            base.clickHeroIcon().clickRecruitButton().runFreeRecruit();

            // 메일 확인
            base.gotoBaseHome();
            base.clickMailIcon().readAllMails();

            // 일일 보상 수령
            base.gotoBaseHome();
            base.clickAllienceIcon().clickSalary().gatherAllBox();

            long endTime = System.currentTimeMillis();
            System.out.println("start Time: "+new Date(startTime * 1000));
            System.out.println("end Time: "+new Date(endTime * 1000));
        }
    }
}
