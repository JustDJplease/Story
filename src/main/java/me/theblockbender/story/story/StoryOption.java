package me.theblockbender.story.story;

import me.theblockbender.story.Main;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class StoryOption {
    private Main main;
    private String displayName;
    private String triggersDialogue;
    private int optionID;

    public StoryOption(Main main, int id, String displayName, String triggersDialogue) {
        this.main = main;
        this.displayName = displayName;
        this.triggersDialogue = triggersDialogue;
        this.optionID = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void runThisOption(Player player) {
        main.storyManager.trigger(player, triggersDialogue);
    }

    public void spawnHologram(Player player, int position, int amountOfOptions) {
        Location location = player.getLocation().add(2, 0, 0);
        Location up = location.clone();
        up.setY(0);
        ArmorStand armorStand = (ArmorStand) player.getWorld().spawnEntity(up, EntityType.ARMOR_STAND);
        armorStand.setVisible(false);
        armorStand.setSmall(true);
        armorStand.setGravity(false);
        armorStand.addPassenger(player);
        armorStand.setCustomName(displayName);
        armorStand.setCustomNameVisible(true);
        armorStand.teleport(location);
    }

    public int getOptionID() {
        return optionID;
    }
}
