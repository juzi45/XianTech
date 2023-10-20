package com.qq.xiantech.world.feature;

import com.qq.xiantech.XianTech;
import com.qq.xiantech.block.BlockInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

/**
 * 注册-矿石生成类型
 *
 * @author Pig-Gua
 * @date 2023-10-18
 */
public class ModConfiguredFeatures {

    // 注意fantom_ore要和数据包名称保持一致
    public static final ResourceKey<ConfiguredFeature<?, ?>> FANTOM_ORES = registerKey("string_crystal_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceabeles = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceabeles = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceabeles = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceabeles = new BlockMatchTest(Blocks.END_STONE);

        //将我们第一步的两种矿石分别填入其中
        List<OreConfiguration.TargetBlockState> overworldFantomOres = List.of(OreConfiguration.target(stoneReplaceabeles,
                        BlockInit.STRING_CRYSTAL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceabeles, BlockInit.DEEP_SLATE_STRING_CRYSTAL_ORE.get().defaultBlockState()));
        //将这种矿石生成类型进行注册
        register(context, FANTOM_ORES, Feature.ORE, new OreConfiguration(overworldFantomOres, 64)); // 7
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(XianTech.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature,
                                                                                          FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
