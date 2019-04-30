package com.skildust.ServerGreeter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import org.apache.commons.lang.StringUtils;

public class CommandSetJoinMessage implements CommandExecutor {
    private Main pluginClass;

    CommandSetJoinMessage(Main ref) {
        pluginClass = ref;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings == null || strings.length < 2) {
            return false;
        }

        String target = strings[0];
        String message = StringUtils.join(Arrays.copyOfRange(strings, 1, strings.length), ' ');
        pluginClass.getConfig().set("joinMessages." + target, message);
        pluginClass.saveConfig();

        commandSender.sendMessage("Message for " + target + " set.");
        return true;
    }
}
