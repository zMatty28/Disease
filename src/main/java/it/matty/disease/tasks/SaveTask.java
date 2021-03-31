package it.matty.disease.tasks;

import it.matty.disease.Diseases;
import it.matty.disease.objects.player.DPlayer;
import org.bukkit.scheduler.BukkitRunnable;

public class SaveTask extends BukkitRunnable {

    @Override
    public void run() {
        for(DPlayer dPlayer : Diseases.getInstance().getPlayers()) {
            if(!Diseases.getInstance().getConfig().getStringList(dPlayer.getPlayer().getName().toLowerCase()).equals(dPlayer.getDiseases()))
                Diseases.getInstance().getConfig().set(dPlayer.getPlayer().getName().toLowerCase(), dPlayer.getDiseases());
        }

        Diseases.getInstance().saveConfig();
        Diseases.getInstance().reloadConfig();
    }
}
