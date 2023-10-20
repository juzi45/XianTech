package com.qq.xiantech.world.feature;

import com.qq.xiantech.XianTech;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

/**
 * 注册-矿石摆放位置
 *
 * @author Pig-Gua
 * @date 2023-10-18
 */
public class ModPlacedFeatures {

    //矿石摆放 注意fantom_ore_placed要和数据包名称保持一致
    public static final ResourceKey<PlacedFeature> FANTOM_ORES_PLACED_KEY = registerKey("string_crystal_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, FANTOM_ORES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FANTOM_ORES),
                ModOrePlacementUtil.commonOrePlacement(4,//每个区块生成多少矿石
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(40))));//-60，60分别指矿石生成高度范围介于[-60,60]

    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(XianTech.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
