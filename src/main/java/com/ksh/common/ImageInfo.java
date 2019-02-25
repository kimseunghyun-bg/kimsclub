package com.ksh.common;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

public class ImageInfo {
    @Getter
    @Setter
    int xPosition;

    @Getter
    @Setter
    int yPosition;

    @Getter
    int width;

    @Getter
    int height;

    @Getter
    File imgFile;

    @Setter
    @Getter
    Boolean isOnScreen = false;

    @Setter
    @Getter
    int section_x=0;
    @Setter
    @Getter
    int section_y=0;

    public ImageInfo(int xPosition, int yPosition, int width, int height) {
        this(xPosition, yPosition, width, height, null);
    }

    public ImageInfo(int xPosition, int yPosition, int width, int height, String filePath) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.width = width;
        this.height = height;
        if (filePath != null)
            this.imgFile = new File(filePath);
    }

    public int getCenterX(){
        return Math.round((this.getXPosition() + (this.getWidth() / 2)));
    }

    public int getCenterY(){
        return Math.round((this.getYPosition() + (this.getHeight() / 2)));
    }

    @Override
    public String toString() {
        String result = "ImageInfo{" +
                "xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", width=" + width +
                ", height=" + height;
        if (imgFile != null)
            result += ", imgFilePath=" + imgFile.getPath();
        result += '}';
        return result;
    }
}
