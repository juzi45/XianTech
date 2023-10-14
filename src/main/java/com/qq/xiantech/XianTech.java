package com.qq.xiantech;

import com.qq.xiantech.config.XianTechConfiguration;
import lombok.extern.slf4j.Slf4j;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;

/**
 * 弦科技 Mod
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
@Slf4j
@Mod(XianTech.MODID)
public class XianTech {

    /**
     * 模组ID，必须和 META-INF/mods.toml中保持一致
     */
    public static final String MODID = "xiantech";

    public XianTech() {
        // Forge事件总线
        MinecraftForge.EVENT_BUS.register(this);

        // Mod事件总线
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        // 添加监听方法
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);

        // mod加载的上下文中，注册自定义配置类
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, XianTechConfiguration.SPEC);
    }

    /**
     * mod 加载时的监听
     *
     * @param event FMLCommonSetupEvent
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        log.info("HELLO FROM COMMON SETUP");
        log.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (XianTechConfiguration.logDirtBlock) {
            log.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        }

        log.info(XianTechConfiguration.magicNumberIntroduction + XianTechConfiguration.magicNumber);

        XianTechConfiguration.items.forEach((item) -> log.info("ITEM >> {}", item.toString()));
    }

    /**
     * Add the example block item to the building blocks tab
     *
     * @param event BuildCreativeModeTabContentsEvent
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.accept(REGISTRY_OBJECT_BLOCK_ITEM);
        }
    }


    /**
     * 订阅 EventBus 上的事件
     */
    @SubscribeEvent
    public void allEvent(Event event) {
        if (event instanceof RegisterEvent) {
            log.info("Event {}", event.toString());
        }
    }

    /**
     * 实例事件
     *
     * @param event ServerStartingEvent
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        log.info("HELLO from server starting");
    }


}
