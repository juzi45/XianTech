package com.qq.xiantech.world.feature;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * 矿石摆放工具类
 *
 * @author Pig-Gua
 * @date 2023-10-18
 */
public class ModOrePlacementUtil {

    /**
     * 默认矿石摆放
     *
     * @param countPlacement       个数
     * @param heightRangePlacement 高度范围
     * @return Placement[个数，扩散方式，高度范围，生物群系]
     */
    public static List<PlacementModifier> orePlacement(PlacementModifier countPlacement, PlacementModifier heightRangePlacement) {
        return List.of(countPlacement, InSquarePlacement.spread(), heightRangePlacement, BiomeFilter.biome());
    }

    /**
     * 普通矿石摆放
     *
     * @param numPerChunk          矿石个数(每个区块)
     * @param heightRangePlacement 高度范围
     * @return Placement[个数，扩散方式，高度范围，生物群系]
     */
    public static List<PlacementModifier> commonOrePlacement(int numPerChunk, PlacementModifier heightRangePlacement) {
        return orePlacement(CountPlacement.of(numPerChunk), heightRangePlacement);
    }

    /**
     * 稀有矿石摆放
     *
     * @param numPerOnce           矿石个数(平均每次)
     * @param heightRangePlacement 高度范围
     * @return Placement[个数，扩散方式，高度范围，生物群系]
     */
    public static List<PlacementModifier> rareOrePlacement(int numPerOnce, PlacementModifier heightRangePlacement) {
        return orePlacement(RarityFilter.onAverageOnceEvery(numPerOnce), heightRangePlacement);
    }

}
