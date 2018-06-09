package me.theblockbender.story.util;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

public class LineOfSightUtil {

    public static ArmorStand getTargetedArmorStand(Player player) {
        List<ArmorStand> nearby = getNearbyArmorStands(player);
        ArmorStand target = null;
        if (nearby.isEmpty())
            return null;
        for (ArmorStand armorStand : nearby) {
            if (isPlayerLookingAtArmorStand(player, armorStand)) {
                target = armorStand;
                break;
            }
        }
        return target;
    }

    private static List<ArmorStand> getNearbyArmorStands(Player player) {
        List<ArmorStand> armorStands = new ArrayList<>();
        for (Entity entity : player.getNearbyEntities(4, 4, 4)) {
            if (entity instanceof ArmorStand)
                armorStands.add((ArmorStand) entity);
        }
        return armorStands;
    }

    // Credit to DarkSeraphim and Mr.Midnight from the Spigot Forums.
    private static boolean isPlayerLookingAtArmorStand(Player player, ArmorStand target) {
        Location eye = player.getEyeLocation();
        Vector toEntity = target.getEyeLocation().toVector().subtract(eye.toVector());
        double dot = toEntity.normalize().dot(eye.getDirection());
        return dot > 0.99D;
    }
}
