package com.github.gaz492.HChat.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import com.github.gaz492.HChat.Hmain;

public class ChatListener
  implements Listener
{
  private Hmain plugin;

  public ChatListener(Hmain plugin)
  {
    this.plugin = plugin;
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }
  @EventHandler(priority=EventPriority.HIGHEST)
  public void playerListener(PlayerChatEvent event) {
    String message = event.getMessage();
    Player player = event.getPlayer();

    if ((message.startsWith("?")) && 
      (player.hasPermission("hchat.use"))) {
      sendMessage(player, message.substring(1));
      event.setCancelled(true);
    }
  }

  public void sendMessage(Player player, String message)
  {
    Player[] players = plugin.getServer().getOnlinePlayers();
    for (Player sendTo : players)
      if (sendTo.hasPermission("hchat.see"))
        sendTo.sendMessage(ChatColor.DARK_AQUA + "[HELP] " + ChatColor.WHITE + player.getDisplayName() + ": " + message);
  }
}
