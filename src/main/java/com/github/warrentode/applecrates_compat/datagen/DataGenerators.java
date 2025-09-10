package com.github.warrentode.applecrates_compat.datagen;

import jackdaw.applecrates.datagen.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.concurrent.CompletableFuture;

public class DataGenerators {
    public DataGenerators() {
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        generatedCrates("applecrates", event);
    }

    public static void generatedCrates(String modid, GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(event.includeServer(), new TagGen(packOutput, lookupProvider,  modid, helper));
        generator.addProvider(event.includeServer(), new CrateRecipes(modid, generator));
        generator.addProvider(event.includeServer(), new CrateLoot(modid, generator));
        generator.addProvider(event.includeClient(), new CrateModels(modid, generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new CrateStates(modid, generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new CrateItems(modid, generator, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LangGen(packOutput, modid, "en_us"));
    }
}