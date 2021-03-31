package it.matty.disease.listeners;

import it.matty.disease.Diseases;
import it.matty.disease.objects.player.DPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(DPlayer.getPlayer(player) == null) DPlayer.create(player);
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        Diseases.getInstance().getPlayers().remove(DPlayer.getPlayer(player));
    }
}
