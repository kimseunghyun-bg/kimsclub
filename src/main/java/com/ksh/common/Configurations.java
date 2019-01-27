package com.ksh.common;

import lombok.Getter;

import java.io.File;

public class Configurations {
    @Getter
    public static String macroFilePath = "C:/Users/Seunghyun/AppData/Local/Nox/record/541bd8103bd24ad1b28407d1f17b524e";
    @Getter
    public static File macroFile = new File(macroFilePath);
}
