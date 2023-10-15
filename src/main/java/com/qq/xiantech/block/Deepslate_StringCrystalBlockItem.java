package com.qq.xiantech.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * 深层弦晶矿
 */
public class Deepslate_StringCrystalBlockItem extends BlockItem {
    /**
     * 默认属性
     */
    private final static Item.Properties DEFAULT_PROPERTIES = new Item.Properties();

    /**
     * 单例对象
     */
    private final static Deepslate_StringCrystalBlockItem INSTANCE = new Deepslate_StringCrystalBlockItem();

    public Deepslate_StringCrystalBlockItem() {
        super(Block.byItem(Deepslate_StringCrystalBlockItem.getInstance()), DEFAULT_PROPERTIES);
    }

    public static Deepslate_StringCrystalBlockItem getInstance() {
        return INSTANCE;
    }

}
