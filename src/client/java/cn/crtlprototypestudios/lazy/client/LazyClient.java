package cn.crtlprototypestudios.lazy.client;

import cn.crtlprototypestudios.lazy.Lazy;
import cn.crtlprototypestudios.lazy.config.LazyConfig;
import cn.crtlprototypestudios.lazy.client.foundation.modules.active.EntityDetector;
import cn.crtlprototypestudios.lazy.client.foundation.modules.auto.AutoFish;
import cn.crtlprototypestudios.lazy.client.foundation.modules.auto.AutoHeal;
import cn.crtlprototypestudios.lazy.client.foundation.modules.passive.HungerResist;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class LazyClient implements ClientModInitializer {
    private static AutoFish autoFish;
    private static EntityDetector entityDetector;
    private static HungerResist hungerResist;
    private static AutoHeal autoHeal;

    @Override
    public void onInitializeClient() {
        Lazy.config = new LazyConfig();
        autoFish = new AutoFish();
        entityDetector = new EntityDetector();
        hungerResist = new HungerResist();
        autoHeal = new AutoHeal();

        ClientTickEvents.END_CLIENT_TICK.register(this::onClientTick);
    }

    private void onClientTick(MinecraftClient client) {
        if (client.player != null) {
            autoFish.tick(client);
            entityDetector.tick(client);
            hungerResist.tick(client);
            autoHeal.tick(client);
        }
    }
}
