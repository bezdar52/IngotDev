package org.ingotdev.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.ingotdev.armors.ModArmors;

@EventBusSubscriber(modid = "ingotdev")
public class NoSwimEvent {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        boolean hasFlippers = player.getItemBySlot(net.minecraft.world.entity.EquipmentSlot.FEET).is(ModArmors.FLIPPERS.get());

        if (hasFlippers) {
            return;
        }
        if (player.isInWater() && !player.onGround()) {

            if (player.isSwimming()) {
                player.setSwimming(false);
            }

            Vec3 motion = player.getDeltaMovement();

            if (motion.y > -0.2) {
                player.setDeltaMovement(motion.x, -0.2, motion.z);
            }
        }
    }
}
