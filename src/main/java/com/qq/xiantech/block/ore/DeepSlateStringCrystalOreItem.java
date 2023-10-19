package com.qq.xiantech.block.ore;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * DeepSlateStringCrystalBlock 深层弦晶矿
 *
 * @author juyue
 * @date 2023-10-15
 */
public class DeepSlateStringCrystalOreItem extends BlockItem {

    /**
     * 默认属性
     */
    private final static Item.Properties DEFAULT_PROPERTIES = new Item.Properties();

    public DeepSlateStringCrystalOreItem(Block block) {
        super(block, DEFAULT_PROPERTIES);
    }

}
