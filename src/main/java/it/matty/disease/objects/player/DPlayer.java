package it.matty.disease.objects.player;

import it.matty.disease.Diseases;
import it.matty.disease.objects.disease.DiseaseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter @Setter
public class DPlayer {
    private final Player player;
    private final List<String> diseases;

    public static DPlayer getPlayer(Player player) {
        Optional<DPlayer> players = Diseases.getInstance().getPlayers().stream().filter(d -> d.getPlayer().equals(player)).findFirst();
        return players.orElse(null);
    }

    public static void create(Player player) {
        Diseases.getInstance().getPlayers().add(new DPlayer(player, Diseases.getInstance().getConfig().getStringList(player.getName().toLowerCase())));
    }

    public void add(DiseaseType disease) {
        this.diseases.add(disease.getName());
    }

    public boolean hasDisease(DiseaseType disease) {
        return this.diseases.contains(disease.getName());
    }
}
