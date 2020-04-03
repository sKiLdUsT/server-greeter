package com.skildust.ServerGreeter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub implements CommandExecutor {
    private Main pluginClass;

    CommandHub(Main ref) {
        pluginClass = ref;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        Location loc = player.getLocation();

        loc.setWorld(Bukkit.getServer().getWorld("world"));
        loc.setX(0);
        loc.setY(250);
        loc.setZ(0);

        player.teleport(loc);
        player.sendMessage("Teleported to hub.");
        return true;
    }
}
