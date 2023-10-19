package com.qq.xiantech.tab;

import com.qq.xiantech.XianTech;
import com.qq.xiantech.block.BlockInit;
import com.qq.xiantech.item.ItemInit;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

/**
 * XianTechTab 弦科技Tab页
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
public class TabInit {

    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, XianTech.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = TABS.register("xiantech_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ItemInit.STRING_CRYSTAL.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ItemInit.STRING_CRYSTAL.get());
                output.accept(BlockInit.STRING_CRYSTAL_ORE.get());
                output.accept(BlockInit.DEEP_SLATE_STRING_CRYSTAL_ORE.get());
                output.accept(ItemInit.STRING_ENERGY_BOARD.get());
            }).build());

}
