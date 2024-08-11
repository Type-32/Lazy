package cn.crtlprototypestudios.lazy;

import cn.crtlprototypestudios.lazy.config.LazyConfig;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Lazy implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger(Lazy.class);
    public static LazyConfig config;

    public static LazyConfig getConfig() {
        return config;
    }

    @Override
    public void onInitialize() {
        LOGGER.info("ayo wtf this yee yee ass mod");
    }
}
