package it.matty.disease.diseases;

import it.matty.disease.objects.player.DPlayer;
import it.matty.disease.objects.disease.DiseaseType;
import it.matty.disease.objects.disease.AbstractDisease;
import it.matty.disease.objects.disease.Disease;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.concurrent.ThreadLocalRandom;

@Disease(disease = DiseaseType.TAGLIO)
public class Taglio extends AbstractDisease {

    @Override
    public void onEffect(DPlayer dPlayer) {
        sendActionBar(dPlayer, "&eHai un taglio! Corri il prima possibile in ospedale.");
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if(!e.getBlock().getType().toString().contains("GLASS")) return;
        if(ThreadLocalRandom.current().nextInt(100) < 70) return;

        DPlayer player = DPlayer.getPlayer(e.getPlayer());
        if(player.getDiseases().contains(getDisease().getName())) return;

        player.add(getDisease());
        sendTitle(player, "&c&lAHIO!", "&7&o(( Ti sei &ftagliato &7&o))");
    }
}
