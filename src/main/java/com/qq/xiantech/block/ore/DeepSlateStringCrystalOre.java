package com.qq.xiantech.block.ore;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

/**
 * DeepSlateStringCrystalOre 深层弦晶矿
 *
 * @author juyue
 * @date 2023-10-15
 */
public class DeepSlateStringCrystalOre extends Block {

    /**
     * 默认属性
     */
    private final static Properties DEFAULT_PROPERTIES = Properties.of()
            .mapColor(MapColor.STONE)
            .sound(SoundType.METAL)
            .strength(2f)
            .requiresCorrectToolForDrops();

    public DeepSlateStringCrystalOre() {
        super(DEFAULT_PROPERTIES);
    }

}
