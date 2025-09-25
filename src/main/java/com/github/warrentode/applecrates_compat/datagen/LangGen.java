package com.github.warrentode.applecrates_compat.datagen;

import jackdaw.applecrates.api.CrateWoodType;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LangGen extends LanguageProvider {
    private final String modid;

    public LangGen(PackOutput output, String modid, String locale) {
        super(output, modid, locale);
        this.modid = modid;
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.applecratescompat_tab", "Applecrates Compat");

        add("block.applecrates_compat.cactus_extra_crate", "Cactus Extra Crate");
        add("block.applecrates_compat.green_cactus_extra_crate", "Green Cactus Extra Crate");
        add("block.applecrates_compat.ebony_crate", "Ebony Crate");
        add("block.applecrates_compat.pream_crate", "Pream Crate");
        add("block.applecrates_compat.tc_skyroot_crate", "Tinker's Skyroot Crate");
        add("block.applecrates_compat.skyroot_crate", "Aether Skyroot Crate");

        CrateWoodType.values().filter(crateWoodType -> !crateWoodType.name().contains("skyroot"))
                .filter((crateWoodType) -> crateWoodType.isFrom(this.modid))
                .forEach((crateWoodType) -> {
                    String capitalized = Stream.of((crateWoodType.name() + "_crate")
                                    .replace("_", " ").trim().split("\\s"))
                            .filter((word) -> !word.isEmpty()).map((word) -> {
                                String upperCase = word.substring(0, 1).toUpperCase();
                                return upperCase + word.substring(1);
                            }).collect(Collectors.joining(" "));
                    this.add(CrateWoodType.getBlock(crateWoodType), capitalized);
                });
    }
}