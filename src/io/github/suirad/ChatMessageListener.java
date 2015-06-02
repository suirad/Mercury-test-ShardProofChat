package io.github.suirad;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import vg.civcraft.mc.mercury.events.AsyncPluginBroadcastMessageEvent;

public class ChatMessageListener implements Listener {
	private ShardProofChat plugin;
	
	public ChatMessageListener(ShardProofChat plugin) {
		this.plugin = plugin;
	}
//	@EventHandler
//	public void listenmsg(AsyncPluginBroadcastMessageEvent event){
//		if (event.getChannel() == "chat"){
//			Bukkit.getServer().broadcastMessage(event.getMessage());
//		}
//	}
	@EventHandler
	public void hookChat(AsyncPlayerChatEvent chat){
		if (!plugin.active){return;}
		ShardProofChat.mercuryapi.sendMessage("all", "chat", "<"+chat.getPlayer().getDisplayName()+"> "+chat.getMessage());
		
	}
}
