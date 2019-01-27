package com.ksh.common.utils;

import java.awt.*;
import java.awt.event.InputEvent;

public class MouseUtil {
    private static final int CLICK = 0;
    private static final int DRAG = 1;
    private static final int DRAGONBASE = 2;
    private static Robot robot;
    private static final int DELAY=750;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void clickMouseRecorder() {
        click(460, 385);

        drag(215, 240, 215, 830);
    }

    public static void clickPlayMacro() {
        click(326, 989);
    }

    public static void click(int x, int y) {
        useMouse(x, y, 0, 0, CLICK);
        robot.delay(DELAY);
    }

    public static void drag(int start_x, int start_y, int end_x, int end_y) {
        useMouse(start_x, start_y, end_x, end_y, DRAG);
        robot.delay(DELAY);
    }

    public static void dragOnBase(int start_x, int start_y, int end_x, int end_y) {
        useMouse(start_x, start_y, end_x, end_y, DRAGONBASE);
        robot.delay(DELAY);
    }

    private static synchronized void useMouse(int start_x, int start_y, int end_x, int end_y, int method) {
        robot.mouseMove(start_x, start_y);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        if (method == DRAGONBASE || method == DRAG) {
            robot.delay(200);

            if (method == DRAGONBASE) {
                int temp_x = start_x + 15;
                int temp_y = start_y + 15;
                while (start_x != temp_x || start_y != temp_y) {
                    start_x = calculateDragPosition(start_x, temp_x);
                    start_y = calculateDragPosition(start_y, temp_y);
                    robot.delay(20);
                    robot.mouseMove(start_x, start_y);
                }

                end_x += 11;
                end_y += 11;
            }
            while (start_x != end_x || start_y != end_y) {
                start_x = calculateDragPosition(start_x, end_x);
                start_y = calculateDragPosition(start_y, end_y);
                robot.delay(1);
                robot.mouseMove(start_x, start_y);
            }
            robot.delay(200);
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }

    private static int calculateDragPosition(int startPosition, int endPosition) {
        int movePosition = 1;
        if (startPosition < endPosition) {
            if (endPosition - startPosition < movePosition) {
                return endPosition;
            }
            return startPosition + movePosition;
        } else if (startPosition > endPosition) {
            if (startPosition - endPosition < movePosition) {
                return endPosition;
            }
            return startPosition - movePosition;
        } else {
            return startPosition;
        }
    }

    public static void main(String[] args) {
        clickMouseRecorder();
    }
}
