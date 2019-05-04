package com.skildust.ServerGreeter;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHome implements CommandExecutor {
    private Main pluginClass;

    CommandHome(Main ref) {
        pluginClass = ref;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        Location loc = player.getLocation();

        loc.setWorld(Bukkit.getServer().getWorld("world"));
        loc.setX(142);
        loc.setY(67);
        loc.setZ(-109);

        player.teleport(loc);
        player.sendMessage("Teleported to home village.");
        return true;
    }
}
