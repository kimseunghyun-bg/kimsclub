package com.ksh.noxEmulator;

import com.ksh.common.Position;

public class MouseMacroBuilder {

    private static int screenWidth = 720;
    private static int screenHeight = 1280;
    private static final String SPACER = "ScRiPtSePaRaToR";

    public static String createDragScript(Position startPosition, Position endPosition, int startTime) {
        return createDragScript(startPosition.getX(), startPosition.getY(), endPosition.getX(), endPosition.getY(), startTime);
    }

    public static String createDragScript(int start_x, int start_y, int end_x, int end_y, int startTime) {
        String result = createScriptRow(screenWidth, screenHeight, ActionType.MULTI, Action.MOUSEDOWN,
                SecondaryAction.MOUSENOACTKBDRL, start_x, start_y, startTime);
        while (start_x != end_x || start_y != end_y) {
            start_x = calculateDragPosition(start_x, end_x);
            start_y = calculateDragPosition(start_y, end_y);
            startTime += 10;
            result += createScriptRow(screenWidth, screenHeight, ActionType.MULTI, Action.MOUSEDOWN,
                    SecondaryAction.SWIPECOORD, start_x, start_y, startTime);
        }
        startTime += 500;
        result += createScriptRow(screenWidth, screenHeight, ActionType.MULTI, Action.MOUSENOACT,
                SecondaryAction.SPACERLINE, startTime);
        result += createScriptRow(screenWidth, screenHeight, ActionType.MULTI, Action.MOUSENOACT,
                SecondaryAction.SPACERLINE, startTime);
        result += createScriptRow(screenWidth, screenHeight, ActionType.MULTI, Action.MOUSENOACT,
                SecondaryAction.MOUSERLKBDHLD, startTime);
        result += createScriptRow(screenWidth, screenHeight, ActionType.MSBRL, Action.MOUSENOACT,
                SecondaryAction.MOUSENOACTKBDRL, startTime);
        return result;
    }

    private static int calculateDragPosition(int startPosition, int endPosition) {
        int movePosition=30;
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

    public static String createClickScript(Position position, int startTime) {
        return createClickScript(position.getX(), position.getY(), startTime);
    }

    public static String createClickScript(int x, int y, int startTime) {
        // mouse press
        String result = createScriptRow(screenWidth, screenHeight, ActionType.MULTI,
                Action.MOUSEDOWN, SecondaryAction.MOUSENOACTKBDRL, x, y, startTime);
        startTime += 100;
        // not necessary
        result += createScriptRow(screenWidth, screenHeight, ActionType.MULTI,
                Action.MOUSENOACT, SecondaryAction.SPACERLINE, startTime);
        result += createScriptRow(screenWidth, screenHeight, ActionType.MULTI,
                Action.MOUSENOACT, SecondaryAction.SPACERLINE, startTime);
        result += createScriptRow(screenWidth, screenHeight, ActionType.MULTI,
                Action.MOUSENOACT, SecondaryAction.MOUSERLKBDHLD, startTime);
        result += createScriptRow(screenWidth, screenHeight, ActionType.MSBRL,
                Action.MOUSENOACT, SecondaryAction.MOUSENOACTKBDRL, startTime);
        return result;
    }

    public static String createBackScript(int startTime) {
        String result = createScriptRow(screenWidth, screenHeight, ActionType.KBDPR,
                Action.ANDROIDBACKBTN, SecondaryAction.MOUSENOACTKBDRL, startTime);
        result += createScriptRow(screenWidth, screenHeight, ActionType.KBDRL,
                Action.ANDROIDBACKBTN, SecondaryAction.MOUSENOACTKBDRL, startTime);
        return result;
    }

    private static String createScriptRow(int screenWidth, int screenHeight, ActionType actionType,
                                   Action action, SecondaryAction secondaryAction, int time) {
        return createScriptRow(screenWidth, screenHeight, actionType, action, secondaryAction, null, null, time);
    }

    private static String createScriptRow(int screenWidth, int screenHeight, ActionType actionType,
                                   Action action, SecondaryAction secondaryAction, Integer mouse_x, Integer mouse_y, int time) {
        String row = "0" + SPACER + screenWidth + "|" + screenHeight + "|" + actionType + ":"
                + action.getValue() + ":" + secondaryAction.getValue();
        if (mouse_x != null && mouse_y != null) {
            row += ":" + mouse_x + ":" + mouse_y;
        }
        row += SPACER + time + "\n";

        return row;
    }

    public static int getLastTime(String macroScript){
        String lastTime = macroScript.substring(macroScript.lastIndexOf(SPACER));
        lastTime = lastTime.replaceAll("[^0-9]","");
        return Integer.parseInt(lastTime);
    }

//    public static int resizeToEmulator(int windowPosition) {
//        return (int) Math.round(windowPosition * 1.636363);
//    }

}