package com.github.warrentode.applecrates_compat.datagen;

import jackdaw.applecrates.api.CrateWoodType;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class TagGen extends BlockTagsProvider {
    private final String modid;

    public TagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
        this.modid = modId;
    }

    protected void addTags(HolderLookup.@NotNull Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_AXE).addOptional(Objects.requireNonNull(ResourceLocation.tryParse("applecrates_compat:cactus_extra_crate")));
        this.tag(BlockTags.MINEABLE_WITH_AXE).addOptional(Objects.requireNonNull(ResourceLocation.tryParse("applecrates_compat:green_cactus_extra_crate")));

        CrateWoodType.values().filter((crateWoodType) -> crateWoodType.isFrom(this.modid))
                .forEach((crateWoodType) -> this.tag(BlockTags.MINEABLE_WITH_AXE)
                        .addOptional(crateWoodType.getFullRegistryResLoc()));
    }
}