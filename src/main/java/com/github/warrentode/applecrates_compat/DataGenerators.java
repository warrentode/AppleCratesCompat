package com.github.warrentode.applecrates_compat;

import jackdaw.applecrates.datagen.*;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class DataGenerators {
    public DataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        generatedCrates("applecrates", event);
    }

    public static void generatedCrates(String modid, GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(event.includeServer(), new CrateTag(modid, generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new CrateRecipes(modid, generator));
        generator.addProvider(event.includeServer(), new CrateLoot(modid, generator));
        generator.addProvider(event.includeClient(), new CrateModels(modid, generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new CrateStates(modid, generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new CrateItems(modid, generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new CrateLanguage(modid, generator, "en_uk"));
        generator.addProvider(event.includeClient(), new CrateLanguage(modid, generator, "en_us"));
        generator.addProvider(event.includeClient(), new CrateLanguage(modid, generator, "fr_fr"));
        generator.addProvider(event.includeClient(), new CrateLanguage(modid, generator, "de_de"));
        generator.addProvider(event.includeClient(), new CrateLanguage(modid, generator, "en_ca"));
        generator.addProvider(event.includeClient(), new CrateLanguage(modid, generator, "fr_ca"));
    }
}