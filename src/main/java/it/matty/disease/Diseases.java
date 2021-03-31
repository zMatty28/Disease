package it.matty.disease;

import it.matty.disease.listeners.JoinListener;
import it.matty.disease.objects.disease.Disease;
import it.matty.disease.objects.player.DPlayer;
import it.matty.disease.tasks.SaveTask;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

public class Diseases extends JavaPlugin {
    @Getter private static Diseases instance;
    @Getter private List<DPlayer> players;

    @Override @SneakyThrows
    public void onEnable() {
        instance = this;
        players = new ArrayList<>();

        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new JoinListener(), this);

        new SaveTask().runTaskTimerAsynchronously(this, 1, 1);
        for (Class<?> disease : new Reflections("it.matty.disease").getTypesAnnotatedWith(Disease.class)) disease.newInstance();
    }
}
