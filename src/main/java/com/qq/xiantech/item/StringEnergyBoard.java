package com.qq.xiantech.item;

import net.minecraft.world.item.Item;

public class StringEnergyBoard extends Item {

    /**
     * 默认属性 **需添加耐久对应能量属性
     */
    private final static Item.Properties DEFAULT_PROPERTIES = new Item.Properties();

    /**
     * 单例对象
     */
    private final static StringEnergyBoard INSTANCE = new StringEnergyBoard();

    public StringEnergyBoard() {
        super(DEFAULT_PROPERTIES);
    }

    public static StringEnergyBoard getInstance() {
        return INSTANCE;
    }

}
