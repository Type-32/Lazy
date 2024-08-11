package cn.crtlprototypestudios.lazy.client.foundation.modules.auto;

import cn.crtlprototypestudios.lazy.Lazy;
import cn.crtlprototypestudios.lazy.client.foundation.modules.LazyModule;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;

public class AutoFish extends LazyModule {
    private boolean isFishing = false;
    private int ticksWaited = 0;

    @Override
    public void tick(MinecraftClient client) {
        if (!Lazy.getConfig().autoFishEnabled || client.player == null) return;

        FishingBobberEntity bobber = client.player.fishHook;

        if (bobber == null) {
            if (!isFishing) {
                client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
                isFishing = true;
                ticksWaited = 0;
            }
        } else {
            if (bobber.isSubmergedInWater() && bobber.getVelocity().y < -0.1) {
                client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
                ticksWaited = 0;
                isFishing = false;
            } else {
                ticksWaited++;
                if (ticksWaited > 600) { // Recast after 30 seconds
                    client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
                    ticksWaited = 0;
                    isFishing = false;
                }
            }
        }
    }
}
