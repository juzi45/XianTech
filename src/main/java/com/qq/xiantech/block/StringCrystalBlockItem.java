package com.qq.xiantech.block;

import net.minecraft.world.item.BlockItem;

/**
 * StringCrystalBlockItem 弦晶矿
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
public class StringCrystalBlockItem extends BlockItem {

    /**
     * 默认属性
     */
    private final static Properties DEFAULT_PROPERTIES = new Properties();

    /**
     * 单例对象
     */
    private final static StringCrystalBlockItem INSTANCE = new StringCrystalBlockItem();

    public StringCrystalBlockItem() {
        super(StringCrystalBlock.getInstance(), DEFAULT_PROPERTIES);
    }

    public static StringCrystalBlockItem getInstance() {
        return INSTANCE;
    }

}
