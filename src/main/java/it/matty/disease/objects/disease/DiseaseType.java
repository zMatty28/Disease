package it.matty.disease.objects.disease;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor @Getter
public enum DiseaseType {
    TAGLIO("taglio", 120, Collections.singletonList(new PotionEffect(PotionEffectType.POISON, 80, 1))),
    USTIONE("ustione", 100, Collections.singletonList(new PotionEffect(PotionEffectType.POISON, 100, 1)));


    private final String name;
    private final int interval;
    private final List<PotionEffect> effects;
}
