package com.qq.xiantech.tab;

import com.qq.xiantech.block.DeepSlate_StringCrystalBlock;
import com.qq.xiantech.block.Deepslate_StringCrystalBlockItem;
import com.qq.xiantech.block.StringCrystalBlock;
import com.qq.xiantech.block.StringCrystalBlockItem;
import net.minecraft.world.item.CreativeModeTab;

/**
 * XianTechTab 弦科技Tab页
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
public class XianTechTab {

    /**
     * 默认属性
     */
    private final static CreativeModeTab.Builder BUILDER = CreativeModeTab.builder()
            .icon(() -> StringCrystalBlockItem.getInstance().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(StringCrystalBlock.getInstance());
                output.accept(StringCrystalBlockItem.getInstance());
                output.accept(DeepSlate_StringCrystalBlock.getInstance());
                output.accept(Deepslate_StringCrystalBlockItem.getInstance());
            });

    /**
     * 单例对象
     */
    private final static CreativeModeTab INSTANCE = BUILDER.build();

    public XianTechTab() {

    }

    public static CreativeModeTab getInstance() {
        return INSTANCE;
    }
}
