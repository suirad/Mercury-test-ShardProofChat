package io.github.suirad;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import vg.civcraft.mc.mercury.MercuryAPI;
import vg.civcraft.mc.mercury.MercuryPlugin;

public class ShardProofChat extends JavaPlugin implements Listener {
	private static MercuryAPI mercuryapi;
	private ShardProofChat instance = this;
	private boolean active = false;
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void onEnable() {
		final MercuryPlugin mercury = (MercuryPlugin)this.getServer().getPluginManager().getPlugin("Mercury");
		if (mercury != null){
			mercuryapi = MercuryPlugin.api;
			active = true;
		}
		this.getServer().getPluginManager().registerEvents(this, this);
		mercuryapi.registerPlugin("chat");
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new BukkitRunnable(){
			
			public void run() {
				if (mercuryapi.hasMessages("chat")){
					ArrayList<String> msgs = MercuryPlugin.api.getMessages("chat");
					for (String msg : msgs){
						//instance.getServer().broadcastMessage(msg);
						//Bukkit.getServer().broadcastMessage(msg+"brah");
						Bukkit.broadcastMessage(msg);
						
					}
				}
			}
			
			
		}, 0, 10L);
	}

	@Override
	public void onDisable() {
		active = false;
	}
	
	@EventHandler
	public void hookChat(AsyncPlayerChatEvent chat){
		if (!active || !mercuryapi.isEnabled()){return;}
		mercuryapi.sendMessage("civcraft1", "chat", "<"+chat.getPlayer().getDisplayName()+"> "+chat.getMessage());
		
	}

}
