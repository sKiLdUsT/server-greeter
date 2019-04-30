package com.skildust.ServerGreeter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Map;

public class CommandListMessages implements CommandExecutor {
    private Main pluginClass;

    CommandListMessages(Main ref) {
        pluginClass = ref;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ArrayList<String> messages = new ArrayList<String>();
        if (pluginClass.getConfig().contains("joinMessages")) {
            Map<String, Object> joinMessageUsers = pluginClass.getConfig().getConfigurationSection("joinMessages").getValues(false);

            messages.add("Join messages: ");
            for(Map.Entry<String, Object> player : joinMessageUsers.entrySet()) {
                messages.add(ChatColor.GREEN + player.getKey() + ": " + player.getValue().toString());
            }
        }
        if (pluginClass.getConfig().contains("leaveMessages")) {
            Map<String, Object> leaveMessageUsers = pluginClass.getConfig().getConfigurationSection("leaveMessages").getValues(false);

            messages.add("Leave messages: ");
            for(Map.Entry<String, Object> player : leaveMessageUsers.entrySet()) {
                messages.add(ChatColor.GREEN + player.getKey() + ": " + player.getValue().toString());
            }
        }

        commandSender.sendMessage(messages.toArray(new String[0]));
        return true;
    }
}
