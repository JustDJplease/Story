package me.theblockbender.story.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class PlayerSelectStoryOptionEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Player player;

    public PlayerSelectStoryOptionEvent(Player player) {
        this.player = player;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public Player getPlayer() {
        return player;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}