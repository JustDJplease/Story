package me.theblockbender.story.listeners;

import me.theblockbender.story.util.NoMotionUtil;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class VehicleListener implements Listener {

    @EventHandler
    public void onPlayerLeaveVehicle(VehicleExitEvent event) {
        LivingEntity livingEntity = event.getExited();
        if (!(livingEntity instanceof Player))
            return;
        Player player = (Player) livingEntity;
        if (NoMotionUtil.frozen.containsKey(player.getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
