package org.ingotdev.armors;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, "ingotdev");

    public static final Holder<ArmorMaterial> FLIPPERS_MATERIAL = ARMOR_MATERIALS.register("flippers", () -> {
        EnumMap<ArmorItem.Type, Integer> defense = Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
            map.put(ArmorItem.Type.BOOTS, 1);
        });

        return new ArmorMaterial(
                defense,
                10,
                SoundEvents.ARMOR_EQUIP_LEATHER,
                () -> Ingredient.of(net.minecraft.world.item.Items.LEATHER),
                List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath("ingotdev", "flippers"))),
                0.0F,
                0.0F
        );
    });

    public static void register(IEventBus modEventBus) {
        ARMOR_MATERIALS.register(modEventBus);
    }
}
