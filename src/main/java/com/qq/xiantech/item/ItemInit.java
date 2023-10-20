package com.qq.xiantech.item;

import com.qq.xiantech.XianTech;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

/**
 * 物品初始化
 *
 * @author Pig-Gua
 * {@code @date} 2023-10-18
 */
public class ItemInit {

    /**
     * 延迟注册器(物品)
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, XianTech.MOD_ID);

    public static final RegistryObject<Item> STRING_CRYSTAL = register("string_crystal", StringCrystal::new);

    public static final RegistryObject<Item> STRING_ENERGY_BOARD = register("string_energy_board", StringEnergyBoard::new);
    /**
     * 注册(物品)
     *
     * @param name 注册 ID
     * @param item 物品 Supplier
     * @param <T>  ? extends Item
     * @return 注册对象
     */
    public static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
