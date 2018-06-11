package me.theblockbender.story.util;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class NoMotionUtil {

    public static Map<UUID, ArmorStand> frozen = new HashMap<>();

    public static void freezePlayer(Player player) {
        UUID uuid = player.getUniqueId();
        if (frozen.containsKey(uuid))
            return;
        Location location = player.getLocation();
        Location up = location.clone();
        up.setY(0);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(up, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setSmall(true);
        armorStand.setGravity(false);
        armorStand.teleport(location);
        armorStand.addPassenger(player);
        frozen.put(uuid, armorStand);
    }

    public static void unfreezePlayer(Player player) {
        UUID uuid = player.getUniqueId();
        if (!frozen.containsKey(uuid))
            return;
        ArmorStand armorStand = frozen.get(uuid);
        armorStand.remove();
        frozen.remove(uuid);
    }
}
