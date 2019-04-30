package com.skildust.ServerGreeter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandClearMessages implements CommandExecutor {
    private Main pluginClass;

    CommandClearMessages(Main ref) {
        pluginClass = ref;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings == null || strings.length != 1) {
            return false;
        }

        String target = strings[0];
        pluginClass.getConfig().set("joinMessages." + target, null);
        pluginClass.getConfig().set("leaveMessages." + target, null);
        pluginClass.saveConfig();

        commandSender.sendMessage("Messages for " + target + " have been cleared.");
        return true;
    }
}
