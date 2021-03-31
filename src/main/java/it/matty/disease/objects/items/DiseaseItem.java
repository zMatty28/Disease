package it.matty.disease.objects.items;

import it.matty.disease.objects.disease.DiseaseType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;

@RequiredArgsConstructor @Getter
public enum DiseaseItem {
    CEROTTO("Cerotto", Material.STICK, 1, DiseaseType.TAGLIO),
    POMATA("Pomata", Material.STICK, 2, DiseaseType.USTIONE);

    private final String name;
    private final Material material;
    private final int data;
    private final DiseaseType disease;
}
