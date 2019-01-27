package com.ksh.noxEmulator;

import lombok.Getter;
import lombok.Setter;

public enum Action {
    MOUSENOACT(0),
    MOUSEDOWN(1),
    ANDROIDHOMEBTN(102),
    ANDROIDBACKBTN(158),
    RECENTAPPBTN(221);

    @Getter
    private int value;

    Action(int value) {
        this.value = value;
    }
}
