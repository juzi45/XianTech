package com.qq.xiantech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

/**
 * StringCrystalBlock 弦晶矿
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
public class StringCrystalBlock extends Block {

    /**
     * 默认属性
     */
    private final static Properties DEFAULT_PROPERTIES = Properties.of().mapColor(MapColor.STONE);

    /**
     * 单例对象
     */
    private final static StringCrystalBlock INSTANCE = new StringCrystalBlock();

    public StringCrystalBlock() {
        super(DEFAULT_PROPERTIES);
    }

    public static StringCrystalBlock getInstance() {
        return INSTANCE;
    }

}
