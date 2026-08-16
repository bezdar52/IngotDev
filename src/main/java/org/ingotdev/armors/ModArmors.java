package org.ingotdev.armors;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static org.ingotdev.armors.ModArmorMaterials.ARMOR_MATERIALS;

public class ModArmors {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("ingotdev");

    public static final DeferredItem<Item> FLIPPERS = ITEMS.register("flippers",
            registryName -> new ArmorItem(ModArmorMaterials.FLIPPERS_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Инициализация и добавление во вкладку Творческого режима
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
