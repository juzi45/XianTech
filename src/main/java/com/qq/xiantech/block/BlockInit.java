package com.qq.xiantech.block;

import com.qq.xiantech.XianTech;
import com.qq.xiantech.block.ore.DeepSlateStringCrystalOre;
import com.qq.xiantech.block.ore.DeepSlateStringCrystalOreItem;
import com.qq.xiantech.block.ore.StringCrystalOre;
import com.qq.xiantech.block.ore.StringCrystalOreItem;
import com.qq.xiantech.item.ItemInit;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方块初始化
 *
 * @author Pig-Gua
 * @date 2023-10-18
 */
public class BlockInit {

    /**
     * 延迟注册器(方块)
     */
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, XianTech.MOD_ID);

    /**
     * 延迟注册器(物品)
     */
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> STRING_CRYSTAL_ORE = register("string_crystal_ore", StringCrystalOre::new,
            object -> () -> new StringCrystalOreItem(object.get()));

    public static final RegistryObject<Block> DEEP_SLATE_STRING_CRYSTAL_ORE = register("deep_slate_string_crystal_ore", DeepSlateStringCrystalOre::new,
            object -> () -> new DeepSlateStringCrystalOreItem(object.get()));

    /**
     * 注册(方块+物品)
     *
     * @param name  注册 ID
     * @param block 方块 Supplier
     * @param item  物品 Supplier
     * @param <T>   ? extends Block
     * @return 注册对象
     */
    private static <T extends Block> RegistryObject<T> register(final String name,
                                                                final Supplier<? extends T> block,
                                                                Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }


    /**
     * 注册(方块)
     *
     * @param name  注册 ID
     * @param block 方块 Supplier
     * @param <T>   ? extends Block
     * @return 注册对象
     */
    private static <T extends Block> RegistryObject<T> registerBlock(final String name,
                                                                     final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }


}
