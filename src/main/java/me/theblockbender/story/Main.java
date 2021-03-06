package me.theblockbender.story;

import me.theblockbender.story.listeners.PlayerQuitListener;
import me.theblockbender.story.listeners.VehicleListener;
import me.theblockbender.story.runnables.SelectOptionTask;
import me.theblockbender.story.story.StoryManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public StoryManager storyManager;
    private SelectOptionTask selectOptionTask;

    public void onEnable() {
        storyManager = new StoryManager();
        selectOptionTask = new SelectOptionTask(this);
        selectOptionTask.runTaskTimer(this, 0L, 1L);
        registerListeners();
    }

    public void onDisable() {
        storyManager = null;
        selectOptionTask.cancel();
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new VehicleListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);
    }
}
