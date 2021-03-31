package it.matty.disease.diseases;

import it.matty.disease.objects.disease.DiseaseType;
import it.matty.disease.objects.disease.AbstractDisease;
import it.matty.disease.objects.disease.Disease;
import it.matty.disease.objects.player.DPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

@Disease(disease = DiseaseType.USTIONE)
public class Ustione extends AbstractDisease {

    @Override
    public void onEffect(DPlayer dPlayer) {
        sendActionBar(dPlayer, "&eSei ustionato! Corri il prima possibile in ospedale.");
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(!(e.getEntity() instanceof Player)) return;
        if(!e.getCause().equals(EntityDamageEvent.DamageCause.FIRE)) return;

        DPlayer dPlayer = DPlayer.getPlayer((Player) e.getEntity());
        if(dPlayer.getDiseases().contains(getDisease().getName())) return;

        dPlayer.add(getDisease());
        sendTitle(dPlayer, "&c&lAHIO!", "&7&o(( Ti sei &fustionato &7&o))");
    }
}
