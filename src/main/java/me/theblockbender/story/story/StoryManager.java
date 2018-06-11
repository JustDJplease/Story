package me.theblockbender.story.story;

import me.theblockbender.story.util.NoMotionUtil;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;

public class StoryManager {
    public void trigger(Player player, String triggersDialogue) {
        // TODO - create dialogue trigger mechanism.
    }

    public void moveArmorStandForwards(ArmorStand armorStand, Player player) {
        // TODO
    }

    public void moveArmorStandBackwards(ArmorStand armorStand, Player player) {
        // TODO+
    }

    public void openOptionsMenu(Player player, StoryPrompt prompt) {
        NoMotionUtil.freezePlayer(player);
        for (StoryOption option : prompt.getOptions()) {
            option.spawnHologram(player, option.getOptionID(), prompt.getOptionsAmount());
        }
    }
}
