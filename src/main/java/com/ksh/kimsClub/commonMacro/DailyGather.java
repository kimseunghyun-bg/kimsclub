package com.ksh.kimsClub.commonMacro;

import com.ksh.kimsClub.views.Base;
import com.ksh.kimsClub.views.Buildings;
import com.ksh.kimsClub.views.CommercialHub;
import com.ksh.kimsClub.views.alliance.AllianceGift;
import com.ksh.kimsClub.views.alliance.AllianceHelp;
import org.opencv.core.Core;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

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

            // 연맹 도움
            base.gotoBaseHome();
            Optional.ofNullable(base.clickHelpIcon()).ifPresent(AllianceHelp::clickHelpAllButton);

            // 연맹 선물
            base.gotoBaseHome();
            Optional.ofNullable(base.clickGiftIcon()).ifPresent(AllianceGift::clickAllCollectButton);
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

            // 연맹 기부
            base.gotoBaseHome();
            base.clickAllianceIcon().clickTechnology().contribute();

            // 물 판매
            base.gotoBaseHome();
            Optional.ofNullable(Buildings.getInstance().rssTrade()).ifPresent(CommercialHub::sellWater);

            // 생산센터 수확
            base.gotoBaseHome();
            Buildings.getInstance().harvest();

            // 전기 구매
            base.gotoBaseHome();
            Optional.ofNullable(Buildings.getInstance().rssTrade()).ifPresent(CommercialHub::buyElectricity);

            // 일일 보상 수령
            base.gotoBaseHome();
            base.clickAllianceIcon().clickSalary().gatherAllBox();

            // 로그인
            base.gotoBaseHome();
            base.clickSettingsIcon().clickAccountButton().clickSwitchAccountButton().clickIm30AccountButton().login(id, pwd);
            CommonMacro.sleep(5000);

            long endTime = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss.SSS");
            System.out.println("start Time: "+sdf.format(new Date(startTime)));
            System.out.println("end Time: "+sdf.format(new Date(endTime)));
            System.out.println((endTime-startTime)/1000L);
        }
    }
}
