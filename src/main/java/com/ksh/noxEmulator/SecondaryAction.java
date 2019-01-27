package com.ksh.noxEmulator;

import lombok.Getter;

public enum SecondaryAction {
    MOUSENOACTKBDRL(0),
    MOUSERLKBDHLD(1),
    SWIPECOORD(2),
    SPACERLINE(6);

    @Getter
    int value;

    SecondaryAction(int value) {
        this.value = value;
    }
}
