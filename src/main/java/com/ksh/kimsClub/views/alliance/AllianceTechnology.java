package com.ksh.kimsClub.views.alliance;

import com.ksh.common.ImageInfo;
import com.ksh.common.utils.OCRUtil;
import com.ksh.kimsClub.commonMacro.CommonMacro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AllianceTechnology {
    private ImageInfo techBadgeImg = new ImageInfo(20, 654, 22, 13, "src/main/resources/lastshelter/images/alliance/techBadge.jpg");
    private ImageInfo contributeCountImg = new ImageInfo(200, 595, 40, 20);
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final AllianceTechnology instance = new AllianceTechnology();

    private AllianceTechnology() {
    }

    public static AllianceTechnology getInstance() {
        return instance;
    }

    public void clickRecommendBadge() {
        logger.info("start clickRecommendBadge");
        CommonMacro.waitImgAndClick(techBadgeImg, 1000);
        logger.info("finish clickRecommendBadge");
    }

    public void contribute() {
        clickRecommendBadge();
        int cnt = 0;

        if (OCRUtil.isImgContainsText(contributeCountImg,"0/25"))
            CommonMacro.waitTimeAndClick(220, 635, 500);

        while (!OCRUtil.isImgContainsText(contributeCountImg,"0/25")
        || OCRUtil.isImgContainsText(contributeCountImg,"10/25")
        || OCRUtil.isImgContainsText(contributeCountImg,"20/25")){
            CommonMacro.waitTimeAndClick(220, 635, 500);
            if (OCRUtil.isImgContainsText(contributeCountImg,"0/25"))
                CommonMacro.waitTimeAndClick(220, 635, 500);
            if(++cnt > 30)
                break;
        }
    }
}
