package com.ksh.kimsClub.commonMacro;

import com.ksh.common.utils.ImageUtil;
import com.ksh.common.utils.MouseUtil;
import com.ksh.noxEmulator.MouseMacroBuilder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class StartMacro {
    public static void main(String[] args) throws Exception{
        Robot robot = new Robot();
        BufferedImage capturedImg;
        double diffStartImg;
        do {
            capturedImg = robot.createScreenCapture(new Rectangle(140, 730, 50, 20));
            BufferedImage expectImg = ImageIO.read(new File("src/main/resources/lastshelter/images/start/firstMsgBox.jpg"));
            diffStartImg = ImageUtil.getDifferencePercent(capturedImg, expectImg);
            Thread.sleep(5000);
            System.out.println(diffStartImg);
        }while (diffStartImg > 5);

        System.out.println("end");
        MouseUtil.clickPlayMacro();
        String a = MouseMacroBuilder.createDragScript(110,1190,360,1000,6000);
        System.out.println(a);
    }

    private static void passLevel1(){
        //TODO 초기화면 진행

    }
}
