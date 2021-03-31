package it.matty.disease.objects.disease;

import it.matty.disease.Diseases;
import it.matty.disease.objects.player.DPlayer;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractDisease implements Listener {
    @Getter private final Diseases plugin = Diseases.getInstance();
    @Getter private final DiseaseType disease;
    @Getter private List<DPlayer> players;

    public AbstractDisease() {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        disease = getClass().getAnnotation(Disease.class).disease();

        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            players = plugin.getPlayers().stream().filter(p -> p.getDiseases().contains(disease.getName())).collect(Collectors.toList());
            if(!players.isEmpty()) {
                for (DPlayer player : players) {
                    disease.getEffects().forEach(e -> player.getPlayer().addPotionEffect(e));
                    onEffect(player);
                }
            }
        }, disease.getInterval() * 20L, disease.getInterval() * 20L);
    }

    public void sendMessage(DPlayer dPlayer, String... messages) {
        for(String message : messages) dPlayer.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void sendActionBar(DPlayer dPlayer, String message) {
        dPlayer.getPlayer().sendActionBar(ChatColor.translateAlternateColorCodes('&', message));
    }

    public void sendTitle(DPlayer dPlayer, String title, String subtitle) {
        dPlayer.getPlayer().sendTitle(ChatColor.translateAlternateColorCodes('&', title),
                ChatColor.translateAlternateColorCodes('&', subtitle), 20, 50, 20);
    }

    public abstract void onEffect(DPlayer dPlayer);
}
