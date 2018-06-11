package me.theblockbender.story.listeners;

import me.theblockbender.story.util.NoMotionUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (NoMotionUtil.frozen.containsKey(uuid)) {
            NoMotionUtil.unfreezePlayer(player);
        }
    }
}
