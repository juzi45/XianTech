package com.qq.xiantech.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

/**
 * 深层弦晶矿
 */
public class DeepSlateStringCrystalBlockItem extends BlockItem {
    /**
     * 默认属性
     */
    private final static Item.Properties DEFAULT_PROPERTIES = new Item.Properties();

    /**
     * 单例对象
     */
    private final static DeepSlateStringCrystalBlockItem INSTANCE = new DeepSlateStringCrystalBlockItem();

    public DeepSlateStringCrystalBlockItem() {
        super(DeepSlateStringCrystalBlock.getInstance(), DEFAULT_PROPERTIES);
    }

    public static DeepSlateStringCrystalBlockItem getInstance() {
        return INSTANCE;
    }

}
