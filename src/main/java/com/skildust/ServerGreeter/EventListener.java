package com.skildust.ServerGreeter;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EventListener implements Listener {
    private Main pluginClass;
    private Map<UUID, ServerPlayer> players;

    EventListener(Main ref) {
        pluginClass = ref;
        players = new HashMap<UUID, ServerPlayer>();

        for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
            players.put(player.getUniqueId(), new ServerPlayer(player.getUniqueId(), player.getName(), player.getLastPlayed()));
        }

        for (Player player : Bukkit.getOnlinePlayers()) {
            players.put(player.getUniqueId(), new ServerPlayer(player.getUniqueId(), player.getName(), player.getLastPlayed()));
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();
        String customMessage = pluginClass.getConfig().getString("joinMessages." + playerName);

        if (customMessage == null) {
            customMessage = "Moin!";
        }

        event.setJoinMessage(ChatColor.GOLD + customMessage + ChatColor.DARK_PURPLE + " (Hallo " + playerName + "!)");

        ServerPlayer internalPlayer = players.get(event.getPlayer().getUniqueId());
        if (internalPlayer == null) {
            internalPlayer = new ServerPlayer(player.getUniqueId(), player.getName(), 0);
            players.put(internalPlayer.getUuid(), internalPlayer);
        }
        if (internalPlayer.getLastPlayed() - Utils.getMidnight() < 0) {
            player.sendMessage(ChatColor.GREEN + "Good to see you today, have an apple!");
            ItemStack apple = new ItemStack(Material.APPLE, 1);
            ItemMeta appleMeta = apple.getItemMeta();
            appleMeta.setDisplayName("Thanks for playing!");
            apple.setItemMeta(appleMeta);
            player.getInventory().addItem(apple);
        }

        internalPlayer.setLastPlayed((new Date()).getTime());
        players.put(internalPlayer.getUuid(), internalPlayer);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
        String customMessage = pluginClass.getConfig().getString("leaveMessages." + playerName);

        if (customMessage == null) {
            customMessage = "Bye!";
        }

        event.setQuitMessage(ChatColor.GOLD + customMessage  + ChatColor.DARK_PURPLE +  " (Tschüss " + playerName + "!)");
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntity().getName().equals("Creeper")) {
            Creeper entity = (Creeper) event.getEntity();
            entity.setExplosionRadius(0);
        }
    }
}
