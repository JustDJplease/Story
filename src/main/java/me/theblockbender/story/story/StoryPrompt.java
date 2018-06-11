package me.theblockbender.story.story;

import java.util.List;

public class StoryPrompt {
    private List<StoryOption> options;

    public StoryPrompt(List<StoryOption> options) {
        this.options = options;
    }

    public StoryOption getOption(int index) {
        return options.get(index);
    }

    public List<StoryOption> getOptions() {
        return options;
    }

    public int getOptionsAmount() {
        return options.size();
    }
}
