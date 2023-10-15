package com.qq.xiantech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public class DeepSlateStringCrystalBlock extends Block {
    /*
     * @date 10/15
     * @time 10:30
     *
     */
    /**
     * 默认属性
     */
    private final static Properties DEFAULT_PROPERTIES = Properties.of().mapColor(MapColor.STONE);

    /**
     * 单例对象
     */
    private final static DeepSlateStringCrystalBlock INSTANCE = new DeepSlateStringCrystalBlock();

    public DeepSlateStringCrystalBlock() {
        super(DEFAULT_PROPERTIES);
    }

    public static DeepSlateStringCrystalBlock getInstance() {
        return INSTANCE;
    }
}
