package net.coreprotect;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import net.coreprotect.config.ConfigHandler;
import net.coreprotect.language.Phrase;
import net.coreprotect.services.PluginInitializationService;
import net.coreprotect.services.ShutdownService;
import net.coreprotect.utility.Chat;

/**
 * Main class for the CoreProtectX plugin
 */
public final class CoreProtectX extends JavaPlugin {

    private static CoreProtectX instance;
    private boolean advancedChestsEnabled = false;

    /**
     * Get the instance of CoreProtectX
     *
     * @return This CoreProtectX instance
     */
    public static CoreProtectX getInstance() {
        return instance;
    }

    private final CoreProtectXAPI api = new CoreProtectXAPI();

    /**
     * Get the CoreProtectX API
     *
     * @return The CoreProtectX API
     */
    public CoreProtectXAPI getAPI() {
        return api;
    }

    @Override
    public void onEnable() {
        // Set plugin instance and data folder path
        instance = this;
        ConfigHandler.path = this.getDataFolder().getPath() + File.separator;

        advancedChestsEnabled = getServer().getPluginManager().getPlugin("AdvancedChests") != null;
        // Initialize plugin using the initialization service
        boolean initialized = PluginInitializationService.initializePlugin(this);

        // Disable plugin if initialization failed
        if (!initialized) {
            Chat.console(Phrase.build(Phrase.ENABLE_FAILED, ConfigHandler.EDITION_NAME));
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        ShutdownService.safeShutdown(this);
    }

    public boolean isAdvancedChestsEnabled() {
        return advancedChestsEnabled;
    }
}
