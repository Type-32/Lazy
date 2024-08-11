package cn.crtlprototypestudios.lazy.client.foundation.modules.passive;

import cn.crtlprototypestudios.lazy.Lazy;
import cn.crtlprototypestudios.lazy.client.foundation.modules.LazyModule;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.HungerManager;

public class HungerResist extends LazyModule {
    @Override
    public void tick(MinecraftClient client) {
        if (!Lazy.getConfig().hungerResistEnabled || client.player == null) return;

        HungerManager hungerManager = client.player.getHungerManager();
        hungerManager.setFoodLevel(20);
        hungerManager.setSaturationLevel(10.0f);
    }
}
