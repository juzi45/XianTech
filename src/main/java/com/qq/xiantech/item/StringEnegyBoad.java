package com.qq.xiantech.item;

import net.minecraft.world.item.Item;

public class StringEnegyBoad extends Item {

    /**
     * 默认属性 **需添加耐久对应能量属性
     */
    private final static Item.Properties DEFAULT_PROPERTIES = new Item.Properties();

    /**
     * 单例对象
     */
    private final static StringEnegyBoad INSTANCE = new StringEnegyBoad();

    public StringEnegyBoad() {
        super(DEFAULT_PROPERTIES);
    }

    public static StringEnegyBoad getInstance() {
        return INSTANCE;
    }

}
