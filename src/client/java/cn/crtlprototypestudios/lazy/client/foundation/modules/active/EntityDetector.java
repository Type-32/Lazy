package cn.crtlprototypestudios.lazy.client.foundation.modules.active;

import cn.crtlprototypestudios.lazy.Lazy;
import cn.crtlprototypestudios.lazy.client.foundation.modules.LazyModule;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.text.Text;

public class EntityDetector extends LazyModule {
    private int tickCounter = 0;

    public void tick(MinecraftClient client) {
        if (!Lazy.getConfig().entityDetectorEnabled || client.player == null || client.world == null) return;

        tickCounter++;
        if (tickCounter % 20 != 0) return; // Check every second

        double range = Lazy.getConfig().entityDetectorRange;
        for (Entity entity : client.world.getEntities()) {
            if (entity instanceof HostileEntity && entity.squaredDistanceTo(client.player) <= range * range) {
                client.player.sendMessage(Text.literal("§cHostile entity detected nearby!"), true);
                break;
            }
        }
    }
}
