package cn.crtlprototypestudios.lazy.client.foundation.modules.active;

import cn.crtlprototypestudios.lazy.Lazy;
import cn.crtlprototypestudios.lazy.client.foundation.modules.LazyModule;
import net.minecraft.client.MinecraftClient;

public class HealthLock extends LazyModule {

    @Override
    public void tick(MinecraftClient client) {
        if (!Lazy.getConfig().healthLockEnabled || client.player == null) return;

        client.player.setHealth(client.player.getMaxHealth());
    }
}
