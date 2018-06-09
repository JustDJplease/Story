package me.theblockbender.story.runnables;

import me.theblockbender.story.Main;
import me.theblockbender.story.story.StoryManager;
import me.theblockbender.story.util.LineOfSightUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class SelectOptionTask extends BukkitRunnable {

    // This task is to be run once every tick.
    private Map<UUID, ArmorStand> lookingMap = new HashMap<>();
    private StoryManager storyManager;

    public SelectOptionTask(Main main) {
        storyManager = main.storyManager;
    }

    @Override
    public void run() {
        List<UUID> cleanup = new ArrayList<>(lookingMap.keySet());
        for (Player player : Bukkit.getOnlinePlayers()) {
            UUID uuid = player.getUniqueId();
            cleanup.remove(uuid);
            ArmorStand armorStand = LineOfSightUtil.getTargetedArmorStand(player);
            if (lookingMap.containsKey(uuid)) {
                ArmorStand previous = lookingMap.get(uuid);
                if (armorStand == null) {
                    storyManager.moveArmorStandBackwards(previous, player);
                    lookingMap.remove(uuid);
                    continue;
                }
                if (previous != armorStand) {
                    lookingMap.put(uuid, armorStand);
                    storyManager.moveArmorStandBackwards(previous, player);
                    storyManager.moveArmorStandForwards(armorStand, player);
                }

            } else {
                if (armorStand != null) {
                    lookingMap.put(uuid, armorStand);
                    storyManager.moveArmorStandForwards(armorStand, player);
                }
            }
        }
        for (UUID uuid : cleanup) {
            lookingMap.remove(uuid);
        }
    }
}
