package com.ksh.kimsClub.views;

public class Item {

    private static final Item instance = new Item();

    private Item() {
    }

    public static Item getInstance() {
        return instance;
    }
}
