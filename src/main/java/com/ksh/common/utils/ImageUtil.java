package com.ksh.common.utils;

import com.ksh.common.ImageInfo;
import org.opencv.core.*;
import org.opencv.core.Point;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImageUtil {
    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static ImageInfo findImage(String sourceImgPath, String templateImgPath) {
        Mat img = Imgcodecs.imread(sourceImgPath, Imgcodecs.IMREAD_COLOR);
        Mat templ = Imgcodecs.imread(templateImgPath, Imgcodecs.IMREAD_COLOR);

        Mat mask = new Mat();
        int match_method;

        Mat result = new Mat();

        int result_cols = img.cols() - templ.cols() + 1;
        int result_rows = img.rows() - templ.rows() + 1;

        result.create(result_rows, result_cols, CvType.CV_32FC1);

        match_method = Imgproc.TM_CCOEFF_NORMED;

        Imgproc.matchTemplate(img, templ, result, match_method, mask);
        Imgproc.threshold(result, result, 0.85, 1, Imgproc.THRESH_TOZERO);

        Point matchLoc;

        Core.MinMaxLocResult mmr = Core.minMaxLoc(result);
        matchLoc = mmr.maxLoc;

        int x = (int) matchLoc.x;
        int y = (int) matchLoc.y;

        ImageInfo imageInfo = new ImageInfo(x, y, templ.cols(), templ.rows());
        if (mmr.maxVal > 0.85)
            imageInfo.setIsOnScreen(true);
        return imageInfo;
    }

    public static List<ImageInfo> findMultiImages(String sourceImgPath, String templateImgPath) {
        List<ImageInfo> resultImages = new ArrayList<>();
        Mat img = Imgcodecs.imread(sourceImgPath, Imgcodecs.IMREAD_COLOR);
        Mat templ = Imgcodecs.imread(templateImgPath, Imgcodecs.IMREAD_COLOR);

        Mat mask = new Mat();
        int match_method;

        Mat result = new Mat();

        int result_cols = img.cols() - templ.cols() + 1;
        int result_rows = img.rows() - templ.rows() + 1;

        result.create(result_rows, result_cols, CvType.CV_32FC1);

        match_method = Imgproc.TM_CCOEFF_NORMED;

        Imgproc.matchTemplate(img, templ, result, match_method, mask);
        Imgproc.threshold(result, result, 0.85, 1, Imgproc.THRESH_TOZERO);

        Point matchLoc;
        Core.MinMaxLocResult mmr;

        while (true) {
            mmr = Core.minMaxLoc(result);
            matchLoc = mmr.maxLoc;

            if (mmr.maxVal >= 0.85) {
                int x = (int) matchLoc.x;
                int y = (int) matchLoc.y;

                ImageInfo imageInfo = new ImageInfo(x, y, templ.cols(), templ.rows());
                imageInfo.setIsOnScreen(true);
                resultImages.add(imageInfo);
                System.out.println(result.get(y,x)[0]);

                result.put(y, x, 0);
            } else {
                break; //No more results within tolerance, break search
            }
        }

        return resultImages;
    }

    public static ImageInfo findImageOnScreen(String templateImgPath) {
        BufferedImage captureImg = robot.createScreenCapture(new Rectangle(0, 0, 440, 813));
        String tempScreenPath = "src/main/resources/lastshelter/images/temp/tempScreen.jpg";
        try {
            ImageIO.write(captureImg, "jpg", new File(tempScreenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return findImage(tempScreenPath, templateImgPath);
    }

    public static List<ImageInfo> findMultiImagesOnScreen(String templateImgPath) {
        BufferedImage captureImg = robot.createScreenCapture(new Rectangle(0, 0, 440, 813));
        String tempScreenPath = "src/main/resources/lastshelter/images/temp/tempScreen2.jpg";
        try {
            ImageIO.write(captureImg, "jpg", new File(tempScreenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return findMultiImages(tempScreenPath, templateImgPath);
    }

    public static double getDifferencePercent(BufferedImage img1, BufferedImage img2) {
        int width = img1.getWidth();
        int height = img1.getHeight();
        int width2 = img2.getWidth();
        int height2 = img2.getHeight();
        if (width != width2 || height != height2) {
            throw new IllegalArgumentException(String.format("Image must have the same dimensions: (%d, %d) vs. (%d, %d)", width, height, width2, height2));
        }

        long diff = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                diff += pixelDiff(img1.getRGB(x, y), img2.getRGB(x, y));
            }
        }
        long maxDiff = 3L * 255 * width * height;

        return 100.0 * diff / maxDiff;
    }

    private static int pixelDiff(int rgb1, int rgb2) {
        int r1 = (rgb1 >> 16) & 0xff;
        int g1 = (rgb1 >> 8) & 0xff;
        int b1 = rgb1 & 0xff;
        int r2 = (rgb2 >> 16) & 0xff;
        int g2 = (rgb2 >> 8) & 0xff;
        int b2 = rgb2 & 0xff;
        return Math.abs(r1 - r2) + Math.abs(g1 - g2) + Math.abs(b1 - b2);
    }

    @Deprecated
    public static boolean compareImage(File file1, File file2) {
        try {
            BufferedImage img1 = ImageIO.read(file1);
            DataBuffer dataBuf1 = img1.getData().getDataBuffer();
            int size1 = dataBuf1.getSize();
            BufferedImage img2 = ImageIO.read(file2);
            DataBuffer dataBuf2 = img2.getData().getDataBuffer();
            int size2 = dataBuf2.getSize();

            if (size1 == size2) {
                for (int i = 0; i < size1; i++) {
                    if (dataBuf1.getElem(i) != dataBuf2.getElem(i)) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public static BufferedImage resizeImage(BufferedImage srcImage, int width, int height) {
        Image tmp = srcImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING);
        BufferedImage resizeImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);

        Graphics2D g = resizeImg.createGraphics();
        g.drawImage(tmp, 0, 0, null);

        return resizeImg;
    }

    @Deprecated
    public static BufferedImage cropImage(BufferedImage srcImg, int width, int height) {
        return srcImg.getSubimage(0, 0, width, height);
    }

    public static BufferedImage createScreenCapture(ImageInfo imageInfo) {
        return robot.createScreenCapture(new Rectangle(imageInfo.getXPosition(), imageInfo.getYPosition(), imageInfo.getWidth(), imageInfo.getHeight()));
    }

    @Deprecated
    public static String findImagePosition(BufferedImage srcImg, BufferedImage bgImg) {
        double diffPercent = 100;
        BufferedImage tmpImg;
        Map<Double, String> similarPosition = new HashMap<>();

        for (int x = 0; x < bgImg.getWidth() - srcImg.getWidth(); x++) {
            for (int y = 0; y < bgImg.getHeight() - srcImg.getHeight(); y++) {
                tmpImg = bgImg.getSubimage(x, y, srcImg.getWidth(), srcImg.getHeight());
                diffPercent = getDifferencePercent(srcImg, tmpImg);
                if (diffPercent < 5) {
                    similarPosition.put(diffPercent, x + "," + y);
                    System.out.println(x + "," + y + " : " + diffPercent);
                }
            }
            System.out.println(x);
        }

        double oldDiff = 100;
        for (Double diff : similarPosition.keySet()) {
            if (oldDiff > diff) {
                oldDiff = diff;
            }
        }

        return similarPosition.get(oldDiff);
    }

    public static void negativeColorImage(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        //convert to negative
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int p = img.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                //subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                //set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(x, y, p);
            }
        }
//        return img;
    }

    public static void main(String[] args) throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        System.out.println(sdf.format(System.currentTimeMillis()));


        // MenuIcon 140, 575, 155, 35
//        BufferedImage captureImg = robot.createScreenCapture(new Rectangle(150, 485, 150, 30));
        BufferedImage captureImg = robot.createScreenCapture(new Rectangle(390, 103, 23, 23));

        ImageIO.write(captureImg, "jpg", new File("sample.jpg"));

        System.out.println(sdf.format(System.currentTimeMillis()));
    }

}
