package com.qq.xiantech.block.ore;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

/**
 * StringCrystalBlockItem 弦晶矿
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
public class StringCrystalOreItem extends BlockItem {

    /**
     * 默认属性
     */
    private final static Properties DEFAULT_PROPERTIES = new Properties();

    public StringCrystalOreItem(Block block) {
        super(block, DEFAULT_PROPERTIES);
    }


}
