package com.qq.xiantech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public class DeepSlate_StringCrystalBlock extends Block {
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
    private final static DeepSlate_StringCrystalBlock INSTANCE = new DeepSlate_StringCrystalBlock();

    public DeepSlate_StringCrystalBlock() {
        super(DEFAULT_PROPERTIES);
    }

    public static DeepSlate_StringCrystalBlock getInstance() {
        return INSTANCE;
    }
}
