package com.skildust.ServerGreeter;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        getCommand("setJoinMessage").setExecutor(new CommandSetJoinMessage(this));
        getCommand("setLeaveMessage").setExecutor(new CommandSetLeaveMessage(this));
        getCommand("clearMessages").setExecutor(new CommandClearMessages(this));
        getCommand("listMessages").setExecutor(new CommandListMessages(this));
        getCommand("home").setExecutor(new CommandHub(this));
    }
}
