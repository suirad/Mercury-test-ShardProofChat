package io.github.suirad;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import vg.civcraft.mc.mercury.MercuryPlugin;
import vg.civcraft.mc.mercury.ServiceHandler;

public class ShardProofChat extends JavaPlugin implements Listener {
	public static ServiceHandler mercuryapi;
	public boolean active = false;
	
	
	@Override
	public void onEnable() {
		final MercuryPlugin mercury = (MercuryPlugin)this.getServer().getPluginManager().getPlugin("Mercury");
		if (mercury != null){
			mercuryapi = MercuryPlugin.handler;
			active = true;
		}
		this.getServer().getPluginManager().registerEvents(new ChatMessageListener(this), this);
	}

	@Override
	public void onDisable() {
		active = false;
	}
	

}


