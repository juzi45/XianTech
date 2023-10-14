package name.juyue.xiantech.util;

import name.juyue.xiantech.Item.ItemBase;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static name.juyue.xiantech.XianTech.MODID;

public class RegisterHandLer {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init() {
        ITEMS.register((IEventBus) FMLJavaModLoadingContext.get().getModEventBus());
    }

    //物品:弦晶石

    public static final RegistryObject<Item> XIANSPAR = ITEMS.register("xianspar", ItemBase::new);


}
