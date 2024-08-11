package cn.crtlprototypestudios.lazy.client.foundation.modules.auto;

import cn.crtlprototypestudios.lazy.Lazy;
import cn.crtlprototypestudios.lazy.client.foundation.modules.LazyModule;
import net.minecraft.client.MinecraftClient;

public class AutoHeal extends LazyModule {
    @Override
    public void tick(MinecraftClient client) {
        if (!Lazy.getConfig().autoHealEnabled || client.player == null) return;

        if (client.player.getHealth() < client.player.getMaxHealth()) {
            client.player.heal(1.0f);
        }
    }
}
