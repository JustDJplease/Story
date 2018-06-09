package me.theblockbender.story.story;

import me.theblockbender.story.Main;
import org.bukkit.entity.Player;

public class StoryOption {
    private Main main;
    private String displayName;
    private String triggersDialogue;

    public StoryOption(Main main, String displayName, String triggersDialogue) {
        this.main = main;
        this.displayName = displayName;
        this.triggersDialogue = triggersDialogue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void runThisOption(Player player) {
        main.storyManager.trigger(player, triggersDialogue);
    }
}
