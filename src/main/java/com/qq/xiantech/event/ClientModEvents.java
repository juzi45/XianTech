package com.qq.xiantech.event;


import com.qq.xiantech.block.*;

import com.qq.xiantech.item.StringCrystal;
import com.qq.xiantech.tab.XianTechTab;
import lombok.extern.slf4j.Slf4j;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

import static com.qq.xiantech.XianTech.MODID;

/**
 * ClientModEvents 订阅客户端 Mod 事件总线
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
@Slf4j
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    /**
     * 客户端启动事件
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        log.info("HELLO FROM CLIENT SETUP");
        log.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }

    /**
     * Mod注册事件
     *
     * @param event 事件
     */
    @SubscribeEvent
    public static void register(RegisterEvent event) {
        log.info("HELLO from RegisterEvent");

        registerCreativeTab(event);
        registerBlocks(event);
        registerItems(event);
    }

    /**
     * 注册创造模式Tab
     *
     * @param event 注册事件
     */
    private static void registerCreativeTab(RegisterEvent event) {
        event.register(ResourceKey.createRegistryKey(new ResourceLocation("creative_mode_tab")),
                helper -> helper.register(new ResourceLocation(MODID, "xiantech_tab"), XianTechTab.getInstance())
        );
    }

    /**
     * 注册Blocks
     *
     * @param event 注册事件
     */
    private static void registerBlocks(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.BLOCKS,
                helper -> {
                    // Block
                    helper.register(new ResourceLocation(MODID, "string_crystal_block"), StringCrystalBlock.getInstance());
                    helper.register(new ResourceLocation(MODID, "deepslate_string_crystal_block"), DeepSlateStringCrystalBlock.getInstance());
                }
        );
    }

    /**
     * 注册Items
     *
     * @param event 注册事件
     */
    private static void registerItems(RegisterEvent event) {
        event.register(ForgeRegistries.Keys.ITEMS,
                helper -> {
                    // BlockItem
                    helper.register(new ResourceLocation(MODID, "string_crystal_block"), StringCrystalBlockItem.getInstance());
                    helper.register(new ResourceLocation(MODID, "deepslate_string_crystal_block"), DeepSlateStringCrystalBlockItem.getInstance());

                    // Item
                    helper.register(new ResourceLocation(MODID, "string_crystal"), StringCrystal.getInstance());
                }
        );
    }
}
