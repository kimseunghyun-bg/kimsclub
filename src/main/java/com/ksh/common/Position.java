package com.ksh.common;

import lombok.Getter;

public class Position {
    @Getter
    int x;
    @Getter
    int y;
    @Getter
    int section;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.section=0;
    }

    public Position(int x, int y, int section) {
        this.x = x;
        this.y = y;
        this.section = section;
    }

}