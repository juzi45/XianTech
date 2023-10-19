package com.qq.xiantech.event;


import com.qq.xiantech.block.*;

import com.qq.xiantech.tab.TabInit;
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

import static com.qq.xiantech.XianTech.MOD_ID;

/**
 * ClientModEvents 订阅客户端 Mod 事件总线
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
@Slf4j
@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
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
    }

}
