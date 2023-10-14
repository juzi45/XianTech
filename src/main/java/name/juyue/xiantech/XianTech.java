package name.juyue.xiantech;

import com.mojang.logging.LogUtils;
import name.juyue.xiantech.config.XianTechConfiguration;
import name.juyue.xiantech.util.RegisterHandLer;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

/**
 * 弦科技 Mod
 *
 * @author Pig-Gua
 * @date 2023-10-14
 */
@Mod(XianTech.MODID)
public class XianTech {

    /**
     * 模组ID，必须和 META-INF/mods.toml中保持一致
     */
    public static final String MODID = "xiantech";

    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * 延迟注册器(Blocks, Items, 创造模式Tabs)
     */
    public static final DeferredRegister<Block> DEFERRED_REGISTER_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);

    public static final DeferredRegister<Item> DEFERRED_REGISTER_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final DeferredRegister<CreativeModeTab> DEFERRED_REGISTER_CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    /**
     * 注册器中添加实例
     */
    public static final RegistryObject<Block> REGISTRY_OBJECT_BLOCK = DEFERRED_REGISTER_BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE)));

    public static final RegistryObject<Item> REGISTRY_OBJECT_BLOCK_ITEM = DEFERRED_REGISTER_ITEMS.register("example_block", () -> new BlockItem(REGISTRY_OBJECT_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> REGISTRY_OBJECT_ITEM = DEFERRED_REGISTER_ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEat().nutrition(1).saturationMod(2f).build())));

    public static final RegistryObject<CreativeModeTab> REGISTRY_OBJECT_TAB = DEFERRED_REGISTER_CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> REGISTRY_OBJECT_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(REGISTRY_OBJECT_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
                output.accept(REGISTRY_OBJECT_BLOCK_ITEM.get());
            }).build());


    public XianTech() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // 添加mod加载的 commonSetup 监听方法
        modEventBus.addListener(this::commonSetup);

        // 延迟注册器，交由EventBus进行注册
        DEFERRED_REGISTER_BLOCKS.register(modEventBus);
        DEFERRED_REGISTER_ITEMS.register(modEventBus);
        DEFERRED_REGISTER_CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // mod加载的上下文中，注册自定义配置类
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, XianTechConfiguration.SPEC);
        RegisterHandLer.init();
    }

    /**
     * mod 加载时的监听
     *
     * @param event FMLCommonSetupEvent
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        if (XianTechConfiguration.logDirtBlock) {
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
        }

        LOGGER.info(XianTechConfiguration.magicNumberIntroduction + XianTechConfiguration.magicNumber);

        XianTechConfiguration.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    /**
     * Add the example block item to the building blocks tab
     *
     * @param event BuildCreativeModeTabContentsEvent
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(REGISTRY_OBJECT_BLOCK_ITEM);
        }
    }

    /**
     * You can use SubscribeEvent and let the Event Bus discover methods to call
     *
     * @param event ServerStartingEvent
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    /**
     * You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
     */
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
