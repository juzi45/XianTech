package com.qq.xiantech.block.ore;

import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

/**
 * StringCrystalBlock 弦晶矿
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
public class StringCrystalOre extends DropExperienceBlock {

    /**
     * 默认属性
     */
    private final static Properties DEFAULT_PROPERTIES = Properties.of()
            .mapColor(MapColor.STONE)
            .sound(SoundType.METAL)
            .strength(1f);

    /**
     * 掉落经验
     */
    private final static IntProvider DEFAULT_INT_PROVIDER = UniformInt.of(3, 10);

    public StringCrystalOre() {
        super(DEFAULT_PROPERTIES, DEFAULT_INT_PROVIDER);
    }


}
