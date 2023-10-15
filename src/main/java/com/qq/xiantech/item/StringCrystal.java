package com.qq.xiantech.item;

import net.minecraft.world.item.Item;

/**
 * StringCrystal 弦晶
 *
 * @author Pig-Gua
 * @date 2023-10-15
 */
public class StringCrystal extends Item {

    /**
     * 默认属性
     */
    private final static Properties DEFAULT_PROPERTIES = new Properties();

    /**
     * 单例对象
     */
    private final static StringCrystal INSTANCE = new StringCrystal();

    public StringCrystal() {
        super(DEFAULT_PROPERTIES);
    }

    public static StringCrystal getInstance() {
        return INSTANCE;
    }

}
