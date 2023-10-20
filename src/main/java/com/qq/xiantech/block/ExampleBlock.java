package com.qq.xiantech.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

/**
 * ExampleBlock 示例方块
 *
 * @author Pig-Gua
 * @date 2023-10-21
 */
public class ExampleBlock extends Block {

    private static final Properties PROPERTIES = Properties.of()
            // 颜色
            .mapColor(MapColor.STONE)
            // 破坏时间，爆炸抗性
            .strength(5f, 6f)
            // 方块音效
            .sound(SoundType.STONE)
            // 音符盒声音
            .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
            // 需要正确的工具才有掉落(工具定义在resource/data/minecraft/tags/blocks/mineable下面，掉落定义在resource/xiantech/loot_tables/blocks下面)
            .requiresCorrectToolForDrops();

    public ExampleBlock() {
        super(PROPERTIES);
    }
}
