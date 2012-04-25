package com.github.gaz492.HChat;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.ChatColor;

import com.github.gaz492.HChat.listeners.ChatListener;

public class Hmain extends JavaPlugin
implements Listener
{
	public final String prefix = "[HChat] ";
	public final Logger logger = Logger.getLogger("Minecraft");
	
    public void onEnable(){ 
    	
    	  PluginDescriptionFile pdfFile = getDescription();

    	    logger.log(Level.INFO, "[HChat] Running version " + pdfFile.getVersion());

    	    new ChatListener(this);
    }
     
    public void onDisable(){ 
    	logger.log(Level.INFO, "[HChat]  Shutting down.");
    }
    
    public boolean onCommand(final CommandSender sender, Command cmd, String commandLabel, String[] args){
    	if(cmd.getName().equalsIgnoreCase("hchat")){
    	if(args.length == 0){
    	sender.sendMessage(ChatColor.GOLD + "[HChat] " + ChatColor.RED + "Correct Command is /hchat help");
    	return false;
    	}
    	if(args[0].equalsIgnoreCase("help")){
    	sender.sendMessage(ChatColor.GOLD + "[HChat] " + ChatColor.GREEN + "Use 'help' at the begining of a message to send a message to an admin.");
    	return true;
    	}
    	}
    	return false;
    	} 
}
